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

        String url = "/Login.jsp";

        // Get the user from the session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (username.equals(user.getUserName()) 
                && password.equals(user.getPassWord())) {
            url = "/Account_activity.jsp";
            session.setAttribute("user", user);
        } else {
            url = "/Login_failure.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

}
