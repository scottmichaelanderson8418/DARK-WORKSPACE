package edu.cpcc.lab.mypost.service.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cpcc.lab.mypost.service.dao.PostRepository;
import edu.cpcc.lab.mypost.service.model.Post;

// NOTE: make sure you complete all the TODO's in the below methods.
// NOTE: Use the Lesson 6 Hands On as a reference...
@RestController
@RequestMapping(value = "/myposts/api/posts", headers = "Accept=application/json")
public class MyPostController {

	// NOTE: Integrating logging....for now the underlying engine is Logback.
	// NOTE: make sure you include this line in every new controller for activating
	// logging..
	Logger logger = LoggerFactory.getLogger(MyPostController.class.getName());

	private PostRepository dao;

	@Autowired
	public void PostRepository(PostRepository dao) {
		this.dao = dao;
	}

	// URL: http://localhost:8080/myposts/api/posts
	@GetMapping()
	public List<Post> getAllMessages() {

		logger.trace("getPosts(): entered...");
		logger.debug("getPosts(): entered...");

		// Similar to this SQL Statement: select * from message;
		List<Post> foundPosts = dao.findAll();

		logger.trace("getPosts(): exiting...");
		logger.debug("getPosts(): exiting...");

		return foundPosts;
	}

	// URL: http://localhost:8080/myposts/api/posts/{id}
	// Example: http://localhost:8080/myposts/api/posts/1
	@GetMapping("/{id}")
	public ResponseEntity<Post> get(@PathVariable(value = "id") Integer postId) {

		logger.trace("getPost(): entered...");
		logger.debug("getPost(): entered...");

		Post foundPost = dao.findById(postId).orElse(null);

		if (foundPost == null) {
			return ResponseEntity.notFound().header("Post", "No Post found with that id value").build();
		}

		logger.trace("getPost(): exiting...");
		logger.debug("getPost(): exiting...");

		return ResponseEntity.ok(foundPost);
	}

	// URL: http://localhost:8080/myposts/api/posts
	@PostMapping()
	public ResponseEntity<Post> create(@RequestBody Post newPost) {

		logger.trace("postPost(): entered...");
		logger.debug("postPost(): entered...");

		// Saving to DB using an instance of the repo interface.
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		newPost.setPostdatetime(ts);

		// TODO: write the post to the database...
		Post createdPost = dao.save(newPost);

		logger.trace("postPost(): exited...");
		logger.debug("postPost(): exited...");

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdPost);
	}

	// URL: http://localhost:8080/myposts/api/posts
	@PutMapping()
	public ResponseEntity<Post> update(@RequestBody Post postToUpdate) {

		logger.trace("updatePost(): entered...");
		logger.debug("updatePost(): entered...");

		Post foundPost = dao.findById(postToUpdate.getId()).orElse(null);
		if (foundPost == null) {
			return ResponseEntity.notFound().header("Post", "Post not found with that id").build();

		} else {
			dao.save(postToUpdate);
		}

		logger.trace("updatePost(): exited...");
		logger.debug("updatePost(): exited...");

		return ResponseEntity.ok(postToUpdate);
	}

	// URL: http://localhost:8080/myposts/api/posts
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> delete(@PathVariable(value = "id") Integer postId) {

		logger.trace("deletePost(): entered...");
		logger.debug("deletePost(): entered...");

		Post foundPost = dao.findById(postId).orElse(null);

		if (foundPost == null) {
			return ResponseEntity.notFound().header("Post", "No Post found with that id value").build();
		} else {
			dao.delete(foundPost);
		}

		logger.trace("deletePost(): exited...");
		logger.debug("deletePost(): exited...");

		return ResponseEntity.ok().build();
	}

}