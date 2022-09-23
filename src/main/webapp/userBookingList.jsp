<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Car rental</a>

    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="homepage.jsp">Homepage</a>
            <a class="nav-item nav-link" href="CarServlet?action=getAvailableCars">Make a new reservation</a>
            <a class="nav-item nav-link" href="BookingServlet?action=showMyBookings">Show my bookings</a>
        </div>
    </div>

</nav>
<h3> Hey, <c:out value="${username}" />. Take a look to your reservations. </h3> <br/>
<table class="table table-dark">
    <tr>
        <th>Booking ID</th>
        <th>Car license plate</th>
        <th>Username</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Approved</th>
    </tr>
    <c:forEach var="booking" items="${BookingsByUser}">
    <tr>
        <th><c:out value="${booking.id}"/></th>
        <th><c:out value="${booking.car.licensePlate}"/></th>
        <th><c:out value="${booking.user.username}"/></th>
        <th><c:out value="${booking.startDate}"/></th>
        <th><c:out value="${booking.endDate}"/></th>
        <th><c:out value="${booking.isApproved}" /></th>
   </c:forEach>
    </tr>
</table>
</body>
</html>
