package edu.cpcc.lab.mypost.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cpcc.lab.mypost.service.model.Post;

// Define the Model and the Primary Key
public interface PostRepository extends JpaRepository<Post, Integer> {
}
