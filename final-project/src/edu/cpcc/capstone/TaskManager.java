package edu.cpcc.capstone;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
	
	
	

	private static List<Task> tasks = new ArrayList<>();

	// Add Task
	public static void addTask(Scanner scanner) throws Exception  {

		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);

		System.out.println(Constants.ADD_TASK_MESSAGE);
		String text = scanner.nextLine();
		Task task = new Task(text);

		tasks.add(task);		



	}
	
	

	//---------------------------------------------------------------------------------------------	
	// Remove Task
	public static void removeTask(Scanner scanner) throws Exception  {

		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);

		if (!tasks.isEmpty()) {	
			listTasks();
			System.out.println();
			System.out.println(Constants.REMOVE_TASK_MESSAGE);
			int choice;
			boolean done = false;
			while (!done) {
				try {
					choice = scanner.nextInt();
					choice -= 1;
					tasks.remove(choice);
					listTasks();
					done = true;
				} 
				catch (Exception exception) {
					System.out.println(Constants.INVALID_INPUT_MESSAGE);
				}
				scanner.nextLine();		
			}
		} else {
			System.out.println(Constants.EMPTY_TASK_LIST_MESSAGE);
		}
	}

	//---------------------------------------------------------------------------------------------	
	// Complete Task...
	public static void completeTask(Scanner scanner) throws Exception {

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


	//---------------------------------------------------------------------------------------------	

	//	//List Tasks with StringBuilder
	//	public static void listTasks() {
	//		StringBuilder taskList = new StringBuilder();
	//		
	//		for(int k = 0; k < tasks.size(); k++) {
	//			
	//			taskList.append(k+1+ ". ");
	//			
	////			taskList.append(".")
	//			
	//			
	//			taskList.append(tasks.get(k));
	//			
	//			taskList.append(", ");
	//		}
	//		
	//		
	//		
	//		System.out.println(taskList.toString());
	//		
	//		
	////		for(int i = 0 ; i < taskList.length(); i++)  {
	////			
	////			System.out.println(taskList);
	////	
	////			
	////		}
	//			
	//		
	//			
	//			
	//	}


	//---------------------------------------------------------------------------------------------	

	// List Tasks...
	public static void listTasks() throws Exception {

		if (tasks == null ) throw new Exception (Constants.NULL_TASK_LIST_MESSAGE);

		if (tasks.size() > 0) {
			for (int i= 0; i < tasks.size(); i++) {
				// this will display a task in a single line...
				tasks.get(i);
				
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
