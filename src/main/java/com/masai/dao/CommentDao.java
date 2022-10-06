package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Comment;
import com.masai.model.Post;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{

	
}
