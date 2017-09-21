
$(document).ready(function(){
	$("span").mouseover(function(){
	     $(this).css("cursor","pointer");
	})
	
	$("span").click(function(){
	     var yanzhengma=Math.floor(Math.random()*9999);
	     //alert(yanzhengma);
	     $(this).text(yanzhengma);
	})
	
	/*****************************登录验证*******************************************/
	
	$("#btn-login").click(function(){
	    var userName=$("#userName").val();
	    var pwd=$("#pwd").val();
	    var yanzheng=$("#check").val();
	    var yanzhengma1=$("span").text();
	    
	    if(userName==""||userName==null)
	    {
	    	alert("请输入用户名！");
	    	return false;
	    }
	    else if(pwd==null||pwd=="")
	    {
	    	alert("请输入密码！");
	    	return false;
	    }
	    else if(yanzheng==null||yanzheng=="")
	    {
	    	alert("请输入验证码！");
	    	return false;
	    }
	    else if(yanzheng!=yanzhengma1)
	    {
	    	alert("验证码输入错误，请重新输入！");
	    	$("pwd").val("");
	    	$("#check").val("");
	    	return false;
	    }
	})
	
	
	
})