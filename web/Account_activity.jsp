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
        <div><h2>Account Activity</h2></div>
        <c:if test = "${session != null}">Welcome</c:if>
        <c:if test = "${session == null}">You are not logged in</c:if>
        <p>
            <a href="index.jsp">Return to Main Page</a>
        </p>
    </body>
</html>

<c:import url="/includes/footer.jsp" />
