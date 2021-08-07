package com.sboot.kaja.vo;

import lombok.Data;

@Data
public class SawonVO {
	private String name;
	private String tel;
}

//getter , setter , toString() 다 생략
//why? lombok의 @Data