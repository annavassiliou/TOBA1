package user.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("userUsername");
        String password = request.getParameter("userPassword");
        String url = "/Login.jsp";

        // validate the parameters
        boolean isValid = username.equals("jsmith@toba.com")
                && password.equals("letmein");
        if (isValid) {
            url = "/Account_activity.jsp";
        } else {
            url = "/Login_failure.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        

    }
    
    


}
