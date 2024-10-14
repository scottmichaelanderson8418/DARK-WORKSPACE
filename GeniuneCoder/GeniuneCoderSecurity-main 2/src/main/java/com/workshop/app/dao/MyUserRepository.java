package com.workshop.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.app.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

	Optional<MyUser> findByUsername(String username);

	// this will create the necessary SQL query to find by email
	// Optional<MyUser> findByEmail(String email);

	// List<Student> findAll();

	// @Query("SELECT * FROM myposts.student")
	// // the domain argument will be taken by the query and fill it
	// List<Student> findAllStudents();

	// @Query("SELECT s from Student s WHERE s.email LIKE %:domain")
	// // the domain argument will be taken by the query and fill it
	// Optional<List<MyUser>> findByDomain(@Param("domain") String domain);
}
