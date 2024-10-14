package edu.cpcc.lab.mypost.service.model;

// FIXME: 
// Cannot have the entity having a SQL dependency...need to convert to a java time and then convert.
// https://mkyong.com/java8/java-8-convert-localdatetime-to-timestamp/
//import java.time.LocalDateTime;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// NOTE: What is a POST ? --- this is not be confused with the HTTP POST verb.
// A piece of writing, image, or other item of content published online, typically on a BLOG or social media web site.
// Used in a sentence as so : "in a recent post, he cautioned investors to be wary of these predictions"

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String authorid;

	private String message;

	private Timestamp postdatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getPostdatetime() {
		return postdatetime;
	}

	public void setPostdatetime(Timestamp postdatetime) {
		this.postdatetime = postdatetime;
	}

}
