package test.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		Cookie ckEmail = new Cookie("email","test@wxx.cn");
		//ckEmail.setPath("/");
		Cookie ckPhone = new Cookie("phone","18616380408");
		//ckPhone.setPath("/");
		ckPhone.setMaxAge(0);
		Cookie ckTest = new Cookie("sign","wxx");
		response.addCookie(ckEmail);
		response.addCookie(ckPhone);
		response.addCookie(ckTest);
		
		
		String cookieHeader = request.getHeader("Cookie");
		if(cookieHeader!=null){
			out.println("请求头中的Cookie头字段如下： <br>");
			out.println("cookieHeader" + cookieHeader);
		}else{
			out.println("请求头中没有Cookie的头字段 <br>");
		}
		
		Cookie[] cks = request.getCookies();
		for(int i=0;cks!=null&&i<cks.length;i++){
			out.println(cks[i].getName() + " : " + cks[i].getValue() + "<br>");
		}
	}

}
