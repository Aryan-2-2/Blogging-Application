package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDao repo;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

      com.masai.model.User user = repo.findByName(userName);
    	
      if(user==null) {
     throw new UsernameNotFoundException("User Not Found");
      }
      return new User(user.getName(),user.getPassword(),new ArrayList<>());
    	
      
    }
}