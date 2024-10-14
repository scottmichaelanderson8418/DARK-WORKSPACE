package com.logger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logger.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
