package com.logger.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.logger.dao.MessageRepository;
import com.logger.model.Message;

@RestController
public class ScottMessageController {

    MessageRepository dao;
    // ---------------------------------------
    // Initialize a logger for the class
    Logger logger = LoggerFactory.getLogger(ScottMessageController.class.getName());

    // ----------------------------------------

    // Constructor based auto wiring is helpful especially when testing the
    // controller...where you can
    // switch the real repository with a mock repository.

    @Autowired
    public ScottMessageController(MessageRepository dao) {
	this.dao = dao;
    }

    // URIs
    // Get me all chat messages
    @GetMapping("/chats")
    public List<Message> getAllMessages() {
	System.out.println("Entered getAllMessages()");

	// ------------------------------------------
	logger.trace("getAllMessages: Entered......");
	logger.debug("getAllMessages: Entered......");
	// ------------------------------------------
	// Similar of this SQL Statement: select * from message;
	List<Message> foundMessages = dao.findAll();
	// ------------------------------------------
	logger.trace("Exited: getAllMessages: ");
	logger.debug("Exited: getAllMessages: ");
	// ----------------------------------------
	return foundMessages;
    }

    // Get a specific chat message
    @GetMapping("/chats/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable(value = "id") Integer id) {

	Message foundMessage = dao.findById(id).orElse(null);

	if (foundMessage == null) {
	    // --------------------------------------
	    logger.trace("No messages found for " + id);
	    // ----------------------------------------------
	    return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
	}
	// --------------------------------------
	logger.trace("Get chats/{id} Implemented " + id);
	// ----------------------------------------------
	return ResponseEntity.ok(foundMessage);
    }

    // Create a new chat message
    @PostMapping("/chats")
    public ResponseEntity<Message> postMessage(@RequestBody Message message) {

	System.out.println("Entered Response Entity:------");
	// --------------------------------------
	logger.trace("Posted Message" + message);
	// ----------------------------------------------
	// saving to DB using instance of the repo interface
	Message createdMessage = dao.save(message);

	// RespEntity crafts response to include correct status codes.
	return ResponseEntity.ok(createdMessage);
    }

    // Create a new chat message
    @PutMapping("/chats")
    public ResponseEntity<Integer> updateMessage(@RequestBody Message messageToUpdate) {
	// --------------------------------------
	logger.trace("Message Updated " + messageToUpdate.getId());
	// ----------------------------------------------
	// saving to DB using instance of the repo interface
	Message foundMessage = dao.findById(messageToUpdate.getId()).orElse(null);
	if (foundMessage == null) {
	    // --------------------------------------
	    logger.trace("No messages found for " + messageToUpdate.getId());
	    // ----------------------------------------------

	    // RespEntity crafts response to include correct status codes.
	    return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
	} else {
	    dao.save(messageToUpdate);
	}
	return ResponseEntity.ok().build();
    }

    // Delete a chat message
    @DeleteMapping("/chats/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable(value = "id") Integer id) {
	// --------------------------------------
	logger.error("Message Deleted " + id);
	// ----------------------------------------------
	Message foundMessage = dao.findById(id).orElse(null);
	if (foundMessage == null) {
	    // --------------------------------------
	    logger.error("No messages found for " + id);
	    // ----------------------------------------------
	    return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
	} else {
	    dao.delete(foundMessage);
	}

	return ResponseEntity.ok().build();
    }

}
