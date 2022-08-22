package com.masai.dao;

import Studentbeam.Student;
import throexcetption.StudentException;

public interface StudentDao {
	public String InsertMEthod(int id,String name,String address,int marks);
	public String insertMethod2(Student student);
	public Student getAlldetails(int id)throws StudentException;

}
