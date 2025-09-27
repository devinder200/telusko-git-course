<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Custom Login</title>
</head>
<body>
    <h2>Custom JWT Login</h2>
     <form action="${pageContext.request.contextPath}/doLogin" method="post">

         <label>Username:</label>
         <input type="text" name="username" /><br/>
         <label>Password:</label>
         <input type="password" name="password" /><br/>
         <input type="hidden" name="role" value="USER"/><br/>
         <button type="submit">Login</button>
     </form>

<!-- Display login error only if loginError=true -->
    <c:if test="${param.loginError eq 'true'}">
        <p style="color:red">Invalid username or password</p>
        <script>
            // Remove loginError from URL after showing the message
            if (window.location.search.includes("loginError")) {
                window.history.replaceState({}, document.title, "/login");
            }
        </script>
    </c:if>





    <br>

     <a href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>