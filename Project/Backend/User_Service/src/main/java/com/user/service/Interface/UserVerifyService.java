package com.user.service.Interface;

import com.user.entity.User;
import com.user.exception.UserException;

public interface UserVerifyService {
	
	Boolean verifyUserWithEmail(User user) throws UserException;
	
	Boolean verifyUserWithMobile(User user) throws UserException;
	
	Boolean forgotPassword(User user) throws UserException;
	
	Boolean verifyUser(User user) throws UserException;
	
}
