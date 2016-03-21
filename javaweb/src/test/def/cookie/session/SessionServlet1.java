package test.def.cookie.session;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		int sCount = 0;
		if(sessionCount != null) {
			sCount = sessionCount.intValue();
		}
		out.println("当前会话中发生了 " +(++sCount) + " 次访问!<br>");
		session.setAttribute("count", sCount);
		
		
		Integer requestCount = (Integer) request.getAttribute("count");
		int rCount = 0;
		if(requestCount != null) {
			rCount = requestCount.intValue();
		}
		request.setAttribute("count", ++rCount);
		out.println("当前请求中的count：" + rCount);
		
		out.println("<a href='SessionServlet1'>访问SessionServlet1</a>");
	}
}
