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
 * Servlet implementation class Chart
 */
@WebServlet("/Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chart() {
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
		String[] AndOr = request.getParameter("AndOr").split(",");
		String[] ziduan = request.getParameter("ziduan").split(",");
		String[] mingcheng = request.getParameter("mingcheng").split(",");
		String[] isMohu = request.getParameter("isMohu").split(",");
		String tjZiduan=request.getParameter("tjZiduan");
		String chartType=request.getParameter("chartType");
		System.out.println(tjZiduan);

		for (int i = 0; i < AndOr.length; i++) {
			if (AndOr[i].equals("并含")) {
				AndOr[i] = "and";
			} else if (AndOr[i].equals("或含")) {
				AndOr[i] = "or";
			}
		}
		for (int i = 0; i < ziduan.length; i++) {
			if (ziduan[i].equals("机构全称")) {
				ziduan[i] = "[dbo].[company].name";
			} else if (ziduan[i].equals("归口管理单位")) {
				ziduan[i] = "Centralized";
			} else if (ziduan[i].equals("所在地域")) {
				ziduan[i] = "suozaidiyu";
			} else if (ziduan[i].equals("法人代表")) {
				ziduan[i] = "legalPerson";
			} else if (ziduan[i].equals("联系人")) {
				ziduan[i] = "connectionPerson";
			} else if (ziduan[i].equals("机构属性")) {
				ziduan[i] = "property";
			} else if (ziduan[i].equals("技术需求名称")) {
				ziduan[i] = "requestName";
			} else if (ziduan[i].equals("关键字")) {
				ziduan[i] = "keyword";
			} else if (ziduan[i].equals("拟投入资金总额")) {
				ziduan[i] = "projectSum";
			} else if (ziduan[i].equals("技术需求解决方式")) {
				ziduan[i] = "cooperation";
			} else if (ziduan[i].equals("科技活动类型")) {
				ziduan[i] = "studyClassfied";
			} else if (ziduan[i].equals("学科分类")) {
				ziduan[i] = "subjectClassfied";
			} else if (ziduan[i].equals("需求技术所属领域")) {
				ziduan[i] = "techArea";
			} else if (ziduan[i].equals("需求技术应用行业")) {
				ziduan[i] = "tech";
			}

		}
		String sql = "select "+tjZiduan+",count(*) from [dbo].[tecneed] join [dbo].[company] on [dbo].[tecneed].tec_id=[dbo].[company].tec_id"
				+ " where " + ziduan[0] + "='" + mingcheng[0] + "'";
		if (AndOr.length > 0) {
			for (int i = 0; i < AndOr.length; i++) {
				System.out.println(isMohu[i].equals("模糊查询"));
				if(isMohu[i].equals("精确查询"))
				{
				     sql += " " + AndOr[i] + " " + ziduan[i + 1] + "='" + mingcheng[i + 1] + "'";
				}
				else if(isMohu[i].equals("模糊查询")){
					 sql += " " + AndOr[i] + " " + ziduan[i + 1] + " like '%" + mingcheng[i + 1] + "%'";
				}
			}
		}
		sql+=" group by "+tjZiduan;
		System.out.println(sql);

		ResultSet rs = db.executeQuery(sql);

		JSONObject result = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array1 = new JSONArray();
		JSONArray array2 = new JSONArray();
		try {
			if(chartType.equals("pie")||chartType.equals("doughnut")){
				while (rs.next()) {
					JSONObject json = new JSONObject();
				    json.put("value",rs.getString(2));
				    json.put("color","#F38630");
					array.add(json);
				}
				result.put("result", array);
				response.getWriter().print(result);
			}
			else if(chartType.equals("bar")){
				while(rs.next()){
					array1.add(rs.getString(1));
					array2.add(rs.getString(2));
				}
				result.put("labels", array1);
				json1.put("fillColor","rgba(151,187,205,0.5)");
				json1.put("strokeColor", "rgba(151,187,205,1)");
				json1.put("data", array2);
				array.add(json1);
				result.put("datasets", array);
				response.getWriter().print(result);
			}
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
