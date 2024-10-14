package edu.cpcc.capstone.secondversion.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.cpcc.capstone.secondversion.Task;
import edu.cpcc.capstone.secondversion.TaskManager;

class TestTaskManager {
	
	static Scanner scanner = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {		
		scanner = new Scanner (System.in);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		scanner.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testValidListCreation() {		
		TaskManager manager = new TaskManager(new ArrayList<Task> ());
		assertNotNull(manager.getTasks());		
	}
	
	@Test
	void testAddTask() {
		System.out.println("testAddTask");
		TaskManager manager = new TaskManager(new ArrayList<Task> ());
		try {
			manager.addTask(scanner);
			assertEquals(1, manager.getTasks().size());
		}catch (Exception e) {
			fail();
		}
	}
	
	
	@Test
	void testListTasks() {
		System.out.println("testListTasks");
		TaskManager manager = new TaskManager(new ArrayList<Task> ());
		try {
			manager.addTask(scanner);
			manager.addTask(scanner);
			manager.addTask(scanner);
			manager.addTask(scanner);
			assertEquals(4, manager.getTasks().size());
		}catch (Exception e) {
			fail();
		}
	}
	
	
	@Test
	void testRemoveTask() {
		System.out.println("testRemoveTask");
		TaskManager manager = new TaskManager(new ArrayList<Task> ());
		try {
			manager.addTask(scanner);
			manager.addTask(scanner);
			manager.addTask(scanner);
			manager.addTask(scanner);
			manager.removeTask(scanner);
			assertEquals(3, manager.getTasks().size());
		}catch (Exception e) {
			fail();
		}
	}

}
