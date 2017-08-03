<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
            <div id="sidebar" class="well sidebar-nav">
                <h5><i class="glyphicon glyphicon-home"></i>
                    <small><b>MANAGE STUDENTS</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="addstudent">Add</a></li>
                    <li><a href="listofstudent">List of Students</a></li>
                </ul>
                <h5><i class="glyphicon glyphicon-user"></i>
                    <small><b>MANAGE USERS</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="adduser">Add</a></li><br>
                    <li><a href="listofuser">List of Users</a></li><br><br>
                	<li><a href="send">Send Mail</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-8">
            <!-- Content Here -->
        </div>
    </div>
</div>
</body>
</html>