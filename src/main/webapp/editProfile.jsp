<%-- 
    Document   : editProfile
    Created on : Oct 11, 2015, 1:02:03 PM
    Author     : NSERW
--%>


<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.Profile"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.models.User"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <h1>You can edit your profile here!</h1>
    
        
        <%   Profile pc = (Profile)session.getAttribute("Profile"); 
             LoggedIn lg = (LoggedIn)session.getAttribute("LoggedIn");
             User user = new User();
             if(lg!=null){
             String UserName = lg.getUsername();
             String address = pc.getAddress();
             String firstName = pc.getFName();
             String lastName = pc.getLName();
             String email = pc.getEmail();
             
             if(lg.getlogedin()) {
             
        %>
        <form method="POST"  action="editProfile">
        <ul>
            <li>User Name <input type="text" name="newUsername" value="<%=UserName%>"></li>
            <li>Address <input type="text" name="newAddress" value="<%=address%>"</li>
            <li>First Name <input type="" name="newFName" value="<%=firstName%>"</li>
            <li>Last Name <input type="text" name="newLname" value="<%=lastName%>"</li>
            <li>E-mail <input type="text" name="newEmail" value="<%=email%>"</li>
            <br>
            <input type="submit" value="Edit">
        </ul>
        </form>
            <% } 
            
             }else {
            }
            %>
    </body>
</html>
