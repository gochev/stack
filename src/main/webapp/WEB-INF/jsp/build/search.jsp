<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search for Build</title>
</head>
<body>
<h1>Search for Build</h1>

	<p>
		<form action="/build/search" method="get">
			Filters: <br/>
			Build Name: <input type="text" name="buildName"/>
			<input type="submit" value="SEARCH"/>
		</form>
		
	</p>

	<c:forEach var="build" items="${buildsPage.content}">
		<p>
			Build name: <c:out value="${build.name}"/> <br/>
			
			Created on: <joda:format value="${build.createdDate}" pattern="dd-MM-yyyy"/> <br/>
			Author: <c:out value="${build.user.fullName}"/>
			<a href="/build/detail/${build.id}">Details</a>
		</p>
	</c:forEach>
	<p>

		Total: ${buildsPage.totalElements}
		<c:if test="${buildsPage.number > 0}">
			<span><a
				href="/build/search/?page=${buildsPage.number - 1}">previous</a></span>
		</c:if>
		<c:if test="${buildsPage.number < (buildsPage.totalPages - 1)}">
			<span><a
				href="/build/search?page=${buildsPage.number + 1}">next</a></span>
		</c:if>
	</p>

</body>
</html>