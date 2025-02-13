package com.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.service.Interface.CloudImageService;
import com.user.service.Interface.ConvertObject;
import com.user.service.Interface.UserDatabaseService;
import com.user.vo.Acknowledge;
import com.user.vo.UserVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CloudImageService cloudImageService;
	
	@Autowired
	private UserDatabaseService databaseService;
	
	@Autowired
	private ConvertObject convertObject;
	
	@PostMapping("/create")
	public ResponseEntity<Acknowledge> createUser(@RequestBody @Valid UserVO user) {
		System.out.println(user);
		databaseService.createUser(convertObject.convertFromVotoEntity(user));
		
		Acknowledge acknowledge = new Acknowledge("User is created successfully...");
		return new ResponseEntity<>(acknowledge, HttpStatus.CREATED);
	}
	
	
	
	// cloudinary 
	public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file) {
		Map data = cloudImageService.upload(file);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
