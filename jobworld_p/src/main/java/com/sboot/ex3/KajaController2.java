package com.sboot.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.vo.LoginVO;

@RestController
public class KajaController2 {
	
	@GetMapping("/loginvo")
	public LoginVO getLogin() {
		
		LoginVO lvo = new LoginVO();
		lvo.setId("babo");
		lvo.setPw("ondal");
		
		return lvo; //.jsp X lvo 객체 값 그대로 전송 O
	}

}
