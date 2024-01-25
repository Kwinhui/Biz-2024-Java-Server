package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// controller 가 붙으면 router가 됨
// 여기는 Controller 클래스 이다
@Controller
public class HomeController {

	// "/" 로 요청이 되면 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		// home이라는 문자열을 return 하면 spring 이 home.jsp를 랜더링 해서 사용자에게 보낸다 
		return "home";
	}
	
}
