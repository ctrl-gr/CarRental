<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
    <form action="CarServlet?action=showAvailableCars" method="post">
        Start Date:
        <input type="date" name="startDate"
        value="<c:out value='${booking.startDate}' />"
        /> <br/>
        End Date:
        <input type="date" name="endDate"
       value="<c:out value='${booking.endDate}' />"
        /> <br/>
        Show available cars
        <input type="submit" value="Send" />
    </form>

</body>
</html>
