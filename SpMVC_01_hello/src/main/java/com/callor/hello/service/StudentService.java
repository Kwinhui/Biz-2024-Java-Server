package com.callor.hello.service;

import org.springframework.stereotype.Service;

import com.callor.hello.models.StudentDto;

@Service
public class StudentService {

	
	public StudentDto getStudent() {
		// 빌더패턴
		// new라는 키워드를 사용하지 않고 변수에 이름으로 직접 값을 넣음
		/*
		 * Builder pattern
		 * Dto 객체를 생성하고, setter() method 를 사용하여
		 * 		StudentDto stDto = new StudentDto();
		 * 		stDto.setStNum("0001");
		 * 각 속성(변수)에 값을 세팅하는 기존의 코드를 사용하지 않고,
		 * 
		 * builder() method 통하여 객체를 생성하면서
		 * 		StudentDto stDto = StudentDto.builder() 
		 * 변수에 이름을 Method 처럼 사용하여 값을 세팅하는 코딩스타일
		 * 			.stNum("0001").stName("홍길동").stDept("정보통신").build();
		 */
		StudentDto stDto = StudentDto.builder()
				.stNum("0001")
				.stName("홍길동")
				.stDept("정보통신")
				.build();
		// 변수에 자동으로 값을 채워줌
		
		return stDto;
		
	}
}
