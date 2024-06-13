package com.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.DbConnection;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
@WebServlet


public class Login extends HttpServlet {

	
	@Override
	protected <String> void doPost(HttpServletRequest  req, HttpServletresponse resp)  throws ServletException ,  IOException
	{
	
		
		 PrintWriter out = resp.getWriter();
		 resp.detContent("text/html");
		String myemail =req.getParameter("email1") ;
		String mypass =  req.getParameter("pass1");
		
try {
			
			Connection con = DbConnection.getConnection();
			
			String inser_sql_query  = "Select * FROM register wWHERE email=? AND password=?" ;
			PreparedStatement ps = con.prepareStatement(inser_sql_query);
			ps.setString(1 , myname);
			ps.setString(2 , myname);
			
			ResultSet rd = ps.executeQuery();
			if(rs.next())
			{
				 User userm= new User();
				 user.setName(rs.getString("name"));
				 user.setEmail(rs.getString("email"));
				 user.setCity(rs.getString("city"));
				 
				 
				 HttpSession session = req.getSession();
				 session.setAttribute("session_user" , user);
				 
				 RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				 rd.forward(req ,resp);
			}
			
			else {
				out.println("<h3>Email id and password didn't match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req,resp);
			}
	}