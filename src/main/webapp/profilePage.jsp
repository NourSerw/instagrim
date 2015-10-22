<%-- 
    Document   : profilePage
    Created on : Oct 22, 2015, 3:43:49 PM
    Author     : NSERW
--%>

<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    
    <body>
        <h1>Hello World!</h1>
        
        <%
            LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
            Profile p = (Profile) session.getAttribute("Profile");
            User u = (User) session.getAttribute("User");
            String userName = lg.getUsername();
            String fName = p.getFName();
            String lName = p.getLName();
            String email = p.getEmail();
            String address = p.getAddress();
            u.getProfPic(p.getUUID());
        %>
        
         <a href="/Instagrim/Image/<%=lg.getProfPic()%>" ><img src="/Instagrim/Thumb/<%=lg.getProfPic()%>"></a>
         
    </body>
</html>
