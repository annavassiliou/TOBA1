package user.newPassword;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import user.javabean.User;

public class NewPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url;
        String password = request.getParameter("newPassword");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String message;
        if (password == null || password.isEmpty()) {
            message = "Please fill out all the form fields.";
            url = "/password_reset.jsp";
            session.setAttribute("message", message);
        } else {
            user.setPassWord(password);
            url = "/Login.jsp";
            session.setAttribute("user", user);
            message = null;
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
