package ssm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 功能描述：读取properties文件
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	
	private static Map ctxPropertiesMap;  
	
	/**
	 * 功能描述：属性加载到ctxPropertiesMap中
	 */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,  
                                     Properties props)throws BeansException {  
        super.processProperties(beanFactoryToProcess, props);  
        ctxPropertiesMap =new HashMap();  
        for(Object key : props.keySet()) {  
            String keyStr = key.toString();  
        	String value = props.getProperty(keyStr);  
        	ctxPropertiesMap.put(keyStr, value);  
        }
        ctxPropertiesMap.put("sessionID", UUID.randomUUID().toString());
    }  
    
    /**
     * 功能描述：获取属性值
     */
    public static Object getContextProperty(String name) {  
        return ctxPropertiesMap.get(name);  
    }  
	

}
