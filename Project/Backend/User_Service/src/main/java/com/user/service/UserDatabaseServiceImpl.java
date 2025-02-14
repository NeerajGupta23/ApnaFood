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
public class UserDatabaseServiceImpl implements UserDatabaseService {

	@Autowired
	private UserRepository repository;

	@Override
	public Boolean phoneExists(String phone) {
		Integer id = repository.selectUserIdByPhone(phone);
		if (id == null) {
			return false;
		}
		return true;
	}

	@Override
	public void createUser(User user) {
		user.setRole(Role.User);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setVarified(false);

		repository.save(user);
	}

	@Override
	public Boolean verifyOldPassword(String email, String password) {
		String pwdFromDB = repository.selectUserPwdByEmail(email);
		if (pwdFromDB.equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void updatePassword(String email, String password) throws UserException {
		Integer updatedRow = repository.updatePassword(email, password);

		if (updatedRow > 1)
			throw new UserException("updated password to more than one row!");
		if (updatedRow == null || updatedRow < 1)
			throw new UserException("password is not updated!");
	}

	@Override
	public void updateEmail(String newEmail, String oldEmail) throws UserException {
		Integer updatedRow = repository.updateEmail(newEmail, oldEmail);

		if (updatedRow > 1)
			throw new UserException("updated email to more than one row!");
		if (updatedRow == null || updatedRow < 1)
			throw new UserException("email is not updated!");
	}

	@Override
	public Boolean emailExists(String email) {
		Integer id = repository.selectUserIdByEmail(email);
		if (id == null) {
			return false;
		}
		return true;
	}

	@Override
	public void updatePhone(String email, String newPhone) throws UserException {
		Integer updatedRow = repository.updatePhone(email, newPhone);

		if (updatedRow > 1)
			throw new UserException("updated phone to more than one row!");
		if (updatedRow == null || updatedRow < 1)
			throw new UserException("phone is not updated!");
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
