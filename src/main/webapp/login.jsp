<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="LoginServlet?action=loginUser" method="post">

    Please enter your username
    <input type="text" name="username"/><br>

    Please enter your password
    <input type="password" name="password"/>

    <input type="submit" value="Login">

</form>

</body>
</html>
