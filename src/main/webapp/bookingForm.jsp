<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="text-center">

    <form action="BookingServlet?action=saveBooking" method="post">
        <table class="table table-dark">
            <tr>
                <th>Username:</th>
                <td>
                    <input type="text" name="username" size="35"
                           value="<c:out value='${booking.user.username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>License Plate:</th>
                <td>
                   <input type="text" name="licensePlate" size="7"
                          value="<c:out value='${booking.car.licensePlate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>StartDate:</th>
                <td>
                    <input type="date" name="startDate"
                           value="<c:out value='${booking.startDate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>End Date:</th>
                <td>
                    <input type="date" name="endDate"
                           value="<c:out value='${booking.endDate}' />"
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
