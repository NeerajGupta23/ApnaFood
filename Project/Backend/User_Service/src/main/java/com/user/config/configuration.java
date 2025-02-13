package com.user.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cloudinary.Cloudinary;

@Configuration
public class configuration {
	
	@Value("${cloud.name}")
	private String cloudName;
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.secret}")
	private String apiSecret;
	
	@Bean
	public Cloudinary getCloudinary() {
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		config.put("secure", "true");
		return new Cloudinary(config);
	}
}
