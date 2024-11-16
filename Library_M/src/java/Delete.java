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
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String BookId = request.getParameter("BookId");
        //String BookName = request.getParameter("BookName");
        
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
            
            String query = "DELETE FROM `library` WHERE BookId=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, BookId);
            
            ps.executeUpdate();
            RequestDispatcher rd = request.getRequestDispatcher("./Delete.jsp");
            pw.write("Row Deletet!!!");
            rd.include(request, response);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}