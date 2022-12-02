package com.study.service;

import java.util.ArrayList;
import java.util.List;

import com.study.domain.User;
import com.study.repository.UserRepository;

public class AccountService {
	private static AccountService instance = null;
	
	
	private AccountService() {}
	
	public static AccountService getInstance() {
		if(instance == null) {
			instance = new AccountService();
		}
		
		return instance;
	}
	
	
	
	public boolean isDuplicateUsername(String username) { // 아이디 중복 여부 확인 메소드
		User user = UserRepository.getInstance().findUserByUsername(username);
		return user != null; // true가 나오면 안됨, false가 나와야함.
	}
	
	public void register (User user) {
		UserRepository.getInstance().saveUser(user);
	}
	
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	
	public boolean checkPassword(User user, String password) {
		return user.getPassword().equals(password);
	}
}
