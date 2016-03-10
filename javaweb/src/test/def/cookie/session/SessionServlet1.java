package test.def.cookie.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Integer sessionCount = (Integer)session.getAttribute("count");
		
		int count = 0;
		
		if(sessionCount != null) {
			
			count = sessionCount.intValue();
			
		}
		
		out.println("当前会话中发生了 " +(++count) + " 次访问!<br>");
		
		request.setAttribute("count", new Integer(count));
		
		count = 0;
		ServletContext application = getServletContext();
		
		Integer applicationCount = (Integer) application.getAttribute("count");
		
		if(application != null) {
			
			count = applicationCount.intValue();
			
		}
		
		out.println("Web应用程序中发生了 " +(++count) + " 次访问!<br>");
		
		out.println("<a href='SessionServlet2'>访问SessionServlet2</a>");
		
		
	}
	
	

}
