package com.jian.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	PrintWriter out = response.getWriter();
	
	out.print("<a href ='/Servlets/CookieDemo2'>清除上次访问时间</a><br/>");
	out.print("您上次访问的时间是： ");
	
	//获取用户的时间cookies
	Cookie[]  cookie = request.getCookies();
	for (int i = 0;cookie!=null && i<cookie.length; i++ ){
		if(cookie[i].getName().equals("lastAccessTime")){
			long cookieValue = Long.parseLong(cookie[i].getValue());
			Date date = new Date(cookieValue);
			out.print(date.toLocaleString());
			}
	}
	
	//给用户发送最新的访问时间
	  Cookie cookieN = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
	 cookieN.setMaxAge(30*24*3600);
	 //设置有效路径
	 cookieN.setPath("/Servlets");
	 response.addCookie(cookieN);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
