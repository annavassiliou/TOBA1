<%@ page contentType="text/html" pageEncoding="utf-8" %>
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
        <div><h2>Login</h2></div>
        <p>Please enter login information below.</p>
        <form method="post" action="userLogin">
            <input type="hidden" name="action" value="add">       
            <label class="pad_top">Username:</label>
            <input type="text" name="userUsername" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="userPassword" required><br>     
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="margin_left">
        </form>
        <br>
        <a href="New_Customer.jsp">New Customer</a>
        <a href="password_reset.jsp">Reset Password</a>
    </body>
</html>

<c:import url="/includes/footer.jsp" />
