package com.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class ModifyPassword
 */
@WebServlet("/ModifyPassword")
public class ModifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPassword() {
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
		response.setContentType("text/html;charset=utf-8");
		
		String userName=(String)request.getSession().getAttribute("User");
		String historyPwd=request.getParameter("pwd1");
		String newPwd1=request.getParameter("pwd2");
		DatabaseConnection db = new DatabaseConnection();
		String sql="select pwd from [dbo].[users] where userName='"+userName+"' and pwd='"+historyPwd+"'";
		PrintWriter out = response.getWriter();
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next())
			{
				String sql1="update [dbo].[users] set pwd='"+newPwd1+"' where userName='"+userName+"'";
			 	Boolean bool = db.executeUpdate(sql1);
				if(bool==true)
				{
					out.println("<script language='javascript'> alert('密码修改成功');</script>");
					response.setHeader("refresh", "0;url = WelcomeIndex.html");
				}
				else{
					out.println("<script language='javascript'> alert('密码修改失败');</script>");
					response.setHeader("refresh", "0;url = ModifyPassword.jsp");
				}
			}
			else
			{
				out.println("<script language='javascript'> alert('原始密码输入错误！');</script>");
				response.setHeader("refresh", "0;url = ModifyPassword.jsp");
			}
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
