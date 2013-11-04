<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
<h1>Under Construction!!!</h1>
<table>
<tr><form:form modelAttribute="user" action="welcome.jsp">
	<td>
		<label for="usernameInput">username: </label>
		<form:input path="username" id="usernameInput" />
	</td>
	<td>
		<label for="passwordInput">password:</label>
		<form:input path="password" name = "passwordInput" />
	</td>
	</form:form>
	<td><input type="submit" value="Submit" /></td>
</tr>
	
</table>
</body>
</html>