package com.pokemonreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.pokemonreview.dto.PrintDrawingDto;
import com.pokemonreview.dto.PrintDrawingResponse;
import com.pokemonreview.model.PrintDrawing;
import com.pokemonreview.repository.PrintDrawingRespository;
import com.pokemonreview.service.PrintDrawingService;

@RestController
@RequestMapping(value = "/api")
public class PrintController {

	private PrintDrawingService printDrawingService;

	private PrintDrawingRespository printDrawingRepository;

	// dependency injection using a contructor
	@Autowired
	public PrintController(
			PrintDrawingRespository printDrawingRepository,
			PrintDrawingService printDrawingService) {
		this.printDrawingRepository = printDrawingRepository;
		this.printDrawingService = printDrawingService;

	}

	@PostMapping("/print/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PrintDrawingDto> createPrint(
			@RequestBody PrintDrawingDto printDrawingDto) {

		System.out.println("/print/create");
		// Note: PokemonServiceImpl implements the
		// "pokemonService.createPokemon(pokemonDto)" method

		// copy created Pokemon to Pokemon Object
		// copy created Pokemon to PokemonDto Object

		return new ResponseEntity<>(printDrawingService.createPrint(printDrawingDto),
				HttpStatus.CREATED);

	}

	@GetMapping("/print/getAllPrints")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PrintDrawingResponse> getAllPrints(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

		return new ResponseEntity<>(printDrawingService.getAllPrints(pageNo, pageSize),
				HttpStatus.OK);

	}

	@PostMapping("/print/create/list")
	public ResponseEntity<List<PrintDrawing>> postPrintList(
			@RequestBody List<PrintDrawing> printDrawingList) {

		System.out.println("/print/create/list");

		for (int i = 0; i < printDrawingList.size(); i++) {

			PrintDrawing printDrawing = printDrawingRepository.save(printDrawingList.get(i));

		}

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(printDrawingList);
	}

	@GetMapping("/print/{id}")
	public ResponseEntity<PrintDrawingDto> printDetail(@PathVariable int id) {

		return new ResponseEntity<>(printDrawingService.getPrintById(id), HttpStatus.OK);
	}

	@PutMapping("/print/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PrintDrawingDto> updatePokemon(
			@RequestBody PrintDrawingDto printDrawingDto, @PathVariable("id") int printDrawingId) {

		PrintDrawingDto response = printDrawingService.updatePrint(printDrawingDto, printDrawingId);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/print/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int printDrawingId) {
		System.out.println("Print Deleted with Id = " + printDrawingId);

		printDrawingService.deletePrintId(printDrawingId);

		return new ResponseEntity<>("Print Deleted with id=" + printDrawingId, HttpStatus.OK);
	}
}

// /* These are just "STUBS" we would never do this in real life production */
// @GetMapping("/pokemon")
// public ResponseEntity<List<Pokemon>> getPokemons() {
//
// List<Pokemon> pokemonList = new ArrayList<>();
//
// pokemonList.add(new Pokemon(1, "Scott", "pokemon Scott"));
// pokemonList.add(new Pokemon(2, "Nicole", "pokemon Nicole"));
// pokemonList.add(new Pokemon(3, "Evelyn", "pokemon Evelyn"));
//
// System.out.println("04_20_202404_20_2004_20_204_20_2004_20_2004_20_2024g");
//
// return ResponseEntity.ok(pokemonList);
//
// }

// @GetMapping("/pokemon")
// public ResponseEntity<List<Pokemon>> getAllPokemons() {
//
// List<Pokemon> pokemonList = pokemonRepository.findAll();
//
// System.out.println("Get All Pokemons");
//
// return ResponseEntity.ok(pokemonList);
//
// }

// @GetMapping("/pokemon/{id}")
// public ResponseEntity<Optional<Pokemon>> getAllPokemons(@PathVariable int id)
// {
//
// Optional<Pokemon> pokemonFound = pokemonRepository.findById(id);
//
// return ResponseEntity.ok(pokemonFound);
//
// }

// @PostMapping("/pokemon/create")
// public ResponseEntity<Pokemon> createPokemons(@RequestBody Pokemon pokemon) {
//
// Pokemon createdPokemon = pokemonRepository.save(pokemon);
//
// return ResponseEntity.ok(createdPokemon);
//
// }
