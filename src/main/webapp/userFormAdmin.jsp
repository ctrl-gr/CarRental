<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
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
  <h1>User Management</h1>
  <h2>
    <a href="UserServlet?action=newUserFromAdmin">Add New User</a>
    &nbsp;&nbsp;&nbsp;
    <a href="UserServlet?action=listUser">List All Users</a>
  </h2>
</div>

<div class="center">

  <form action="UserServlet?action=insertUser" method="post">
    <table class="table table-dark">
      <tr>
        <th>First Name:</th>
        <td>
          <input type="text" name="firstName" size="35"
                 value="<c:out value='${user.firstName}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Last Name:</th>
        <td>
          <input type="text" name="lastName" size="35"
                 value="<c:out value='${user.lastName}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Date of Birth:</th>
        <td>
          <input type="date" name="birthDate" size="15"
                 value="<c:out value='${user.birthDate}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Username:</th>
        <td>
          <input type="text" name="username" size="35"
                 value="<c:out value='${user.username}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Password:</th>
        <td>
          <input type="password" name="password" size="35"
                 value="<c:out value='${user.password}' />"
          />
        </td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>