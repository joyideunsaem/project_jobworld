package com.sboot.kaja.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sboot.kaja.vo.GuinVO;

@Mapper //mapping를 위해 xml에서 정의한다
public interface GuinDAO {
	public List<GuinVO> getAllInfo();//v
	public GuinVO getInfo(String id);
	public int insertInfo(String name , String tel);//가입?
	public int deleteInfo(String name);//탈퇴?
	public int updateInfo(//v
			 String id,		//가입시 작성한 아이디
			 String name,	//회사이름
			 String address,	//회사위치
			 String tel,		//연락처
			 String email,	//이메일
			 String job,		//직무소개
			 String people,	//모집인원
			 String period,	//모집기간
			 String intro,	//회사소개
			 String prefer,	//우대사항
			 String edu,		//최종학력
			 String cert,	//자격증
			 String major,	//전공
			 String career	//경력
	);

}
