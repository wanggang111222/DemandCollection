package com.dc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class JsYuanyin
 */
@WebServlet("/JsYuanyin")
public class JsYuanyin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsYuanyin() {
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
		String yuanyin=request.getParameter("jsYuanyin");
		String tec_id=request.getParameter("tec_id");
		String jsCheck=request.getParameter("isCheck");
		
		DatabaseConnection db = new DatabaseConnection();
		String sql="UPDATE [dbo].[tecneed] set [jsCheck]='"+jsCheck+"',[jsYuanyin]='"+yuanyin+"' where tec_id='"+tec_id+"'";
		
		db.executeQuery(sql);
		
		response.sendRedirect("Jssh1.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
