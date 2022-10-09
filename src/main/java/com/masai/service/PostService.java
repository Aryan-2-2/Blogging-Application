package com.masai.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.masai.model.Post;

public interface PostService {

	public Post createPost(Post post);
	public List<Post> getAllPost();
	public Post getPostById(Integer Id);
	public Post updatePostById(Post post ,Integer Id);
    public String deletePostById(Integer Id);
    public Page<Post> paginationAndSorting(Integer pageNo, Integer pageSize, String sortingField, String sortDirection);
	
}
