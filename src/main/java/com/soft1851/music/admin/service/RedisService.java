package com.soft1851.music.admin.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName RedisService
 * @Description RedisTemplate中key的默认的序列化方案是JdkSerializationRedisSerializer
 * StringRedisTemplate中，key的默认序列化方案StringRedisSerializer
 * @Author mq_xu
 * @Date 2020/4/21
 * @Version 1.0
 */
@Service
public class RedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public void save(String key, String value, long duration) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value, duration);
    }

    public String get(String key) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String value = ops.get(key);
        if (value != null) {
            return value;
        } else {
            return "";
        }
    }
}
