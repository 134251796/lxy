package com.bookonline.Servlet;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class ViewServlet extends HttpServlet 
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
            String userName=(String)request.getSession().getAttribute("userName");
            UserDao userDao=new UserDao();
            // 利用userName 进行数据库的查询
            // 将返回的用户信息放入UserBean对象中
            UserBean user=userDao.getUser(connection, userName);
            request.getSession().setAttribute("userName",user.getUserName());
            request.getSession().setAttribute("gender",user.getGender());
            request.getSession().setAttribute("tel",user.getTel());
            request.getSession().setAttribute("email",user.getEmail());
            
            request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}
