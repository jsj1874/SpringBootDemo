package com.stocks.springboot.bean;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "user id:"+this.id + " name:"+name;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this){
			return true;
		}
		User user =  (User) obj;
		return this.id == user.id && this.name == user.name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result = 31 * id;
		return result;
	}
	
	

}
