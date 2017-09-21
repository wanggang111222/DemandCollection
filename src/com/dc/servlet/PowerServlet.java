package com.dc.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class PowerServlet
 */
@WebServlet("/PowerServlet")
public class PowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		DatabaseConnection db = new DatabaseConnection();
		String userName=(String)request.getSession().getAttribute("User");
		String sql="select distinct * from [dbo].[users] where userName='"+userName+"'";
	    ResultSet rs = db.executeQuery(sql);
		String str="";
	    try {
			while(rs.next())
			{

				str=str+rs.getString("xqzj_qx")+","+rs.getString("xqgl_qx")+","+rs.getString("yhxx_qx")+","+rs.getString("yhxg_qx")+","+rs.getString("xssh_qx")
				+","+rs.getString("bmsh_qx")+","+rs.getString("tjcx_qx")+","+rs.getString("power");
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
