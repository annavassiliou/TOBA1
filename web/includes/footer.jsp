<%-- 
    Document   : footer
    Created on : Apr 11, 2016, 5:36:52 PM
    Author     : Annie
--%>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<% 
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>&copy; Copyright <%= currentYear %> Anna Vassiliou</p>
</body>
</html>
