package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/registration")
	ResponseEntity<String> registerUser(@Valid @RequestBody User user){
		   String message =   service.registerUser(user);
	           return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
}
