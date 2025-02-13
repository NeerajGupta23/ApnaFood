package com.user.service.Interface;

import com.user.entity.User;
import com.user.exception.UserException;

public interface OTPService {

	Boolean generateOTPViaEmail(User user) throws UserException;
	
	Boolean generateOTPViaMobile(User user) throws UserException;

}
