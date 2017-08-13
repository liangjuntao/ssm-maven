package example.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用wait notify 实现阻塞队列
 * 执行结果是：
 * put操作永远被阻塞，因为没有外界去唤醒这个线程了
 */

public class MyQueue {
	//模拟一个容器
	private final LinkedList<Object> list = new LinkedList();
	
	//添加一个计数器，模拟容器的大小
	private AtomicInteger count = new AtomicInteger(0);
	private final int minSize = 0;
	private final int maxSize;
	
	//用于加锁
	private final Object lock = new Object();
	
	//构造方法
	public MyQueue(int size ){
		this.maxSize = size ;
	}
	
	public void put(Object obj) throws InterruptedException {
		synchronized (lock) {
			while(count.get() == this.maxSize){
				System.out.println("我的长度是"+count.get()+",达到最大长度，不能添加，进入被唤醒状态！");
				lock.wait();
			}
			//添加元素
			count.incrementAndGet();
			list.add(obj);
			System.out.println("list新添加的元素为"+obj);

			//假设队列是0的时候，其他线程去访问将会被阻塞；这里需要唤醒等待的线程
			lock.notify();
			
		}
	}
	
	public Object take() throws InterruptedException{
		Object result = null;
		synchronized (lock) {
			//容器为空
			while(count.get() == minSize){
				lock.wait();
			}
			//获取
			result = list.removeFirst();
			count.decrementAndGet();
			//考虑容器是满的时候
			lock.notify();
		}
		return result;
	}
	
	public int getSize(){
		return count.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyQueue q = new MyQueue(5);
		q.put("a1");
		q.put("a2");
		q.put("a3");
		q.put("a4");
		q.put("a5");
		System.out.println("当前容器长度是"+ q.getSize());
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					q.put("b1");
					q.put("b2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		},"t1");
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Object o = q.take();
					System.out.println("移除的元素是" + o);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2");
		
		TimeUnit.SECONDS.sleep(2);
		t2.start();
	}
}
