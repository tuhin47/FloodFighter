/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.gaia.dto.AffectedDist;
import sust.gaia.dto.Thana;
import sust.gia.controller.BasicControl;
import sust.gia.controller.Ratio;

/**
 *
 * @author Joker
 */
public class GoingForRelief extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String affectedDistName = request.getParameter("distName");
        String thanaName = request.getParameter("thanaName");
        int relief = Integer.parseInt(request.getParameter("relief"));
        long population = Ratio.getTotalPopulation(affectedDistName, thanaName);
        double totalRelief = relief + Ratio.getPreviousRelif(affectedDistName, thanaName);
        double ratio = Ratio.rationFunction(totalRelief, population);
        AffectedDist dist = Ratio.rationGetAffectedDist(affectedDistName);
        boolean exist = false;
        if (dist == null) {
            dist = new AffectedDist();
            dist.setDistName(affectedDistName);

        } else {

            for (Thana t : dist.getAffectedThana()) {
                if (t.getThana_name().equals(thanaName)) {
                    t.setCumulative(totalRelief);
                    t.setRatio(ratio);
                    exist = true;
//                    dist.getAffectedThana().add(t);
                    break;
                }
            }
        }
        if (exist == false) {
            Thana t = new Thana();
            t.setThana_name(thanaName);
            t.setCumulative(totalRelief);
            t.setRatio(ratio);
            dist.getAffectedThana().add(t);

        }

        new BasicControl().insert(dist);
        request.getRequestDispatcher("planning.jsp").forward(request, response);

        out.print("Thank You for Your Response");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
