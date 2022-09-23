<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert date</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Car rental</a>

    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="homepage.jsp">Homepage</a>
            <a class="nav-item nav-link" href="CarServlet?action=getAvailableCars">Make a new reservation</a>
            <a class="nav-item nav-link" href="BookingServlet?action=showMyBookings">Show my bookings</a>
            <a class="nav-item nav-link" href="LogoutServlet">Logout</a>
        </div>
    </div>

</nav>


<h3> Here you are, <%=request.getParameter("username") %>. Choose your date to make a new reservation.</h3> <br/>
<form action="CarServlet?action=showAvailableCars" method="post">

    Start Date:
    <input type="date" name="startDate"
           value="<c:out value='${booking.startDate}' />"
    /> <br/>
    End Date:
    <input type="date" name="endDate"
           value="<c:out value='${booking.endDate}' />"
    /> <br/>
    Show available cars
    <input type="submit" value="Send"/>
</form>

</body>
</html>
