package com.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email format is invalid")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
}

