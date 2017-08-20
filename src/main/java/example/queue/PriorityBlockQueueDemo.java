package example.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockQueueDemo {
	public static void main(String[] args) {
		PriorityBlockingQueue<Task> p = new PriorityBlockingQueue<Task>();
		
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("任务1");
		
		Task t2 = new Task();
		t2.setId(6);
		t2.setName("任务2");
		
		Task t3 = new Task();
		t3.setId(1);	
		t3.setName("任务3");
		
		p.add(t1);
		p.add(t2);
		p.add(t3);
		
		p.forEach(e -> System.out.println(e.getId()));
		
	}
}
