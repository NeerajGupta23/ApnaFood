package com.user.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
	private String type;
	private LocalDateTime time;
	private String message;
	private String abstractMessage;
}
