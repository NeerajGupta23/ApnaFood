package com.user.service.Interface;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudImageService {
	Map upload(MultipartFile file);
}
