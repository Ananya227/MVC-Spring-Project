package com.controllers;

import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;


public class Logout  extends HttpServlet
{

	
	protected  void doPost(HttpServletRequest  req, HttpServletResponse resp)  throws ServletException , IOException{
	 HttpDession session = req.getSession();
	 
	 session.invalidate();
	 
	 RequestDispatcher rd =  req.getRequestDispatcher("/login.html");
	 rd.forward(req, resp);
}
