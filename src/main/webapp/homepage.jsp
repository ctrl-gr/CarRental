<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>


<h3> Hi <%=request.getParameter("username") %>.  </h3> <br/>

<a href="CarServlet?action=getAvailableCars">Make a reservation</a> <br/>

</body>
</html>
