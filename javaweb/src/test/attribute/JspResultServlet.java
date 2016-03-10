package test.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspResultServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		User user = (User) request.getAttribute("user");
		
		if(user!=null) {
			
			out.println("<h1>你的注册信息如下 ： <h1>");
			out.println("用户名 ； " + user.getName() + "<br>");
			out.println("Email : " + user.getEmail() + "<br>");
			
		}
		
		out.close();
	}
	
	

}
