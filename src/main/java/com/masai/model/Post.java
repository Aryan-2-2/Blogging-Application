package com.masai.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.nullability.AlwaysNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "title should not be null")
	private String title;
	
	@NotNull(message = "body should not be null")
	private String body;
	     
    @CreationTimestamp
	private LocalDateTime createdAt;

	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	List<Comment> comment;
	
}
