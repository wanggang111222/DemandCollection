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
 * Servlet implementation class GetInfoByType
 */
@WebServlet("/GetInfoByType")
public class GetInfoByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoByType() {
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
		String type1=request.getParameter("type1");
		String type2=request.getParameter("type2");
		
		DatabaseConnection db = new DatabaseConnection();
		String sql="select *  from [dbo].[tecneed] join [dbo].[company] on [dbo].[tecneed].tec_id=[dbo].[company].tec_id where "
				+type1+" like '%"+type2+"%'";
		ResultSet rs =db.executeQuery(sql);
		JSONArray array = new JSONArray();
		JSONObject result = new JSONObject();
		try {
			while(rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("name", rs.getString("name"));
				json.put("requestName", rs.getString("requestName"));
				json.put("suozaidiyu", rs.getString("suozaidiyu"));
				json.put("Centralized", rs.getString("Centralized"));
				json.put("property", rs.getString("property"));
				json.put("studyClassfied", rs.getString("studyClassfied"));
				json.put("tec_id", rs.getString("tec_id"));
				json.put("xsCheck", rs.getString("xsCheck"));
				json.put("jsCheck", rs.getString("jsCheck"));
				array.add(json);
			}
			result.put("result", array);
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
