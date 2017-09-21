<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*" import="java.text.SimpleDateFormat"
import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="db" class="com.dc.data.DatabaseConnection" scope="page" />
	<%
		request.setCharacterEncoding("UTF-8");
		//String id = request.getParameter("OrganizationId");
		String OrganizationName = request.getParameter("OrganizationName");
		String adress = request.getParameter("adress");
		String suozaidiyu = request.getParameter("suozaidiyu");
		String website = request.getParameter("website");
		String mail = request.getParameter("mail");
		String legalPerson = request.getParameter("legalPerson");
		String postcode = request.getParameter("postcode");
		String connectionPerson = request.getParameter("connectionPerson");
		String tel = request.getParameter("tel");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String property = request.getParameter("property");
		String Centralized = request.getParameter("Centralized");
		String info = request.getParameter("info");
		String requestName = request.getParameter("requestName");
		String firstYear=request.getParameter("first-year");
		String secondYear=request.getParameter("second-year");
		String requestInfo1 = request.getParameter("requestInfo1");
		String requestInfo2= request.getParameter("requestInfo2");
		String requestInfo3 = request.getParameter("requestInfo3");
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		String keyword3 = request.getParameter("keyword3");
		String keyword4 = request.getParameter("keyword4");
		String keyword5 = request.getParameter("keyword5");
		String studyClassfied = request.getParameter("studyClassfied");
		//String subjectClassfied = request.getParameter("subjectClassfied");
		String subjectClassfied1 = request.getParameter("subjectClassfied1");
		String subjectClassfied2 = request.getParameter("subjectClassfied2");
		String subjectClassfied3 = request.getParameter("subjectClassfied3");
		String[] techArea = request.getParameterValues("techArea");
		
		String tech1 = request.getParameter("tech1");
		String tech2 = request.getParameter("tech2");
		String tech3 = request.getParameter("tech3");
		
		String techArea1 = "";
		if(!studyClassfied.equals("基础研究"))
		{
			for(int i = 0;i < techArea.length; i++)
			{ 
				techArea1 = techArea1 + techArea[i] + ",";
			}
			
		}
		
		
		String[] cooperation = request.getParameterValues("cooperation");
		String cooperativeUnit = request.getParameter("cooperativeUnit");
		String projectSum = request.getParameter("projectSum");
		//String self = request.getParameter("self");
		//String borrow = request.getParameter("borrow");
		//String other = request.getParameter("other");
		String xsCheck = "false";
		String jsCheck="false";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currentTime=df.format(new Date());

		
		String cooperation1 = "";
		for(int i = 0;i < cooperation.length; i++)
		{ 
			cooperation1 = cooperation1 + cooperation[i] + ",";
		}
		String subjectClassfied =subjectClassfied1+","+subjectClassfied2+","+subjectClassfied3;
		String tech=tech1+","+tech2+","+tech3;
		String year=firstYear+","+secondYear;
		String keyword=keyword1+","+keyword2+","+keyword3+","+keyword4+","+keyword5;
		String CompanySQL = "Insert Into company Values('" + session.getAttribute("id") + "','" + OrganizationName +"','" + adress + "','"+suozaidiyu+"','"
				+ website + "','" + mail + "','" + legalPerson + "','" + postcode + "','" + connectionPerson + "','"
				+ tel + "','" + phone + "','" + fax + "','" + property + "','" + Centralized + "','" + info + "')";
		Boolean i = db.executeUpdate(CompanySQL);
		
		String tecneedSQL = "Insert Into tecneed ([id],[name],[requestName],[year] ,[requestInfo1],[requestInfo2],[requestInfo3]"
		                   +",[keyword],[studyClassfied],[subjectClassfied],[techArea],[tech],[cooperation],[cooperativeUnit]"
		                   +",[projectSum],[xsCheck],[jsCheck],[tjTime]) Values('" + session.getAttribute("id") + "','" + OrganizationName +"','" + requestName + "','" +year+"','"+ requestInfo1 + "','"+ requestInfo2 + "','"
				+ requestInfo3 + "','"+ keyword + "','" + studyClassfied + "','" + subjectClassfied + "','" + techArea1 + "','" + tech + "','" + cooperation1 + "','" + cooperativeUnit +"','" + projectSum + "','"
				+ xsCheck + "','"+ jsCheck+ "','"+ currentTime+"')";
		Boolean j = db.executeUpdate(tecneedSQL);
		
		String moneysSQL = "Insert Into moneys Values('" + session.getAttribute("User") + "','" + projectSum +"')";
		Boolean k = db.executeUpdate(moneysSQL);
		
		if (i==true&&k == true&&j==true) {
			out.println("<script language='javaScript'> alert('提交成功，请等待审核，注意查看信息。');</script>");
			response.setHeader("refresh", "1;url=Check.jsp");
		}
	%>
</body>
</html>