package ssm.util;

import org.apache.log4j.Logger;

/**
 * 功能描述：属性读取工具类
 */
public class SystemPropertiesUtils {

	private static final Logger logger = Logger.getLogger(SystemPropertiesUtils.class);

	/**
	 * 功能描述：获取字符串 属性值
	 */
	public static String parseStr(String name) {
		return (String) CustomPropertyPlaceholderConfigurer.getContextProperty(name);
	}

	/**
	 * 功能描述：获取整型 属性值
	 */
	public static int parseInt(String name) {
		return (Integer) CustomPropertyPlaceholderConfigurer.getContextProperty(name);
	}

	/**
	 * 功能描述：获取整型 属性值，defaultVal： 出错时返回默认值
	 */
	public static int parseInt(String name, int defaultVal) {
		try {
			return (Integer) CustomPropertyPlaceholderConfigurer.getContextProperty(name);
		} catch (Exception e) {
			logger.info("[SystemPropertiesUtils] parseError : " + e.getMessage());
		}
		return defaultVal;
	}

}
