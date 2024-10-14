package edu.cpcc.capstone.thirdversion;

import java.util.List;
import java.util.Scanner;

public class TaskManager {
	
	private List<Task> tasks;
	

	public TaskManager(final List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
	
	
	// Add Task
	public void addTask(Scanner scanner) throws Exception  {
		
		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);
		System.out.println(Constants.ADD_TASK_MESSAGE);
		String text = scanner.nextLine();
		Task task = new Task(text);
		tasks.add(task);		
	}
	
	
	// Remove Task
	public void removeTask(final Scanner scanner) throws Exception  {
		
		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);
		
		if (!tasks.isEmpty()) {	
			// display the list of tasks...
			listTasks();
			System.out.println();
			System.out.println(Constants.REMOVE_TASK_MESSAGE);
			int choice;
			boolean done = false;
			while (!done) {
				try {
					choice = scanner.nextInt();
					// to align with the indexing scheme of the array list since task #s are displayed from 1
					// choice = choice - 1
					choice -= 1;
					// FIXME: what if the task # is greater than the size of the array list ?					
					// remove the task from the list...
					tasks.remove(choice);
					// listTasks();
					// exit the loop...
					done = true;
				} 
				catch (Exception exception) {
					System.out.println(Constants.INVALID_INPUT_MESSAGE);
				}
				// to address a scanner quirk....
				scanner.nextLine();		
			}
		} else {
			System.out.println(Constants.EMPTY_TASK_LIST_MESSAGE);
		}
	}
	
	
	// Complete Task...
	public void completeTask(final Scanner scanner) throws Exception {
		
		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);
				
		if (!tasks.isEmpty()) {
			// display only the list of tasks to be completed...filter out the completed tasks..
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).getComplete() == false) {
					System.out.println((i+1) + ". " + tasks.get(i).toString());
				}
			}
			
			System.out.println(Constants.COMPLETE_TASK_MESSAGE);
			int choice;
			boolean done = false;
			while (!done) {
				try {
					choice = scanner.nextInt();
					for (int i = 0; i < tasks.size(); i++) {
						// increment by 1 to compare the location of the node with the choice
						if ((i+1) == choice) {
							tasks.get(i).setComplete(true);
						}
					}
					done = true;
				} 
				catch (Exception exception) {
					System.out.println(Constants.INVALID_INPUT_MESSAGE);
				}
				scanner.nextLine();
			}			
		} 
		else {
			System.out.println(Constants.EMPTY_TASK_LIST_MESSAGE);
		}
	}	
	
	
	// List Tasks...
	public void listTasks() throws Exception {
		
		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);
		
		if (!tasks.isEmpty()) {
			for (int i= 0; i < tasks.size(); i++) {
				// this will display a task in a single line...
				// FIXME: try using a String Builder instead of doing string concatenation...and then display to System out..
				System.out.println((i+1) + ". " + tasks.get(i).toString());
			}	
			System.out.println();
		}
		else {
			System.out.println(Constants.EMPTY_TASK_LIST_MESSAGE);
		}
	}
	
	
	

}
