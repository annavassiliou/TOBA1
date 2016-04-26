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
        <div><h2>Password Reset</h2></div>
        <p>Enter new password below.</p>
        <p><i>${message}</i></p>
        <form method="post" action="resetPassword">
            <input type="hidden" name="action" value="reset"> 
            <label class="pad_top">Username:</label>
            <input type="text" name="userUsername" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="userPassword" required><br> 
            <label class="pad_top">New Password:</label>
            <input type="password" name="newPassword" value="${passWord}"><br>     
            <label>&nbsp;</label>
            <input type="submit" value="Reset" class="margin_left">
        </form>

        <p>
            <a href="index.jsp">Return to Main Page</a>
        </p>
    </body>
</html>

<c:import url="/includes/footer.jsp" />
