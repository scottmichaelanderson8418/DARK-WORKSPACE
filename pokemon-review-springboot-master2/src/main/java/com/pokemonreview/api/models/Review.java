package com.pokemonreview.api.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private int start;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pokemon_id")
	private Pokemon pokemon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStars() {
		return start;
	}

	public void setStars(int stars) {
		this.start = stars;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}
