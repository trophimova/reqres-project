package org.reqres.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationResponse {

	@JsonProperty("id")
	private String id;

}