$(document).ready(function(){
   //机构编号
	$("#OrganizationId").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(0)").text("请输入机构编号!").css("color","red")
	      }
	      
	})
	$("#OrganizationId").focus(function(){
	      $("span:eq(0)").text("");
	})
	//机构名称
	$("#OrganizationName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(1)").text("请输入机构名称!").css("color","red")
	      }
	})
	$("#OrganizationName").focus(function(){
	      $("span:eq(1)").text("");
	})
	//地址
	$("#adress").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(2)").text("请输入地址信息!").css("color","red")
	      }
	})
	$("#adress").focus(function(){
	      $("span:eq(2)").text("");
	})
	//用户名
	$("#userName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(3)").text("请设置你的用户名!").css("color","red")
	      }
	      else if($(this).val().length<6)
	      {
	      	$("span:eq(3)").text("用户名少于6位数!").css("color","red")
	      }
	      else if($(this).val().length>20)
	      {
	      	$("span:eq(3)").text("用户名大于20位数!").css("color","red")
	      }
	})
	$("#userName").focus(function(){
	      $("span:eq(3)").text("");
	})
	//身份证号
	$("#idCardNum").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(4)").text("请输入你的身份证号!").css("color","red")
	      }
	})
	$("#idCardNum").focus(function(){
	      $("span:eq(4)").text("");
	})
	//真实姓名
		$("#realName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(5)").text("请输入你的真实姓名!").css("color","red")
	      }
	})
	$("#realName").focus(function(){
	      $("span:eq(5)").text("");
	})
	//固定电话
	$("#tel").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(6)").text("请输入你的固定电话!").css("color","red")
	      }
	})
	$("#tel").focus(function(){
	      $("span:eq(6)").text("");
	})
	//手机
	$("#phone").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(7)").text("请输入你的手机号!").css("color","red")
	      }
	})
	$("#phone").focus(function(){
	      $("span:eq(7)").text("");
	})
	//设置登录密码
	$("#pwd1").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(8)").text("请设置你的登录密码!").css("color","red")
	      }
	})
	$("#pwd1").focus(function(){
	      $("span:eq(8)").text("");
	})
	//密码确认
	$("#pwd2").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("span:eq(9)").text("请再次输入密码!").css("color","red")
	      }
	      else if($(this).val()!=$("#pwd1").val())
	      {
	      	$("span:eq(9)").text("两次输入的密码不一致!").css("color","red")
	      }
	})
	$("#pwd2").focus(function(){
	      $("span:eq(9)").text("");
	})
	
	
	
	
	/******************************提交验证**********************************************/
	$("#btn").click(function(){
		  var OrganizationId=$("#OrganizationId").val();
		  var OrganizationName=$("#OrganizationName").val();
		  var adress=$("#adress").val();
		  var userName=$("#userName").val();
		  var idCardNum=$("#idCardNum").val();
		  var realName=$("#realName").val();
		  var tel=$("#tel").val();
		  var phone=$("#phone").val();
		  var pwd1=$("#pwd1").val();
		  var pwd2=$("#pwd2").val();
		  
	      if(OrganizationId==null||OrganizationId=="")
	      {
	      	alert("机构编号输入为空请重新输入！");
	      	return false;
	      }
	      else if(OrganizationName==null||OrganizationName=="")
	      {
	      	alert("机构名称输入为空请重新输入！");
	      	return false;
	      }
	      else if(adress==null||adress=="")
	      {
	      	alert("地址输入为空请重新输入！");
	      	return false;
	      }
	      else if(userName==null||userName=="")
	      {
	      	alert("用户名输入为空请重新输入！");
	      	return false;
	      }
	      else if(idCardNum==null||idCardNum=="")
	      {
	      	alert("身份证号输入为空请重新输入！");
	      	return false;
	      }
	      else if(realName==null||realName=="")
	      {
	      	alert("真实姓名输入为空请重新输入！");
	      	return false;
	      }
	      else if(tel==null||tel=="")
	      {
	      	alert("固定电话输入为空请重新输入！");
	      	return false;
	      }
	      else if(phone==null||phone=="")
	      {
	      	alert("手机号输入为空请重新输入！");
	      	return false;
	      }
	      else if(pwd1==null||pwd1=="")
	      {
	      	alert("第一次密码输入为空请重新输入！");
	      	return false;
	      }
	      else if(pwd2==null||pwd2=="")
	      {
	      	alert("第二次密码输入为空请重新输入！");
	      	return false;
	      }
	      else if(pwd2!=pwd1)
	      {
	      	alert("两次密码输入不一致，请重新输入！")
	      }
	      
	})
	
	
	
	
	
	
	
})