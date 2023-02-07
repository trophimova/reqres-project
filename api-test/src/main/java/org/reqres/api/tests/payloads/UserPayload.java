package org.reqres.api.tests.payloads;

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

	@JsonProperty("name")
	private String name;

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

}