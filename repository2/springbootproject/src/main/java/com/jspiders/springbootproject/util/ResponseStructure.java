package com.jspiders.springbootproject.util;

import java.util.List;

import com.jspiders.springbootproject.Entity.Adhar;

public class ResponseStructure<T> {

	int status;
	String message;
	T data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void setData(List<Adhar>all) {
	
	}
}
