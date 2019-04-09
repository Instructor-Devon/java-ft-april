package com.devon.app;

public class Person {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static Person[] GetSomePeople() {
		return new Person[] {
			new Person(1, "Alec"),
			new Person(2, "Jenny"),
			new Person(3, "Sam"),
		};
	}
	public static Person GetOne() {
		return new Person(3, "Sam");
	}
	
}
