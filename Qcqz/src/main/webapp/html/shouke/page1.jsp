<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../inc.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript">
function getpam(str){
	var url = window.location.href;
	var v = "";
	var pamArray = url.split("?")[1].split("&");
	for(var i = 0; i < pamArray.length;i++){
		var key = pamArray[i].split("=")[0];
		var value = pamArray[i].split("=")[1];
		if(key == str){
			v = value;
			continue;
		}
	}
	return v;
}
var index = 0;
var banji = getpam("banji");
	$(function() {
		var groupid = window.location.href.split("?")[1].split("=")[1];
		var groupid = getpam("id");
		var banji = getpam("banji");
		
		$.ajax({
			type:"get",
			url:'<%=basePath%>property/getPropertyByPId?pid='+groupid,
			success:function(data){
				var data = eval("("+data+")");
				if(data.length > 0){
					for(var i = 0; i < data.length; i++){
						var d = data[i];
						(function(d){
							var singleDiv =  $("<div>",{
								"id" : d.cid+"_single",
							}).css({
								"width" : "100%",
								"height" : "35px",
								"float" : "left"
							}).appendTo($("#west"));
							
							var div = $("<div>",{
								"id" : d.cid,
								"title" : d.cname,
								"text" : d.cname
							}).css({
								"width" : "100px",
								"height" : "30px",
								"float" : "left"
							}).appendTo($(singleDiv));
							
							$.ajax({
								type:"get",
								url:'<%=basePath%>nword/getAll?groupId='+d.cid,
								success:function(wordData){
									var wordDataRows = wordData.rows;
									
									for(var j = 0; j < wordDataRows.length; j++){
										(function(j){
											var wD = wordDataRows[j];
											var wordDiv = $("<div>",{
												"id" : wD.cid,
												"title" : wD.cname,
												"text" : wD.cname
											}).click(function(){
												$("#ciImageDiv").find("img").attr("src",'<%=basePath%>'+wD.cpath);
												setTimeout(function(){
													$("#ciImageDiv").find("img").attr("src","");
												},2000)
											}).css({
												"width" : "100px",
												"height" : "30px",
												"margin-left" : "5px",
												"float" : "left"
											}).appendTo($(singleDiv));
										})(j);
									}
								}
							})
						})(d);
					}
					
				}
			}
		})
		
		var div_lianxi_chaizi = $("<div>",{
			"id" : "div_lianxi_chaizi",
			"title" : "练习拆字",
			"text" : "练习拆字"
		}).click(function(){
			$("#wordIframe",window.parent.document).attr("src","page2.jsp?id="+groupid+"&banji="+banji);
		}).css({
			"width" : "100px",
			"height" : "30px",
			"float" : "left"
		}).appendTo($("#south"));
		
		var div_goBack = $("<div>",{
			"id" : "div_goBack",
			"title" : "返回",
			"text" : "返回"
		}).click(function(){
			$("#wordIframe",window.parent.document).attr("src","page.jsp?id="+groupid+"&banji="+banji);
		}).css({
			"width" : "100px",
			"height" : "30px",
			"float" : "left"
		}).appendTo($("#south"));
	});
</script>
<style type="text/css">
	#west > div > div{
		font-size : 12px;
		font-family:Tahoma,Verdana,微软雅黑,新宋体;
		background: #E0ECFF;
		cursor:pointer;
		border:1px solid #99BBE8;
		margin: 0 auto;
		margin-top:5px;
		line-height:24px;
		width:80%;
		height:20px;
		text-align:center;
	}
	#south > div{
		font-size : 12px;
		font-family:Tahoma,Verdana,微软雅黑,新宋体;
		background: #E0ECFF;
		cursor:pointer;
		border:1px solid #99BBE8;
		margin: 0 auto;
		margin-left:5px;
		line-height:24px;
		width:80px;
		height:20px;
		text-align:center;
	}
	#ciDiv{
		float:left;
		width:300px;;
		height:180px;
		font-size:100px;
		margin-left:100px;
		margin-top:150px;
		border:1px solid #99BBE8;
	}
	#ciImageDiv{
		float:left;
		width:350px;
		height:350px;
		margin-left:50px;
		margin-top:75px;
		border:1px solid #99BBE8;
	}
</style>
</head>
<body class="easyui-layout">
	<div id="west" data-options="region:'west'" style="width:60%;">
		
	</div>
	<div id="south" data-options="region:'south'" style="height:100px;">
	</div>
	<div data-options="region:'center'">
		<div id="ciImageDiv">
			<img width="100%" height="100%" border='0' src="" />
		</div>
	</div>
	
</body>
</html>
