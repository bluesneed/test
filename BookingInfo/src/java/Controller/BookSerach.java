/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JiawenHuang
 */
@WebServlet("/bookSearch")
public class BookSerach extends HttpServlet {
   
    @Resource(mappedName="jdbc/demo") public DataSource ds;
 
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp){     
       
       String bookTitle=req.getParameter("title");
       String msg="";
        
         Book book=null;
            try {
                book = getBook(bookTitle);
                        
            } catch (SQLException ex) {
               msg="error";
            }            
        
        if(null==book){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
           return;
        }
        
        resp.setContentType(MediaType.APPLICATION_JSON);
        resp.setStatus(HttpServletResponse.SC_OK);
        
         try (PrintWriter pw=resp.getWriter();){
            
            JsonObjectBuilder builder=Json.createObjectBuilder();
            builder.add("title", book.getTitle())
                    .add("author",book.getAuthor())
                    .add("publisher",book.getPublisher())
                    .add("topic", book.getTopic());
                    //.add("price",book.getPrice());
            msg
            
            pw.println(builder.build().toString());
          //  pw.flush();
            
                  
        } catch (IOException ex) {
            
        }
        
    
        
        
        
        
        
               
   }
    
    
    public Book getBook(String title) throws SQLException{
        
            Connection cn=ds.getConnection();
             PreparedStatement ps=cn.prepareCall("select * from books where title= ? ");
             ps.setString(1, title);
            
             ResultSet rs=ps.executeQuery();
             
             rs.next();
                 
              Book book =new Book();
              book.setAuthor(rs.getString("author"));
            // book.setPrice(rs.getFloat("price"));
              book.setPublisher(rs.getString("publisher"));
              book.setTitle(rs.getString("title"));
              book.setCommnet(rs.getString("comment"));
              
              rs.close();
              cn.close();
              
              return book;    
                 
             
        
        
    }
}
        
       
        
       
            
    

        
     
