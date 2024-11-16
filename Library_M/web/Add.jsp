<%-- 
    Document   : Add
    Created on : 4 Nov, 2024, 9:10:28 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <form action="Add" method="post">
            <h1>Enter Details to Add Book</h1>
            Enter Book_Id<input type="number" name="BookId" ><br>
            Enter Book_Name<input type="text" name="BookName" ><br>
            Enter Author_Name<input type="text" name="AuthorName" ><br>
            Enter Category<input type="text" name="Category" ><br>
            <input type="Reset">
            <input type="Submit">
        </form>
    </body>
</html>
