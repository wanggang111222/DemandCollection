<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图标生成</title>
<style type="text/css">
#btn {
	width: 103px;
	margin: 20px auto;
}
</style>
</head>
<body>
<script src="js/jquery-3.1.1.min(1).js"></script>
<script src="js/highcharts.js"></script>
<script type="text/javascript" >
$(function() {
	var type = [ "机构全称", "归口管理单位", "所在地域", "法人代表",
					"联系人", "机构属性", "技术需求名称", "关键字", "拟投入资金总额",
					"技术需求解决方式", "科技活动类型", "学科分类", "需求技术所属领域",
					"需求技术应用行业" ];
			for (var i = 0; i < type.length; i++) {
				$("#select1").append(
								"<option value='"+type[i]+"'>"
										+ type[i]
										+ "</option>");
			}
			$("#add").click(function() {
								if($("table tr").length <= 15) {
									$("#table1").append(
													"<tr>"
															+ "<td>"
															+ "<select id='select"+$("#table1 tr").length+"'>"
															+ "<option value='请选择'>请选择<\/option>"
															+ "<\/select>:"
															+ "<\/td>"
															+ "<td>"
															+ "<input type='text'>:"
															+ "<select>"
															+ "<option value='模糊查询'>模糊查询<\/option>"
															+ "<option value='精确查询'>精确查询<\/option>"
															+ "<\/select>"
															+ "<\/td>"
															+ "<td>"
															+ "<a href='javascript:void(0)'>移除<\/a>"
															+ "<\/td>"
															+ "<\/tr>");
									for (var i = 0; i < type.length; i++) {
										$("#select"+($("#table1 tr").length-1)).append(
														"<option value='"+type[i]+"'>"
																+ type[i]
																+ "</option>");
									}
								}
								else{
									alert("最多只能添加14项，已经超过上限！");
									return false;
								}

							})
$("#table1").on("click","tr td a",function(){
	$(this).parent().parent().remove();
})
//===============年龄分布柱状图===============
	
})
</script>
   <h2 align="center">生成图表</h2>
   <div id="main">
		<table align="center" border="1" cellspacing="0" cellpadding="0" id="table1">
			<tr>
				<td>字段选择</td>
				<td>输入具体名称</td>
				<td>操作</td>
			</tr>

			<tr>
				<td width="200px"><select id="select1">
						<option value="请选择">请选择</option>
				</select></td>
				<td width="340px"><input type="text" name="type"></td>
				<td width="150px"><button id="add">增加查询项</button></td>
			</tr>
		</table>
		<div id="btn">
			<button id="chaxun">提交</button>
		</div>
	</div>
   <div id="chartBar" style="width:450px; height:250px; float:left"></div> 
   <div id="chartPie" style="width:200px; height:250px; float:left"></div>
</body>
</html>