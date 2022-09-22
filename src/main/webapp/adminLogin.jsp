
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<form action="LoginServlet?action=loginAdmin" method="post">

  Please enter your username
  <input type="text" name="username"/><br>

  Please enter your password
  <input type="password" name="password"/> <br/>

  <input type="submit" value="Login">

</form>
</body>
</html>
