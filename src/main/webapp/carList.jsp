<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Car List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
<div class="text-center">
  <h1>Car Management</h1>
  <h2>
    <a href="CarServlet?action=newCar">Add new car</a>
    &nbsp;&nbsp;&nbsp;
  </h2>
</div>

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
  <c:forEach var="car" items="${listCar}">
    <tr>
      <td><c:out value="${car.licensePlate}"/></td>
      <td><c:out value="${car.manufacturer}"/></td>
      <td><c:out value="${car.model}"/></td>
      <td><c:out value="${car.year}"/></td>
      <td><c:out value="${car.type}"/></td>
      <td><c:out value="${car.seats}"/></td>
      <td>
        <a href="CarServlet?action=editCar&id=<c:out value='${car.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="CarServlet?action=deleteCar&id=<c:out value='${car.id}' />">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
