<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Build</title>
</head>
<body>
	<h1>Create Build</h1>

	<form:form modelAttribute="build" method="post" action="/build/create">
		<form:hidden path="id"/>
		<fieldset>
			<dl>
				<dt>
					<label for="name">Name</label>
				</dt>
				<dd>
					<form:input path="name" /> <br/>
					<form:errors path="name" />
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="content">Content</label>
				</dt>
				<dd>
					<form:textarea path="content" style="width:80%" rows="5" /> <br/>
					<form:errors path="content" />
				</dd>
			</dl>
			<button type="submit">Submit</button>
		</fieldset>
	</form:form>
</body>
</html>