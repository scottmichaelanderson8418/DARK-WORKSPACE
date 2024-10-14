package com.factory;

public class AnimalFactory {

	public static Animal getAnimal(String animalName) throws Exception {

		switch (animalName) {

		case "cow":
			return new Cow();
		case "dog":
			return new Dog();
		case "cat":
			return new Cat();
		default:
			throw new Exception("Invalid server type");

		}

	}
}
