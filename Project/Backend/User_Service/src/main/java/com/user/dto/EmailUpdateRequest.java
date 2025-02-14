package com.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailUpdateRequest {
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email format is invalid")
	private String newEmail;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email format is invalid")
	private String oldEmail;
}
