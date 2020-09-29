package com.pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.bean.Student;

@Controller
public class FormController {
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String form(ModelMap m) {
		Student stud = new Student();
		init(m);
		m.addAttribute("student", stud);
		return "register";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("student") Student s, BindingResult br, ModelMap m) {
		String result;
		if(br.hasErrors()) {
			init(m);
			result = "register";
		} else {
			m.addAttribute("student", s);
			result = "success"; 
		}
		return result;
	}
	
	void init(ModelMap m) {
		List<String> g = new ArrayList<String>();
		g.add("male");
		g.add("female");
		m.addAttribute("genderList", g);
		List<String> s = new ArrayList<String>();
		s.add("html");
		s.add("css");
		m.addAttribute("subjectList", s);
	}
}
