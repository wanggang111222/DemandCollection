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
 * Servlet implementation class GetRoleInfo
 */
@WebServlet("/GetRoleInfo")
public class GetRoleInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRoleInfo() {
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
		String sql="select * from [dbo].[role]";
		ResultSet rs = db.executeQuery(sql);
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			while(rs.next())
			{
				JSONObject json = new JSONObject();
				json.put("roleName", rs.getString("roleName"));
				json.put("xqzj_qx", rs.getString("xqzj_qx"));
				json.put("xqgl_qx", rs.getString("xqgl_qx"));
				json.put("yhxx_qx", rs.getString("yhxx_qx"));
				json.put("yhxg_qx", rs.getString("yhxg_qx"));
				json.put("xssh_qx", rs.getString("xssh_qx"));
				json.put("bmsh_qx", rs.getString("bmsh_qx"));
				json.put("tjcx_qx", rs.getString("tjcx_qx"));
				json.put("power", rs.getString("power"));
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
