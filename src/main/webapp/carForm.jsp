<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New car form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="text-center">
    <h1>Car Management</h1>
    <h2>
        <a href="new">Add new car</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List all cars</a>
    </h2>
</div>

<div class="center">

    <form action="CarServlet" method="post">
        <table class="table table-dark">
            <tr>
                <th>License Plate:</th>
                <td>
                    <input type="text" name="licensePlate" size="35"
                           value="<c:out value='${car.licensePlate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Manufacturer:</th>
                <td>
                    <input type="text" name="manufacturer" size="35"
                           value="<c:out value='${car.manufacturer}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Model:</th>
                <td>
                    <input type="text" name="model" size="15"
                           value="<c:out value='${car.model}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>
                    <input type="text" name="type" size="35"
                           value="<c:out value='${car.type}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Year:</th>
                <td>
                    <input type="number" name="year" size="4"
                           value="<c:out value='${car.year}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Seats:</th>
                <td>
                    <input type="number" name="seats" size="1"
                           value="<c:out value='${car.seats}' />"
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
