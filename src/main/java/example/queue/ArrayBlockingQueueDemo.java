package example.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * 有界的
 */
public class ArrayBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		//初始化时，必须设置容量
		ArrayBlockingQueue<String> a = new ArrayBlockingQueue<String>(5);
		a.put("a2");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("e");
		//两秒钟之内添加元素a，如果添加进去，返回true；否则返回false
		System.out.println(a.offer("a", 2, TimeUnit.SECONDS));
		a.add("f");
	}
}
