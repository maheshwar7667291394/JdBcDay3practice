package com.masai.user;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoimpl;

import Studentbeam.Student;
import throexcetption.StudentException;

public class Main {

	public static void main(String[] args) {
	 Scanner input=new Scanner(System.in);
	 System.out.println("enter Id");
	 int id=input.nextInt();
	 
//	 System.out.println("Enter name");
//	 String name=input.next();
//	 
//	 System.out.println("Enter address");
//	 String address=input.next();
//	 
//	 System.out.println("enter marks");
//	 int marks=input.nextInt();
	 
	 StudentDao dao=new StudentDaoimpl();
	 Student std;
	try {
		std = dao.getAlldetails(id);
		 System.out.println(std);
	} catch (StudentException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
//	 System.out.println(result);

			 

	}

}
