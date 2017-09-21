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
 * Servlet implementation class ShouyuRole
 */
@WebServlet("/ShouyuRole")
public class ShouyuRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShouyuRole() {
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
		String roleName=request.getParameter("roleName");
		String userName=request.getParameter("userName");
		
		String xqzj_qx="";
		String xqgl_qx="";
		String yhxx_qx="";
		String yhxg_qx="";
		String xssh_qx="";
		String bmsh_qx="";
		String tjcx_qx="";
		
		String sql1="select * from [dbo].[role] where roleName='"+roleName+"'";
		ResultSet rs = db.executeQuery(sql1);
		try {
			while(rs.next())
			{
				 xqzj_qx=rs.getString("xqzj_qx");
				 xqgl_qx=rs.getString("xqgl_qx");
				 yhxx_qx=rs.getString("yhxx_qx");
				 yhxg_qx=rs.getString("yhxg_qx");
				 xssh_qx=rs.getString("xssh_qx");
				 bmsh_qx=rs.getString("bmsh_qx");
				 tjcx_qx=rs.getString("tjcx_qx");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String sql2="update [dbo].[users]"
				+ " set"
				 +" [xqzj_qx] = '"+xqzj_qx+"'"
	             +",[xqgl_qx] = '"+xqgl_qx+"'"
	             +",[yhxx_qx] = '"+yhxx_qx+"'"
	             +",[yhxg_qx] = '"+yhxg_qx+"'"
	             +",[xssh_qx] = '"+xssh_qx+"'"
	             +",[bmsh_qx] = '"+bmsh_qx+"'"
	             +",[tjcx_qx] = '"+tjcx_qx+"'"
	             +",[power] = '"+roleName+"'"
	             +" where userName='"+userName+"'";
		System.out.println(sql1);
		System.out.println(sql2);
		db.executeUpdate(sql2);
		response.sendRedirect("User_gl.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
