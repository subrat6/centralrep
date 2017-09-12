<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="./MarshallerServlet">
 <center>
 ISBN :<input type="text" name="isbn"/><br/>
 TITTLE:<input type="text" name="tittle"/><br/>
 AUTHER-NAME:<input type="text" name="authername"/><br/>
 DOB:<input type="text" name="dob"/><br/>
 PUBLISHER-NAME:<input type="text" name="pubname"/><br/>
 PUBLISHED-DT:<input type="text" name="pubdt"/><br/>
 <input type="submit" name="place">  
 </center>
 </form>
</body>
</html>