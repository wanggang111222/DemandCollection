package com.dc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class Subject3Servlet
 */
@WebServlet("/Subject3Servlet")
public class Subject3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subject3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 String title1=request.getParameter("title1");
		 String sql="select title from [dbo].[学科$] where left2 = (select left2 from [dbo].[学科$] where title = '"+title1+"') and mid33 = (select mid33 from [dbo].[学科$] where title = '"+title1+"')";
		 String str="";
		 DatabaseConnection db = new DatabaseConnection();
		 ResultSet rs = db.executeQuery(sql);
		 try {
			while(rs.next())
			 {
				  str=str+rs.getString(1)+",";
			 }
			response.getWriter().print(str);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
