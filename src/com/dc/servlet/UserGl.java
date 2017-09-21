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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserGl
 */
@WebServlet("/UserGl")
public class UserGl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGl() {
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
		String sql="select * from [dbo].[users] where admin='0'";
		ResultSet rs = db.executeQuery(sql);
		JSONArray jsonarray=new JSONArray();
		JSONObject result=new JSONObject();
		
		try {
			while(rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("realName", rs.getString("realName"));
				json.put("name", rs.getString("name"));
				json.put("adress", rs.getString("adress"));
				json.put("userName", rs.getString("userName"));
				json.put("idCardNum", rs.getString("idCardNum"));
				json.put("tel", rs.getString("tel"));
				json.put("phone", rs.getString("phone"));
				jsonarray.add(json);
			}
			result.put("result", jsonarray);
			response.getWriter().print(result);
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
