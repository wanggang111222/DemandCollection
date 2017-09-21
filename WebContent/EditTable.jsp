<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>填写数据</title>
<link href="css/EditTable.css" rel="stylesheet" type="text/css">
</head>
<body>
	<script src="js/jquery-3.1.1.min(1).js"></script>
	<script src="js/zhengze.js"></script>
	<!--框架必需end--><!--引入弹窗组件start-->
    <script type="text/javascript" src="js/attention/zDialog/zDrag.js">
    </script>
	<script src="js/editTable.js"></script>
	
	<script>
	    $(document).ready(function(){
	    	$.ajax({
	    		url:"auto",
	    		type:"post",
	    		dataType:"json",
	    		success:function(json){
	    			$("#OrganizationName").val(json.name);
	    			$("#adress").val(json.adress);
	    			$("#tel").val(json.tel);
	    			$("#phone").val(json.phone);
	    		}
	    	})
	    })
	   /* function tijiao(){
	    	var tijiao=confirm("是否提交，提交后不能更改信息！");
	    	if(tijiao==true){
	    		document.getElementById("form").action="SaveChange.jsp";
	    		document.getElementById("form").submit();
	    	}
	    }*/
	</script>
	<div id="care">（注：“*”表示该选项为必填项，“！”表示该项填写格式错误或填写为空，请重新填写）</div>
   <form id="form" method="post" action="SaveChange.jsp">
	<div id="neirong">
		<table border="1" width="860px" align="center">
			<tr>
				<td id="td-OrganizationName">
				   <span class="warnning" id="warnning1">!</span>
				        机构全称
				   <span>*</span>
				</td>
				<td colspan="3"><input type="text" name="OrganizationName"
					class="colspan3" id="OrganizationName"></td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning2">!</span>通讯地址<span>*</span></td>
				<td>
				<input type="text" name="adress" class="colspan1" id="adress">
				</td>
				<td><span class="warnning" id="warnning3">!</span>所在地域<span>*</span></td>
				<td>
				    <select name="suozaidiyu" class="colspan1" id="suozaidiyu">
				    </select>
				</td>
			</tr>
			<tr>
				<td width="130px">网址</td>
				<td width="290px"><input type="text" name="website"
					class="colspan1" id="website"></td>
				<td width="130px">
				<span class="warnning" id="warnning4">!</span>
				电子信箱<span>*</span>
				<div class="tishi tishi1 tishi1-mail">（请输入正确的邮箱地址）</div>
				<div class="tishi tishi2 tishi2-mail">（邮箱输入格式错误，请重新输入）</div>
				</td>
				<td width="310px"><input type="text" name="mail"
					class="colspan1" id="mail"></td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning5">!</span>法人代表<span>*</span></td>
				<td><input type="text" name="legalPerson" class="colspan1"
					id="legalPerson"></td>
				<td>邮政编码</td>
				<td><input type="text" name="postcode" class="colspan1"
					id="postcode"></td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning7">!</span>联系人<span>*</span></td>
				<td><input type="text" name="connectionPerson"
					class="colspan1" id="connectionPerson"></td>
					<td>传真</td>
				<td><input type="text" name="fax" class="colspan1" id="fax"></td>
				
			</tr>
			<tr>
				<td>电话<span>*</span></td>
				<td colspan="3">固话：<input
					type="text" name="tel" class="colspan1" id="tel"> <span
					class="warnning" id="warnning9">!</span>手机:<input type="text"
					name="phone" class="colspan1" id="phone"></td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning11">!</span>机构属性<span>*</span></td>
				<td colspan="3"><input type="radio" name="property" value="企业">企业
					<input type="radio" name="property" value="高等院校">高等院校 <input
					type="radio" name="property" value="研究机构">研究机构 <input
					type="radio" name="property" value="其他">其他</td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning12">!</span>归口管理部门</td>
				<td colspan="3"><input type="text" name="Centralized"
					class="colspan3" id="Centralized">
						<div id="Centralized-Explorer"></div>
					</td>
			</tr>
			<tr height="100px">
				<td colspan="4"><span class="warnning" id="warnning13">!</span>机构简介（单位基本情况，研究基础等，限500字）<span>*</span><textarea
						rows="13" cols="" name="info" id="info"></textarea>
						<span style="color:black;font-size:16px;">总字数500字；</span>已经输入字数：<span id="zishu" style="color:black;font-size:16px;">0</span>
				</td>
			</tr>
			<tr>
				<td><span class="warnning" id="warnning14">!</span>技术需求名称<span>*</span></td>
				<td><input type="text" name="requestName"
					class="colspan1" id="requestName"></td>
			    <td>需求时限</td>
			    <td><input type="text" class="year" id="first-year" name="first-year"/>年-<input type="text" class="year" id="second-year" name="second-year"/>年</td>
			</tr>
			<tr>
				<td colspan="4"><span class="warnning" id="warnning15">!</span>技术需求概述<span>*</span><br>
				    1、主要问题（需要解决的重大技术问题，限500字以内）
					<textarea rows="13" cols="" id="requestInfo1" class="requestInfo" name="requestInfo1"></textarea>
					<span style="color:black;font-size:16px;">总字数500字；</span>已经输入字数：<span id="zishu1" style="color:black;font-size:16px;">0</span><br>
					2、技术关键（所需的关键技术、主要指标，限500字以内）
					<textarea rows="13" cols="" id="requestInfo2" class="requestInfo" name="requestInfo2"></textarea>
					<span style="color:black;font-size:16px;">总字数500字；</span>已经输入字数：<span id="zishu2" style="color:black;font-size:16px;">0</span><br>
					3、预期目标（技术创新性、经济社会效益，限500字以内）
					<textarea rows="13" cols="" id="requestInfo3" class="requestInfo" name="requestInfo3"></textarea>
					<span style="color:black;font-size:16px;">总字数500字；</span>已经输入字数：<span id="zishu3" style="color:black;font-size:16px;">0</span><br>
					<span class="warnning" id="warnning16">!</span>关键字<span>*</span>
					<div id="keyword-input">
					<input type="text" name="keyword1" class="keyword-input" id="keyword1">
					<input type="text" name="keyword2" class="keyword-input" id="keyword2">
					<input type="text" name="keyword3" class="keyword-input" id="keyword3">
					<input type="text" name="keyword4" class="keyword-input" id="keyword4">
					<input type="text" name="keyword5" class="keyword-input" id="keyword5">
					</div>
				</td>
			</tr>
			<tr>
				<td>拟投入资金总额</td>
				<td colspan="3"><input type="text" name="projectSum" id="projectSum" class="colspan3"></td>
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
				<td rowspan="2"><span class="warnning" id="warnning21">!</span>技术需求解决方式<span>*</span></td>
				<td colspan="3"><input type="radio" name="cooperation"
					value="独立开发">独立开发 <input type="radio" name="cooperation"
					value="技术转让">技术转让 <input type="radio" name="cooperation"
					value="技术入股">技术入股 <input type="radio" name="cooperation"
					value="合作开发">合作开发 <input type="radio" name="cooperation"
					value="其他">其他</td>
			</tr>
			<tr>
				<td colspan="3">合作意向单位<input type="text" name="cooperativeUnit" id="cooperativeUnit"></td>
			</tr>
			
			<tr>
				<td><span class="warnning" id="warnning17">!</span>科技活动类型<span>*</span></td>
				<td colspan="3"><input type="radio" name="studyClassfied"
					value="基础研究">基础研究<input type="radio" name="studyClassfied"
					value="应用研究 ">应用研究 <input type="radio" name="studyClassfied"
					value="试验发展">试验发展 <input type="radio" name="studyClassfied"
					value="研究发展与成果应用 ">研究发展与成果应用 <input type="radio"
					name="studyClassfied" value="技术推广与科技服务">技术推广与科技服务
					<input type="radio" name="studyClassfied" value="生产性活动" />生产性活动
					</td>
					
			</tr>
			<tr id="jichu">
				<td><span class="warnning" id="warnning18">!</span>学科分类（限基础研究填写）<span>*</span></td>
				<td colspan="3">
			      <select id="subjectClassfied1" class="subjectClassfied" name="subjectClassfied1">
			          <option class="option1" value="请选择">请选择</option>
			      </select>
			      <select id="subjectClassfied2" class="subjectClassfied" name="subjectClassfied2">
			          <option class="option1">请选择</option>
			      </select>
			      <select id="subjectClassfied3" class="subjectClassfied" name="subjectClassfied3">
			          <option class="option1">请选择</option>
			      </select>
				   <div id="a" ></div>
				</td>
			</tr>
			<tr id="feijichu1">
				<td><span class="warnning" id="warnning19">!</span>需求技术所属领域（非基础研究填写）<span>*</span></td>
				<td colspan="3"><input type="checkbox" name="techArea"
					value="电子信息技术">电子信息技术 <input type="checkbox" name="techArea"
					value="光机电一体化">光机电一体化 <input type="checkbox" name="techArea"
					value="软件">软件 <input type="checkbox" name="techArea"
					value="生物制药技术">生物制药技术 <input type="checkbox" name="techArea"
					value="新材料及应用技术">新材料及应用技术 <input type="checkbox"
					name="techArea" value="先进制造技术">先进制造技术 <input type="checkbox"
					name="techArea" value="现代农业技术">现代农业技术 <input type="checkbox"
					name="techArea" value="新能源与高效节能技术">新能源与高效节能技术 <input
					type="checkbox" name="techArea" value="资源与环境保护新技术">资源与环境保护新技术
					<input type="checkbox" name="techArea" value="其他技术（注明）">其他技术（注明）
				</td>
			</tr>
			<tr id="feijichu2">
				<td>需求技术应用行业<span>*</span></td>
				<td colspan="3">
				   <select name="tech1" class="tech" id="tech1">
				      <option value="请选择">请选择</option>
				   </select>
				   <select name="tech2" class="tech" id="tech2">
				      <option value="请选择">请选择</option>
				   </select>
				   <select name="tech3" class="tech" id="tech3">
				      <option value="请选择">请选择</option>
				   </select>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center"><button value="保存并提交"
					id="btn" type="submit">保存并提交</button></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>