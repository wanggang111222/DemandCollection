package com.dc.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class Addusers
 */
@WebServlet("/Addusers")
public class Addusers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addusers() {
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
		
		String uuid = UUID.randomUUID().toString();
		String name = request.getParameter("name");
		String userName=request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		DatabaseConnection db = new DatabaseConnection();
		String sql="INSERT INTO [dbo].[users]"
           +"([id]"
		   +",[name]"
           +",[userName]"
           +",[pwd]"
           +",[admin])"
          +" VALUES('"+uuid+"','"+name+"','"+userName+"','"+pwd+"','"+name+"')";
		System.out.println(sql);
		Boolean bool = db.executeUpdate(sql);
		if(bool==false)
		{
			response.getWriter().print("false");
		}
		else if(bool==true)
		{
			response.getWriter().print("true");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
