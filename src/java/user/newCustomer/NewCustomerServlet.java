package user.newCustomer;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import user.javabean.User;
import user.data.AccountDB;
import user.data.UserDB;
import user.util.PasswordUtil;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/New_Customer.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/Success.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            String email = request.getParameter("email");

            HttpSession session = request.getSession();
            // store data in User object
            User user = new User(firstName, lastName, phone, address, city,
                    state, zipCode, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || phone == null
                    || address == null || city == null || state == null
                    || zipCode == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty()
                    || phone.isEmpty() || address.isEmpty() || city.isEmpty()
                    || state.isEmpty() || zipCode.isEmpty() || email.isEmpty()) {
                message = "Please fill out all the form fields.";
                url = "/New_Customer.jsp";
            } else {
                message = null;
                url = "/Success.jsp";
                session.setAttribute("user", user);
                UserDB.insert(user);
               // AccountDB.insert(user);
            }
            request.setAttribute("message", message);

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

 @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
        // get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // check strength requirements
        String message;
        try {
            PasswordUtil.checkPasswordStrength(password);
            message = "";
        } catch (Exception e) {
            message = e.getMessage();
        }
        request.setAttribute("message", message);        
        
        // hash and salt password
        String hashedPassword;
        String salt = "";
        String saltedAndHashedPassword;
        try {
            hashedPassword = PasswordUtil.hashPassword(password);
            salt = PasswordUtil.getSalt();
            saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);                    
            
        } catch (NoSuchAlgorithmException ex) {
            hashedPassword = ex.getMessage();
            saltedAndHashedPassword = ex.getMessage();
        }
        request.setAttribute("hashedPassword", hashedPassword);
        request.setAttribute("salt", salt);
        request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
        
        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}
