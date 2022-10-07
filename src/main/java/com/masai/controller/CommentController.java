package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.service.CommentServiceImpl;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {
	
	@Autowired
	CommentServiceImpl service;
	
	@PostMapping("/")
	ResponseEntity<String> createCommentByPostId(@Valid @RequestBody Comment comment ,@PathVariable("postId") Integer Id){
		            String message =  service.createCommentById(comment, Id);     
		            return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	ResponseEntity<List<Comment>> getAllCommentByPostId(@PathVariable("postId") Integer Id){
		            List<Comment> comments =  service.getAllcommentByPostId(Id);     
		            return new ResponseEntity<List<Comment>>(comments, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{Id}")
	ResponseEntity<Comment> updateCommentById(@Valid @PathVariable("postId") Integer Id ,@RequestBody Comment comment ,@PathVariable("Id") Integer commentId){
		             Comment comments =  service.updateCommentById(Id, comment, commentId);     
		            return new ResponseEntity<Comment>(comments, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{Id}")
	ResponseEntity<Comment> getCommentById(@PathVariable("postId") Integer Id, @PathVariable("Id") Integer  commentId){
		            Comment comment =  service.getCommentByCommentId(Id, commentId);     
		            return new ResponseEntity<Comment>(comment, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{Id}")
	ResponseEntity<String> deleteCommentById(@PathVariable("postId") Integer Id, @PathVariable("Id") Integer commentId){
		            String comment =  service.deleteCommentById(Id, commentId);     
		            return new ResponseEntity<String>(comment, HttpStatus.ACCEPTED);
	}
	
	
	

}
