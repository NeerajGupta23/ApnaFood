package com.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.user.Enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer userId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "mobile", unique = true)
	private String mobileNo;

	@Column(name = "profilePic")
	private byte[] profilePicture;

	@Column(name = "role", nullable = false)
	private Role role;

	@Column(name = "updatedAt", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "createdAt", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "varified", nullable = false)
	private boolean isVarified;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addressIdFK", referencedColumnName = "id", unique = true)
	private Address address;
	
	
}
