package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Student;

public class StudentCrudImp implements StudentCrud {
	@Autowired
	DataSource datasource;
	
	Connection connect=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public void addStudent(Student student) {
		String query="insert into student values(?,?,?,?)";
		try {
			ps=datasource.getConnection().prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getSurname());
			ps.setString(4, student.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//connect.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateStudent(Student student) {
		String query="update student set address=?,surname=?,phone=? where name=?";
		try {
			ps=datasource.getConnection().prepareStatement(query);
			ps.setString(1, student.getAddress());
			ps.setString(2, student.getSurname());
			ps.setString(3, student.getPhone());
			ps.setString(4, student.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
			//	connect.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteStudent(Student student) {
		String query="delete from student where name=?";
		try {
			ps=datasource.getConnection().prepareStatement(query);
			ps.setString(1, student.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	@Override
	public List<Student> getAllStudent() {
		List<Student> std=new ArrayList<Student>();
		String query="select * from student";
		try {
			ps=datasource.getConnection().prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setSurname(rs.getString("surname"));
				student.setPhone(rs.getString("phone"));
				std.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//connect.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return std;
	}

	@Override
	public Student getStudentByName(String name) {
		Student student=new Student();
		String query="select * from student where name=?";
		try {
			ps=datasource.getConnection().prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()){
				student.setAddress(rs.getString("address"));
				student.setSurname(rs.getString("surname"));
				student.setPhone(rs.getString("phone"));
				student.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//connect.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

}
