/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;

/**
 *
 * @author NSERW
 */
@WebServlet(name = "editProfile", urlPatterns = {"/editProfile"})
public class editProfileServlet extends HttpServlet {
    Cluster cluster = null;


    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
         LoggedIn lg = new LoggedIn();
         HttpSession session = request.getSession();
        lg = (LoggedIn) session.getAttribute("LoggedIn");
        String username = lg.getUsername();
        String newUsername = request.getParameter("newUsername");
        String newAddress = request.getParameter("newAddress");
        String newFirstName = request.getParameter("newFName");
        String newLastName = request.getParameter("newLname");
        String newEmail = request.getParameter("newEmail");
        User us = new User();
        us.setCluster(cluster);
        
        Pattern p0 = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m0 = p0.matcher(newEmail);
        boolean emailVerify = m0.matches();
        
       boolean update = us.updateProfile(newUsername, username, newFirstName, newLastName, newAddress, newEmail);
       if(emailVerify == true && update == true)
       {
           RequestDispatcher rd = request.getRequestDispatcher("editProfile.jsp");
            rd.forward(request, response);
       }
       else 
       {
           String errorMessage1 = "Email is not valid!";
            request.setAttribute("errorMessage1", errorMessage1);
            request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
            response.sendRedirect("/Instagrim/editProfile.jsp");
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