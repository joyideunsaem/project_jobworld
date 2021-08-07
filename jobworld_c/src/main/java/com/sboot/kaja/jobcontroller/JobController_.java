package com.sboot.kaja.jobcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sboot.kaja.dbConn.DBConn;

@WebServlet("/register")
public class JobController_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public JobController_() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO JOBUSERTABLE VALUES (?,?,?,?,?,?,?)";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		boolean isSucess = true;
		
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
			isSucess = false;
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
		
		if (isSucess) {
			request.setCharacterEncoding("utf-8");
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("회원가입에 성공하였습니다.");
			writer.println("<script>");
			writer.println("alert('회원가입 성공!')");
			writer.println("location.href='login.jsp'");
			writer.println("</script>");
		}
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
