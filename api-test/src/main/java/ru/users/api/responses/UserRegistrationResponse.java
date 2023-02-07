package ru.users.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationResponse {

	@JsonProperty("avatar")
	private String avatar;

}