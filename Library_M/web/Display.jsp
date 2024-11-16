<%-- 
    Document   : Display
    Created on : 4 Nov, 2024, 9:09:41 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
    </head>
    <body>
        <form action="Display" method="post">
            <h1>Enter Details to Search Book</h1>
            Enter Book_Id<input type="number" name="BookId" ><br>
            Enter Book_Name<input type="text" name="BookName" ><br>
            <input type="reset">
            <input type="submit">
        </form>
    </body>
</html>
