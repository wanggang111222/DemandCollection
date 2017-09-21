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
 * Servlet implementation class Tech3Servlet
 */
@WebServlet("/Tech3Servlet")
public class Tech3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tech3Servlet() {
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
		String title2=request.getParameter("title2");
		DatabaseConnection db= new DatabaseConnection();
		String sql="select distinct title from [dbo].[国民经济行业$] "
				+ "where left1=(select distinct left1 from [dbo].[国民经济行业$] where title='"+title2+"') "
				+ "and mid22 = (select distinct mid22 from [dbo].[国民经济行业$] where title='"+title2+"')";
		String str="";
		
		ResultSet rs = db.executeQuery(sql);
		try {
			while(rs.next())
			{
				str=str+rs.getString(1)+",";
			}
			response.getWriter().println(str);
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
