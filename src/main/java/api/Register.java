package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Register{

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Register{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}

	public Register(String password, String email) {
		this.password = password;
		this.email = email;
	}

//	public Register() {
//
//	}
}