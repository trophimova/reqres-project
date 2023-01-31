package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnSuccessReg{

	@JsonProperty("error")
	private String error;

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"UnSuccessReg{" + 
			"error = '" + error + '\'' + 
			"}";
		}
}