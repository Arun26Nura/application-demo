package com.besant.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.app.repo.LoginRepo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Do Get Login Method called");
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName=req.getParameter("uname");
		String password=req.getParameter("psw");
		
		HttpSession session= req.getSession();
		
		LoginRepo repo= new LoginRepo();
		boolean isValidUser= repo.checkValidUser(userName, password);
		if(isValidUser) {
			session.setAttribute("userid", userName);
			res.sendRedirect("profile");
		}else {
			System.out.println("failed");
		}
		
	}
}
