<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course</title>
</head>
<body>
	<form name="choose" action="choose_course" method="post">
    <table border="1" width="150" height="160">
    	<tr>
    	<td>Java</td>
    	<td><input type="radio" name="course" value="Java">
    	<tr>
    	<td>C</td>
    	<td><input type="radio" name="course" value="C">
    	<tr>
    	<td>HTML5</td>
    	<td><input type="radio" name="course" value="HTML5">
      </table>
      <input type="submit" value="Sure">
      
	</form>
	
</body>
</html>