/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;    
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;


/**
 *
 * @author NSERW
 */
@WebServlet(name = "LogOut", urlPatterns = {"/LogOut"})
public class LogoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            //response.setContentType("text/html");  
            //PrintWriter out=response.getWriter();  
              
           // request.getRequestDispatcher("index.jsp").include(request, response);  
            
            //LoggedIn lg= new LoggedIn();
            //lg.setLogedout();
            //String emptyName = null;
            //lg.setUsername(emptyName);
              
            HttpSession session=request.getSession();  
            session.setAttribute("LoggedIn", null);
            response.sendRedirect("/Instagrim");
            //session.invalidate();  
              
            //out.print("You are successfully logged out!");  
              
            //out.close();  
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
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    


