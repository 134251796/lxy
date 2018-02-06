package com.bookonline.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;

public class QueryServlet extends HttpServlet 
{
        private Connection connection;
       public void init() throws ServletException
       {
           super.init();
               connection=DB.getConnection();
       }
       public void destroy()
       {
        super.destroy();
           //关闭数据库连接 
        DB.closeConnection(connection);
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String fname = request.getParameter("fname");
        TicketDao ticketDao=new TicketDao();
        boolean value = false;
        List ticketList = new ArrayList();
		try {
			value = ticketDao.query(connection,fname);
			System.out.println(fname);
			System.out.println(value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        if(value)
		{
        	try {
				ticketList = ticketDao.queryAll(connection, fname);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("ticketList", ticketList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showticket.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryfailed.jsp");
			dispatcher.forward(request, response);
		}         
    }
}
