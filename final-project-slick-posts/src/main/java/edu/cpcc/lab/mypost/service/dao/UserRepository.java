package edu.cpcc.lab.mypost.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cpcc.lab.mypost.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String userName);
}
