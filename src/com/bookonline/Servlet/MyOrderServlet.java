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

public class MyOrderServlet extends HttpServlet 
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
        MyOrderDao myorderDao=new MyOrderDao();
        boolean value = false;
        List orderList = new ArrayList();
		try {
			value = myorderDao.query(connection,UserDao.userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        if(value)
		{
        	try {
				orderList = myorderDao.queryAll(connection, UserDao.userid,TicketDao.filmid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	System.out.println(orderList);
			request.setAttribute("orderList", orderList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("myorder.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryfailed.jsp");
			dispatcher.forward(request, response);
		}         
    }
}
