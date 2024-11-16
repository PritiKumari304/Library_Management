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
@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String BookId = request.getParameter("BookId");
        String BookName = request.getParameter("BookName");
        String AuthorName= request.getParameter("AuthorName");
        String Category = request.getParameter("Category");
        
        PrintWriter pw = response.getWriter();
        
        /**
         * Here we will perform Read operation from database
         */
        String url = "jdbc:mysql://localhost:3306/Library_Management";
        String user = "root";
        String pwd = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            String query = "UPDATE `library` SET `BookId`=?,`BookName`=?,`AuthorName`=?,`Category`=? WHERE `BookId`=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, BookId);
            ps.setString(2, BookName);
            ps.setString(3, AuthorName);
            ps.setString(4, Category);
            ps.setString(5, BookId);
            
            ps.executeUpdate();
            RequestDispatcher rd = request.getRequestDispatcher("./Update.jsp");
            pw.write("Table Updated!!!");
            rd.include(request, response);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}