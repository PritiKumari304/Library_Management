/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/Add"})
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) throws IOException, ServletException {
       
        PrintWriter pw = response.getWriter();
        String url="jdbc:mysql://localhost:3306/Library_Management";
        String uname = "root";
        String pwd = "";
        
        String Book_Id = request.getParameter("BookId");
        String Book_Name = request.getParameter("BookName");
        String Author_Name = request.getParameter("AuthorName");
        String Category = request.getParameter("Category");
        RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
            try{
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement pst1 = con.prepareStatement("insert into library values(?,?,?,?);");
                pst1.setString(1, Book_Id);
                pst1.setString(2, Book_Name);
                pst1.setString(3, Author_Name);
                pst1.setString(4, Category); 
                pst1.executeUpdate();
                response.setContentType("text/html");
                rd.include(request, response);
                pw.write("Book Added Successful");
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        
    }
}