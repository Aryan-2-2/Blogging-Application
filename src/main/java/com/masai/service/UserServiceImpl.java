package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserServiceIntr{

	@Autowired
	UserDao repouser;
	
	@Override
	public String createUser(User user) {
	
	
	
	   repouser.save(user);  
		
		return"saved";
	}
	
	
	
}
