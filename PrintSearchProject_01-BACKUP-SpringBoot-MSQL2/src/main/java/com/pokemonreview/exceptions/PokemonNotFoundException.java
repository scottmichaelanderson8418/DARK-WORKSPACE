package com.pokemonreview.exceptions;

public class PokemonNotFoundException extends RuntimeException {

	private static final long serialVersionID = 1;

	public PokemonNotFoundException(String message) {

		super(message);
	}

}
