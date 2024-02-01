package org.springdemo.spring_hello;

public class Stucontext {
private String name;
public String getName() {
	return name;
}
public void setName(String name ) {
	this.name=name;
}
public void displayInfo() {
	System.out.print("Hello:"+name);
}
}
