package com.bookonline.JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TicketDao
{	
	public static int filmid;
	public static int price;
    public boolean query(Connection connection, String fname) throws SQLException
    {
		boolean value = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select Fid,Fname, Fdirector,Fmactor,price from film_tab where Fname=?";		
			// 获得PreparedStatement对象，并填充
			statement = connection.prepareStatement(sql);
			statement.setString(1,fname);
			resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				value = true;
				filmid=resultSet.getInt("Fid");
				price=resultSet.getInt("price");
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
    
    //订票
    public boolean update(Connection connection, String fname) throws SQLException
    {
		boolean value = false;
		PreparedStatement statement = null;
		Statement st = connection.createStatement();
		ResultSet resultSet = null;
		String sql = "select shengyu from film_tab where Fname = ?";		
			// 获得PreparedStatement对象，并填充
			statement = connection.prepareStatement(sql);
			statement.setString(1,fname);
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{	
				int x = Integer.parseInt(resultSet.getString(1));
				if(x>= 1){
					sql = "update film_tab set shengyu = shengyu - 1";
					int t = st.executeUpdate(sql);
					if(t >= 1) value = true;
					return value;
				}
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
    
    
    //查询所有的票，用于显示
    public List queryAll(Connection connection, String fname) throws SQLException
    {
    	List list = new ArrayList();
    	String sql = "select Fname,Fdirector,Fmactor,time,price,shengyu from film_tab where Fname = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,fname);
		ResultSet resultSet = statement.executeQuery();;
		TicketBean ticket = null;
		while(resultSet.next())
		{
			ticket = new TicketBean();
			ticket.setFname(resultSet.getString("Fname"));
			ticket.setFdirector(resultSet.getString("Fdirector"));
			ticket.setFmactor(resultSet.getString("Fmactor"));
			ticket.setTime(resultSet.getString("time"));
			ticket.setPrice(resultSet.getString("price"));
			ticket.setShengyu(resultSet.getString("shengyu"));
			list.add(ticket);
		}		
		return list;
    }
    
  //添加电影票
    public int add(Connection connection, String fname,String fdirector,String fmactor,String time,String price,String shengyu) throws SQLException
    {
    	int value = -1;
    	String sql = "insert into film_tab(fname,fdirector,fmactor,time,price,shengyu) values(?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try{	
			statement = connection.prepareStatement(sql);
			statement.setString(1,fname);
            statement.setString(2,fdirector);
            statement.setString(3,fmactor);
            statement.setString(4,time);
            statement.setString(5,price);
            statement.setString(6,shengyu);
            value=statement.executeUpdate();
		}catch (SQLException ex)
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
}
  
