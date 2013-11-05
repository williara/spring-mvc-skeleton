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
<tr><form:form modelAttribute="user" action="/home">
	<td>
		<form:label path="username">username: </form:label>
		<form:input path="username" id="usernameInput" />
	</td>
	<td>
		<form:label path="password">password:</form:label>
		<form:password path="password" id = "passwordInput" />
	</td>
	<td><input type="submit" value="Submit" /></td>
	</form:form>
</tr>
<tr>
	<td>
		<c:if test="${not empty message}"><div class="message green">${message}</div></c:if>
	</td>
</tr>
	
</table>
</body>
</html>