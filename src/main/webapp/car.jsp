<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table-dark">
    <tr>
        <th>Car ID</th>
        <th>License Plate</th>
        <th>Manufacturer</th>
        <th>Model</th>
        <th>Registration Year</th>
        <th>Type</th>
        <th>Seats</th>
    </tr>
    <c:forEach var="car" items="${carList}">
    <tr>
        <th><c:out value="${car.id}" /></th>
        <th><c:out value="${car.licensePlate}" /></th>
        <th><c:out value="${car.manufacturer}" /></th>
        <th><c:out value="${car.model}" /></th>
        <th><c:out value="${car.registrationYear}" /></th>
        <th><c:out value="${car.type}" /></th>
        <th><c:out value="${car.seats}" /></th>
        </c:forEach>
    </tr>
</table>
</body>
</html>
