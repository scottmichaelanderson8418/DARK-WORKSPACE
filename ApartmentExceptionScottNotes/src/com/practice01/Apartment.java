package com.practice01;

public class Apartment {

	private String streetAddress;
	private int apartmentNumber;
	private int numberOfBedRooms;
	private int rentValue;

	public Apartment() {
		this.streetAddress = "";
		this.apartmentNumber = 0;
		this.numberOfBedRooms = 0;
		this.rentValue = 0;

	}

	public Apartment(String streetAddress, int apartmentNumber, int numberOfBedRooms, int rentValue) {
		super();

		this.streetAddress = streetAddress;
		this.apartmentNumber = apartmentNumber;
		this.numberOfBedRooms = numberOfBedRooms;
		this.rentValue = rentValue;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public int getNumberOfBedRooms() {
		return numberOfBedRooms;
	}

	public void setNumberOfBedRooms(int numberOfBedRooms) {
		this.numberOfBedRooms = numberOfBedRooms;
	}

	public int getRentValue() {
		return rentValue;
	}

	public void setRentValue(int rentValue) {
		this.rentValue = rentValue;
	}

	@Override
	public String toString() {
		return "Apartment [streetAddress=" + streetAddress + ", apartmentNumber=" + apartmentNumber
				+ ", numberOfBedRooms=" + numberOfBedRooms + ", rentValue=" + rentValue + "]";
	}

}
