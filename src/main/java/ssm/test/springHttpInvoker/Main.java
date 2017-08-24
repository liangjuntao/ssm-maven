package ssm.test.springHttpInvoker;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssm.menu.pojo.Menu;
import ssm.user.pojo.User;
import ssm.util.MyHttpInvokerProxy;

/**
 * 测试spring的HttpInvoker
 * 注意点：
 * 1.剔除shiro，shiro有登录验证。
 * 2. 
 */
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring/spring.xml");  
        LocalMenuService localMenuService = (LocalMenuService)MyHttpInvokerProxy.proxy("LocalMenuService");
        User user = new User();  
        user.setId(1);
        List<Menu> list = localMenuService.findAll(user);
        list.forEach( e -> System.out.println(e.getName()));
	}
}
