package com.app.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.StudentCrud;
import com.app.model.Student;

public class StudentService {
	@Autowired
	StudentCrud studentcrud;
	
	public void addStudent(Student student){
		studentcrud.addStudent(student);
	}
	
	public List<Student> getAllStudent(){
		List<Student> lis=studentcrud.getAllStudent();
		return lis;
	}
	
	public Student getStudentByName(String name){
		Student student1=studentcrud.getStudentByName(name);
		return student1;
	}
	
	public void updateStudent(Student student){
		studentcrud.updateStudent(student);
	}
	
	public void deleteStudent(Student student){
		studentcrud.deleteStudent(student);
	}
}
