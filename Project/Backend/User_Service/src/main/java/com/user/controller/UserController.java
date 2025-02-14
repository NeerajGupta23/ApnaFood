package com.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.dto.Acknowledge;
import com.user.dto.EmailUpdateRequest;
import com.user.dto.PhoneUpdateRequest;
import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.service.Interface.CloudImageService;
import com.user.service.Interface.UserDatabaseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CloudImageService cloudImageService;
	
	@Autowired
	private UserDatabaseService databaseService;
	
	
	// create user
	@PostMapping("/create")
	public ResponseEntity<Acknowledge> createUser(@RequestBody @Valid User user) {
		databaseService.createUser(user);	

		Acknowledge acknowledge = new Acknowledge("User is created successfully...");
		return new ResponseEntity<>(acknowledge, HttpStatus.CREATED);
	}
	
	// exists email
	@GetMapping("/uniqueEmail/{email}")
	public ResponseEntity<Boolean> emailExist(
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
			@PathVariable String email
		) {
		
		Boolean result = databaseService.emailExists(email);	
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	// update email
	@PutMapping("/updateEmail")
	public ResponseEntity<Acknowledge> updateEmail(@RequestBody @Valid EmailUpdateRequest emailUpdateRequest) {
		System.out.println(emailUpdateRequest);
		databaseService.updateEmail(emailUpdateRequest.getNewEmail(), emailUpdateRequest.getOldEmail());
		
		Acknowledge acknowledge = new Acknowledge("User's email is updated succesfully...");
		return new ResponseEntity<>(acknowledge, HttpStatus.OK);
	}
	
	
	
	// verify Old password
	@PostMapping("/verifyOldPwd")
	public ResponseEntity<Boolean> verifyOldPassword(@RequestBody @Valid UserDTO user) {
		Boolean result = databaseService.verifyOldPassword(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	// update password 
	@PutMapping("/updatePwd")
	public ResponseEntity<Acknowledge> updatePassword(@RequestBody @Valid UserDTO user) {
		databaseService.updatePassword(user.getEmail(), user.getPassword());
		Acknowledge acknowledge = new Acknowledge("User's password is updated succesfully...");
		return new ResponseEntity<>(acknowledge, HttpStatus.OK);
	}
	


	// exists phone
	@GetMapping("/uniquePhone/{phone}")
	public ResponseEntity<Boolean> phoneExist(
			@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
			@PathVariable String phone
		) {
		Boolean result = databaseService.phoneExists(phone);	
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	// update phone 
	@PutMapping("/updatePhone")
	public ResponseEntity<Acknowledge> updatePhone(@RequestBody @Valid PhoneUpdateRequest phoneUpdateRequest) {
		System.out.println(phoneUpdateRequest);
		databaseService.updatePhone(phoneUpdateRequest.getEmail(), phoneUpdateRequest.getPhone());
		
		Acknowledge acknowledge = new Acknowledge("User's phone is updated succesfully...");
		return new ResponseEntity<>(acknowledge, HttpStatus.OK);
	}
	
	
	
	// update other except password, email and phone
	
	
	
	// cloudinary 
	public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file) {
		Map data = cloudImageService.upload(file);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
