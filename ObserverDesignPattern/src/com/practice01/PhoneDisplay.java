package com.practice01;

public class PhoneDisplay implements Observer {

	private String weather;

	@Override
	public void update(String weather) {
		// TODO Auto-generated method stub

		this.weather = weather;
		display();
	}

	private void display() {
		System.out.println("Phone Display: Weather updated - " + weather);
	}

}
