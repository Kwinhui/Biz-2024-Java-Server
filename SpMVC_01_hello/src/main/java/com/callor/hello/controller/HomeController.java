package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.StudentDto;
import com.callor.hello.service.StudentService;


@Controller
public class HomeController {
	
	/*
	 * Spring Project 에서 가장 많이 보이는 에러 메시지
	 * No qualifying bean of type 'com.callor.hello.service.StudentService'
	 * 
	 * HomeController 에서 StudentService 클래스로 만들어진 bean(객체, 컴포넌트)를
	 * 사용하겠다고 Spring 에게 달라고 요청을 했다
	 * 
	 * 그런데 어떤 이유로 StudentService 클래스의 bean이 생성이 안되었을때
	 * 보여지는 에러 메시지 이다.
	 * 
	 * 이 메시지의 대부분의 원인은 bean 을 생성할 클래스에 
	 * @Annotation 이 누락된 경우이다
	 */
	private final StudentService studentSerivce;
	public HomeController(StudentService studentSerivce) {
		this.studentSerivce = studentSerivce;
		// 생성자에서 매개변수를 받아 초기화
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		StudentDto stDto = studentSerivce.getStudent();
		
				
		
		
		
		return "home";
		
		
		
	}

	
	
}
