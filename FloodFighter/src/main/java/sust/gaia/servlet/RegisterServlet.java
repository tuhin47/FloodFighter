package sust.gaia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.gia.controller.SignUp;

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("tag"));
        if (request.getParameterMap().containsKey("tag") && request.getParameter("tag").equals("register")) {
            tagRegister(request, response);
        }
    }

    public void tagRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        // userName, firstName, lastName, userType, password, email, department
        if (new SignUp().addUser(request.getParameter("userName"), request.getParameter("password"),
                request.getParameter("email"), request.getParameter("contact"))) {

            request.setAttribute("alertMsg", "Register Successful");
            request.getRequestDispatcher("relief.jsp").forward(request, response);

            out.print("Register Successful");
        } else {

            request.setAttribute("alertMsg", "Register Failed");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

            out.print("Register Failed");
        }
    }
}
