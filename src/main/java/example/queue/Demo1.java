package example.queue;

import java.util.concurrent.ConcurrentLinkedQueue;


public class Demo1 {
	public static void main(String[] args) {
		/**
		 * 无阻塞 链式队列
		 */
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		 clq.add("a");
		 clq.offer("b");
		 clq.offer("c");
		 clq.offer("d");
		 clq.forEach(e -> System.out.println(e));
		 clq.remove();   //调用poll实现；
		 clq.poll();	//取出头元素并删除
		 clq.peek();  //不会删除元素
		 clq.forEach(e -> System.out.println(e));
	}
}
