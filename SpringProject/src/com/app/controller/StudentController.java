package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Student;
import com.app.servicelayer.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentservice;

	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("add");
	}

	@RequestMapping(value = "/added", method = RequestMethod.POST)
	public ModelAndView added(@ModelAttribute("addstudent") Student student) {
		studentservice.addStudent(student);
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/listofstudent", method = RequestMethod.GET)
	public ModelAndView getAllStudent() {
		List<Student> list = studentservice.getAllStudent();
		return new ModelAndView("listofstudent", "list", list);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("name") String name) {
		Student student1 = studentservice.getStudentByName(name);
		return new ModelAndView("edit", "student", student1);
	}

	@RequestMapping(value = "/edited", method = RequestMethod.POST)
	public ModelAndView edited(@ModelAttribute("editstudent") Student student) {
		studentservice.updateStudent(student);
		List<Student> list = studentservice.getAllStudent();
		return new ModelAndView("listofstudent", "list", list);
	}

	@RequestMapping(value = "/delete/{name}/", method = RequestMethod.GET)
	public String delete(@PathVariable String name,Model model) {
		Student student1 = studentservice.getStudentByName(name);
		// System.out.println("name of student "+student1.getName());
		model.addAttribute("student", student1);
		return "delete";
	}

	@RequestMapping(value = "/deleted", method = RequestMethod.POST)
	public ModelAndView deleted(@ModelAttribute("deletestudent") Student student) {
		studentservice.deleteStudent(student);
		List<Student> lis = studentservice.getAllStudent();
		return new ModelAndView("listofstudent", "list", lis);
	}
	
//	@RequestMapping(value="/update",method=RequestMethod.GET)
//	public String editss(@ModelAttribute("editstudent") String name,Model model){
//		Student student=studentservice.getStudentByName(name);
//		model.addAttribute("student", student);
//		return "editstudent";
//	}

	
}
