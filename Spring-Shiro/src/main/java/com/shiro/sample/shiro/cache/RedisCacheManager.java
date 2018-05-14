package com.shiro.sample.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro缓存权限、角色数据
 */
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisCache redisCache;


    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
