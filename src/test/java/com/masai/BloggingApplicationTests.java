package com.masai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.masai.dao.PostDao;
import com.masai.model.Post;
import com.masai.service.PostService;

@SpringBootTest
class BloggingApplicationTests {

	@Test
	void contextLoads() {
	}
	
    @Autowired
	private PostService service;
	
    @MockBean
    private PostDao repo;

    
    @Test
    public void createPostTest() {
    	
    Post post =new Post();
    post.setId(1);
    post.setTitle("Thor");
    post.setBody("king");
    post.setCreatedAt(LocalDateTime.now());
    
    when(repo.save(post)).thenReturn(post);
    assertEquals(post, service.createPost(post));
    }
    
    @Test
    public void getAllPostTest() {
    	
    	when(repo.findAll()).thenReturn(Stream.of(new Post(1, "ironman", "stark", LocalDateTime.now(), null),new Post(2, "hulk", "superhuman", LocalDateTime.now(), null) )
    			.collect(Collectors.toList()));
    	assertEquals(2, service.getAllPost().size());
    	
    }
    
  @Test  
  public void getPostById() {
    	Integer Id = 1;
    	when(repo.findById(Id))
    	.thenReturn(Optional.of( new Post(1, "BlackWidow", "scarlett", LocalDateTime.now(), null)));
    }
    
    
  
    
}
