package controller;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class WebController extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {   
    PrintWriter printWriter = null;
	
	try {
		printWriter = response.getWriter();
	}
	catch (Exception e) { System.out.println("ERROR"); }
	

	String name = request.getParameter("textTest");
    printWriter.println(name);       
      
  }
}