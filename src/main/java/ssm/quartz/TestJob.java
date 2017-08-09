package ssm.quartz;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestJob {
	
	private static final Logger logger = Logger.getLogger(TestJob.class);
	Map<Integer,Integer> map = new HashMap();
	
	protected void execute(){
		logger.info("----------------定时作业开始执行-------------");
		//测试显示是10个线程
		int i = Thread.currentThread().getName().toString().hashCode();
		System.out.println("i的值是:"+ i);
		map.put(i, i+1);
		System.out.println("此时个数是："+map.size());
	}

}
