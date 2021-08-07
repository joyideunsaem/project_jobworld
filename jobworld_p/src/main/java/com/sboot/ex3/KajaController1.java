package com.sboot.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sboot.vo.LoginVO;

/* 컨트롤러 2개로 프로그램 코딩
 * 1) @Controller : url->.jsp로 전달 | 평상시 사용하던 컨트롤러. 일반적인 url 및 처리 파일을 따라감
 * 2) @RestController : 객체 값 그대로 전달 | 값을 타 프로젝트로 전송하거나(MSA형식) 값을 가져올 때 사용 */

@Controller
public class KajaController1 {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/loginvo")
	public LoginVO getLogin() {
		LoginVO lvo = new LoginVO();
		lvo.setId("babo");
		lvo.setPw("ondal");
		return lvo;
	}
	
	@RequestMapping("/")
	public String kaja() {
		return "redirect:getallinfo";
	}
	
	//security의 url을 정의 -------------------------
	
	@RequestMapping("/kaja/login")
	public String login() {
		return "kaja/userLogin"; //.jsp
	}
	
	@RequestMapping("/toResult")
	public String loginkajaMain() {
		return "result"; //.jsp
	}

	
	
	
	
	
	
	
	
}
