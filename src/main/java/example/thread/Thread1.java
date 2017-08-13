package example.thread;

public class Thread1 {
	public static void main(String[] args) {
		final Object lock = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println("已经进入run方法，释放锁");
						lock.wait();
						//这里lock被释放掉了，这个线程进入阻塞态；如果没有被唤醒，将会一直处于等待状态；
						//外界必须唤醒这个线程，否则t1线程，永远不会结束，也不会被唤醒。
						System.out.println("重新获取锁");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		t1.start();
	}

}
