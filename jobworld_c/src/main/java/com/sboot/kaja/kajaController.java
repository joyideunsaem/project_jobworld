package com.sboot.kaja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sboot.kaja.dao.GuinDAO;
import com.sboot.kaja.dao.GujicDAO;
import com.sboot.kaja.dao.SawonDAO;
import com.sboot.kaja.dbConn.DBConn;
import com.sboot.kaja.vo.GuinVO;
import com.sboot.kaja.vo.GujicVO;
import com.sboot.kaja.vo.SawonVO;
import com.sboot.vo.LoginVO;

@Controller
public class kajaController {

	@Autowired
	SawonDAO dao;
	@Autowired
	GuinDAO guindao;
	@Autowired
	GujicDAO gujicdao;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	//(p)userLogin.jsp - babo/ondal - result.jsp - 포트번호링크
	//		- (c)@RequestMapping("/") - @RequestMapping("/getallinfo")
	@RequestMapping("/")
	public String kaja() {
		LoginVO lvo = restTemplate.getForObject("http://sawonlogin-service/loginvo", LoginVO.class);
		System.out.println(lvo.getId());		//p의 controller2 loginvo로 가서 회원정보 가져옴
		System.out.println(lvo.getPw());
		return "redirect:getallinfo";
	}			//회원정보를 갖고 @RequestMapping("/getallinfo")로 이동

	@RequestMapping("/getallinfo")
	public String getallinfo(Model model) {
		model.addAttribute("getallinfo", dao.getAllInfo());
		return "getallinfo";
	}

	@RequestMapping("/insertForm")
	public String insertform() {
		return "insertForm";
	}

	@RequestMapping("/sawonInsert")
	public String insertSawon(HttpServletRequest req) {
		dao.insertInfo(req.getParameter("name"), req.getParameter("tel"));
		return "redirect:getallinfo";
	}

	@RequestMapping("/getinfo")
	public String updateForm(HttpServletRequest req, Model model) {
		SawonVO svo = dao.getInfo(req.getParameter("name"));
		model.addAttribute("name", svo.getName());
		model.addAttribute("tel", svo.getTel());
		return "updateForm";
	}

	@RequestMapping("/sawonUpdate")
	public String sawonUpdate(HttpServletRequest req) {
		dao.updateInfo(req.getParameter("name"), req.getParameter("tel"));
		return "redirect:getallinfo";
	}

	@RequestMapping("/sawonDelete")
	public String sawonDelete(HttpServletRequest req) {
		dao.deleteInfo(req.getParameter("name"));
		return "redirect:getallinfo";
	}

	
	
	//main
	@RequestMapping("/main")
	public String mainPage(HttpSession session) {
		//String sessionID = (String)session.getAttribute("id");
		//System.out.println("sid="+sessionID);
		return "main";
	}
	
	//join
	@RequestMapping("/join")
	public String joinPage() {
		return "join";
	}
	
	//login page
	@RequestMapping("/login")//logic need
	public String loginPage() {
		return "login";
	}
	
	//login process	//gujic
	@RequestMapping("/loginProcess")//logic
	public String loginProcess(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//디비에 아이디/비번 맞는지 확인..		
		String sql = "SELECT count(*) FROM gujictable WHERE id=? and pw=?";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean isSucess = false;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//rs사용시 필요
				if (rs.getInt(1) > 0) {	//1열의 결과값이 0보다 큰가?
					isSucess = true;	//count(*) 이 0이면 불일치 1개(이상)이면 id, pw일치
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if( isSucess)//맞으면    //(로그아웃 헤더 설정..)    //(logout 시 세션 초기화)
		{	
			session.setAttribute("id", id);//id 세션 설정
			//System.out.println("testsid="+session.getAttribute("id"));
			return "redirect:main";//메인으로?  +session=redirect  ?
		}
		else 
			return "login";//틀리면 로긴으로..
		
	}
	
	//login process	//guin
	@RequestMapping("/loginProcess2")//logic
	public String loginProcess2(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//디비에 아이디/비번 맞는지 확인..		
		String sql = "SELECT count(*) FROM guintable WHERE id=? and pw=?";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean isSucess = false;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//rs사용시 필요
				if (rs.getInt(1) > 0) {	//1열의 결과값이 0보다 큰가?
					isSucess = true;	//count(*) 이 0이면 불일치 1개(이상)이면 id, pw일치
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (pstmt != null) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if( isSucess)//맞으면    //(로그아웃 헤더 설정..)    //(logout 시 세션 초기화)
		{	
			session.setAttribute("id", id);//id 세션 설정
			//System.out.println("testsid="+session.getAttribute("id"));
			return "redirect:main";//메인으로?  +session=redirect  ?
		}
		else 
			return "login";//틀리면 로긴으로..
		
	}
	
	//logout
	@RequestMapping("/logout")//logic need
	public String logout(HttpSession session) {
		session.removeAttribute("id");//세션 값 삭제
		session.invalidate();// 세션 전체 제거, 무효화 
		return "redirect:main";//session 반영
	}
	
	//register////////gujic
	@RequestMapping("/register")//gujic
	public String register(HttpServletRequest request) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO gujictable (id,pw,name,age,address,gender,email) VALUES (?,?,?,?,?,?,?)";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, age);
			pstmt.setString(5, address);
			pstmt.setString(6, gender);
			pstmt.setString(7, email);
			
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				if (pstmt != null) 
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:login";//redirect?
	}

	//register////////guin
	@RequestMapping("/register2")//guin
	public String register2(HttpServletRequest request) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO guintable (id,pw,name,address,tel,email) VALUES (?,?,?,?,?,?)";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, address);
			pstmt.setString(5, tel);
			pstmt.setString(6, email);
			
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				if (pstmt != null) 
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:login";//redirect?
	}
	
	//getallinfo R
	@RequestMapping("/gujicAll")//for list..
	public String gujicAll(Model model) {
		model.addAttribute("gujicAll", gujicdao.getAllInfo());
		return "form/gujicAllForm";
	}
	
	@RequestMapping("/guinAll")//for list..
	public String guinAll(Model model) {
		model.addAttribute("guinAll", guindao.getAllInfo());
		return "form/guinAllForm";
	}
	
	//getinfo R
	@RequestMapping("/gujic")//?id=아이디
	public String gujicInfo(HttpServletRequest req, Model model) {
		model.addAttribute("gujic", gujicdao.getInfo(req.getParameter("id")));
		return "form/gujicInfo";
	}
	
	@RequestMapping("/guin")//?id=아이디
	public String guinInfo(HttpServletRequest req, Model model) {
		model.addAttribute("guin", guindao.getInfo(req.getParameter("id")));
		return "form/guinInfo";
	}
	
	//guingujic for U
	@RequestMapping("/gujicForm")//?id=아이디
	public String gujicUpdateForm(HttpServletRequest req, Model model) {
		System.out.println(req.getParameter("id"));//null..
		if(req.getParameter("id").equals("null"))//sid가 없을시..  String "null"..
			return "redirect:main";
		GujicVO gujicvo = gujicdao.getInfo(req.getParameter("id"));
		if(gujicvo == null)//db에 없을시 (구인회사->구직자 등)
			return "redirect:main";
		
		model.addAttribute("id", gujicvo.getId());//for updateForm
		model.addAttribute("name", gujicvo.getName());
		model.addAttribute("age", gujicvo.getAge());
		model.addAttribute("gender", gujicvo.getGender());
		model.addAttribute("address", gujicvo.getAddress());
		model.addAttribute("tel", gujicvo.getTel());
		model.addAttribute("email", gujicvo.getEmail());
		model.addAttribute("intro", gujicvo.getIntro());
		model.addAttribute("major", gujicvo.getMajor());
		model.addAttribute("career", gujicvo.getCareer());
		model.addAttribute("edu", gujicvo.getEdu());
		model.addAttribute("cert", gujicvo.getCert());
		return "form/gujicUpdateForm";
	}
	
	@RequestMapping("/guinForm")//?id=아이디
	public String guinUpdateForm(HttpServletRequest req, Model model) {
		System.out.println(req.getParameter("id"));//null..
		if(req.getParameter("id").equals("null"))//sid가 없을시..  String "null"..
			return "redirect:main";
		
		GuinVO guinvo = guindao.getInfo(req.getParameter("id"));
		if(guinvo == null)//db에 없을시 (구직자->구인회사 등)
			return "redirect:main";
		model.addAttribute("id", guinvo.getId());//for updateForm
		model.addAttribute("name", guinvo.getName());
		model.addAttribute("address", guinvo.getAddress());
		model.addAttribute("tel", guinvo.getTel());
		model.addAttribute("email", guinvo.getEmail());
		model.addAttribute("job", guinvo.getJob());
		model.addAttribute("people", guinvo.getPeople());
		model.addAttribute("period", guinvo.getPeriod());
		model.addAttribute("intro", guinvo.getIntro());
		model.addAttribute("prefer", guinvo.getPrefer());
		model.addAttribute("major", guinvo.getMajor());
		model.addAttribute("career", guinvo.getCareer());
		model.addAttribute("edu", guinvo.getEdu());
		model.addAttribute("cert", guinvo.getCert());
		return "form/guinUpdateForm";
	}
	
	//guingujic U
	@RequestMapping("/guinUpdate")//?id=아이디&tel=전화번호2//ing..//java.sql.SQLException: 부적합한 열 유형: 1111
	public String guinUpdate(HttpServletRequest req, RedirectAttributes redirect) {//for red파라미터!
		//System.out.println("id="+req.getParameter("id")+" tel="+req.getParameter("tel"));
		guindao.updateInfo(req.getParameter("id"), req.getParameter("name"),
				req.getParameter("address"), req.getParameter("tel"),
				req.getParameter("email"), req.getParameter("job"),
				req.getParameter("people"), req.getParameter("period"),
				req.getParameter("intro"), req.getParameter("prefer"),
				req.getParameter("edu"), req.getParameter("cert"),
				req.getParameter("major"), req.getParameter("career")
				);
		redirect.addAttribute("id", req.getParameter("id"));//for /guin?id=아이디 (파라미터!)
		return "redirect:guinForm";
	}
	
	@RequestMapping("/gujicUpdate")
	public String gujicUpdate(HttpServletRequest req, RedirectAttributes redirect) {//for red파라미터!
		gujicdao.updateInfo(req.getParameter("id"), req.getParameter("name"),
				req.getParameter("age"), req.getParameter("gender"),
				req.getParameter("address"), req.getParameter("tel"),
				req.getParameter("email"), req.getParameter("intro"),
				req.getParameter("edu"), req.getParameter("cert"),
				req.getParameter("major"), req.getParameter("career")
				);
		redirect.addAttribute("id", req.getParameter("id"));//for /gujic?id=아이디 (파라미터!)
		return "redirect:gujicForm";
	}
	
	
}
