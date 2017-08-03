<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="deleted" modelAttribute="deletestudent">
		<table>
			<tr>
				<td>Name: <input type="text" name="name" value="${student.name }" /></td>
			</tr>
			<tr>
				<td>Address: <input type="text" name="address" value="${student.address }"  /></td>
			</tr>
				<td>Surname: <input type="text" name="surname" value="${student.surname}"  /></td>
			</tr>
				<td>Phone: <input type="text" name="phone" value="${student.phone }"  /></td>
			</tr>
			
			</table>
		<input type="submit" value="delete"/>
	</form>

</body>
</html>