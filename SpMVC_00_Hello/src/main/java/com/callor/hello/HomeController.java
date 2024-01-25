package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.controller.HomeService;
import com.callor.hello.models.StudentDto;


// controller 가 붙으면 router가 됨
// 여기는 Controller 클래스 이다
@Controller
public class HomeController {
//	@Autowired
	// autowried 는 메모리누수가 있을수 있음
	// homeservice 라는 클래스를 나에게 제공해줘
	// final 키워드가 붙으면 new생성자 없이 사용할 수 없다.
	
	/*
	 * 컴포넌트 자동으로 주입받기
	 * 컴포넌트 클래스를 사용하여 객체를 "선언만" 하고
	 * 생성자를 통하여 컴포넌트 객체를 주입받아 생성(초기화)한다.
	 * Spring Framework 에 의해 준비된 컴포넌트는 필요한 곳에서
	 * 선언만 하면 자동으로 주입이 된다.
	 * DI(Dependency Inject, 의존성 주입)
	 * 생성자를 통해서 주입받을 객체는 final 키워드를 부착하여 선언한다
	 * 
	 * 제어의 역전
	 * 일반적인 자바 코드에서 어떤 클래스를 사용하여 만든
	 * 객체의 method 나 속성(변수)에 접근하기 위해서는 반드시
	 * 객체를 선언하고 생성자를 통하여 객체를 생성(초기화)해야 한다.
	 * 그렇지 않으면 NullpointerException 이 발생한다.
	 * Class class = new Class() 와 같은 코드를 사용하여 사용할 곳에서
	 * 객체를 생성하여 준비한다.
	 * 
	 * Spring Project 에서는 그러한 절차가 없이 필요하다 라는 선언만 하면
	 * Spring container 에 미리 준비된 컴포넌트(객체,bean)를 주입해 준다.
	 * 객체를 생성하는 방향이 일반 자바와 반대라는 의미로
	 * "제어의 역전(Inverted of Control)" 이라고 한다.
	 * 
	 * Spring Project 에서는 new 키워드를 사용하는 경우가 많지 않다.
	 */
	
	// 홈서비스라는 클래스가 필요하니
	// 생성자를 통해서 주입해줘
	private final HomeService homeService;
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
		// 사용하려면 기본생성자에서 주입해 주어야 한다.
	}
	
	// "/" 로 요청이 되면 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		homeService.hello();
		
		// home이라는 문자열을 return 하면 spring 이 home.jsp를 랜더링 해서 사용자에게 보낸다 
		return "home";
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public String student(Model model) {
		StudentDto stDto = homeService.getStudent();
		model.addAttribute("STD", stDto);
		/*
		 * STD = stDto 형식으로 변수를 만들고
		 * 그 변수를 model 객체에 추가해라
		 */
		// STD 변수를 만들어서 stDto에 담고 model에 추가해라
		// model에 담아서 view에게 보내서 ${STD.stNum} 이런식으로 변수를 가져올수있음
		
		return "student";
		
	}
	
	
	
}
