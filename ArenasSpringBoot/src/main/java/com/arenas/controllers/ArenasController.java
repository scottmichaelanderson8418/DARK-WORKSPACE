
package com.arenas.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arenas.models.Actor;
import com.arenas.service.CreateArenasDB;

@Controller
@RequestMapping({ "/", "/arenas" })
public class ArenasController {

	// heyscottypotty

	// -- Spring boot automatically loads the application.properties file whenever
	// it starts up
	// -- Spring bo
	// ot finds the ActorsController class marked with the
	// “@Controller” annotation
	// -- The “@RequestMapping” annotation maps HTTP requests
	// to handler methods of MVC and REST
	// -- The @Value annotation tells spring boot
	// to locate the value of "$(spring.datasource.url)" in the Application
	// Properties file.
	// -- The “@Value” annotation injects the value of the
	// “spring.datasource.url” which is found in the Application properties into the
	// value of “private String url;”
	// -- private String url = jdbc:mysql://localhost:3306/sakila

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	CreateArenasDB obj = new CreateArenasDB();

	@Autowired
	CreateArenasDB createArenasDB;

	//
	// public void create
	// createArenasDB
	//

	@GetMapping("/")
	// "Model model" is the data bucket to dump data into the person that you bound
	// with index html page
	public String getAllActors(Model model) throws Exception {

		// An ArrayList named "actors" is created to store each row instance of the
		// actors
		List<Actor> actorsYYY = new ArrayList<Actor>();

		// Code to query the database and add actors to the List will go here
		// "con" is a non-primitive datatype (reference variable) of the Interface
		// "Connection" the interface "Connection" creates a "Statement" object for
		// sending SQL statements to the database

		Connection con;

		try {
			//
			// the "con" reference variable is set equal to the getConnection() method in
			// the DriverManager class the getConnection method returns the result of
			// passing in "url, username, password"
			//
			con = DriverManager.getConnection(url, username, password);
			//
			// the "getConnection(url, username, password)" will return "(getConnection(url,
			// info, Reflection.getCallerClass()))";
			//
			// the Reflection class is used to filter out fields and methods from certain
			// classes from public view
			//
			// the getCallerClass() method is used to retrieve access flags written to the
			// class file the getCallerClass() method in the Reflection class will determine
			// if the "password" is correct.
			//
			// --------------------------------------------------------------------------------------------------------------------
			//
			// @CallerSensitive public static Connection getConnection(String url, String
			// user, String password) throws SQLException {
			//
			// java.util.Properties info = new java.util.Properties();
			//
			// if (user != null) { info.put("user", user); } if (password != null) {
			// info.put("password", password); }
			//
			// return (getConnection(url, info, Reflection.getCallerClass())); }
			//
			// public class Reflection {
			//
			// - Used to filter out fields and methods from certain classes from public
			// view, where they are sensitive or they may contain VM-internal objects. These
			// Maps are updated very rarely. Rather than synchronize on each access, we use
			// copy-on-write
			//
			//
			//
			// @HotSpotIntrinsicCandidate public static native Class<?> getCallerClass();
			//
			// - Retrieves the access flags written to the class file. For inner classes
			// these flags may differ from those returned by Class.getModifiers(), which
			// searches the InnerClasses attribute to find the source-level access flags.
			// This is used instead of Class.getModifiers() for run-time access checks due
			// to compatibility reasons; see 4471811. Only the values of the low 13 bits
			// (i.e., a mask of 0x1FFF) are guaranteed to be valid.
			//
			// --------------------------------------------------------------------------------------------------------------------
			//
			// "stmt" is a non-primitive datatype (reference variable) of the Interface
			// Statement Add a statement object to tell it which query you wish to run. To
			// do that you will need to add the following code within the try block of the
			// getAllActors method after you assigned the connection to the con object
			//
			//
			// createStatement() - Creates a <code>PreparedStatement</code> object for
			// sending parameterized SQL statements to the database. <P>

			Statement stmt = con.createStatement();
			//

			//

			//

			// Executes the given SQL statement, which returns a single
			// <code>ResultSet</code> object. <p>

			ResultSet rs = stmt.executeQuery("SELECT * FROM actor");
			//
			// The "rs" object contains the results of the Actors query. We will fill the
			// list of actors using a while loop and the result set. The while loop is
			// looping over each record in the "ResultSet" and getting the value of the
			// field name passed as a string
			//
			// SMA Notes: A new object/instance of the ActorFilm class is created named
			// "newActorFilm" The while loop will loop through and retrieve the results from
			// the sequel server query named "SELECT * FROM actor" The results of the SQL
			// query "SELECT * FROM actor" are injected into non-primitive variable of the
			// "ResultSet" Interface named "rs".
			//
			//
			while (rs.next()) {

				// create a new Actor object
				Actor newActor = new Actor();
				//
				// get the values from each column of the current row and add them to the new
				// Album
				newActor.setActor_id(rs.getInt("actor_id"));
				newActor.setFirst_name(rs.getString("first_name"));
				newActor.setLast_name(rs.getString("last_name"));
				newActor.setLast_update(rs.getTimestamp("last_update"));
				//
				// add the new actor to the actors list
				actorsYYY.add(newActor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// The instance of the ArrayList "actors" gets bound to the actor
		model.addAttribute("actors", actorsYYY);

		// The string "index will be looked for in src/main/resources/templates

		return "actors";
	}

	public static createArenasDatabase(CreateArenasDB obj) {
		
	obj.createArenasDB(null);
	}
}