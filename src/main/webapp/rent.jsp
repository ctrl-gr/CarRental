<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table-dark">
    <tr>
        <th>Rent ID</th>
        <th>Car</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Approved</th>
    </tr>
    <c:forEach var="rent" items="${rentList}">
    <tr>
        <th><c:out value="${rent.id}" /></th>
        <th><c:out value="${rent.carId}" /></th>
        <th><c:out value="${rent.startDate}" /></th>
        <th><c:out value="${rent.endDate}" /></th>
        </c:forEach>
    </tr>
</table>
</body>
</html>
