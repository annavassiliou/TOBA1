<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>TOBA Titan Online Banking Application</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>

        <div><h1>TOBA Titan Online Banking Application</h1></div>
        <div>Account has been successfully created.</div>
        <br>
        <p>Here is your user information:</p>

        <label>First Name:</label>
        <span><c:out value="${user.firstName}" /></span><br>
        <label>Last Name:</label>
        <span><c:out value="${user.lastName}" /></span><br>
        <label>Phone:</label>
        <span><c:out value="${user.phone}" /></span><br>
        <label>Address:</label>
        <span><c:out value="${user.address}" /></span><br>
        <label>City:</label>
        <span><c:out value="${user.city}" /></span><br>
        <label>State:</label>
        <span>${user.state}</span><br>
        <label>Zip Code:</label>
        <span>${user.zipCode}</span><br>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>Username:</label>
        <span>${user.userName}</span><br>
        <label>Password:</label>
        <span>${user.passWord}</span><br>

        <p>
        <a href="index.jsp">Return to Main Page</a>
        </p>

    </body>
</html>

<c:import url="/includes/footer.jsp" />
