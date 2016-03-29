package user.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Login.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/Account_activity.html";    // the "join" page
        } else if (action.equals("add")) {
            String username = request.getParameter("userUsername");
            String password = request.getParameter("userPassword");

            // validate the parameters
            boolean isValid = username.equals("jsmith@toba.com")
                    && password.equals("letmein");
            if (isValid) {
                url = "/Account_activity.html";
            } else {
                url = "/Login_failure.html";
            }
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
