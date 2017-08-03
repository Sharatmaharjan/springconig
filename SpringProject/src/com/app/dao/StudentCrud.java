package com.app.dao;

import java.util.List;

import com.app.model.Student;

public interface StudentCrud {
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentByName(String name);
	

}
