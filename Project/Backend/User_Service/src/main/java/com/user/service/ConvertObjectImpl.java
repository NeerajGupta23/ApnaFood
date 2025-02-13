package com.user.service;

import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.service.Interface.ConvertObject;
import com.user.vo.UserVO;


@Service
public class ConvertObjectImpl implements ConvertObject{

	@Override
	public User convertFromVotoEntity(UserVO userVO) {
		User user = new User();
		user.setName(userVO.getName());
		user.setEmail(userVO.getEmail());
		user.setPassword(userVO.getPassword());
		return user;
	}

}
