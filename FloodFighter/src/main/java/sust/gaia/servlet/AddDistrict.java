/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.gaia.dto.District;
import sust.gaia.dto.ThanaDetails;
import sust.gia.controller.BasicControl;
import sust.gia.controller.HibernateUtil;

/**
 *
 * @author Joker
 */
public class AddDistrict extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String distName = request.getParameter("distName");
        long distPopulatin = Integer.parseInt(request.getParameter("distPopulation"));
        long area = Integer.parseInt(request.getParameter("area"));
        String thana_name = request.getParameter("thanaName");
        long thanaPopulatin = Integer.parseInt(request.getParameter("thanaPopulation"));
        BasicControl bc = new BasicControl();
        District dist = bc.returnExistedDist(distName);
        
        if (dist == null) {
            dist = new District(distName, distPopulatin, area);
            dist.getThana().add(new ThanaDetails(thana_name, thanaPopulatin));
            bc.insert(dist);
            
        } else {
            dist.getThana().add(new ThanaDetails(thana_name, thanaPopulatin));
            bc.insert(dist);
        }
        
        out.print("Done");
        
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
