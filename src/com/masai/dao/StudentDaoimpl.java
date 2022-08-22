package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.utility.DBUtil;

import Studentbeam.Student;
import throexcetption.StudentException;

public class StudentDaoimpl implements StudentDao{

	@Override
	public String InsertMEthod(int id, String name, String address, int marks) {
	      String result="not inserted";
	      
	     
	      try ( Connection con=DBUtil.GEtconnection()){
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,address);
			ps.setInt(4,marks);
			int x=ps.executeUpdate();
		  if(x>0){
				result="insertion sucessfull";
			  
		  }
			
			
		} catch (SQLException e) {
		
			result=e.getMessage();
		}
	      
	      
	      return result;
	}

	@Override
	public String insertMethod2(Student student) {
		String result="not connected";
		
		try (Connection con=DBUtil.GEtconnection()){
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1,student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3,student.getAddress());
			ps.setInt(4,student.getMarks());
			int x=ps.executeUpdate();
			if(x>0) {
				result="insertion sucessfull";
			}
			
		} catch (SQLException e) {
		
			result=e.getMessage();
		}
		
		
		
		return result;
	}

	@Override
	public Student getAlldetails(int id)throws StudentException{
		Student student=null;
		 Connection con=DBUtil.GEtconnection();
		try {
			PreparedStatement ps=con.prepareStatement("select *from student where id=?");
			ps.setInt(1, id);
		  ResultSet rs=ps.executeQuery();
		  if(rs.next()) {
			  int id1=rs.getInt("id");
			  String n1=rs.getString("name");
			  String s1=rs.getNString("address");
			  int m1=rs.getInt("marks");
			  
			  student=new Student();
			 student.setRoll(id1);
			 student.setName(n1);
			 student.setAddress(s1);
			 student.setMarks(m1);
			
			  
		  }
		  else {
			  throw new StudentException("student no found by given nuber");
		  }
		  
		  
		} catch (SQLException e) {
			
			throw new StudentException(e.getMessage());
		}
		
		return student;
	}

}
