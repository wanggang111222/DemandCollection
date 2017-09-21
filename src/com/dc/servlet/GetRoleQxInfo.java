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
 * Servlet implementation class GetRoleQxInfo
 */
@WebServlet("/GetRoleQxInfo")
public class GetRoleQxInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRoleQxInfo() {
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
		String roleName=request.getParameter("role");
		
		DatabaseConnection db = new DatabaseConnection();
		String sql="select * from [dbo].[role] where roleName='"+roleName+"'";
		ResultSet rs = db.executeQuery(sql);
		JSONObject json = new JSONObject();
		try {
			while(rs.next())
			{
			     json.put("xqzj_qx", rs.getString("xqzj_qx"));
			     json.put("xqgl_qx", rs.getString("xqgl_qx"));
			     json.put("yhxx_qx", rs.getString("yhxx_qx"));
			     json.put("yhxg_qx", rs.getString("yhxg_qx"));
			     json.put("xssh_qx", rs.getString("xssh_qx"));
			     json.put("bmsh_qx", rs.getString("bmsh_qx"));
			     json.put("tjcx_qx", rs.getString("tjcx_qx"));
			     
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
