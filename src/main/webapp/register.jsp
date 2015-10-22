<%-- 
    Document   : register.jsp
    Created on : Sep 28, 2014, 6:29:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1>InstaGrim ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
        <nav>
            <ul>
                
                <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
            </ul>
        </nav>
       
        <article>
            <h3>Register as user</h3>
            
            <form method="POST"  action="Register">
                <ul>
                    <p> ${message}</p>
                    <li>User Name <input type="text" name="username"></li>
                    <li>Password  <input type="password" name="password"></li>
                    <li>Confirm Password <input type="password" name="password01"></li>
                    <li>Address <input type="=text" name="address"</li>
                    <li>First Name <input type="text" name="fName"</li>
                    <li>Last Name <input type="text" name="lName"</li>
                    <li>E-mail <input type="text" name="email"</li>
                    <%--
                    <form method="Post" action="uploadProfilePic">
                        <li> Profile Picture <input type="file" name="profilePic"</li> 
                    </form>
                    --%>
                </ul>
                <br/>
                <input type="submit" value="Register"> 
            </form>
                    
                    

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
