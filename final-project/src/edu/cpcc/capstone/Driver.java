package edu.cpcc.capstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	// Driver....main....
	public static void main (String args[]) throws Exception{

		//Step 1 Create Scanner object and declare boolean "done" = false
		
		//Create new scanner instance/object
		Scanner scanner = new Scanner(System.in);

		//Declare boolean variable
		Boolean done = false;

		//Step 2
		
//		//while loop will display main menu until user chooses to quit 
		while (!done) {

			//Step 3
			//scanner object is injected into the displayMenu method
			Integer choice = displayMenu(scanner);
			//
			//Step 4
			//executeAction method passes scanner object & Integer choice
			executeAction(scanner, choice);

		}

		//system prints out "Goodbye" to the screen and closes the scanner
		System.out.println("Goodbye !!!");		

		scanner.close();

	}


	//-------------------------------------------------------------------------------------------


	public static int displayMenu(Scanner scanner) throws Exception{

		boolean booleanA = true;
		String choiceStr = "";
		int choice = 0;


		// TODO: display menu....
		List<String> mainMenu = new ArrayList<String>();		

		mainMenu.add("1. Add a task");
		mainMenu.add("2. Remove a task");
		mainMenu.add("3. Mark a task complete");
		mainMenu.add("4. List the tasks");
		mainMenu.add("5. Exit Task Manager");

		for(int i = 0; i < mainMenu.size(); i++ ) {

			System.out.println(mainMenu.get(i));

		}
		//run this while loop until a valid "choiceStr" is received from the user..
		while(booleanA) {
			try {
				//Ask user for method to execute
				System.out.println("Enter number of Method to execute: ");
		

				//Store the user input into userSelectionStr
				choiceStr = scanner.nextLine();
				
				//insert blank line
				System.out.println();

				//Convert String variable to integer variable
				choice = Integer.parseInt(choiceStr); 

				//the value for "choice" must be an integer value 1-5
				if (choice == (int)choice && choice > 0 && choice < 6 ) {
					booleanA = false;
				} else {
					throw new Exception("Enter integer value 1-3");
				}

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return choice;
	}


	//-------------------------------------------------------------------------------------------

	// TODO: 
	//executeAction method will
	public static Boolean executeAction(Scanner scanner, int choice) throws Exception{		

		boolean done = false;

		if (choice == 1) {
			// TODO: call the add task method in Task Manager.
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
			// TODO: call the list tasks method in Task Manager.
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




