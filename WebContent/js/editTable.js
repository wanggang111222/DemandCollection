
$(document).ready(function(){
	$(".warnning").hide();
	$(".tishi1").show();
	$(".tishi2").hide();
	
	
	$.ajax({
		   url:"111",
		   type:"GET",
		   datatype:"text",
		   success:function(data)
		   { 
		   	var str=data.split(",");
		   	var select1=$("#subjectClassfied1");
		   	for(var i=0;i<str.length-1;i++)
		   	{
		   		select1.append("<option value="+"'"+str[i]+"'"+">"+str[i]+"</option>");
		   	}
		   }
	   })
	$("#subjectClassfied1").change(function(){
		  $("#subjectClassfied2").html("").append("<option>"+"请选择"+"</option>")
		  $("#subjectClassfied3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"222",
	      	type:"GET",
	      	data:{"title":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select2=$("#subjectClassfied2")
	      		for(var i=0;i<str.length-1;i++)
		   	    {
		   	    	if(str[i]!=str1)
		   	    	{
		   		        select2.append("<option value="+"'"+str[i]+"'"+">"+str[i]+"</option>");
		   	    	}
		   	    }
	      	}
	      })
	})
	$("#subjectClassfied2").change(function(){
		 $("#subjectClassfied3").html("").append("<option>"+"请选择"+"</option>")
	      var str1 = $(this).val();
	      $.ajax({
	      	url:"333",
	      	type:"GET",
	      	data:{"title1":str1},
	      	datatype:"text",
	      	success:function(data){
	      		var str=data.split(",");
	      		var select3=$("#subjectClassfied3")
	      		if(str.length!=2)
	      		{
	      		    for(var i=0;i<str.length-1;i++)
		   	        {
		   	    	    if(str[i]!=str1)
		   	    	    {
		   		            select3.append("<option value="+"'"+str[i]+"'"+">"+str[i]+"</option>");
		   	    	    }
		   	    }
	      		}
	      		else
	      		{
	      			select3.html("").append("<option value='空'>空<option>")
	      		}
	      	}
	      })
	})
	
	//机构名称
	$("#OrganizationName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning1").show();
	      }
	      if(isChinese($(this).val())==false)
	      {
	      	  $(".tishi1-OrganizationName").hide();
	      	  $(".tishi2-OrganizationName").show();
	      }
	})
	$("#OrganizationName").focus(function(){
	      $("#warnning1").hide();
	      $(".tishi1-OrganizationName").show();
	      $(".tishi2-OrganizationName").hide();
	})
	//通讯地址
	$("#adress").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning2").show();
	      }
	})
	$("#adress").focus(function(){
	      $("#warnning2").hide();
	})
	//所在地域
	$("#suozaidiyu").blur(function(){
	      if($(this).val()=="请选择"||$(this).val()==null)
	      {
	      	$("#warnning3").show();
	      }
	})
	$("#suozaidiyu").focus(function(){
	      $("#warnning3").hide();
	})
	//电子邮箱
	$("#mail").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning4").show();
	      }
	      if(isEmail($(this).val())==false)
	      {
	      	  $(".tishi1-mail").hide();
      	      $(".tishi2-mail").show();
	      }
	})
	$("#mail").focus(function(){
	      $("#warnning4").hide();
	      $(".tishi1-mail").show();
	      $(".tishi2-mail").hide();
	})
	//法人代表
	$("#legalPerson").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning5").show();
	      }
	})
	$("#legalPerson").focus(function(){
	      $("#warnning5").hide();
	})
	//邮政编码
	$("#postcode").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning6").show();
	      }
	})
	$("#postcode").focus(function(){
	      $("#warnning6").hide();
	})
	//联系人
	$("#connectionPerson").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning7").show();
	      }
	})
	$("#connectionPerson").focus(function(){
	      $("#warnning7").hide();
	})
	//固话
	$("#tel").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning8").show();
	      }
	})
	$("#tel").focus(function(){
	      $("#warnning8").hide();
	})
	//手机
	$("#phone").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning9").show();
	      }
	})
	$("#phone").focus(function(){
	      $("#warnning9").hide();
	})
	//传真
	$("#fax").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning10").show();
	      }
	})
	$("#fax").focus(function(){
	      $("#warnning10").hide();
	})
	//归口管理部门

	//机构简介
	$("#info").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning13").show();
	      }
	})
	$("#info").focus(function(){
	      $("#warnning13").hide();
	})
	//技术需求名称
	$("#requestName").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning14").show();
	      }
	})
	$("#requestName").focus(function(){
	      $("#warnning14").hide();
	})
	//需求时限
	//重大需求概述
	$("#requestInfo").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning15").show();
	      }
	})
	$("#requestInfo").focus(function(){
	      $("#warnning15").hide();
	})
	//关键字
    $("#keyword1").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning16").show();
	      }
	})
	$("#keyword1").focus(function(){
	      $("#warnning16").hide();
	})
	//学科分类
	$("#subjectClassfied").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning18").show();
	      }
	})
	$("#subjectClassfied").focus(function(){
	      $("#warnning18").hide();
	})
	//需求运用技术行业
	$("#tech").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning20").show();
	      }
	})
	$("#tech").focus(function(){
	      $("#warnning20").hide();
	})
	//计划总投资
	$("#projectSum").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning22").show();
	      }
	})
	$("#projectSum").focus(function(){
	      $("#warnning22").hide();
	})
	//企业自筹
	$("#self").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning23").show();
	      }
	})
	$("#self").focus(function(){
	      $("#warnning23").hide();
	})
	//银行贷款
	$("#borrow").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning24").show();
	      }
	})
	$("#borrow").focus(function(){
	      $("#warnning24").hide();
	})
	//其他融资
	$("#other").blur(function(){
	      if($(this).val()==""||$(this).val()==null)
	      {
	      	$("#warnning25").show();
	      }
	})
	$("#other").focus(function(){
	      $("#warnning25").hide();
	})
	
	
	/*......................表内的限制..............*/
	
	$("#jichu").hide();
	$("#feijichu1").hide();
	$("#feijichu2").hide();
	$("input[name='studyClassfied']").click(function(){
		//$("#subjectClassfied").attr("disabled",true);
		//alert($(this).val()==("基础研究"))
		var str=$("input[name='studyClassfied']:checked").val();
	     if((str.trim())!=("基础研究"))
	     {
//		     $("#subjectClassfied").attr("disabled",true);
//		     $(":radio[name='techArea']").attr("disabled",false)
	     	 $("#jichu").hide();
	     	 $("#subjectClassfied1 option[value='请选择']").prop("selected",true);
	     	 $("#subjectClassfied2").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#subjectClassfied3").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#feijichu1").show();
	     	 $("#feijichu2").show();
	     }
	     if((str.trim())==("基础研究"))
	     {
	     	 $("#jichu").show();
	     	 $("#feijichu1").hide();
	     	 $("#feijichu2").hide();
	     	 $("input[name='techArea']").each(function(){
	     	 	if($(this).prop("checked")==true)
	     	 	{
	     	        $(this).prop("checked",false);
	     	 	}
	     	 });
	     	 $("#tech1 option[value='请选择']").prop("selected",true);
	     	 $("#tech2").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     	 $("#tech3").html("").append("<option value='请选择'>"+"请选择"+"</option>")
	     }
	})
	
	/*....................提交验证.....................*/
	$("#btn").click(function(){
	      var OrganizationName=$("#OrganizationName").val();
	      var adress=$("#adress").val();
	      var suozaidiyu=$("#suozaidiyu").val()
	      var mail=$("#mail").val();
	      var legalPerson=$("#legalPerson").val();
	      var connectionPerson=$("#connectionPerson").val();
	      var phone=$("#phone").val();
	      var inputproperty=$("input[name='property']:checked").val();
	      var info=$("#info").val();
	      var requestName=$("#requestName").val();
	      var time1=$("#first-year").val();
	      var time2=$("#second-year").val();
	      var requestInfo1=$("#requestInfo1").val();
	      var requestInfo2=$("#requestInfo2").val();
	      var requestInfo3=$("#requestInfo3").val();
	      var keyword1=$("#keyword1").val();
	      var inputstudyClassfied=$("input[name='studyClassfied']:checked").val();
	      var subjectClassfied1=$("#subjectClassfied1").val();
	      var subjectClassfied2=$("#subjectClassfied2").val();
	      var subjectClassfied3=$("#subjectClassfied3").val();
	      
	      var subjectClassfied=$("#subjectClassfied").val();
	      var inputtechArea=$("input[name='techArea']:checked").val();
	      
	      var tech1=$("#tech1").val();
	      var tech2=$("#tech2").val();
	      var tech3=$("#tech3").val();
	      
	      var inputcooperation=$("input[name='cooperation']:checked").val();
	     // var inputcooperation= $("#cooperation");
	      var cooperativeUnit=$("#cooperativeUnit").val();
	      var projectSum=$("#projectSum").val();
	      var self=$("#self").val();
	      var borrow=$("#borrow").val();
	      var other=$("#other").val();
	      if(OrganizationName==null||OrganizationName=="")
	      {
	      	alert("机构名称输入为空请重新输入！");
	      	return false;
	      }
	      else if(adress==null||adress=="")
	      {
	      	alert("通讯地址输入为空，请重新输入！");
	      	return false;
	      }
	      else if(suozaidiyu=="请选择")
	      {
	      	alert("所在地域输入为空，请重新输入！")
	      	return false;
	      }
	      else if(mail==null||mail=="")
	      {
	      	alert("电子邮箱输入为空，请重新输入！");
	      	return false;
	      }
	      else if(legalPerson==null||legalPerson=="")
	      {
	      	alert("法人代表输入为空，请重新输入！");
	      	return false;
	      }
	      else if(connectionPerson==null||connectionPerson=="")
	      {
	      	alert("联系人输入为空，请重新输入！");
	      	return false;
	      }
	      else if(phone==null||phone=="")
	      {
	      	alert("手机输入为空，请重新输入！");
	      	return false;
	      }
	      else if(inputproperty==null||inputproperty=="")
	      {
	      	alert("机构属性输入为空，请重新输入！");
	      	return false;
	      }
	      else if(info==null||info=="")
	      {
	      	alert("机构简介输入为空，请重新输入！");
	      	return false;
	      }
	      else if(requestName==null||requestName=="")
	      {
	      	alert("技术需求名称输入为空，请重新输入！");
	      	return false;
	      }
	      else if(parseInt(time1)>=parseInt(time2))
	      {
	      	  alert("第二个年要大于第一年，输入不符合，请重新输入！")
	      	  return false;
	      }
	      else if((requestInfo1==null||requestInfo1=="")||(requestInfo2==null||requestInfo2=="")||(requestInfo3==null||requestInfo3==""))
	      {
	      	  alert("重大科技需求概述输入为空，请重新输入！");
	      	  return false;
	      }
	      else if(keyword1==null||keyword1=="")
	      {
	      	alert("关键字输入为空，请重新输入！");
	      	return false;
	      }
	      	      else if(projectSum==null||projectSum=="")
	      {
	      	alert("计划总投资输入为空，请重新输入！");
	      	return false;
	      }
	      	      else if(inputcooperation==null||inputcooperation=="")
	      {
	      	alert("合作意向单位输入为空，请重新输入！");
	      	return false;
	      }
	      else if(inputstudyClassfied==null||inputstudyClassfied=="")
	      {
	      	alert("研究类型输入为空，请重新输入！");
	      	return false;
	      }
	      else if((subjectClassfied1=="请选择"||subjectClassfied2=="请选择"||subjectClassfied3=="请选择")&&inputstudyClassfied=="基础研究")
	      {
	      	alert("学科分类输入为空，请重新选择！");
	      	return false;
	      }
	      /*else if((subjectClassfied==null||subjectClassfied=="")&&inputstudyClassfied=="基础研究")
	      {
	      	alert("学科分类输入为空，请重新输入！");
	      	return false;
	      }*/
	      else if((inputtechArea==null||inputtechArea=="")&&inputstudyClassfied!="基础研究")
	      {
	      	alert("需求技术所属领域输入为空，请重新输入！");
	      	return false;
	      }
	      else if((tech1=="请选择"||tech2=="请选择"||tech3=="请选择")&&inputstudyClassfied!="基础研究")
	      {
	      	alert("需求技术应用行业输入为空，请重新输入！");
	      	return false;
	      }
	      else
	      {
	      	 var tijiao="确定提交吗？提交后不能修改！";
	      	 if(confirm(tijiao)==true){
	      	 }
	      	 else{
	      	 	return false;
	      	 }
	      }
	      
	      
	})
	
	/*......................键盘操作.........................*/
	var ss = $("input");
	$("input:first").focus();
	$("input").keydown(function(){
		if(event.keyCode==13)
		{
			event.preventDefault();
			var nxtIdx=ss.index(this);
	        nxtIdx++;
	        if(nxtIdx==15)
	        {
	        	$("textarea:eq(0)").focus();
	        }
	        else if(nxtIdx==16)
	        {
	        	$("textarea:eq(1)").focus();
	        }
	        else
	        {
			    $("input:eq("+nxtIdx+")").focus();
	        }
		}
	})
	
	/*.......................投资限制..................................*/
	/*
	$(document).keyup(function(){
		var self=parseInt($("#self").val());
		var borrow=parseInt($("#borrow").val());
		var other=parseInt($("#other").val());
		if(isNaN(self))
		{
			self=0;
		}
		if(isNaN(borrow))
		{
			borrow=0;
		}
		if(isNaN(other))
		{
			other=0;
		}
		var sum=self+borrow+other;
		$("#projectSum").val(sum);
	})
	$(document).keyup(function(){
		var self=parseInt($("#self").val());
		if(isNaN(self))
		{
			self=0;
		}
		$("projectSum").val(self);
	})
	*/
	/*......................关键字限制......................................*/
	$("#keyword-input").find("input").attr("disabled",true);
	$("#keyword-input").children(":first").attr("disabled",false);
	
	$("#keyword1").keyup(function(){
		if($("#keyword1").val().length>0)
		{
	      $("#keyword-input").children("#keyword2").attr("disabled",false);
		}
		else
		{
		  $("#keyword-input").children("#keyword2").attr("disabled",true);
		  $("#keyword-input").children("#keyword3").attr("disabled",true);
		  $("#keyword-input").children("#keyword4").attr("disabled",true);
		  $("#keyword-input").children("#keyword5").attr("disabled",true);
		  $("#keyword-input").children("#keyword2").val("");
		  $("#keyword-input").children("#keyword3").val("");
		  $("#keyword-input").children("#keyword4").val("");
		  $("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword2").keyup(function(){
		if($("#keyword2").val().length>0)
		{
	      $("#keyword-input").children("#keyword3").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword3").attr("disabled",true);
		   $("#keyword-input").children("#keyword4").attr("disabled",true);
		   $("#keyword-input").children("#keyword5").attr("disabled",true);
		   $("#keyword-input").children("#keyword3").val("");
		  $("#keyword-input").children("#keyword4").val("");
		  $("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword3").keyup(function(){
		if($("#keyword3").val().length>0)
		{
	      $("#keyword-input").children("#keyword4").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword4").attr("disabled",true);
			$("#keyword-input").children("#keyword5").attr("disabled",true);
			$("#keyword-input").children("#keyword4").val("");
		     $("#keyword-input").children("#keyword5").val("");
		}
	})
	$("#keyword4").keyup(function(){
		if($("#keyword4").val().length>0)
		{
	      $("#keyword-input").children("#keyword5").attr("disabled",false);
		}
		else
		{
			$("#keyword-input").children("#keyword5").attr("disabled",true);
			$("#keyword-input").children("#keyword5").val("");
		}
	})
	
/*.........................归口管理部门智能联想...................................*/	
	
	$("#Centralized-Explorer").hide();
	$("#Centralized").keyup(function(){
	      var Centralized=$("#Centralized").val();
	      $("#Centralized-Explorer").html("");
	      if(Centralized!=null&&Centralized!="")
	      { 
	      	  $("#Centralized-Explorer").show();
	      	  $.ajax({
	      	  	url:"444",
	      	  	type:"GET",
	      	  	data:{"key":Centralized},
	      	  	datatype:"text",
	      	  	success:function(data){
	      	  		var str=data.split(",");
	      	  		for(var i=0; i<str.length-1;i++)
	      	  		{
	      	  		     $("#Centralized-Explorer").append("<div class='Centralized-list'>"+str[i]+"</div>")
	      	  		}
	      	  	}
	      	  })
	      }
	      else
	      {
	      	  $("#Centralized-Explorer").hide();
	      }
	      
	})
	$("#Centralized-Explorer").mouseover(function(){
	     $(this).css("cursor","pointer");
	})
	
     $("#Centralized-Explorer").on("click",".Centralized-list",function(){
	     var str=$(this).text();
	     $("#Centralized").val(str);
	     $("#Centralized-Explorer").hide();
     })
	 $("#Centralized").blur(function(){
	     $("#Centralized-Explorer").hide();  
	 })
	
/*................................所在地域........................................*/	
     
    $("#suozaidiyu").html("").append("<option>请选择</option>");
    $.ajax({
    	url:"555",
    	type:"GET",
    	datatype:"text",
    	success:function(data){
    		var str=data.split(",");
    		for(var i=0;i<str.length-1;i++)
    		{
    			//alert(111);
    			$("#suozaidiyu").append("<option value='"+str[i]+"'>"+str[i]+"</option>")
    		}
    	}
    })
	
	
	/*....................................需求技术应用行业三级下拉ajax.......................................*/
    
	$.ajax({
		url:"666",
		type:"GET",
		datatype:"text",
		success:function(data){
			var str=data.split(",")
			for(var i=0;i<str.length-1;i++)
			{
			    $("#tech1").append("<option value='"+str[i]+"'>"+str[i]+"</option>");
			}
		}
	})
	
	$("#tech1").change(function(){
	    $("#tech2").html("").append("<option value='请选择'>请选择</option>");
	    $("#tech3").html("").append("<option value='请选择'>请选择</option>");
	    var str1=$(this).val();
	    $.ajax({
	    	url:"777",
	    	type:"GET",
	    	data:{"title1":str1},
	    	datatype:"text",
	    	success:function(data)
	    	{
	    		var str=data.split(",");
	    		for(var i=0;i<str.length-1;i++)
			    {
			    	if(str[i]!=str1)
			    	{
			           $("#tech2").append("<option value='"+str[i]+"'>"+str[i]+"</option>");
			    	}
			    }
	    	}
	    })
	})
	$("#tech2").change(function(){
	    $("#tech3").html("").append("<option value='请选择'>请选择</option>");
	    var str1=$(this).val();
	    $.ajax({
	    	url:"888",
	    	type:"GET",
	    	data:{"title2":str1},
	    	datatype:"text",
	    	success:function(data)
	    	{
	    		var str=data.split(",");
	    		if(str.length!=2)
	    		{
	    		    for(var i=0;i<str.length-1;i++)
			        {
			    	    if(str[i]!=str1)
			    	    {
			                $("#tech3").append("<option value='"+str[i]+"'>"+str[i]+"</option>");
			    	    }
			        }
	    		}
	    		else
	    		{
	    			$("#tech3").html("").append("<option value='空'>空<option>")
	    		}
	    	}
	    })
	})
	
	/********************************字数限制********************************************/
	
	$("#info").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#info").val(value);
	    }
	})
	
	$("#requestInfo1").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu1").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo1").val(value);
	    }
	})
	
	$("#requestInfo2").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu2").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo2").val(value);
	    }
	})
	
	$("#requestInfo3").keyup(function(){
	    var zishu=$(this).val();
	    $("#zishu3").text(zishu.length);
	    if(zishu.length>500)
	    {
	    	alert("字数超过限制！");
	    	var value=zishu.substring(0,500);
	    	$("#requestInfo3").val(value);
	    }
	})
	
	
	/***********************需求年限*********************************/
})