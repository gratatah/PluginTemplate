package com.gratatah.demo;

public class Person {

	String name; //Here is where the field of name is defined
	int age;
	boolean canCook;

	void setName(String name) {
		this.name = name;
	}
	/*

	The `setName` method takes a `String` parameter `name` and uses the "this" keyword to differentiate between
	the instance variable `name` and the method parameter `name`. Without "this" the method would attempt to set the method
	parameter `name` equal to itself, resulting in no change to the instance variable.

	By default, the more brackets a variable/object is in, the higher priority it has in execution. This all allows for the
	name string object of only the current instance to be changed.
	 */

	String getName() {
		return name;
	}

}
