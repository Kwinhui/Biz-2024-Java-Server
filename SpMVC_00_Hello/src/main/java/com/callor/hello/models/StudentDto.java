package com.callor.hello.models;

public class StudentDto {
	// Spring project 에서는 Dto 클래스의 속성(변수, 멤버)는
	// private 으로 선언한다.
	private String stNum;
	private String stName;
	private String stGrade;
	
	
	// Spring 에서 사용하는 Dto 기본 모양
	public StudentDto() {
		
	}
	
	
	public StudentDto(String stNum, String stName, String stGrade) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stGrade = stGrade;
	}


	// 정보의 은닉을 위해 private로 설정하고 get,set 으로 접근
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStNum() {
		return this.stNum;
	}
	
	public String getStName() {
		return stName;
	}


	public void setStName(String stName) {
		this.stName = stName;
	}


	public String getStGrade() {
		return stGrade;
	}


	public void setStGrade(String stGrade) {
		this.stGrade = stGrade;
	}
	@Override
	public String toString() {
		return "StudentDto [stNum = " + stNum + ", stName = " + stName + ", stGrade = " + stGrade + "]";
	}

	
	
	

}
