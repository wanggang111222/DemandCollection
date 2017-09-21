<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>授予角色</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
   #btn1{width:107px;margin:10px auto;}
   #btn{width:103px;}
</style>
</head>
<body>
<script src="js/jquery-3.1.1.min(1).js"></script>
<script src="js/jquery.params.js"></script>
<script src="js/bootstrap.min.js"></script>
   <h2 align="center">授予角色</h2>
   <table align="center" border="1px" cellspacing="0" cellpadding="0" width="400px">
      <thead>
        <tr>
         <th>请选择</th>
         <th>角色</th>
        </tr>
      </thead>
      <tbody>
      <jsp:useBean id="db" class="com.dc.data.DatabaseConnection" scope="page"></jsp:useBean>
      <%
           String sql="select roleName from [dbo].[role]";
           ResultSet rs = db.executeQuery(sql);
           while(rs.next())
           {
      %>
      <tr>
         <td><input type="radio" name="roles"></td>
         <td><%=rs.getString(1) %></td>
      </tr>
      <%
           }
      %>
      </tbody>
   </table>
   <div id="btn1">
   <button type="button" class="" id="btn">
                  确认授予
   </button>
   <script>
      $(document).ready(function(){
    	  $("#btn").click(function(){
    		  var name=$.query.get("userName");
    		  alert(name);
    		  var roleName=$("input[name='roles']:checked").parent().parent().children("td").eq(1).text();
    		  var url="shouyurole?roleName="+roleName+"&userName="+name;
    		  window.location.href=url;
    	  })
      })
   </script>
   </div>
</body>
</html>