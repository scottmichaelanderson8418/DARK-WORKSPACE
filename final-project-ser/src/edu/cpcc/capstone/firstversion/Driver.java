package edu.cpcc.capstone.firstversion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	// Driver....main....
	public static void main (String args[]) throws Exception  {

		// new line...must have !!!!
		TaskManager.initialize(new ArrayList<Task>());
		// TaskManager.initialize(null);
		
		Scanner scanner = new Scanner(System.in);
		
		Boolean done = false;
		while (!done) {
			Integer choice    = displayMenu(scanner);
			done              = executeAction(scanner, choice);			
		}
		
		System.out.println("Goodbye !!!");		
		
		scanner.close();
		
	}
	
	// TODO: 
	public static int displayMenu(final Scanner scanner) {
		
		boolean done = false;
		
		int choice = -1;

		System.out.println();
		System.out.println("*****************");
		System.out.println("** Main Menu **");
		System.out.println("*****************");
		System.out.println("1. Add a task");
		System.out.println("2. Remove a task");
		System.out.println("3. Complete a task");
		System.out.println("4. List all tasks");
		System.out.println("5. Quit");
		System.out.println("*****************");
		System.out.println("Please make a selection.");

		while (!done) {
			try {
				// valid inputs from the keyboard - "1" or "2" or "3" 
				// invalid input - "'" or ssdsddsds  or 2323ssdsddsd - cannot be converted to an integer...
				choice = scanner.nextInt();
				validateChoice(choice);
				done = true;
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input...please enter a numeric choice !\n");
				// to address a scanner quirk...
				scanner.nextLine();				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		
		// return choice...
		return choice;
	}	
	
	private static void validateChoice(final int choice) throws Exception  {
		if (choice <= 0 || choice > 5) throw new Exception ("Invalid choice...please try again.");
	}

	
	// TODO: 
	public static Boolean executeAction(final Scanner scanner, final int choice) throws Exception {		
		
		boolean done = false;
		
		// TODO: integration road map...Quit -> Add Task -> List Tasks -> Complete Task -> Remove Task
		
		if (choice == 1) {
			// DONE: call the add task method in Task Manager.
			// need this line for a scanner quirk...
			scanner.nextLine();
			TaskManager.addTask(scanner);
		}
		else if (choice == 2) {
			// TODO: call the remove task method in Task Manager.
			TaskManager.removeTask(scanner);
		}
		else if (choice == 3) {
			// TODO: call the complete task method in Task Manager.
			TaskManager.completeTask(scanner);
		}
		else if (choice == 4) {
			// DONE: call the list tasks method in Task Manager.
			TaskManager.listTasks();
		}
		else if (choice == 5) {
			done =  true;
		}
		else {
			System.out.println("Invalid choice...please try again");
		}
		
		return done;	
		
		
	}		
	

}
