package com.dc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String checkCode = request.getParameter("randcode");
		DatabaseConnection db = new DatabaseConnection();
		PrintWriter out =response.getWriter();
		String checkCode1=(String)request.getSession().getAttribute("rand");
		
		String sql = "Select * From users";
		System.out.println(userName);
		ResultSet rs = db.executeQuery(sql);
		boolean userFlag = false;
		boolean pwFlag = false;
		try {
			while(rs.next())
			{
				if(userName.equals(rs.getString("userName")))
				{
					userFlag = true;
					if(pwd.equals(rs.getString("pwd")))
					{
						pwFlag = true;
						response.setHeader("refresh", "0;url = main.html");
						request.getSession().setAttribute("User",userName);
						request.getSession().setAttribute("id",rs.getString(1));
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(!userFlag)
		{
			out.println("<script language='javascript'> alert('用户不存在，请注册');</script>");
			response.setHeader("refresh", "0;url = register.html");
		}
		else if(!pwFlag)
		{
			out.println("<script language='javascript'> alert('密码错误');</script>");
			response.setHeader("refresh", "0;url = login1.html");
		}
		else if(!checkCode.equals(checkCode1))
		{
			out.println("<script language='javascript'> alert('验证码输入错误');</script>");
			response.setHeader("refresh", "0;url = login1.html");
		}
		db.connectionClose();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
