package com.sboot.kaja.vo;

import lombok.Data;

@Data
public class GujicVO {		//구직자
	private String id;		//가입시 작성한 아이디
	private String name;	//이름
	private String age;		//나이
	private String gender;	//성별
	private String address;	//주소
	private String tel;		//연락처
	private String email;	//이메일
	private String intro;	//자기소개
	private String major;	//전공
	private String career;	//경력
	private String edu;		//최종학력
	private String cert;	//자격증
}

//getter , setter , toString() 다 생략
//why? lombok의 @Data