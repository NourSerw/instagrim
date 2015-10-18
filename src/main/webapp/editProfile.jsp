<%-- 
    Document   : editProfil
    Created on : Oct 11, 2015, 1:02:03 PM
    Author     : NSERW
--%>

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
        <p> Your profile name is: ${message}</p>
        
        <form method="POST"  action="Update">
        <ul>
            <li>User Name <input type="text" name="newUsername"></li>
            <li>Address <input type="=text" name="newAddress"</li>
            <li>First Name <input type="text" name="newFName"</li>
            <li>Last Name <input type="text" name="newLname"</li>
            <li>E-mail <input type="text" name="newEmail"</li>
            <br>
            <input type="submit" value="Edit">
        </ul>
        </form>
    </body>
</html>
