package test.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		request.getSession();
		
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		
		if(name == null||nickname == null){
			out.println("请传递参数name和nickname后继续实验！");
			return;
		}
		
		if("".equals(name.trim())||"".equals(nickname.trim())){
			out.println("name和nickname不能为空白串！");
		}
		else{
			
			Cookie ckName = new Cookie("name",name);
			Cookie ckNickname = new Cookie("nickname",nickname);
			ckNickname.setMaxAge(365*24*3600);
			Cookie ckEmail = new Cookie("email","test@wxx.cn");
			Cookie ckPhone = new Cookie("phone","18616380408");
			
			response.addCookie(ckName);
			response.addCookie(ckNickname);
			response.addCookie(ckEmail);
			response.addCookie(ckPhone);			
			
		}
/**
 * 应將下面的代码设计成一个专门用于查询某个名称的Cookie的方法
 * 然后用这个方法来查询名为nickname的Cookie的值。
 * */
		
		String lastNickname = null;
		Cookie[] cks = request.getCookies();
		
		for(int i=0;cks!=null&&i<cks.length;i++){
			if("nickname".equals(cks[i].getName())){
				lastNickname = cks[i].getValue();
				break;
			}
		}
		
		if(lastNickname!=null){
			
			out.println("欢迎您， <b><i>" + lastNickname + "<b><i>！<br>");
			
		}else{
			
			out.println("欢迎您， 新客人！<br>");
		}
		
		String cookieHeader = request.getHeader("Cookie");
		if(cookieHeader!=null){
			out.println("请求头中的Cookie头字段如下： <br>");
			out.println("cookieHeader : " + cookieHeader);
		}else{
			out.println("请求头中没有Cookie的头字段 <br>");
		}
		
		
	}

}
