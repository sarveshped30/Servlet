/* Project: Creating LoginServlet
 * CFP assignment
 * Author: Sarvesh Pednekar */

package com.bridgelabz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/* NewLoginServlet class inheriting HttpServlet */
@WebServlet("/NewLoginServlet")
public class NewLoginServlet extends HttpServlet {

    @Override
    //doPost method receiving request from client and dispatching response
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Declaring name and password pattern
        String NAME_PATTERN = "^[A-Z][a-z]{2,}$";
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        // Declaring user details
        String userName = req.getParameter("user");
        String password = req.getParameter("pwd");

        /* Directing to LoginSuccess.jsp page after the validation of user details
            if validation failed returning to login page */
        if(Pattern.matches(NAME_PATTERN, userName) && Pattern.matches(PASSWORD_PATTERN, password)) {
            req.setAttribute("user", userName);
            req.getRequestDispatcher("/LoginSuccess.jsp").forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<font color=red> Either username or password is invalid.</font>");
            req.getRequestDispatcher("/login.html").include(req, resp);
        }
    }
}
