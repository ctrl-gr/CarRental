<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available cars</title>
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


<h1>Please <%=request.getAttribute("username") %>, select a car: </h1>
<table class="table table-dark">
    <tr>
        <th>License Plate</th>
        <th>Manufacturer</th>
        <th>Model</th>
        <th>Year</th>
        <th>Type</th>
        <th>Seats</th>
        <th>Action</th>
    </tr>
    <c:forEach var="car" items="${availableCars}">
        <tr>
            <td><c:out value="${car.licensePlate}"/></td>
            <td><c:out value="${car.manufacturer}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.year}"/></td>
            <td><c:out value="${car.type}"/></td>
            <td><c:out value="${car.seats}"/></td>

            <td><form action="BookingServlet?action=saveBooking" method="post">
                <input type="hidden" value="<%=request.getAttribute("username") %>" name="username" />
                <input type="hidden" value="${car.id}" name="carId"/>
                <input type="hidden" value="${startDate}" name="startDate" />
                <input type="hidden" value="${endDate}" name="endDate" />
                <input type="submit" value="Select" />

            </form>
            &nbsp;&nbsp;
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
