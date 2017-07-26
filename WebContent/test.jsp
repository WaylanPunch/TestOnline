<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><s:property value="#session.list.TITLE" /></h3>
	<form	action="Checkanswer" method="post">
	<table border="1" width="400" height="400">
        				<tr>
        					<th>A</th>
        					<th>B</th>
        					<th>C</th>
        					<th>D</th>
        					<th>Your Answer</th>
        				</tr>
        				<tbody>
		
        				<tr>
        					<td><s:property value="#session.list.A" /></td>
        					<td><s:property value="#session.list.B" /></td>
        					<td><s:property value="#session.list.C" /></td>
        					<td><s:property value="#session.list.D" /></td>
        					<td>
        					
        							<input type="radio" name="answer" value="A">A
        							<input type="radio" name="answer" value="B">B
        							<input type="radio" name="answer" value="C">C
        							<input type="radio" name="answer" value="D">D
        						
        					</td>
        				</tr>
 						
						</tbody>
        			</table>
        			<input type="submit"  value="sure">
	</form>
</body>
</html>