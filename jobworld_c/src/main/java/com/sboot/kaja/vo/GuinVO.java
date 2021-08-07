package com.sboot.kaja.vo;

import lombok.Data;

@Data
public class GuinVO {		//구인회사
	private String id;		//가입시 작성한 아이디
	private String name;	//회사이름
	private String address;	//회사위치
	private String tel;		//연락처
	private String email;	//이메일
	private String job;		//직무소개
	private String people;	//모집인원
	private String period;	//모집기간
	private String intro;	//회사소개
	private String prefer;	//우대사항
	private String edu;		//최종학력
	private String cert;	//자격증
	private String major;	//전공
	private String career;	//경력
}

//getter , setter , toString() 다 생략
//why? lombok의 @Data