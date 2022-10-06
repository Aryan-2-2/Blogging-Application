package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.CommentDao;
import com.masai.dao.PostDao;
import com.masai.exception.CommentNotFound;
import com.masai.exception.PostNotFoundException;
import com.masai.model.Comment;
import com.masai.model.Post;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao repo;
	
	@Autowired
	PostDao postRepo;
	
	@Override
	public String createCommentById(Comment comment,Integer Id) {
		
		                          
		    Optional<Post> post =  postRepo.findById(Id);		   
		    if(post.isEmpty()) {
		    	throw new PostNotFoundException("Post not found with this given ID");
		    }
		   
		    post.get().getComment().add(comment);
		    comment.setPost(post.get());
		    
		    
		    repo.save(comment);
		    
		    return "Commented on the post successfully...";
		
	}

	@Override
	public List<Comment> getAllcommentByPostId(Integer Id) {
		
		 Optional<Post> post = postRepo.findById(Id);
		 
		 if(post.isEmpty()) {
			 throw new PostNotFoundException("Post not found with this given ID");
		 }		
		return post.get().getComment();
		
	}

	@Override
	public Comment getCommentByCommentId(Integer postId ,Integer Id) {
		
		  Optional<Post> post =  postRepo.findById(postId);
		
	     if(post.isEmpty()) {
	    	 throw new PostNotFoundException("Post not found with this given ID");
	     }
		  
		Optional<Comment> comment =  repo.findById(Id);
		if(comment.isEmpty()) {
			throw new CommentNotFound("Comment Not Found with this given ID");
		}
		
        return comment.get();		
	}

	@Override
	public Comment updateCommentById(Integer postId ,Comment comment, Integer Id) {
		
		 Optional<Post> post =  postRepo.findById(postId);
			
	     if(post.isEmpty()) {
	    	 throw new PostNotFoundException("Post not found with this given ID");
	     }
		
		   Optional<Comment> fetched_comment =   repo.findById(Id);
		   if(fetched_comment.isEmpty()) {
			   throw new CommentNotFound("Comment not found with this given ID");
		   }
		   
		   post.get().getComment().add(comment);
		   comment.setPost(post.get());
		   
		   repo.deleteById(Id);
		   repo.save(comment);
		   
		   return comment;
	}

	@Override
	public String deleteCommentById(Integer postId ,Integer Id) {

		 Optional<Post> post =  postRepo.findById(postId);
			
	     if(post.isEmpty()) {
	    	 throw new PostNotFoundException("Post not found with this given ID");
	     }
		
		Optional<Comment> fetched_comment =   repo.findById(Id);
		   if(fetched_comment.isEmpty()) {
			   throw new CommentNotFound("Comment not found with this given ID");
		   }
		   
		   repo.deleteById(Id);
		   
		   return "Comment deleted successfully...";
	}

}
