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
            Profile p = (Profile) session.getAttribute("Profile");
            UUID userID = p.getUUID();
            String userName = loggedIN.getUsername(); 
            PicModel pm01 = new PicModel();
            Cluster c;
            User u = new User();
            c = CassandraHosts.getCluster();
            pm01.setCluster(c);
            loggedIN.setProfPic(u.getProfilePic(userID));
            
        %>
        <nav>
            <ul>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
                <li class="nav"><a href="/Instagrim/editProfile.jsp">Edit profile</a></li>
            </ul>
        </nav>
 
        <article>
            <h1>Your Profile Picture</h1>
            <
            <%
                
            %>
            
            <h2>Your Pics</h2>
        <%
            java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
            if (lsPics == null) {
        %>
        <p>No Pictures found</p>
        <%
        } else {
            Iterator<Pic> iterator;
            iterator = lsPics.iterator();
            while (iterator.hasNext()) {
                Pic p = (Pic) iterator.next();

        %>
        <a href="/Instagrim/Image/<%=p.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=p.getSUUID()%>"></a><br/><%

            }
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
