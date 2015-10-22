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
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    Cluster cluster=null;
    
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password01 = request.getParameter("password01"); 
        String address = request.getParameter("address");
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        
        Convertors convertor = new Convertors();
        java.util.UUID picid = convertor.getTimeUUID();
        
        Pattern p0 = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m0 = p0.matcher(email);
        boolean emailVerify = m0.matches();
        
        
        if(password.equals(password01) && emailVerify == true)
        {
        User us=new User();
        us.setCluster(cluster);
        us.RegisterUser(picid, username, password,address,firstName,lastName,email);
        
        
	response.sendRedirect("/Instagrim");
        } 
           else if(!password.equals(password01) && emailVerify == true)
        {
            String message = "The passwords do not macth!";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            response.sendRedirect("/register.jsp");

        } else if(emailVerify == false && password.equals(password01))
        {
            String message = "Incorrect Email!";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            response.sendRedirect("/register.jsp");
           
        }
        else {
            String message =" Password does not match and incorrect email!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            response.sendRedirect("/register.jsp");
        }
        
       
       //
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
