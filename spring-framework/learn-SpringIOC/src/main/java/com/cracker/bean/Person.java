package com.cracker.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

	private String lastName;
	private Integer age;
	private String gender;

	public Person() {
	}

	public Person(String lastName, Integer age, String gender) {
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person{" +
				"lastName='" + lastName + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}
}
