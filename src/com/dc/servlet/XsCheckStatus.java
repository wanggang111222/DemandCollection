package com.dc.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.*;
import net.sf.ezmorph.*;
import org.apache.commons.*;

import com.dc.data.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XsCheckStatus
 */
@WebServlet("/XsCheckStatus")
public class XsCheckStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XsCheckStatus() {
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
		String id =(String) request.getSession().getAttribute("id");
		int BeginRecord;
		int pagesize = 10; // 分页大小
		int total = 0; // 总记录数  
	    int PageCount = 0; // 页码总数 
		Integer pageNo=Integer.parseInt(request.getParameter("pageno"));
		BeginRecord= (pageNo - 1) * pagesize; // 开始位置
		ResultSet rs2 = db.executeQuery("select COUNT(*) from [dbo].[tecneed]");
		try {
			if(rs2.next())
			{
				total=rs2.getInt(1);
				PageCount = (total - 1) / pagesize + 1;
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String sql1="select top "+pagesize+" * from [dbo].[tecneed] where tec_id not in (select top "+BeginRecord+" tec_id from [dbo].[tecneed]) and id='"+id+"'";
		ResultSet rs1 = db.executeQuery(sql1);
		System.out.println(sql1);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		/*String sql= "select distinct * from [dbo].[tecneed] where id = '"+id+"'";
		ResultSet rs = db.executeQuery(sql);*/
		try {
			while(rs1.next())
			{
				JSONObject json =  new JSONObject();
				String time[]=rs1.getString("year").split(",");
				json.put("time1", time[0]);
				json.put("time2", time[1]);
				json.put("id", rs1.getString("id"));
				json.put("techId", rs1.getString("tec_id"));
				json.put("name", rs1.getString("name"));
				json.put("currentTime", rs1.getString("tjTime"));
				json.put("requestName", rs1.getString("requestName"));
				json.put("xsCheck", rs1.getString("xsCheck"));
				json.put("jsCheck", rs1.getString("jsCheck"));
				jsonArray.add(json);
			}
			result.put("techRequest", jsonArray);
			result.put("total", total);
			result.put("pageSize", pagesize);
			result.put("page", pageNo);
			result.put("totalPage", PageCount);
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
