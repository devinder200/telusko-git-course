<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Custom Login</title>
</head>
<body>
    <h2>Please Login</h2>
     <form action="${pageContext.request.contextPath}/doLogin" method="post">

         <label>Username:</label>
         <input type="text" name="username" /><br/>
         <label>Password:</label>
         <input type="password" name="password" /><br/>
         <button type="submit">Login</button>
     </form>
    <br>
 <!-- Google OAuth2 Login -->
    <a href="<c:url value='/oauth2/authorization/google'/>">Login with Google</a>

    <br>
     <a href="${pageContext.request.contextPath}/register">Register</a>


</body>
</html>