<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User added</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Car rental</a>

    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="adminHomepage.jsp">Homepage</a>
            <a class="nav-item nav-link" href="UserServlet">User management</a>
            <a class="nav-item nav-link" href="BookingServlet">Booking management</a>
            <a class="nav-item nav-link" href="CarServlet">Car management</a>
        </div>
    </div>
</nav>
<center>
  <h1><%= "The user has been added successfully" %>
  </h1>
  <br/>
  <a href="UserServlet?action=listUser">View all the users</a>
</center>
</body>
</html>
