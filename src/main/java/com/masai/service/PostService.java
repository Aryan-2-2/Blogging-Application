package com.masai.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.masai.model.Post;

public interface PostService {

	public String createPost(Post post);
	public List<Post> getAllPost();
	public Post getPostById(Integer Id);
	public Post updatePostById(Post post ,Integer Id);
    public String deletePostById(Integer Id);
    public List<Post> paginationaAndSorting(String field);
    public Page<Post> pagesize(Integer offset, Integer pageSize);
	
}
