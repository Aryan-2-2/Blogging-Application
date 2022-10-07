package com.masai.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.dao.PostDao;
import com.masai.exception.PostAlreadyPresentException;
import com.masai.exception.PostNotFoundException;
import com.masai.model.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao repo;
	
	
	@Override
	public String createPost(Post post) {
		
		
		  Optional<Post> fetched_post  = repo.findById(post.getId());
		  if(fetched_post.isPresent()) {
			  throw new PostAlreadyPresentException("Post is already present");
		  }
		  
		  repo.save(post);
		  return "Post saved successfully...";
	}

	@Override
	public List<Post> getAllPost() {
		
	List<Post> posts = repo.findAll();
	if(posts.isEmpty()) {
	  throw new PostNotFoundException("Nothing in database...");	
	}
		
	return posts;
	}

	@Override
	public Post getPostById(Integer Id) {

    Optional<Post> post =       repo.findById(Id);
		
    if(post.isEmpty()) {
    	throw new PostNotFoundException("Post not found with this given ID");
    }
    
      return post.get();
	}

	@Override
	public Post updatePostById(Post post, Integer Id) {
		
		  Optional<Post> fetched_post = repo.findById(Id);
		  if(fetched_post.isEmpty()) {
			  throw new PostNotFoundException("Post not found with given ID");
		  }
		  
		
		  repo.save(post);
		  return post;
		  
		
	}

	@Override
	public String deletePostById(Integer Id) {
		
		   Optional<Post> post = repo.findById(Id);
	       if(post.isEmpty()) {
	    	   throw new PostNotFoundException("Post not found with given ID");
	       }
		   
	       repo.deleteById(Id);
		   return "Post deleted successfully";
		        
		
	}

	@Override
	public Page<Post> paginationAndSorting(Integer pageNo, Integer pageSize, String sortingField,
			String sortDirection) {
		
		Sort sort = sortDirection.equals(Sort.Direction.ASC.name()) ? Sort.by(sortingField).ascending():
			Sort.by(sortingField).descending();
		
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNo - 1,pageSize,sort);
		return repo.findAll(pageable);
	}


}
