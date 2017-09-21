<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="db" class="com.dc.data.DatabaseConnection" scope="page"></jsp:useBean>
   <%
        request.setCharacterEncoding("utf-8");
        String OrganizationId=request.getParameter("OrganizationId");
        String OrganizationName=request.getParameter("OrganizationName");
        String adress=request.getParameter("adress");
        String userName=request.getParameter("userName");
        String idCardNum=request.getParameter("idCardNum");
        String tel=request.getParameter("tel");
        String phone=request.getParameter("phone");
        String pwd1=request.getParameter("pwd1");
        String pwd2=request.getParameter("pwd2");
        String realName=request.getParameter("realName");
        
        String sql="insert into users values('"+OrganizationId+"','"+OrganizationName+"','"+adress+"','"+userName+"','"
        +idCardNum+"','"+realName+"','"+tel+"','"+phone+"','"+pwd2+"','0','0','0','0','0','0','0','0','0')";
        
        //System.out.println(sql);
        
        Boolean check=db.executeUpdate(sql);
        
        if(check==true)
        {
             out.println("<script language='javaScript'> alert('注册成功！');window.top.location.href='login1.html'</script>");
             //response.setHeader("refresh", "1;url=login1.html");
        }
        else if(check==false)
        {
        	out.println("<script language='javaScript'> alert('用户名已经存在，请重新注册！');window.top.location.href='login1.html'</script>");
            //response.setHeader("refresh", "1;url=login1.html");
        }
   %>
</body>
</html>