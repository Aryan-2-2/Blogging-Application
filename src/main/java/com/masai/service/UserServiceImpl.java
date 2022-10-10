package com.masai.service;

import java.util.Optional;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserServiceIntr{

	@Autowired
	UserDao repo;
	
	@Override
	public String registerUser(User user) {
	
	   Optional<User> fetched_user = repo.findById(user.getId());
	
	   if(fetched_user.isPresent()) {
		   throw new KeyAlreadyExistsException("User already exists");
	   }
	   
	   repo.save(user);
	   return "User is registerd successfully...";
	   
	   
	}
	
	
	
}
