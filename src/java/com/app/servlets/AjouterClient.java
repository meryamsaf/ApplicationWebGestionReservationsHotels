/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servlets;

import com.app.beans.Client;
import com.app.dao.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author meryam
 */
@WebServlet(name = "AjouterClient", urlPatterns = {"/AjouterClient"})
public class AjouterClient extends HttpServlet {


 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       
               Client clt=new Client();
        
        clt.setCin(request.getParameter("cin"));
        clt.setNom(request.getParameter("nom"));
        clt.setPrenom(request.getParameter("prenom"));
        clt.setTelephone(request.getParameter("telephone"));
        clt.setAdress(request.getParameter("adress"));
        clt.setMail(request.getParameter("mail"));
        clt.setPassword(request.getParameter("password"));
        
        
        ClientDAO.Ajouter(clt);
        request.getRequestDispatcher("AjouterClient.jsp").include(request, response);
        
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
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
