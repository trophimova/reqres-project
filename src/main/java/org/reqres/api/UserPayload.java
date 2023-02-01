package org.reqres.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(fluent = true)
public class UserPayload {

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

}