package org.reqres.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(fluent = true)
public class UserPayload {

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

}