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
 * Servlet implementation class Zhcx
 */
@WebServlet("/Zhcx")
public class Zhcx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Zhcx() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		DatabaseConnection db = new DatabaseConnection();
		String[] hangshu = request.getParameter("hangshu").split(",");
		String[] AndOr = request.getParameter("AndOr").split(",");
		String[] ziduan = request.getParameter("ziduan").split(",");
		String[] mingcheng = request.getParameter("mingcheng").split(",");
		String[] isMohu = request.getParameter("isMohu").split(",");
		System.out.println(ziduan.length);

		for (int i = 0; i < AndOr.length; i++) {
			if (AndOr[i].equals("����")) {
				AndOr[i] = "and";
			} else if (AndOr[i].equals("��")) {
				AndOr[i] = "or";
			}
		}
		for (int i = 0; i < ziduan.length; i++) {
			if (ziduan[i].equals("����ȫ��")) {
				ziduan[i] = "[dbo].[company].name";
			} else if (ziduan[i].equals("��ڹ���λ")) {
				ziduan[i] = "Centralized";
			} else if (ziduan[i].equals("���ڵ���")) {
				ziduan[i] = "suozaidiyu";
			} else if (ziduan[i].equals("���˴���")) {
				ziduan[i] = "legalPerson";
			} else if (ziduan[i].equals("��ϵ��")) {
				ziduan[i] = "connectionPerson";
			} else if (ziduan[i].equals("��������")) {
				ziduan[i] = "property";
			} else if (ziduan[i].equals("������������")) {
				ziduan[i] = "requestName";
			} else if (ziduan[i].equals("�ؼ���")) {
				ziduan[i] = "keyword";
			} else if (ziduan[i].equals("��Ͷ���ʽ��ܶ�")) {
				ziduan[i] = "projectSum";
			} else if (ziduan[i].equals("������������ʽ")) {
				ziduan[i] = "cooperation";
			} else if (ziduan[i].equals("�Ƽ������")) {
				ziduan[i] = "studyClassfied";
			} else if (ziduan[i].equals("ѧ�Ʒ���")) {
				ziduan[i] = "subjectClassfied";
			} else if (ziduan[i].equals("��������������")) {
				ziduan[i] = "techArea";
			} else if (ziduan[i].equals("������Ӧ����ҵ")) {
				ziduan[i] = "tech";
			}

		}
		String sql = "select * from [dbo].[tecneed] join [dbo].[company] on [dbo].[tecneed].tec_id=[dbo].[company].tec_id"
				+ " where " + ziduan[0] + "='" + mingcheng[0] + "'";
		if (AndOr.length > 0) {
			for (int i = 0; i < AndOr.length; i++) {
				System.out.println(isMohu[i].equals("ģ����ѯ"));
				if(isMohu[i].equals("��ȷ��ѯ"))
				{
				     sql += " " + AndOr[i] + " " + ziduan[i + 1] + "='" + mingcheng[i + 1] + "'";
				}
				else if(isMohu[i].equals("ģ����ѯ")){
					 sql += " " + AndOr[i] + " " + ziduan[i + 1] + " like '%" + mingcheng[i + 1] + "%'";
				}
			}
		}
		System.out.println(sql);

		ResultSet rs = db.executeQuery(sql);

		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			while (rs.next()) {
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
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
