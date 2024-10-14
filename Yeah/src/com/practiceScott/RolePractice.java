package com.practiceScott;

import java.util.Arrays;

public class RolePractice {

	public static void main(String[] args) {

		MyUser userA = new MyUser();

		userA.setRole("ADMIN,USER");

		userA.setUsername("Scott");

		userA.toString();

		userA.getRole().split(",");

		Arrays.toString(userA.getRole().split(","));

		System.out.println(Arrays.toString(userA.getRole().split(",")));

	}

}
