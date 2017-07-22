package sust.gaia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.gia.controller.LoginService;
import sust.gia.controller.SignUp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tagLogin(request, response);
        /*
        System.out.println(request.getParameter("tag"));
        if (request.getParameterMap().containsKey("tag") && request.getParameter("tag").equals("login")) {
            
        }*/
    }

    private void tagLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        LoginService ls = new LoginService();
        if (ls.authenticateUser(request.getParameter("userName"), request.getParameter("password"),
                request.getParameter("userType"))) {

//                HttpSession httpSession = request.getSession();
//                httpSession.setAttribute("user", ls.getLoginUser());
            request.getRequestDispatcher("relief.jsp").forward(request, response);
            out.print("Login successful");
            // out.print(request.getParameter("name"));

        } else {

            request.setAttribute("alertMsg", "Login Failed");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

            out.print("Login Failed");

        }

    }

}
