package com.learnspringboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.dto.PrintDrawingDto;
import com.learnspringboot.dto.PrintDrawingResponse;
import com.learnspringboot.model.MyUser;
import com.learnspringboot.repository.MyUserRepository;
import com.learnspringboot.service.PrintDrawingService;

/**
 * Controller class for handling print drawing related requests.
 */
@RequestMapping(value = "/api")
@RestController
public class PrintController {

	/** The logger. */
	// Initialize a logger for the class
	public static final Logger logger = LoggerFactory.getLogger(PrintController.class.getName());

	/** The my user repository. */
	@Autowired
	private MyUserRepository myUserRepository;

	/** The print drawing service. */
	@Autowired
	private PrintDrawingService printDrawingService;

	/**
	 * Constructor injection for PrintDrawingService.
	 * 
	 * @param printDrawingService the PrintDrawingService instance
	 */
	public PrintController(PrintDrawingService printDrawingService) {
		this.printDrawingService = printDrawingService;
	}

	@GetMapping("/")
	public String sayHello() {
		return "Hello";
	}

	/**
	 * Creates a new print drawing.
	 *
	 * @param printDrawingDto the print drawing details
	 * @return the created print drawing
	 */
	@PostMapping("/print/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PrintDrawingDto> createPrint(@RequestBody PrintDrawingDto printDrawingDto) {

		logger.trace("Entered......createPrint() ");

		System.out.println("/print/create"); // Log the creation request

		return new ResponseEntity<>(printDrawingService.createPrint(printDrawingDto), HttpStatus.CREATED);
	}

	/**
	 * Deletes a print drawing by ID.
	 *
	 * @param id the ID of the print drawing to delete
	 * @return a response indicating the result of the delete operation
	 */
	@DeleteMapping("/print/delete/{id}")
	public ResponseEntity<String> deletePrintById(@PathVariable("id") int id) {
		printDrawingService.deleteByPrintId(id);
		return new ResponseEntity<>("Successfully deleted print drawing id = " + id, HttpStatus.OK);
	}

	/**
	 * Deletes a user by ID.
	 *
	 * @param id the ID of the user to delete
	 * @return a response indicating the result of the delete operation
	 * @throws NotFoundException if the user is not found
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws NotFoundException {
		myUserRepository.deleteById(id);
		return new ResponseEntity<>("User found and deleted", HttpStatus.OK);
	}

	/**
	 * Retrieves print drawings with pagination and sorting.
	 *
	 * @param pageNo             the page number to retrieve
	 * @param pageSize           the size of the page to retrieve
	 * @param field              the field to sort by
	 * @param diameterMinValue   the minimum diameter value to filter
	 * @param diameterMaxValue   the maximum diameter value to filter
	 * @param faceLengthMinValue the minimum face length value to filter
	 * @param faceLengthMaxValue the maximum face length value to filter
	 * @return a response containing the print drawings
	 */
	@GetMapping("/pagination/filter")
	public PrintDrawingResponse findByDiameterWithPaginationAndSorting(
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "sortField", required = false) String field,
			@RequestParam(value = "diameterMinValue", required = true) Float diameterMinValue,
			@RequestParam(value = "diameterMaxValue", required = true) Float diameterMaxValue,
			@RequestParam(value = "faceLengthMinValue", required = true) Float faceLengthMinValue,
			@RequestParam(value = "faceLengthMaxValue", required = true) Float faceLengthMaxValue) {

		// Set default values if parameters are not provided
		if (field == null) {
			field = "diameterLow";
		}
		if (diameterMinValue == null) {
			diameterMinValue = 0.0f;
		}
		if (diameterMaxValue == null) {
			diameterMaxValue = 100.0f;
		}
		if (faceLengthMinValue == null) {
			faceLengthMinValue = 0.0f;
		}
		if (faceLengthMaxValue == null) {
			faceLengthMaxValue = 3000.0f;
		}

		// Retrieve print drawings with pagination and sorting
		return printDrawingService.findDiameterWithPaginationAndSorting(pageNo, pageSize, field, diameterMinValue,
				diameterMaxValue, faceLengthMinValue, faceLengthMaxValue);
	}

	@GetMapping("/pagination/filterThym")
	public String findByDiameterWithPaginationAndSortingThym(Model model,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "sortField", required = false) String field,
			@RequestParam(value = "diameterMinValue", required = true) Float diameterMinValue,
			@RequestParam(value = "diameterMaxValue", required = true) Float diameterMaxValue,
			@RequestParam(value = "faceLengthMinValue", required = true) Float faceLengthMinValue,
			@RequestParam(value = "faceLengthMaxValue", required = true) Float faceLengthMaxValue) {

		// Set default values if parameters are not provided
		if (field == null) {
			field = "diameterLow";
		}
		if (diameterMinValue == null) {
			diameterMinValue = 0.0f;
		}
		if (diameterMaxValue == null) {
			diameterMaxValue = 100.0f;
		}
		if (faceLengthMinValue == null) {
			faceLengthMinValue = 0.0f;
		}
		if (faceLengthMaxValue == null) {
			faceLengthMaxValue = 3000.0f;
		}

		PrintDrawingResponse printDrawingResponse = printDrawingService.findDiameterWithPaginationAndSorting(pageNo,
				pageSize, field, diameterMinValue, diameterMaxValue, faceLengthMinValue, faceLengthMaxValue);

		List<PrintDrawingDto> printDrawingDtoList = printDrawingResponse.getContent();
		model.addAttribute("printDrawingResponse", printDrawingResponse);
		model.addAttribute("printDrawingDtoList", printDrawingDtoList);

		return "printDrawingDtoList";

	}

	/**
	 * Retrieves all prints with pagination.
	 *
	 * @param pageNo   the page number to retrieve
	 * @param pageSize the size of the page to retrieve
	 * @return a response containing the print drawings
	 */
	@GetMapping("/print")
	public ResponseEntity<PrintDrawingResponse> getAllPrints(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return new ResponseEntity<>(printDrawingService.getAllPrints(pageNo, pageSize), HttpStatus.OK);
	}

	/**
	 * Retrieves all users stored in the "myusers" table.
	 *
	 * @return a response containing the list of users
	 */
	@GetMapping("/admin/getallusers")
	public ResponseEntity<List<MyUser>> getAllUsers() {

		List<MyUser> users = myUserRepository.findAll();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/**
	 * Retrieves a print drawing by ID.
	 *
	 * @param id the ID of the print drawing to retrieve
	 * @return a response containing the print drawing
	 */
	@GetMapping("/print/{id}")
	public ResponseEntity<PrintDrawingDto> getPrintDetail(@PathVariable("id") int id) {
		return new ResponseEntity<>(printDrawingService.getPrintById(id), HttpStatus.OK);
	}

	/**
	 * Retrieves all print drawings matching the search field with sorting.
	 *
	 * @param field the field to sort by
	 * @return a list of print drawings
	 */
	@GetMapping("/printDrawings/findAll/{searchField}")
	public List<PrintDrawingDto> getProductsWithSort(@PathVariable("searchField") String field) {
		List<PrintDrawingDto> drawings = printDrawingService.findAllProductsWithSorting(field);
		return drawings;
	}

	/**
	 * Admin accessible homepage.
	 *
	 * @return a welcome message for admin
	 */
	@GetMapping("/admin/home")
	public String handleAdminHome() {
		return "Welcome to ADMIN home!";
	}

	/**
	 * User accessible homepage.
	 *
	 * @return a welcome message for user
	 */
	// Endpoint: User accessible home page
	@GetMapping("/user/home")
	public String handleUserHome() {
		return "Welcome to the user home page :)";
	}

	/**
	 * Accessible by everyone.
	 *
	 * @return a welcome message for the homepage
	 */
	@GetMapping("/home")
	public String handleWelcome() {
		return "Welcome to the homepage";
	}

	/**
	 * Updates a print drawing by ID.
	 *
	 * @param printDrawingUpdate the print drawing details to update
	 * @param id                 the ID of the print drawing to update
	 * @return the updated print drawing
	 */
	@PutMapping("/print/update/{id}")
	public ResponseEntity<PrintDrawingDto> updatePrintDetail(@RequestBody PrintDrawingDto printDrawingUpdate,
			@PathVariable("id") int id) {

		PrintDrawingDto response = printDrawingService.updatePrint(printDrawingUpdate, id);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
