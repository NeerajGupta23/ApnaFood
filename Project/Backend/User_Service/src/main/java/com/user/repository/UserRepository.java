package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select userId from User where email = :email")
	public Integer selectUserIdByEmail(String email);
	
	@Query(value = "select password from User where email = :email")
	public String selectUserPwdByEmail(String email);
	
	@Query(value = "update User set password = :password where email = :email")
	@Modifying
	@Transactional
	public Integer updatePassword(@Param("email")String email, @Param("password")String password);
	
	@Query(value = "update User set email = :newEmail where email = :oldEmail")
	@Modifying
	@Transactional
	public Integer updateEmail(@Param("newEmail")String newEmail, @Param("oldEmail")String oldEmail);

}
