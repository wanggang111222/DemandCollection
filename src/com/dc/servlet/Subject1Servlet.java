package com.dc.servlet;

import java.io.IOException;
import com.dc.data.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Subject1Servlet extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			   throws ServletException, IOException {
			  doGet(req,resp);
			 }
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
			   throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
		 resp.setCharacterEncoding("utf-8");
		 String sql="select title from [dbo].[学科$] where mid33=000 and right2=00";
		 String str="";
		 DatabaseConnection db = new DatabaseConnection();
		 ResultSet rs = db.executeQuery(sql);
		 try {
			while(rs.next())
			 {
				 str=str+rs.getString(1)+",";
			 }
			resp.getWriter().print(str);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 
		 
	 }

}
