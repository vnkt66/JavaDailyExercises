package com.jdbc;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter p = response.getWriter();
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		Connection con = null;
		RequestDispatcher r = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetRegistration", "student", "student");
			PreparedStatement ps = con.prepareStatement("select * from Login where loginid = ? and password = ?");
			ps.setString(1, login);
			ps.setString(2, password);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next() == false) {
//		    	System.out.println("I am Not Login");
		    	response.sendRedirect("/JdbcServlet/Error.html");
		    } else {
		    	do {
		    		login = rs.getString("LoginId");
		    		password = rs.getString("Password");
//		    		System.out.println(login + "You are Logged in");
		    	} while(rs.next());
//		    	System.out.println("I am Login");
		    	r = request.getRequestDispatcher("/Success.html");
		    	r.forward(request, response);
		    }
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
