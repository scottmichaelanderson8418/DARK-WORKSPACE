package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

}
