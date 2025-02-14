package com.user.service.Interface;

import com.user.entity.User;
import com.user.exception.UserException;

public interface UserDatabaseService {
	
	Boolean emailExists(String email);
	
	void createUser(User user);
	
	Boolean verifyOldPassword(String email, String password);
	
	void updatePassword(String email, String password) throws UserException;
	
	void updateEmail(String newEmail, String oldEmail) throws UserException;
	
	Boolean updateUser(User user) throws UserException;
	
	Boolean deleteUser(User user) throws UserException;
	
	Boolean createPassword(User user) throws UserException;
	
	Boolean selectUserByEmail(User user) throws UserException;
	
	Boolean selectUserById(User user) throws UserException;
	
	Boolean userExistWithEmail(String email) throws UserException;
	
	Boolean userExistWithPhone(String phone) throws UserException;
	
}
