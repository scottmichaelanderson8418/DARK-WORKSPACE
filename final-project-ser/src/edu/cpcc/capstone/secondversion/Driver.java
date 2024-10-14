package edu.cpcc.capstone.secondversion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	// Driver....main....
	public static void main (String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);
		
		TaskManager taskManager = new TaskManager(new ArrayList<Task> ());
		
		
		/*
		 * List<Task> tasks = new ArrayList<Task> ());
		 * 
		 * 
		 * 
		 */
		
		Boolean done = false;
		while (!done) {
			Integer selection = displayMenu(scanner);
			done              = executeAction(taskManager, 
					                          scanner, 
					                          selection);
		}
		
		System.out.println("Goodbye !!!");		
		
		scanner.close();
		
	}
	
	// TODO: 
	public static int displayMenu(Scanner scanner) {
		
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
	
	private static void validateChoice(int choice) throws Exception  {
		if (choice <=0 || choice > 5) throw new Exception ("Invalid choice...please try again..");
	}

	
	public static Boolean executeAction(TaskManager taskManager, Scanner scanner, int choice) throws Exception {		
		
		boolean done = false;
	
		if (choice == 1) {
			// need this line for a scanner quirk...
			scanner.nextLine();
			taskManager.addTask(scanner);
		}
		else if (choice == 2) {
			taskManager.removeTask(scanner);
		}
		else if (choice == 3) {
			taskManager.completeTask(scanner);
		}
		else if (choice == 4) {
			taskManager.listTasks();
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
