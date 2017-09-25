package com.ci.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ci.beans.Cache;

/**
 * Servlet implementation class CalculateIntrest
 */
@WebServlet("/CalculateIntrest")
public class CalculateIntrest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	private static final String ri="intrestprops";
    public CalculateIntrest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
      PrintWriter out=response.getWriter();
      String ri="intrestprops";
      String cities=request.getParameter("cities");
      out.println("<h1>"+cities+"</h1>");
      String gender=request.getParameter("gender");
      out.println("<h1>"+gender+"</h1>");
      String[] vehicle=request.getParameterValues("vehicle");
      float rateofinterest=0;
      float pramount=Float.parseFloat(request.getParameter("princple"));
      for (String str : vehicle) {
    	  out.println("<h1>"+str+"</h1>");
	}
      Properties props=new Properties();
      Cache cache=Cache.getInstance();
      if (cache.containsKey(ri)==false) {
		props.load(new FileInputStream(request.getServletContext().getRealPath("/WEB-INF/intrest.properties")));
    	  //props.load(request.getServletContext().getResourceAsStream("/WEB-INF/intrest.properties"));
		cache.put(ri, props);
	}else {
		props=(Properties) cache.get(ri);
	}
     if (props.containsKey(cities)) {
		 rateofinterest=pramount + Float.parseFloat(props.getProperty(cities));
		 out.println("<h1>"+rateofinterest+"</h1>");
	}else {
		try {
			throw new Exception("City is not available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
	
	}

}
