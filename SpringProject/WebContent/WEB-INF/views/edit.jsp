<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="edited" modelAttribute="editstudent">
		<table>
			<tr>
				<td>Address: <input type="text" name="address" value="${student.address }"  /></td>
			</tr>
				<td>Surname: <input type="text" name="surname" value="${student.surname}"  /></td>
			</tr>
				<td>Phone: <input type="text" name="phone" value="${student.phone }"  /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="name" value="${student.name }" /></td>
			</tr>
			</table>
		<input type="submit" value="Update"/>
	</form>

</body>
</html>