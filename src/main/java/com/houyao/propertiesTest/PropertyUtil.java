package com.houyao.propertiesTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @Author: houyao
 * @Description:重写Spring的 PropertyPlaceholderConfigurer类，能通过代码读取配置文件
 * @Date: Created in 17:33:43 2019/5/31
 */
public class PropertyUtil  extends PropertyPlaceholderConfigurer {

    private static Properties props;       // 存取properties配置文件key-value结果

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.props = props;
    }

    public static String getProperty(String key){
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return this.props.setProperty(key, value);
    }
}
