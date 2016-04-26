package user.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import user.javabean.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("userUsername");
        String password = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String url = "/Login.jsp";

        // Get the user from the session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUserName(userName);
        user.setPassWord(passWord);
        // if the user from session is null redirect to registration page
        if (username == null && password == null) {
            url = "/New_customer.jsp";
        } else {
            // else validate username and pwd from form against the actual user object
            boolean isValid = username.equals(userName)
                    && password.equals(passWord);
            if (isValid) {
                url = "/Account_activity.jsp";
                session.setAttribute("user", user);
            } else {
                url = "/Login_failure.jsp";
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

}
