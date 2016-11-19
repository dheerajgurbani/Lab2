<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action="/275_lab2/phoneDisplay">>
Phone Number<input type="text" name="phoneNumber"/><br>
Description<input type="text" name="description"/><br>
Address<br>
Street<input type="text" name="street"/>
City<input type="text" name="city"/>
State<input type="text" name="state"/>
Zip<input type="text" name="zip"/>
<br>
<button type="submit" value="createPhone">Create</button>
</form> 

</body>
</html>