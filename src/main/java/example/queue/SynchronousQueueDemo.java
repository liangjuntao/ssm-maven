package example.queue;

import java.util.concurrent.SynchronousQueue;


public class SynchronousQueueDemo {
	public static void main(String[] args) {
		//虚拟队列，没有容量。
		SynchronousQueue<String> s = new SynchronousQueue<>();
		s.add("a");
	}
}
