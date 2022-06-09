/* Project: Creating FirstServlet
 * CFP Assignment
 * Author: Sarvesh Pednekar */
package com.bridgelabz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//FirstServlet class inheriting HttpServlet class
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    //doPost method receiving request from client and dispatching response
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Hello Tomcat");
        out.close();
    }
}
