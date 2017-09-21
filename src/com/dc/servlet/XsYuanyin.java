package com.dc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class XsYuanyin
 */
@WebServlet("/XsYuanyin")
public class XsYuanyin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XsYuanyin() {
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
		String yuanyin=request.getParameter("xsYuanyin");
		String tec_id=request.getParameter("tec_id");
		String isCheck=request.getParameter("isCheck");
		String admin=request.getParameter("admin");
		
		DatabaseConnection db = new DatabaseConnection();
		String sql="UPDATE [dbo].[tecneed] set [xsCheck]='"+isCheck+"',[xsYuanyin]='"+yuanyin+"',guanlichushi='"+admin+"' where tec_id='"+tec_id+"'";
		
		db.executeQuery(sql);
		
		response.sendRedirect("Xssh1.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
