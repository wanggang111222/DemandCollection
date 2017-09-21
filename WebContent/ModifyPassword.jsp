<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<style type="text/css">
   body{font-size:20px;}
   td{text-align:center;}
   #div-btn{width:90px;height:35px;margin:20px auto;}
   #btn{width:88px;height:33px;}
   
</style>
</head>
<body>
<script src="js/jquery-3.1.1.min(1).js"></script>
   <h2 align="center">修改密码</h2>
   <form action="modifypassword" method="post">
   <table align="center" border="1" cellpadding="0" cellspacing="0">
      <tr>
         <td>原始密码：</td>
         <td><input type="password" name="pwd1" ></td>
      </tr>
      <tr>
         <td>新密码：</td>
         <td><input type="password" name="pwd2" ></td>
      </tr>
      <tr>
         <td>再次输入新密码：</td>
         <td><input type="password" name="pwd3" ></td>
      </tr>
   </table>
   <div id="div-btn"><input type="submit" value="提交" id="btn"></div>
   </form>
   <script type="text/javascript">
      $(document).ready(function(){
    	  $("#btn").click(function(){
    		  var pwd1=$("input[name='pwd1']").val();
        	  var pwd2=$("input[name='pwd2']").val();
        	  var pwd3 =$("input[name='pwd3']").val();
        	  if(pwd1==null||pwd1==""){
        		  alert("原始密码输入为空！");
        		  return false;
        	  }
        	  else if(pwd2==null||pwd2==""){
        		  alert("新密码输入为空！");
        		  return false;
        	  }
        	  else if(pwd3==null||pwd3==""){
        		  alert("再次输入的密码为空！");
        		  return false;
        	  }
        	  else if(pwd1.length<6){
        		  alert("输入的历史密码小于6个字符！");
        		  return false;
        	  }
        	  else if(pwd2.length<6){
        		  alert("输入的历史密码小于6个字符！");
        		  return false;
        	  }
        	  else if(pwd3.length<6){
        		  alert("输入的历史密码小于6个字符！");
        		  return false;
        	  }
    	  })
    	  
      })
   </script>
</body>
</html>