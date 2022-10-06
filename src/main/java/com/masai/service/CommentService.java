package com.masai.service;

import java.util.List;

import com.masai.model.Comment;
import com.masai.model.Post;

public interface CommentService {

	public String createCommentById(Comment comment,Integer Id);
	public List<Comment> getAllcommentByPostId(Integer Id);
	public Comment getCommentByCommentId(Integer postId ,Integer commentId);
	public Comment updateCommentById(Integer postId ,Comment comment,Integer Id);
    public String deleteCommentById(Integer postId ,Integer Id);
    
	
}
