package fr.dawan.project.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Person implements Serializable{
	
	private String firstName;
	private String lastName;
	private String[] phones;
	
	
	
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	public Person() {
		super();
	}
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
