package example.async;

import java.util.concurrent.CompletableFuture;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.function.Supplier;  
/**
 * jdk1.8实现
 */
public class JavaPromise {  
    public static void main(String[] args) throws Throwable, ExecutionException {  
        // 两个线程的线程池  
        ExecutorService executor = Executors.newFixedThreadPool(1);  
        //jdk1.8实现方式  
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {  
            public String get() {  
                System.out.println("task started!");  
                try {  
                    //模拟耗时操作  
                	System.out.println("in try :" + Thread.currentThread().getName());
                    Thread.sleep(2000); 
                    System.out.println("out try");
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                return "task finished!";  
            }  
        }, executor);  
        //采用lambada的实现方式  
        future.thenAccept(e -> System.out.println(e + " ok"));  
        System.out.println("main thread is running");  
        executor.shutdown();
    }  
}  
