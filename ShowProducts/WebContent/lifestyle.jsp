<%@page import="com.sp.beans.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<%
			out.print("<table border='1' width='100%'");
			out.println("<tr><th>PRODUCTNO</th><th>PRODUCTNAME</th><th>PRODUCTPRICE</th></tr>");
			List<Products> listproduct = (List<Products>) request.getAttribute("lifestyleproduct");
			//out.println(listproduct.size());
			// Object[] pros=new Object[listproduct.size()];
			for (Products pr : listproduct) {
				out.println("<tr><td>" + pr.getProductcode() + "</td><td>" + pr.getProductname() + "</td><td>"
						+ pr.getProductprice() + "</td></tr> ");
				/* for(int i=0;i<listproduct.size();i++){
				  pr1=listproduct.get(i);
				  pros[i]=pr1;
				} */
			}
			out.print("</table>");
			/* 	for(int i=0;i<pros.length;i++){
				if(i<pros.length){
				Products pr=(Products)pros[i];
				out.println("<tr><td>"+pr.getProductcode()+"</td><td>"+pr.getProductname()+"</td><td>"+pr.getProductprice()+"</td></tr> ");
				out.println("<tr><td></td><td>"+pr.getProductname()+"</td><td></td></tr> ");
				out.println("<tr><td></td><td>"+pr.getProductprice()+"</td><td></td></tr> ");
			 	out.println(pr.getProductcode());
				out.println(pr.getProductname());
				out.println(pr.getProductprice());
				} 
				} */
		%>


	</center>
</body>
</html>