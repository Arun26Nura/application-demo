package com.besant.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.app.repo.SignUpRepo;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("psw");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		
		SignUpRepo repo= new SignUpRepo();
		boolean isInserted= repo.insertIntoProfile(userName, password, email, firstName, lastName, phone);
		
		if(isInserted)
			response.sendRedirect("login");
		else
			response.sendRedirect("error");
		
	}

}
