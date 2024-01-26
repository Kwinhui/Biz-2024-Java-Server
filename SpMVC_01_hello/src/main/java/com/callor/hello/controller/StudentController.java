package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.models.StudentDto;





@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	private String viewURL = "student/%s";
	
	
	/*
	 * 	"/student/" 또는 "/student" 로 요청이 되면
	 */
	// 끝에 "/"가 있거나 없을때 배열로 만들어줘야함
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String list() {
		return String.format(viewURL, "list");
		// return "student/list"; 와 같음
	}
	
	
	// 입력화면을 열어주는 router
	// 주소 : http://localhost:8080/hello/student/insert
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return String.format(viewURL, "input");
	}

	/*
	 * form 의 input box 에 입력된 데이터(문자열)은 controller method 의 매개변수와
	 * 1:1로 매칭된다
	 * 이때 input box 에 name 속성은 Dto class 의 변수명과 일치해야 한다.
	 *
	 * 
	 * @ResponseBody
	 * method 문자열을 return 하면 원래는 views/*.jsp 파일을 찾아서 rendering 한 후
	 * client 로 보낸다. 하지만 @ResponseBody 가 설정되면,
	 * 문자열을 Http 프로토콜의 Response 영역에 그대로 실어서 client 로 보낸다. 
	 */
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute StudentDto stDto) {

		System.out.println(stDto.toString());
		
		// 문자열을 그대로 return
		return stDto.toString();
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String stNum) {
		
		return String.format(viewURL, "update");
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(StudentDto stDto) {
		
		return "redirect:/detail";
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String stNum) {
		return String.format(viewURL, "detail");
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete() {
		
		// "/student" URL 로 화면을 전환하라
		return "redirect:/student";
	}
	
	
	
		
		
	
}
