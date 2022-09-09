<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body>
        <table class="table-dark">
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birth Date</th>
            </tr>
            <c:forEach var="user" items="${userList}">
            <tr>
                <th><c:out value="${user.id}" /></th>
                <th><c:out value="${user.firstName}" /></th>
                <th><c:out value="${user.lastName}" /></th>
                <th><c:out value="${user.birthDate}" /></th>
                </c:forEach>
            </tr>
        </table>
</body>
</html>
