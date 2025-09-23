<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
    <title>Register User</title>
</head>
<body>
    <h2>Please Register</h2>
     <form action="${pageContext.request.contextPath}/registerUser" method="post">

         <label>Username:</label>
         <input type="text" name="username" /><br/>
         <label>Password:</label>
         <input type="password" name="password" /><br/>
         <button type="submit">Register</button>
     </form>
<br>
${message}

</body>
</html>