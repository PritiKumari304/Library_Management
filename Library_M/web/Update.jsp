<%-- 
    Document   : Update
    Created on : 4 Nov, 2024, 9:11:11 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
         <form action="Update" method="post">
            <h1>Enter Details to be Updated</h1>
            Book_Id<input type="number" name="BookId" ><br>
            Book_Name<input type="text" name="BookName" ><br>
            Author_Name<input type="text" name="AuthorName" ><br>
            Category<input type="text" name="Category" ><br>
            <input type="reset">
            <input type="submit">
        </form>
    </body>
</html>
