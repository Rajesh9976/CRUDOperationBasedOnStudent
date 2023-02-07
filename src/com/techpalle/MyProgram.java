package com.techpalle;

import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args)
	{
		
		//Student.creating();
		//Student.inserting("Rajesh", "Java", "abc@gmail.com");
		//Student.inserting("RS", "J2EE", "sss@gmail.com");
		//Student.updating("RSS", "Java", 2);
		//Student.delete(2); 
		
      ArrayList<Student> res1=Student .reading();  //overloading
		  for(Student item:res1)
		  {
			System.out.println(item.sno);
			System.out.println(item.sname);
			System.out.println(item.sub);
			System.out.println(item.email);
			
			System.out.println("********");
		  } 
		
		//Student.read();
		  
		
		
	}

}
