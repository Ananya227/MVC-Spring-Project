package com.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbcon.DbConnection;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
@WebServlet("/loginForm")


public class Register extends HttpServlet {

	
	@Override
	protected <Connection> void doPost(HttpServletRequest  req, HttpServletResponse resp)  throws ServletException , IOException
	
	{
		
		PrintWriter out = resp.getWriter();
		resp.setcontentType("text/html");
		
		String myname = req.getParameter("name1");
		String myemail =  req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		String mycity = req.getParameter("city1");
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String inser_sql_query  = "INSERT INTO register VALUES(? ,? , ? ,?,?)";
			PreparedStatement ps = con.prepareStatement(inser_sql_query);
			ps.setString(1 , myname);
			ps.setString(2 , myname);
			ps.setString(3 , myname);
			ps.setString(4 , myname);
			
			int count = ps.executeUpdate();
			if(count > 0)
			{
				out.println("<h3 style = 'color:green'> Registered Successfully  </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				
				rd.include(req, resp);
			}
			
			else
			{
				out.println("<h3 style ='color:red> User not registered due to some error </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, resp);
			}
			
			
			
			
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
}
