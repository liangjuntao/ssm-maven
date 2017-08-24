package ssm.util;

import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * 功能描述：httpinvoker代理类
 */
public class MyHttpInvokerProxy extends HttpInvokerProxyFactoryBean {
	// 用于拼接要访问的远程服务Url
	private static String defaultServiceUrl = "http://127.0.0.1:8080/";
	private static String defaultServiceInterface = "ssm.test.springHttpInvoker.";

	static {
		String remoteUrl = (String) CustomPropertyPlaceholderConfigurer.getContextProperty("serverUrl");
		if (null != remoteUrl && !"".equals(remoteUrl)) {
			defaultServiceUrl = remoteUrl;
		}
	}

	/**
	 * 功能描述：根据服务接口名及其接口类位置获取代理
	 */
	public static Object proxy(String serviceName, String serviceInterface) {
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		Class c = getClassByClassName(defaultServiceInterface + serviceInterface);
		if (null == c) {
			return null;
		}
		proxy.setServiceUrl(defaultServiceUrl + serviceName);
		proxy.setServiceInterface(c);
		proxy.afterPropertiesSet();
		return proxy.getObject();
	}

	/**
	 * 功能描述：根据服务名获取代理
	 */
	public static Object proxy(String serviceName) {
		// HttpInvokerProxyFactoryBean 可以通过spring的配置文件生成bean。
		// 采用配置文件灵活度不高，基于反射动态去生成调用的代理的接口。
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		Class c = getClassByClassName(defaultServiceInterface + serviceName);
		if (null == c) {
			return null;
		}
		//设置代理要访问服务的Url
		proxy.setServiceUrl(defaultServiceUrl + serviceName);
		//设置代理的接口
		proxy.setServiceInterface(c);
		proxy.afterPropertiesSet();
		HttpComponentsHttpInvokerRequestExecutor m = new HttpComponentsHttpInvokerRequestExecutor();
		m.setConnectTimeout(3000);
		m.setReadTimeout(3000);
		proxy.setHttpInvokerRequestExecutor(m);
		//返回结果。
		return proxy.getObject();
	}

	/**
	 * 功能描述：根据全限定名称获取class
	 */
	public static Class getClassByClassName(String className) {
		Class obj = null;
		try {
			obj = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
