package com.sboot.kaja.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sboot.kaja.vo.SawonVO;

@Mapper //mapping를 위해 xml에서 정의한다
public interface SawonDAO {
	public List<SawonVO> getAllInfo();
	public SawonVO getInfo(String name);
	public int insertInfo(String name , String tel);
	public int deleteInfo(String name);
	public int updateInfo(String name, String tel);
}
