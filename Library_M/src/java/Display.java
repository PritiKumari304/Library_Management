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
@WebServlet(urlPatterns = {"/Display"})
public class Display extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String Book_Id = request.getParameter("BookId");
        String Book_Name = request.getParameter("BookName");
        
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
            
            String query = "SELECT * FROM Library WHERE BookId= ?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, Book_Id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String BookIdFromDb = rs.getString("BookId");
                String BookNameFromDb = rs.getString("BookName");
                String AuthorNameFromDb = rs.getString("AuthorName");
                String CategoryFromDb = rs.getString("Category");
                if( Book_Id.equals(BookIdFromDb)){
                   
                    RequestDispatcher rd = request.getRequestDispatcher("./Display_out.jsp");
                    pw.write("<h3>Book Found successfully!!</h3>");
                    request.setAttribute("BookId", BookIdFromDb);
                    request.setAttribute("BookName", BookNameFromDb);
                    request.setAttribute("AuthorName", AuthorNameFromDb);
                    request.setAttribute("Category", CategoryFromDb);
                    rd.include(request, response);
                    
                }else{
                    pw.write("<h3>Book Not Found</h3>");
                    
                    RequestDispatcher rd = request.getRequestDispatcher("./Display.jsp");
                    rd.include(request, response);
                }    
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}