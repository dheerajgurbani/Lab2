<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/275_lab2/updateUser">
First Name<input type="text" name ="firstname" value ="${user.firstname}"/><br>
Last Name <input type="text" name="lastname" value ="${user.lastname}"/><br>
Title <input type="text" name="title" value = "${user.title}"/><br>
Address<br>
Street<input type="text" name="street" value = "${user.address.street}"/>
City<input type="text" name="city" value = "${user.address.city}"/>
State<input type="text" name="state" value = "${user.address.state}"/>
Zip<input type="text" name="zip"value = "${user.address.zip}"/> 
<input type = "hidden" name = "userId" value ="${user.id}">
<button type="submit" value="updateUser">Update</button>
</form>

<form method = "delete" action = "/275_lab2/deleteUser">
<input type = "hidden" name = "userId" value ="${user.id}">
<button type="submit" value="deleteUser">Delete</button>
</form>
</body>
</html>