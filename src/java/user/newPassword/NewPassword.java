package user.newPassword;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String newPassword = request.getParameter("newPassword");
        String url = "/password_reset.jsp";

        String message;
        if (newPassword == null || newPassword.isEmpty()) {
            message = "Please fill out all the form fields.";
            url = "/password_reset.jsp";
        } else {
            message = null;
            url = "/Account_activity.jsp";
        }
        request.setAttribute("message", message);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

}
