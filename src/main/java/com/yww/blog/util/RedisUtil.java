package com.yww.blog.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *     Redis的工具类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/20 15:11
 **/
@Component
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    // *****************String****************************

    /**
     * 新增数据
     * @param key   数据的键
     * @param value 数据的值
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取数据
     * @param key   数据的键
     * @return      数据的值
     */
    public String get(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

}
