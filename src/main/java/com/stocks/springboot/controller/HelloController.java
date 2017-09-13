package com.stocks.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@RequestMapping(value ="/index/{name}",method = RequestMethod.GET)
	@ResponseBody
	public String index(@PathVariable(value = "name") String name){
		return "Hello world " + name;
	}
	
	@Value("${nickname}")
	private String nickname;
	
	@Value("${greeting}")
	private String greeting;
	
	@RequestMapping(value = "/config",method = RequestMethod.GET)
	@ResponseBody
	public String config(){
		return "nickname:"+nickname + "\tgreeting:"+greeting; 
	}
}
