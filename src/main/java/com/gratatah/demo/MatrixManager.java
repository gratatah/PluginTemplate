package com.gratatah.demo;

public class MatrixManager {

	void manageMatrix() {
		Person john = new Person(); // When we create a new instance of Person, john is only what is referred to by Java in memory
		john.setName("John");
		/*
		It does not actually have the name John as a String object until it is given one,
		this is done by calling the setName function in our Person class
		 */

		Person julia = new Person();
		julia.setName("Julia");

		System.out.println(julia.getName());

	}

}
