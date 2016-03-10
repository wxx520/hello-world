package test.attribute;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String name = request.getParameter("user");
			String email =request.getParameter("email");
			
			User user = new User();
			
			user.setName(name);
			user.setEmail(email);
			
			request.setAttribute("user", user);
			
			/**
			 * 
			 * 	RequestDispatcher rd = request.getRequestDispatcher("JspResultServlet");
			 * 	rd.forward(request, response);
			 * 
			 * */
			
			RequestDispatcher rd = request.getRequestDispatcher("/servlet/JspResultServlet");
			
			rd.forward(request, response);
			
	
	}

}
