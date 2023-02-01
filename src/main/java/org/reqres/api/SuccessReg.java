package org.reqres.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessReg {

	@JsonProperty("id")
	private int id;

	@JsonProperty("token")
	private String token;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"SuccessReg{" + 
			"id = '" + id + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}

	public SuccessReg(int id, String token) {
		this.id = id;
		this.token = token;
	}

	public SuccessReg() {

	}
}