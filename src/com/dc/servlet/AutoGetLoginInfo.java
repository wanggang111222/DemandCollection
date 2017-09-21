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

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AutoGetLoginInfo
 */
@WebServlet("/AutoGetLoginInfo")
public class AutoGetLoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoGetLoginInfo() {
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
		
			String sql1="select distinct name,adress,tel,phone from [dbo].[users] where id ='"+request.getSession().getAttribute("id")+"'";
	        ResultSet rs1 = db.executeQuery(sql1);
	        JSONObject json = new JSONObject();
	        try {
			if(rs1.next())
			   {
				   json.put("name", rs1.getString("name"));
				   json.put("adress", rs1.getString("adress"));
				   json.put("tel", rs1.getString("tel"));
				   json.put("phone", rs1.getString("phone"));
			   }
			response.getWriter().print(json);
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
