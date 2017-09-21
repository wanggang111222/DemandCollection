<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核阶段</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/Check.css" rel="stylesheet" type="text/css">
</head>
<style>
   button{width:100px;height:30px;}
</style>
<body>
    <script src="js/jquery-3.1.1.min(1).js"></script>
    <script src="js/jPages.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- <script>
        $(document).ready(function(){
        	 $.ajax({
        		 url:"xsCheckStatus",
        		 type:"post",
        		 dataType:"json",
        		 success:function(json){
        			 //alert(json.techRequest.length);
        			 for(var i = 0;i<json.techRequest.length;i++)
        			 {
        				 var xscheck="";
        				 var jsCheck="";
        				 var delete1="";
        				 var chakan="";
        				 var xiugai="";
        				 if(json.techRequest[i].xsCheck=="false")
        				 {
        					 xscheck="待审核";
        					 delete1="删除";
        					 chakan="查看";
        					 xiugai="修改";
        					 
        				 }
        				 else if(json.techRequest[i].xsCheck=="true"){
        					 xscheck="已审核";
        				 }
        				 if(json.techRequest[i].jsCheck=="false")
        				 {
        					 jscheck="待审核";
        				 }
        				 else if(json.techRequest[i].jsCheck=="true")
        				 {
        					 jscheck="已审核";
        				 }
        				 var xsCheck = json.techRequest[i].xsCheck
        				 $("tbody").append("<tr>"+
        						 +"<td><\/td>"
        						 +"<td>"+json.techRequest[i].time1+"-"+json.techRequest[i].time2+"<\/td>"
        				         +"<td>"+json.techRequest[i].id+"<\/td>"
        				         +"<td>"+json.techRequest[i].name+"<\/td>"
        				         +"<td>"+json.techRequest[i].currentTime+"</td>"
        				         +"<td>"+json.techRequest[i].requestName+"<\/td>"
        				         +"<td>"+xscheck+"<\/td>"
        				         +"<td>"+jscheck+"<\/td>"
        				         +"<td><a href='javascript:void(0)' onclick='delete1("+json.techRequest[i].techId+",this)'>"+delete1+"<\/a>&nbsp;&nbsp;<a href='javascript:void(0)'>查看<\/a>&nbsp;&nbsp;"
        				         +"<a href='javascript:void(0)' onclick='modify("+json.techRequest[i].techId+")'>"+xiugai+"<\/a><\/td>"
        				       +"<\/tr>");

        			 }
        			 
        		 }
        	 })
        	 /*********************************查询按钮在选中请选择时触发可编辑****************************************/
        	 $("#select").prop("disabled",true);
        	 $("#delete").prop("disabled",true);
        	 $("#modify").prop("disabled",true);
        	 $("table").on("click","tr td input[name='check']",function(){
        		 $("#select").prop("disabled",false);
        		 if($(this).parent().siblings().eq(5).text()!="已审核")
        		 {
                	 $("#delete").prop("disabled",false);
                	 $("#modify").prop("disabled",false);
        		 }
        		 
        	 })

        	 
        	 $("#new-request").click(function(){
        		 window.location.href="EditTable.jsp";
        	 })
        })
        
    </script> -->
    <script type="text/javascript">
	 /*****************************************删除按钮事件*****************************************************/
	 function delete1(techId,a){
		 alert(1111);
		 $.ajax({
			 url:"requestDelete",
			 type:"post",
			 data:{"techId":techId},
			 dataType:"text",
			 success:function(data){
				 $(a).parent().parent().remove();
			 }
		 })
		 
	 }
	 function modify(techId){
		 var url="modify.html?modifyId="+techId+"";
		 window.location.href=url;
	 }
	 function chakan(techId)
	 {
		 var url="Chakan.html?tec_id="+techId+"";
		 window.location.href=url;
	 }
    </script>
    <script type="text/javascript">
        var curPage=1;//当前页码
        var total,pageSize,totalPage;
        $(document).ready(function(){
        	
        	getData(1);
        })
        //获取分页条
        function getPageBar(){
        	//页码大于最大页数
        	if(curPage>totalPage){
        		curPage=totalPage;
        	}
        	//页码小于1
        	if(curPage<1){
        		curPage=1;
        	}
        		pageStr="<span>共" + total + "条</span><span>" + curPage + "/"  
                + totalPage + "</span>";
        	
        	//如果是第一页
        	if(curPage==1){
        		pageStr+="<span>首页</span><span>上一页</span>";
        	}else{
        		pageStr += "<span><a href='javascript:getData(1)' rel='1'>首页</a></span><span><a href='javascript:getData("+(curPage - 1)+")' rel='"  
                + (curPage - 1) + "'>上一页</a></span>";
        	}
        	
        	 //如果是最后页    
            if (curPage >= totalPage) {  
                pageStr += "<span>下一页</span><span>尾页</span>";  
            } else {  
                pageStr += "<span><a href='javascript:getData("+((curPage) + 1)+")' rel='"  
                        + (parseInt(curPage) + 1)  
                        + "'>下一页</a></span><span><a href='javascript:getData("+totalPage+")' rel='"  
                        + totalPage + "'>尾页</a></span>";  
            }
        	 
            $("#pageCount").html(pageStr);
        }
     function getData(page) {  
            
            $.ajax({  
                type : 'POST',  
                url : 'xsCheckStatus',  
                data : {  
                    'pageno' : page  
                },  
                dataType : 'json',  
                success : function(json) {  
                    $("tbody").html(""); 
                    total = json.total; //总记录数    
                    pageSize = json.pageSize; //每页显示条数    
                    curPage = json.page; //当前页    
                    totalPage = json.totalPage; //总页数 
                    for(var i=0;i<json.techRequest.length;i++){ 
                    	var xscheck="";
       				 var jsCheck="";
       				 var delete1="";
       				 var chakan="";
       				 var xiugai="";
       				 if(json.techRequest[i].xsCheck=="false")
       				 {
       					 xscheck="待审核";
       					 delete1="删除";
       					 chakan="查看";
       					 xiugai="修改";
       					 
       				 }
       				 else if(json.techRequest[i].xsCheck=="true"){
       					 xscheck="已审核";
       				 }
       				 if(json.techRequest[i].jsCheck=="false")
       				 {
       					 jscheck="待审核";
       				 }
       				 else if(json.techRequest[i].jsCheck=="true")
       				 {
       					 jscheck="已审核";
       				 }
                    	 $("tbody").append("<tr>"+
                    			 +"<td><\/td>"
        						 +"<td>"+json.techRequest[i].time1+"-"+json.techRequest[i].time2+"<\/td>"
        				         +"<td>"+json.techRequest[i].id+"<\/td>"
        				         +"<td>"+json.techRequest[i].name+"<\/td>"
        				         +"<td>"+json.techRequest[i].currentTime+"</td>"
        				         +"<td>"+json.techRequest[i].requestName+"<\/td>"
        				         +"<td>"+xscheck+"<\/td>"
        				         +"<td>"+jscheck+"<\/td>"
        				         +"<td><a href='javascript:void(0)' onclick='delete1("+json.techRequest[i].techId+",this)'>"+delete1+"<\/a>&nbsp;&nbsp;<a href='javascript:void(0)' onclick='chakan("+json.techRequest[i].techId+")'>查看<\/a>&nbsp;&nbsp;"
        				         +"<a href='javascript:void(0)' onclick='modify("+json.techRequest[i].techId+")'>"+xiugai+"<\/a><\/td>"
        				       +"<\/tr>");  
                    }  
                   
  
                },  
                complete : function() { //生成分页条    
                    getPageBar();  
                },  
                error : function() {  
                    alert("数据加载失败");  
                }  
            });  
        }
        
    </script>
    <script>
       $(document).ready(function(){
    	   $("#new-request").click(function(){
      		 window.location.href="EditTable.jsp";
      	 })
       })
    </script>
    <style type="text/css">
        #new-request{margin:10px 908px;color:red;}
        a{color:blue;}
    </style>
    <jsp:useBean id="db" class="com.dc.data.DatabaseConnection" scope="page"></jsp:useBean>
    <h2>审核状态</h2>
    <button id="new-request">新需求</button>
    <table class="table table-bordered">
      <thead>
       <tr>
          <td>需求时限</td>
          <td>机构代码</td>
          <td>机构名称</td>
          <td>提交时间</td>
          <td>技术需求名称</td>
          <td>形式审核状态</td>
          <td>技术审核状态</td>
          <td>操作</td>
       </tr>
       </thead>
       <tbody id="movies">
       </tbody>
    </table>
    <div class="row">  
                    <div class="col-md-5"></div>  
                    <div class="col-md-7" id="pageCount"></div>  
    </div>
<div class="holder" style="margin-left: 760px;"></div>
</body>
</html>