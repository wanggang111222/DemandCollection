<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>形式审核</title>
<link href="css/EditTable.css" rel="stylesheet" type="text/css">
<style type="text/css">
   p
   {
      border:1px solid red;
      width:800px;
      height:150px;
      overflow: scroll;
      margin-left:20px;
   }
   p
   {
   
   }
   span
   {
      color:black;
      font-weight:800;
   }
   textarea{      width:710px;
      height:200px;}
</style>
</head>
<body>
    <script src="js/jquery-3.1.1.min(1).js"></script>
    <script src="js/jquery.params.js"></script>
    <script>
	    $(document).ready(function(){
	    	var tec_id=$.query.get("tec_id");
	    	$.ajax({
	    		url:"modify",
	    		type:"post",
	    		data:{"tec_id":tec_id},
	    		dataType:"json",
	    		success:function(json){
                     $("#OrganizationName").text(json.request.name);
                     $("#adress").text(json.company.adress);
                     $("#suozaidiyu").text(json.company.suozaidiyu);
                     $("#website").text(json.company.website);
                     $("#mail").text(json.company.mail);
                     $("#legalPerson").text(json.company.legalPerson);
                     $("#postcode").text(json.company.postcode);
                     $("#connectionPerson").text(json.company.connectionPerson);
                     $("#tel").text(json.company.tel);
                     $("#phone").text(json.company.phone);
                     $("#fax").text(json.company.fax);
                     $("#property").text(json.company.property);
                     $("#Centralized").text(json.company.Centralized);
                     $("#info").text(json.company.info);
                     $("#requestName").text(json.request.requestName);
                     $("#first-year").text(json.request.year1);
                     $("#second-year").text(json.request.year2);
                     $("#requestInfo1").text(json.request.requestInfo1);
                     $("#requestInfo2").text(json.request.requestInfo2);
                     $("#requestInfo3").text(json.request.requestInfo3);
                     
                     var keyword=(json.request.keyword).split(",");
                     for(var i=0;i<keyword.length;i++)
                     {
                    	 if(keyword[i]!="null"){
                             $("#keyword-input").append("<b>"+keyword[i]+"<\/b>&nbsp;&nbsp;&nbsp;")
                    	 }
                     }
                     
                    $("#projectSum").text(json.request.projectSum+"万元");
                     
                     var cooperation = (json.request.cooperation).split(",")
                     for(var i=0;i<cooperation.length-1;i++){
                         $("#cooperation").html(cooperation[i]+"&nbsp;&nbsp;");
                     }
                     
                     $("#cooperativeUnit").text(json.request.cooperativeUnit);
                     
                     var studyClassfied=json.request.studyClassfied;
                     $("#studyClassfied").text(studyClassfied);
                     
                     if(studyClassfied!="基础研究"){
                    	 $("#feijichu1").show();
                    	 $("#feijichu2").show();
                    	 $("#jichu").hide();
                    	 
                    	 var techArea=(json.request.techArea).split(",");
                    	 for(var i=0;i<techArea.length-1;i++){
                    		 $("#techArea").append("<b>"+techArea[i]+"<\/b>&nbsp;&nbsp;&nbsp;");
                    	 }
                    	 //获取三级菜单全部内容
                    	 var tech=(json.request.tech).split(",");

                    	 for(var i=0;i<tech.length-1;i++){
                    		 $("#tech").append("<b>"+tech[i]+"<\/b>&nbsp;&nbsp;&nbsp;");
                    	 }
                    	 
                     }
                     else if(studyClassfied=="基础研究"){
                    	 $("#feijichu1").hide();
                    	 $("#feijichu2").hide();
                    	 $("#jichu").show();
                    	 var subjectClassfied=(json.request.subjectClassfied).split(",");

                    	 for(var i=0;i<subjectClassfied.length-1;i++){
                    		 $("#subjectClassfied").append("<b>"+subjectClassfied[i]+"<\/b>&nbsp;&nbsp;&nbsp;");
                    	 }
                     }
                    	 
                     }
                     

	    	})
	    	//确定按钮点击事件
	    	$("#btn").click(function(){
	    		var yuanyin=$("#xsYuanyin").val();
	    		var isCheck=$("input[name='isCheck']:checked").val();
	    		var admin=$("#guanlichushi").val();
	    		var url="xsyuanyin?xsYuanyin="+yuanyin+"&tec_id="+tec_id+"&isCheck="+isCheck+"&admin="+admin;
	    		window.location.href=url;
	    	})
	    	//
	    	$("#yuanyin").hide();
	    	$("#guanli").hide();
	    	var guanlichushi=["办公室","人事处","机关党委","政策法规处","计划财务处","平台与基础处",
	    	                  "国际合作处","高新技术处","农村科技处","社会发展处","成果与市场处","监察室",
	    	                  "离退休干部处","知识产权局","半干旱中心","山办","机关服务中心","科技研发中心",
	    	                  "科技情报研究院","器材公司","基金办","档案馆","科技管理信息中心","科技投资中心",
	    	                  "成果转换中心","中小企业创新资金管理中心","对外交流中心"];
	    	for(var i=0;i<guanlichushi.length;i++){
	    		$("#guanlichushi").append("<option value='"+guanlichushi[i]+"'>"+guanlichushi[i]+"<\/option>");
	    	}
	    	
	    	$("input[name='isCheck']").click(function(){
	    		if($(this).val()=="true"){
	    			$("#yuanyin").hide();
	    			$("#guanli").show();
	    		}
	    		else if($(this).val()=="false"){
	    			$("#yuanyin").show();
	    			$("#guanli").hide();
	    		}
	    	})
	    	
	    	})
	</script>
   <h2>形式审核</h2>
   <div id="neirong">
		<table border="1" width="860px" align="center">
			<tr>
				<td id="td-OrganizationName">
				        <span>机构全称</span>
				</td>
				<td colspan="3" id="OrganizationName"></td>
			</tr>
			<tr>
				<td><span>通讯地址</span></td>
				<td id="adress">
				</td>
				<td><span>所在地域</span></td>
				<td id="suozaidiyu">
				</td>
			</tr>
			<tr>
				<td width="130px"><span>网址</span></td>
				<td width="290px" id="website"></td>
				<td width="130px">
				<span>电子信箱</span>
				</td>
				<td width="310px"  id="mail"> </td>
			</tr>
			<tr>
				<td ><span>法人代表</span></td>
				<td id="legalPerson"></td>
				<td><span>邮政编码</span></td>
				<td id="postcode"></td>
			</tr>
			<tr>
				<td rowspan="2"><span>联系人</span></td>
				<td rowspan="2" id="connectionPerson"></td>
				<td><span>电话</span></td>
				<td><span>固话：</span><b id="tel"></b><br><span>手机:</span><b id="phone"></b></td>
			</tr>
			<tr>
				<td><span>传真</span></td>
				<td id="fax"></td>
			</tr>
			<tr>
				<td><span>机构属性</span></td>
				<td colspan="3" id="property"></td>
			</tr>
			<tr>
				<td><span>归口管理部门</span></td>
				<td colspan="3" id="Centralized">
					</td>
			</tr>
			<tr height="100px">
				<td colspan="4"><span>机构简介（单位基本情况，研究基础等，限500字）</span>
				  <p id="info"></p>
				</td>
			</tr>
			<tr>
				<td><span>技术需求名称</span></td>
				<td id="requestName"></td>
			    <td><span>需求时限</span></td>
			    <td><b id="first-year"></b>年-<b id="second-year"></b>年</td>
			</tr>
			<tr>
				<td colspan="4"><span>技术需求概述</span><br>
				   <span> 1、主要问题（需要解决的重大技术问题，限500字以内）</span><br>
				    <p id="requestInfo1"></p>
					<span>2、技术关键（所需的关键技术、主要指标，限500字以内）</span><br>
				    <p id="requestInfo2"></p>
					<span>3、预期目标（技术创新性、经济社会效益，限500字以内）</span><br>
				    <p id="requestInfo3"></p>
                                                    <span>  关键字:</span>
					<div id="keyword-input">

					</div>
				</td>
			</tr>
			<tr>
				<td><span>拟投入资金总额</span></td>
				<td colspan="3" id="projectSum"></td>
				<!-- 
				<td>其中拟投入自有资金总额</td>
				<td><input type="text" name="self" id="self" class="colspan1"></td>
				 -->
				<!-- 
				<td colspan="3">
					<div class="colspan-other">
						<span class="warnning" id="warnning22">!</span>资金需求总额<input type="text" name="projectSum" id="projectSum">万元
					</div>
					<div class="colspan-other">
						<span class="warnning" id="warnning23">!</span>企业自筹:<input type="text" name="self" id="self">万元
					</div>
					<div class="colspan-other">
						<span class="warnning" id="warnning24">!</span>银行贷款:<input type="text" name="borrow" id="borrow">万元
					</div>
					<div class="colspan-other">
						<span class="warnning" id="warnning25">!</span>其他融资:<input type="text" name="other" id="other">万元
					</div>
				</td>
				 -->
			</tr>
			<tr>
				<td rowspan="2"><span>技术需求解决方式</span></td>
				<td colspan="3" id="cooperation"></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align:left"><span>合作意向单位:</span><b id="cooperativeUnit" style="margin-left:100px;"></b></td>
			</tr>
			
			<tr>
				<td><span>科技活动类型</span></td>
				<td colspan="3" id="studyClassfied">
					</td>
					
			</tr>
			<tr id="jichu">
				<td><span>学科分类（限基础研究填写）</span></td>
				<td colspan="3" id="subjectClassfied">
				</td>
			</tr>
			<tr id="feijichu1">
				<td><span>需求技术所属领域（非基础研究填写）</span></td>
				<td colspan="3" id="techArea">
				</td>
			</tr>
			<tr id="feijichu2">
				<td><span>需求技术应用行业（非基础研究填写）</span></td>
				<td colspan="3" id="tech">
				</td>
			</tr>
			<tr>
			   <td>是否通过</td>
			   <td colspan="3"><input type="radio" value="true" name="isCheck">是<input type="radio" value="false" name="isCheck">否</td>
			</tr>
			<tr id="yuanyin">
			    <td><span>审核意见及原因</span></td>
				<td colspan="3" align="center"><textarea rows="10" cols="" name="xsYuanyin" id="xsYuanyin"></textarea></td>
			</tr>
			<tr id="guanli">
			   <td><span>管理处室</span></td>
			   <td colspan="3"><select id="guanlichushi"></select></td>
			</tr>

			<tr>
			    <td colspan="4" align="center"><button id="btn">提交</button></td>
			</tr>
		</table>
	</div>
</body>
</html>