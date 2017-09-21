package com.dc.data;
import java.sql.*;
public class DatabaseConnection {
	private String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url="jdbc:sqlserver://localhost:1433;DatabaseName=TechnologyNeed";
	private String username="sa";
	private String password="Wanggang199069";
	private Connection con=null;
	public DatabaseConnection()
	{
		try
		{
		    Class.forName(dbDriver);
		    con=DriverManager.getConnection(url,username,password);
		    con.setAutoCommit(true);
		}
		catch(Exception e)
		{
			System.out.println(".....");
		}
	}
	public ResultSet executeQuery(String sql)
	{
		try
		{
			Statement stmt=con.createStatement();
			//Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		}
		catch(SQLException e)
		{
			return null;
		}
	}
	public boolean executeUpdate(String sql)
	{
		
		try
		{
			Statement stmt=con.createStatement();
			int num=stmt.executeUpdate(sql);
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
	}
	public void connectionClose()
	{
		try
		{
		    con.close();
		}
		catch(SQLException e)
		{}
	}

}
