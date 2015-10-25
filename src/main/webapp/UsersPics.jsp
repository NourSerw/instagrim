<%-- 
    Document   : UsersPics
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Administrator
--%>

<%@page import="uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts"%>
<%@page import="com.datastax.driver.core.Cluster"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.models.PicModel"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.datastax.driver.core.Row"%>
<%@page import="com.datastax.driver.core.ResultSet"%>
<%@page import="com.datastax.driver.core.Session"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.models.User"%>
<%@page import="com.datastax.driver.core.querybuilder.QueryBuilder"%>
<%@page import="com.datastax.driver.core.Statement"%>
<%@page import="com.datastax.driver.core.Statement"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>InstaGrim ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
        <%
            LoggedIn loggedIN = (LoggedIn) session.getAttribute("LoggedIn"); 
            //Profile pf = (Profile) session.getAttribute("Profile");
            String uN = loggedIN.getUsername();
            PicModel pm = new PicModel();
            Cluster cluster;
            User us = new User();
            cluster = CassandraHosts.getCluster();
            pm.setCluster(cluster);
            us.setCluster(cluster);
            loggedIN.setProfPic(us.getProfilePic(loggedIN.getUsername()));
            String pp = loggedIN.getProfPic();
            
        %>
        <nav>
            
            <ul>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
                <li class="nav"><a href="/Instagrim/editProfile.jsp">Edit profile</a></li>
                <li class="nav"><a href="/Instagrim/profilePage.jsp">Your Profile</a></li>
            </ul>
        </nav>
 
        <article>
            
            
           
            
            
        <%
            Pic p = null;
            Pic profilePic = null;
   
            java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
             
            if(lsPics!=null)
            {
             for(int i= 0; i<lsPics.size();i++)
            {
                p = lsPics.get(i);
                if(p.getSUUID().equals(pp))
                {
                    profilePic = p;
                }
            }
            }
                %>
            <h1>Your Profile Picture</h1>  
            
            <%
             if(profilePic!=null)
                {
            %> 
            
            <a href="/Instagrim/Image/<%=profilePic.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=profilePic.getSUUID()%>"></a><br/>
            <%
                }
             %>
            <form action="/Instagrim/uploadProfilePic" enctype="multipart/form-data" method="POST">
            <input type="file" name="Update">
            <input type="submit" value="Press">        
        </form>
            
            
             <h2>Your Pics</h2>
             <%
            if (lsPics == null) {
        %>
        <p>No Pictures found</p>
        
        <%
        } else {
                
            //iterator = lsPics.iterator();
            for(int i= 0; i<lsPics.size();i++)
            {
                p = lsPics.get(i);
               
                %>
                <a href="/Instagrim/Image/<%=p.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=p.getSUUID()%>"></a><br/>
            <%
                }   
        %>
       
            <%

            }
            
        %>
        
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
