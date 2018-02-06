package com.bookonline.JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MyOrderDao 
{
	
	public boolean query(Connection connection, int userid) throws SQLException
    {
		boolean value = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select ordered from order_tab where uid=?";		
			// 获得PreparedStatement对象，并填充
			statement = connection.prepareStatement(sql);
			statement.setInt(1,userid);
			resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				value = true;
				return value;
			}			
		
			try
			{
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
			}
			catch (SQLException e)
			{
			}
		return value;
  }
    // insert方法 向数据库中插入用户信息
	public int insert(Connection connection, MyOrderBean order,int uid,int fid)
        {
	
		int value=-1;
		PreparedStatement statement=null;
		String sql="insert into order_tab(ordered,price,tel,uid,Fid) values(?,?,?,?,?)";
                try 
                {
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,order.getOrdered());
                    statement.setInt(2,order.getPrice());
                    statement.setString(3,order.getTel());
                    statement.setInt(4,uid);
                    statement.setInt(5,fid);
                    value=statement.executeUpdate();
                } 
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
		finally
		{
                	try
			{
				if(statement != null) statement.close();
			}
			catch (SQLException ex)
			{
			}
		}
                return value;
        }
    
    public List queryAll(Connection connection,int userid,int filmid) throws SQLException
    {
	    	List list = new ArrayList();
	    	MyOrderBean order=new MyOrderBean();
	        String sql="select order_tab.ordered,film_tab.price,user_tab.tel,user_tab.userName,film_tab.Fname from (order_tab left join film_tab on order_tab.Fid=film_tab.Fid) left join user_tab on order_tab.uid=user_tab.uid where order_tab.uid="+userid+" and order_tab.Fid="+filmid;
	        System.out.println(userid+"------------"+filmid);
	        PreparedStatement statement=null;
	        ResultSet result=null;
            statement=connection.prepareStatement(sql);
            result=statement.executeQuery();
            while(result.next())
            {
            	order.setOrdered(result.getString("ordered"));
            	order.setPrice(result.getInt("price"));
            	order.setTel(result.getString("tel"));
            	order.setUsername(result.getString("userName"));
            	order.setFname(result.getString("Fname"));
            	list.add(order);                  
            }
            return list;
    }
 
}