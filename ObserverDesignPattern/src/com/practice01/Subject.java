package com.practice01;

public interface Subject {

	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();

}
