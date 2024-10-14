package com.practice01;

public class ScottArray02 {

	private int[] list;
	private int length;
	private int count;

	public ScottArray02(int length) {
		this.list = new int[length];
		this.count = 0;

	}

	public void removeAt(int index) {

		if (index < 0 || index > (count - 1)) {
			throw new ArrayIndexOutOfBoundsException();
		}

		int i = 0;

		int[] tempList = new int[length];

		boolean booA = false;

		for (int k = 0; k < count; k++) {

			if (k == index) {

				booA = true;

			}

			if (booA) {

				list[k] = list[k + 1];
			}
		}

		count--;

		System.out.println("Print Out List");
		for (int x : tempList) {
			System.out.println(x);
		}

	}

	public void insert(int number) {

		if (count >= (list.length)) {
			System.out.println("double length");
			int[] tempAry = new int[2 * this.list.length];

			for (int i = 0; i < this.list.length; i++) {

				tempAry[i] = list[i];

			}

			list = tempAry;

			list[count++] = number;

		} else {

			list[count++] = number;
		}

	}

	public int[] getList() {
		return list;
	}

	public void setList(int[] list) {
		this.list = list;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
