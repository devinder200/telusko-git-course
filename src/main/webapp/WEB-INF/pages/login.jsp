<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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


</body>
</html>