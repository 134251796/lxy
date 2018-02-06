package com.bookonline.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
//进行订票
public class BookServlet extends HttpServlet 
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
        String Fname = (String)request.getParameter("fname");
        TicketDao ticketDao=new TicketDao();
        boolean value = false;
        
		try {
			System.out.println(Fname);
			value = ticketDao.update(connection,Fname);
			System.out.println("--------------"+value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        if(value)
		{
				// 订票成功
	        	String username=(String) request.getAttribute("userName");
	            MyOrderBean order=new MyOrderBean();
	            MyOrderDao orderDao=new MyOrderDao();
	            
	            TicketDao ticket=new TicketDao();
	            List ticketList = new ArrayList();
	            try {
	            	ticketList = ticket.queryAll(connection,Fname);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	            order.setOrdered("15281691952"+TicketDao.filmid);
	            order.setUsername(username);
	            order.setTel(UserDao.usertel);
	            order.setFname(Fname);
	            order.setPrice(TicketDao.price);
	         
	            orderDao.insert(connection, order,UserDao.userid, TicketDao.filmid);
				RequestDispatcher dispatcher = request.getRequestDispatcher("booksuccess.jsp");
				dispatcher.forward(request, response);
			}
		else
		{
			// 订票失败
			RequestDispatcher dispatcher = request.getRequestDispatcher("bookfailed.jsp");
			dispatcher.forward(request, response);
		}
    }
}
