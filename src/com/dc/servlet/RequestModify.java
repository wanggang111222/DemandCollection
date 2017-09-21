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
 * Servlet implementation class RequestModify
 */
@WebServlet("/RequestModify")
public class RequestModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestModify() {
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
		
		String modifyId =request.getParameter("tec_id");
		String sql1="select * from [dbo].[tecneed] where tec_id='"+modifyId+"'";
		String sql2="select * from [dbo].[company] where tec_id='"+modifyId+"'";
		
		JSONObject json1 = new JSONObject();
		JSONObject json2 =new JSONObject();
		JSONObject result = new JSONObject();
		DatabaseConnection db = new DatabaseConnection();
		
		ResultSet rs1 = db.executeQuery(sql1);
		ResultSet rs2 = db.executeQuery(sql2);
		try {
			if(rs1.next())
			{
				String year[] = rs1.getString("year").split(",");
				json1.put("name", rs1.getString(2));
				json1.put("requestName", rs1.getString("requestName"));
				json1.put("year1", year[0]);
				json1.put("year2", year[1]);
				json1.put("requestInfo1", rs1.getString("requestInfo1"));
				json1.put("requestInfo2", rs1.getString("requestInfo2"));
				json1.put("requestInfo3", rs1.getString("requestInfo3"));
				json1.put("keyword", rs1.getString("keyword"));
				json1.put("studyClassfied", rs1.getString("studyClassfied"));
				json1.put("subjectClassfied", rs1.getString("subjectClassfied"));
				json1.put("techArea", rs1.getString("techArea"));
				json1.put("tech", rs1.getString("tech"));
				json1.put("cooperation", rs1.getString("cooperation"));
				json1.put("cooperativeUnit", rs1.getString("cooperativeUnit"));
				json1.put("projectSum", rs1.getString("projectSum"));
			}
			if(rs2.next())
			{
				json2.put("adress", rs2.getString("adress"));
				json2.put("suozaidiyu", rs2.getString("suozaidiyu"));
				json2.put("website", rs2.getString("website"));
				json2.put("mail", rs2.getString("mail"));
				json2.put("postcode", rs2.getString("postcode"));
				json2.put("legalPerson", rs2.getString("legalPerson"));
				json2.put("connectionPerson", rs2.getString("connectionPerson"));
				json2.put("tel", rs2.getString("tel"));
				json2.put("phone", rs2.getString("phone"));
				json2.put("fax",rs2.getString("fax"));
				json2.put("property",rs2.getString("property"));
				json2.put("Centralized",rs2.getString("Centralized"));
				json2.put("info",rs2.getString("info"));
			}
			result.put("request", json1);
			result.put("company", json2);
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
