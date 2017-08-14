package example.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
	public static void main(String[] args) {
		LinkedBlockingQueue<String> l = new LinkedBlockingQueue<String>(3);
		l.add("a"); // add操作，如果queue满了，会报错
		l.add("b");
		l.add("c");
		l.add("报错"); 
		l.offer("d"); //offer操作，如果queue满了，不会添加元素，也不会报错。
		l.offer("g");
		l.forEach(e -> System.out.println(e));
		System.out.println(l.size());
	}
}
