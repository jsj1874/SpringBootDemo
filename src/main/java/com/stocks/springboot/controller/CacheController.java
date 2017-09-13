package com.stocks.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.springboot.bean.User;
import com.stocks.springboot.service.CacheService;

@RestController
@RequestMapping(value = "/cache")
public class CacheController {
	
	@Autowired
	CacheService<String,String> cacheService;
	
	@Autowired
	CacheService<String,User> userService;
	
	@RequestMapping(value = "setcache")
	public String setCache(String key,String value){
		try{
			cacheService.set(key, value);
			return "set cache("+key+","+value+") is success!";
		}catch (Exception e) {
			// TODO: handle exception
			return  "set cache key："+key +"value:"+value+"is fail!";
		}
	}
	
	@RequestMapping(value = "delcache")
	public String delCache(String key){
		try{
			cacheService.del(key);
			return "delete cache("+key+") is success!";
		}catch (Exception e) {
			// TODO: handle exception
			return  "delete cache key："+key +"is fail!";
		}
		
	}
	
	@RequestMapping(value = "getcache")
	public String getcache(String key){
		try{
			String val = cacheService.getValue(key);
			return "get cache("+key+","+val+") is success!";
		}catch (Exception e) {
			// TODO: handle exception
			return  "get cache key："+key +"is fail!";
		}
		
	}
	
	@RequestMapping(value = "setuser")
	public String setcache(String key,User user){
		try{
			userService.setRedisCache(key, user);
			return user.toString();
		}catch (Exception e) {
			// TODO: handle exception
			return  "set user key："+key +"is fail!";
		}
		
	}
	
	@RequestMapping(value = "getuser")
	public String getuser(String key){
		try{
			User user = userService.getRedisCacheValue(key);
			return "user"+user.toString()+" is success!";
		}catch (Exception e) {
			// TODO: handle exception
			return  "get user  fail!";
		}
		
	}

}
