/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servlets;

import com.app.beans.Reservation;
import com.app.dao.ReservationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author meryam
 */
@WebServlet(name = "modifierReservation", urlPatterns = {"/modifierReservation"})
public class modifierReservation extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
       
          Reservation r=new Reservation();
           ReservationDAO resDAO=new ReservationDAO();
    
        r.setId(Integer.parseInt(request.getParameter("id")));
        r.setId_client(request.getParameter("cin"));

        r.setTypeCham(request.getParameter("typeCh"));
        r.setNomhotel(request.getParameter("nomHot"));
            r.setNbre_personne(Integer.parseInt(request.getParameter("personne")));
          r.setNbrJour(Integer.parseInt(request.getParameter("jour")));
          
          String date = request.getParameter("date");
       Date newDate =new SimpleDateFormat("yyyy-mm-dd").parse(date);		
	r.setDate_reser_debut(newDate);
   resDAO.modifier(r);
        request.getRequestDispatcher("modifierReservation.jsp").include(request, response); 
}

    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(modifierReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(modifierReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
