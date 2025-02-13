package com.user.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.user.service.Interface.CloudImageService;

@Service
public class CloudImageServiceImpl implements CloudImageService {

	@Autowired
	private Cloudinary cloudinary;
	
	@Override
	public Map upload(MultipartFile file) {
		Map data = null;
		
		try {
			data = cloudinary.uploader().upload(file.getBytes(), Map.of());
		} catch(IOException e) {
			System.out.println(e.getStackTrace());
			System.out.println();
			System.out.println(e.getMessage());
		}
	
		return data;
	}
	
}
