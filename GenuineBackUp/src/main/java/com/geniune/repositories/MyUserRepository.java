package com.geniune.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geniune.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

	Optional<MyUser> findByUsername(String username);

	void deleteById(Long id);
}
