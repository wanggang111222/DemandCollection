<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
<style type="text/css">
body{font-size:20px;}
   td{text-align:center;}
</style>
</head>
<body>
   <h2 align="center">用户信息</h2>
   <table align="center" cellpadding="0" cellspacing="0" border=1 width="480px">
   <jsp:useBean id="db" class="com.dc.data.DatabaseConnection" scope="page"></jsp:useBean>
   <%
       String userName=(String)session.getAttribute("User");
       String sql="select * from [dbo].[users] where userName='"+userName+"'";
       System.out.println(sql);
       ResultSet rs =db.executeQuery(sql);
       try{
    	   if(rs.next())
    	   {
    		   %>
    		   <tr>
    		      <td>机构编号</td>
    		      <td><%=rs.getString("id") %></td>
    		   </tr>
    		    <tr>
    		      <td>机构名称</td>
    		      <td><%=rs.getString("name") %></td>
    		   </tr>
    		   <tr>
    		      <td>地址</td>
    		      <td><%=rs.getString("adress") %></td>
    		   </tr>
    		    <tr>
    		      <td>用户名</td>
    		      <td><%=rs.getString("userName") %></td>
    		   </tr>
    		    <tr>
    		      <td>固定电话</td>
    		      <td><%=rs.getString("tel") %></td>
    		   </tr>
    		    <tr>
    		      <td>手机号</td>
    		      <td><%=rs.getString("phone") %></td>
    		   </tr>
    		   <%
    	   }
       }
       catch(Exception e)
       {
    	   
       }
   %>
   </table>
</body>
</html>