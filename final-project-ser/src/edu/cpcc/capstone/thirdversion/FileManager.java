package edu.cpcc.capstone.thirdversion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


// Good read: https://www.geeksforgeeks.org/how-to-serialize-arraylist-in-java/
public class FileManager {
	
	public static void writeToFile(List<Task> tasks) throws Exception {

		FileOutputStream writeData = new FileOutputStream(Constants.PERSISTENT_FILE_NAME);
		ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		writeStream.writeObject(tasks);
		writeStream.flush();
		writeStream.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Task> readFromFile() throws Exception {

		List<Task> tasks = null;
		File taskFile = new File("tasks.ser");
		// if file already exists will do nothing 
		taskFile.createNewFile(); 			
		if (taskFile.isFile() && taskFile.length() == 0) {
			tasks =  new ArrayList<Task> ();
		}else {
			//if file present, read into array list
			FileInputStream readData = new FileInputStream(Constants.PERSISTENT_FILE_NAME);
			ObjectInputStream readStream = new ObjectInputStream(readData);

			tasks = (ArrayList<Task>) readStream.readObject();
			readStream.close();
		}
		return tasks;

	}

	
	
	

}














































