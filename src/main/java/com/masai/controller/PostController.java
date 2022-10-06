package com.masai.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Post;
import com.masai.service.PostServiceImpl;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	 @Autowired
	 PostServiceImpl service;
	
	 @PostMapping("/")
	 ResponseEntity<String> createPost(@RequestBody Post post){
	         String message =  service.createPost(post);         
	         return new ResponseEntity<>(message,HttpStatus.CREATED);         
	 }
	
	 @GetMapping("/")
	 ResponseEntity<List<Post>> getAllPost(){
         List<Post> post =  service.getAllPost();         
         return new ResponseEntity<>(post,HttpStatus.ACCEPTED);         
     }
	 
	 @GetMapping("/{Id}")
	 ResponseEntity<Post> getPostById(@PathVariable("Id") Integer Id){
         Post post =  service.getPostById(Id);         
         return new ResponseEntity<>(post,HttpStatus.ACCEPTED);         
     }
	 
	 @PutMapping("/{Id}")
	 ResponseEntity<Post> updatePostById(@RequestBody Post post ,@PathVariable Integer Id){
         Post fetched_post =  service.updatePostById(post, Id);         
         return new ResponseEntity<>(fetched_post,HttpStatus.ACCEPTED);         
     }
	 
	 @DeleteMapping("/{Id}")
	 ResponseEntity<String> deletePostById(@PathVariable Integer Id){
         String message =  service.deletePostById(Id);         
         return new ResponseEntity<>(message,HttpStatus.ACCEPTED);         
     }
	 
	
	 //http://localhost:8888/api/posts/paginationAndSorting/1?pageSize=2&sortingField=title&sortingDirection=DESC
	 @GetMapping("/paginationAndSorting")
	 ResponseEntity<Page<Post>> paginationAndSorting(@RequestParam(required = false, defaultValue = "") Integer pageNo,@RequestParam(required = false, defaultValue = "10")  Integer pageSize,@RequestParam(required = false, defaultValue = "title") String sortingField,@RequestParam(required = false , defaultValue = "ASC") String sortingDirection){
         Page<Post> page =  service.paginationAndSorting(pageNo, pageSize, sortingField, sortingDirection);         
         return new ResponseEntity<>(page,HttpStatus.ACCEPTED);         
     }
	 
	 
	 
}