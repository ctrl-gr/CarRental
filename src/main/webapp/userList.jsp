<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="text-center">
    <h1>User Management</h1>
    <h2>
        <a href="">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Users</a>

    </h2>
</div>

<table class="table table-dark">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date of Birth</th>
        <th>Username</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.birthDate}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td>
                <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>