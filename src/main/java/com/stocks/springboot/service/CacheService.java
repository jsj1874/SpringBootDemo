package com.stocks.springboot.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class CacheService<K,V> {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, V> cache;
	
	@Autowired
	private RedisTemplate<K, V> redisTemplate;
	
	@Resource(name = "redisTemplate")
	ValueOperations<K, V> objRedisCache;
	
	/**
	 *
	 * 添加缓存
	 * 
	 */
	public V getValue(K key){
		V value = cache.get(key);
		return (null == value) ? null : value;
		
	}
	
	/**
	 * 
	 * 删除缓存
	 * 
	 */
	public void del(String key){
		stringRedisTemplate.delete(key);
	}
	
	
	/**
	 *
	 * 设置缓存
	 * 
	 */
	public void set(K key,V val){
		cache.set((String) key, val);
	}
	
	/**
	 *
	 * redis
	 * 
	 */
	public void setRedisCache(K key,V val){
		objRedisCache.set(key, val);
		
	}
	
	/**
	 *
	 * redis删除缓存
	 * 
	 */
	public void delRedisCache(K key){
		redisTemplate.delete(key);
	}
	
	/**
	 * 
	 * 
	 */
	public V getRedisCacheValue(K key){
		return objRedisCache.get(key);
	}

}
