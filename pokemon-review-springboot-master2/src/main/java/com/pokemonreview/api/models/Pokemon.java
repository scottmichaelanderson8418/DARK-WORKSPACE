package com.pokemonreview.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	@OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<Review>();
	private String type;

	public Pokemon() {

	}

	public Pokemon(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setType(String type) {
		this.type = type;
	}

}
