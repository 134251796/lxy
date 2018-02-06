package com.bookonline.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
//进行付款
public class PayServlet extends HttpServlet 
{
	public void init() throws ServletException
    {
        super.init();
    }
    public void destroy()
    {
     super.destroy();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
			// 付款
			RequestDispatcher dispatcher = request.getRequestDispatcher("paysuccess.jsp");
			dispatcher.forward(request, response);      
    }
}
