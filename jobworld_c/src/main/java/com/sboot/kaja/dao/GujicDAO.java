package com.sboot.kaja.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sboot.kaja.vo.GujicVO;

@Mapper //mapping를 위해 xml에서 정의한다
public interface GujicDAO {
	public List<GujicVO> getAllInfo();//v
	public GujicVO getInfo(String name);//
	public int insertInfo(String name , String tel);//가입?
	public int deleteInfo(String name);//탈퇴?
	public int updateInfo(//v
			String id, 
			String name, 
			String age, 
			String gender, 
			String address, 
			String tel,
			String email, 
			String intro, 
			 String edu,		//최종학력
			 String cert,	//자격증
			 String major,	//전공
			 String career	//경력
			 );
}
