<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "db" class = "com.dc.data.DatabaseConnection" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("pwd").trim();

		String sql = "Select * From users";
		ResultSet rs = db.executeQuery(sql);
		boolean userFlag = false;
		boolean pwFlag = false;
		while(rs.next())
		{
			if(userName.equals(rs.getString(4)))
			{
				userFlag = true;
				if(password.equals(rs.getString(8)))
				{
					pwFlag = true;
					response.setHeader("refresh", "0;url = EditTable.jsp");
					session.setAttribute("User",userName);
					session.setAttribute("id",rs.getString(1));
				}
			}
		}
		if(!userFlag)
		{
			out.println("<script language='javaScript'> alert('用户不存在，请注册');</script>");
			response.setHeader("refresh", "0;url = register.html");
		}
		else if(!pwFlag)
		{
			out.println("<script language='javaScript'> alert('密码错误');</script>");
			response.setHeader("refresh", "0;url = Login.html");
		}
		db.connectionClose();
	%>
</body>
</html>