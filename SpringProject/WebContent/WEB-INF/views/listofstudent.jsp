<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of student</title>
</head>
<body>
	<table>
		<tr>
			<td>Name</td>
			<td>Address</td>
			<td>Surname</td>
			<td>Phone</td>
		</tr>
		<c:forEach var="ps" items="${list}">
			<tr>
				<td><c:out value="${ ps.name}"></c:out></td>
				<td><c:out value="${ ps.address}"></c:out></td>
				<td><c:out value="${ ps.surname}"></c:out></td>
				<td><c:out value="${ps.phone }"></c:out></td>
				<td><a href="edit?name=<c:out value="${ps.name }"></c:out>">Edit</a></td>
				<td><a href="delete/<c:out value="${ps.name }"></c:out>/">Delete</a></td>
			</tr>
		</c:forEach>
		<a href="welcome">Back to Home</a></li>
	</table>
</body>
</html>