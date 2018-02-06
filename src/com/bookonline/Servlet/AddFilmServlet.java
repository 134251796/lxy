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

public class AddFilmServlet extends HttpServlet 
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
        String fname = (String)request.getParameter("fname");
        String fdirector = (String)request.getParameter("fdirector");
        String fmactor = (String)request.getParameter("fmactor");
        String time = (String)request.getParameter("time");
        String price = (String)request.getParameter("price");
        String shengyu = (String)request.getParameter("shengyu");
        TicketDao ticketDao=new TicketDao();
        int value = -1;
		try {
			value = ticketDao.add(connection,fname,fdirector,fmactor,time,price,shengyu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        if(value == 1)
		{
			// 添加成功！
        	request.getSession().setAttribute("message", "添加成功，再次添加或返回！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("addfilm.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// 添加失败
			request.getSession().setAttribute("message", "添加失败，重新添加或返回！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("addfilm.jsp");
			dispatcher.forward(request, response);
		}         
    }
}
