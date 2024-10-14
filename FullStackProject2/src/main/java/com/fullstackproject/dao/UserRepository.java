package com.fullstackproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstackproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}