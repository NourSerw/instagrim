<%-- 
    Document   : UserProfile
    Created on : Oct 25, 2015, 12:54:11 PM
    Author     : NSERW
--%>

<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
            User
        %>
    </body>
</html>
