<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car added</title>
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
    <h1><%= "The car has been added successfully" %>
    </h1>
    <br/>
    <a href="CarServlet?action=listCar">View all the cars</a>
</center>
</body>
</html>
