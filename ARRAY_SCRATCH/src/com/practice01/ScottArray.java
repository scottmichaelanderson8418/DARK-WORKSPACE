package com.practice01;

public class ScottArray {

	private int[] list;

	private int length;

	private int count;

	public ScottArray(int length) {
		this.list = new int[length];

	}

	public void insert(int number) {

		if (count == this.list.length) {

			int[] tempList = new int[count * 2];

			for (int i = 0; i < count; i++) {

				tempList[i] = this.list[i];

			}

			this.list = tempList;

		}

		this.list[count++] = number;
	}

	public int findIndexAtNumber(int number) {

		for (int i = 0; i < list.length; i++) {

			if (number == list[i]) {
				return i;
			}

		}

		return -1;
	}

	public void removeAt(int number) throws ArrayIndexOutOfBoundsException {

		if (number < 0 || number > count - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}

		// create temporary array
		int[] tempA = new int[count];

		int countA = 0;

		// add all values of array except array[number] to tempA array
		for (int i = 0; i < count; i++) {

			if (i != number) {

				tempA[i - countA] = this.list[i];

			} else {

				countA++;

			}

		}

		--count;

		for (int i = 0; i < count; i++) {

			this.list[i] = tempA[i];

		}

	}

	public int numberAtIndex(int number) {
		if (number < 0 || number > count - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return this.list[number];

	}

	public String print() {

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append("[");

		while (i < count) {

			if (i != 0) {
				sb.append(", ");
			}
			sb.append(this.list[i++]);

		}
		sb.append("]");
		return sb.toString();
	}

}
