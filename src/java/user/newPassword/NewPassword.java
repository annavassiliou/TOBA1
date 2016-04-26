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
        String userName = request.getParameter("userUsername");
        String passWord = request.getParameter("userPassword");
        String newPassWord = request.getParameter("newPassword");

        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(newPassWord);

        String message;
        if (newPassWord == null || newPassWord.isEmpty()) {
            message = "Please fill out all the form fields.";
            url = "/password_reset.jsp";
            session.setAttribute("message", message);
        } else {
            passWord = newPassWord;
            user.setPassWord(passWord);
            url = "/Account_activity.jsp";
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
