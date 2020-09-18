package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PetServlet
 */
@WebServlet("/PetServlet")
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
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
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pet = request.getParameter("pet");
		long phone = Long.parseLong(request.getParameter("phone"));
		String ptype = request.getParameter("ptype");
		int age = Integer.parseInt(request.getParameter("age"));
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetRegistration", "student", "student");
			PreparedStatement ps = con.prepareStatement("insert into PetRegistration values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, addr);
			ps.setString(4, email);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, pet);
			ps.setLong(8, phone);
			ps.setString(9, ptype);
			ps.setInt(10, age);
			int count = ps.executeUpdate();
			if(count == 1) {
				System.out.println(fname + "\n" + lname + "\n" + addr + "\n" + email + "\n" + city + "\n" + state + "\n" + pet + "\n" + phone + "\n" + ptype + "\n" + age);
				p.println("Success");
				p.close();
			} else {
				System.out.println("Failure");
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
