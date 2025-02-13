package com.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Enums.Role;
import com.user.entity.User;
import com.user.exception.UserException;
import com.user.repository.UserRepository;
import com.user.service.Interface.UserDatabaseService;

@Service
public class UserDatabaseServiceImpl implements UserDatabaseService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void createUser(User user) throws UserException {
		if(user == null)
			throw new UserException("Expected user passed null for user creation!"); 	
		
		user.setRole(Role.User);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setVarified(false);
			
		repository.save(user);			
	}

	@Override
	public Boolean updateUser(User user) throws UserException {	
		return null;
	}

	@Override
	public Boolean deleteUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createPassword(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changePassword(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean selectUserByEmail(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean selectUserById(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean userExistWithEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean userExistWithPhone(String phone) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
