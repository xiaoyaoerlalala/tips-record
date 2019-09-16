package com.houyao.typeTransform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 11:05:34 2019/9/6
 */
public class MapToClass {
    public static final Logger logger = LoggerFactory.getLogger(MapToClass.class);
    /**
     * Map转对象,使用时需要注意，如果map的key与对象属性大小写不同，是转换不了的，只能转换大小写符合的部分
     * 大小写不符的，可以先将map转成json数据，然后将json转成对象
     * @param map
     * @param classes
     * @return
     */
    private Object transMap2Bean(Map<String,Object> map, Class classes){
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = classes.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        } catch (InstantiationException e) {
            logger.error("javaBean 初始化异常");
        } catch (IllegalAccessException e) {
            logger.error("javaBean 存在非法访问！");
        } catch (InvocationTargetException e) {
            logger.error("javaBean Invoke异常");
        }
        return obj;
    }
}
