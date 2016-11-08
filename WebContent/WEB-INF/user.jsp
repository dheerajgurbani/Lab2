<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="/userid">
First Name<input type="text" id="firstname"/><br>
Last Name <input type="text" id="lastname"/><br>
Address<br>
Street<input type="text" id="streetUser"/>
City<input type="text" id="cityUser"/>
State<input type="text" id="stateUsere"/>
Zip<input type="text" id="zipUser"/>
<br>
Title <input type="text" id="title"/><br>
Phone <input type="text" id="phone">
<button type="submit" value="createUser">Create</button>
</form>
</body>
</html>