package com.jian.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
//@WebServlet(urlPatterns = "/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		test3(request, response);	
		
	}
	
	public void test3(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
		
	   this.getServletConfig().getServletContext();
		
		
		Enumeration e = this.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value = this.getInitParameter(name);
			System.out.println(name + " : " + value);
		}
		
		
		String out = this.getServletConfig().getInitParameter("data");
		System.out.println(out);
	}
	
	
	public void test2(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
		
		  response.setContentType("text/html"); 
		  response.setHeader("refresh", "3;url=index.jsp");
	      PrintWriter out = response.getWriter();
	      String title = "HTTP Header Request Example";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	        "<tr bgcolor=\"#949494\">\n" +
	        "<th>Header Name</th><th>Header Value(s)</th>\n"+
	        "</tr>\n"); 
	      Enumeration headerNames = request.getHeaderNames();      
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	         out.print("<tr><td>" + paramName + "</td>\n");
	         String paramValue = request.getHeader(paramName);
	         out.println("<td> " + paramValue + "</td></tr>\n");
	      }
	      out.println("</table>\n</body></html>");
 		
	}


	public void test1(HttpServletResponse response) throws FileNotFoundException, IOException {
		String data = "aaaaaBBBBBBBBCCDCC";
		
		ServletContext cont = getServletContext();
		String str = cont.getRealPath("1.jpeg");
		
 		response.setContentType("image/jpeg");
 		
 		FileInputStream file = new FileInputStream(str);
 		OutputStream out = response.getOutputStream();
 		
 		byte[] buffer = new byte[1024];
 		int len = 0;
 		while((len= file.read(buffer)) >= 0){
 			out.write(buffer, 0, len);
 		}
		file.close();
		out.close();
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	 
	

}
