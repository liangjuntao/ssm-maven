package example.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * method.invoke(对象，参数)
 * spring在依赖注入的时候便是用反射实现的
 * bean需要有get,set方法
 */
public class Main {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StudentDemo sd = new StudentDemo();
		sd.setName("测试invoke");
		for (Method m : sd.getClass().getMethods()) {
			if (m.getName().startsWith("setName")) {
				m.invoke(sd, "zhangsna");
				System.out.println(sd.getName());
			}
		}
	}
}
