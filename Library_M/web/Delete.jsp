<%-- 
    Document   : Delete
    Created on : 4 Nov, 2024, 9:14:13 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
    </head>
    <body>
         <form action="Delete" method="post">
            <h1>Enter Details to Delete Book</h1>
            Enter Book_Id<input type="number" name="BookId" ><br>
            Enter Book_Name<input type="text" name="Book_Name" ><br>
            <input type="reset">
            <input type="submit">
        </form>
    </body>
</html>
