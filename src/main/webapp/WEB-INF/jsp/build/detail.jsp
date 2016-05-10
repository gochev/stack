<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Build Details</title>
</head>
<body>
<h1>Build Details</h1>

	<p>
		<a href="/build/edit/${build.id}">Edit</a>
	</p>
	<p>
		Build name: <c:out value="${build.name}"/> <br/>
			
		Created on: <joda:format value="${build.createdDate}" pattern="dd-MM-yyyy"/> <br/>
		Author: <c:out value="${build.user.fullName}"/>
		
		<p>
			Content:
			<c:out value="${build.content }"/>
		</p>
	</p>

</body>
</html>