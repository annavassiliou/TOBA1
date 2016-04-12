<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="resetPassword">
            <input type="hidden" name="action" value="reset">       
            <label class="pad_top">New Password:</label>
            <input type="password" name="newPassword" value="${passWord}"><br>     
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="margin_left">
        </form>
    </body>
</html>

<c:import url="/includes/footer.jsp" />
