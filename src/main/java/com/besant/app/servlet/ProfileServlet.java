package com.besant.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.app.pojo.Profile;
import com.besant.app.repo.LoginRepo;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String userName=(String)session.getAttribute("userid");

		
		System.out.println("Do GET PROFILE");
		LoginRepo repo= new LoginRepo();
		
		Profile profile= repo.getuser(userName);
		System.out.println(userName);
		request.setAttribute("username",userName);
		request.setAttribute("email",profile.getEmail());
		request.setAttribute("phone", profile.getPhone());
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	
		}

}
