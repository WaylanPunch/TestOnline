<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	You are right !!!
		 	  <s:url var="next_page" value="choose_course.action">
				<s:param name="pageNow" >
					<s:property value="#session.pageNow" />
				</s:param>
						<s:param name="course" >
					<s:property value="#session.course"/>
				</s:param>
				</s:url>
				
               <s:a href="%{next_page}">Next</s:a>
</body>
</html>