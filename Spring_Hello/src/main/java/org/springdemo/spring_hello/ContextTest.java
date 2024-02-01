package org.springdemo.spring_hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ContextTest {
public static void main (String[]args) {
	//TODO Auto-generated method stub
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	Stucontext student = (Stucontext) context.getBean("studentbean");

	student.displayInfo();
 
}
}
