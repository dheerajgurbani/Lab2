<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="updatephoneform" method="post">
Phone Number<input type="text" id="number" name="phoneNumber" value="${phone.number}"><br>
Description<input type="text" id="phonedescription" name="description" value="${phone.description}"/><br>
Address<br>
Street<input type="text" id="streetaddr" name="street" value="${phone.address.street}"/>
City<input type="text" id="phonecity" name="city" value="${phone.address.city}"/>
State<input type="text" id="phonestate" name="state" value="${phone.address.state}"/>
Zip<input type="text" id="phonezip" name="zip" value="${phone.address.zip}"/>


<c:forEach items="${phone.user}" var="phoneUser">
        	<br>
        	<input type="radio" name="phoneUserElement" value="${phoneUser}">${phoneUser}
</c:forEach> 

<script>
function removeUser()
{
	var userId = document.getElementById("userId").value;
	}
</script>


Add user by id<input type = "text" name = "userId" id = "userId"/>
<input type = "hidden" id="phoneid" name = "phoneId" value ="${phone.id}">
<button type="submit" value="updateUser" onclick="updatePhoneDetails()">Update Phone Details</button>
</form>

<!-- <script>
function updatePhoneDetails() {
	alert("Phone");
	var phoneid = document.getElementById("phoneid").value;
	var number = document.getElementById("number").value;
	var description = document.getElementById("phonedescription").value;
	var street = document.getElementById("streetaddr").value;
	var city = document.getElementById("phonecity").value;
	var state = document.getElementById("phonestate").value;
	var zip = document.getElementById('phonezip').value;
	var userId = document.getElementById('userId').value; 
	alert(number);
	var phoneform = "/275_lab2/phone/" + phoneid +"?number="+number+"&description="+description+"&title="+title+"&street="+street+"&city="+city+"&state="+state+"&zip="+zip+"&userId="+userId;
	alert(phoneform);
	$("#updatephoneform").attr("action",phoneform);
	
}
</script>
 --><button  value="deletePhone" onclick="deletePhone()">Delete Phone number</button>
</body>

<script>
function deletePhone(){
	
$.ajax({
	
    url: '/275_lab2/phone/${phone.id}',
    type: 'DELETE',
    success: function(result) {
        // Do something with the result
       
    }
});
}

</script>
</html>