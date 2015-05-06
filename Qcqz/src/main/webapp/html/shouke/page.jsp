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
	$(function() {
		//var groupid = window.location.href.split("?")[1].split("=")[1];
		var groupid = getpam("id");
		var banji = getpam("banji");
		
		var table = $("<table>", {
			"width" : "800px",
			"height" : "48px",
			"border" : "1",
		}).css({
			"border-collapse" : "collapse",
			"text-align" : "center"
		}).appendTo($("#wordContainer"));
		for (var j = 0; j < 30; j++) {
			if (j % 15 == 0) {
				var tr = $("<tr>").appendTo($(table));
			}
			$(table).find("tr:last").append(
					"<td style='width:60px;height:24px;'></td>");
		}
		var ciClickArray = new Array();
		$.ajax({
			type:"get",
			url:'<%=basePath%>property/getPropertyByPId?pid='+groupid,
			success:function(data){
				var data = eval("("+data+")");
				if(data.length > 0){
					for(var i = 0; i < data.length; i++){
						var d = data[i];
						(function(d){
							var div = $("<div>",{
								"id" : d.cid,
								"title" : d.cname,
								"text" : d.cname
							}).click(function(){
								$("#west").empty();
								var id = this.id;
								$.ajax({
									type:"get",
									url:'<%=basePath%>nword/getAll?groupId='+id,
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
													
													
													if(ciClickArray.length > 0){
														var obj = ciClickArray[ciClickArray.length-1];
														$("#"+obj).css({
															"background" : "green",
															"color" : "white"
														});
													}
													if(ciClickArray.indexOf(wD.cid) < 0){
														ciClickArray.push(wD.cid);
													}
													<%-- $("#ciDiv").empty();
													$("#ciImageDiv").find("img").attr("src",'<%=basePath%>'+wD.cpath);
													$("#ciImageDiv").find("img").css({
														"display" : "block"
													})
													$("#ciDiv").html(wD.cname);
													$("#ciDiv").attr("ciId",wD.cid); --%>
													var _id = wD.cid+"_show";
													var ciDiv_show = $("#" + _id).html();
													if(!ciDiv_show){
														ciDiv_show = $("<div>",{
															"id" : wD.cid+"_show"
														}).css({
															"width" : "200px",
															"height" : "200px",
															"margin-top": "20px",
															"margin-left": "20px",
															"border": "0px solid #99BBE8",
															"float" : "left"
														}).appendTo($("#show"));
														
														var ciDiv_show_text = $("<div>",{
															"id" : wD.cid+"_show_text",
															"text" : wD.cname
														}).css({
															"width" : "200px",
															"height" : "20px",
															"font-size" : "24px",
															"text-align" : "center"
														}).appendTo($(ciDiv_show));
														
														var ciDiv_show_img = $("<div>",{
															"id" : wD.cid+"_show_img",
															"html":"<img width='150px' height='150px' border='0' src='"+'<%=basePath%>'+wD.cpath+"' />"
														}).css({
															"width" : "150px",
															"height" : "150px",
															"margin-top": "25px",
															"margin-left": "25px",
															"border": "1px solid #99BBE8"
														}).bind("click",function(){
															var img = $(this).find("img")[0];
															if(img){
																if(img.style.display == "block" || img.style.display == "" || img.style.display == undefined){
																	img.style.display = "none";
																}else{
																	img.style.display = "block";
																}
															}
														}).appendTo($(ciDiv_show));
													}
													var node = $(this).parent().children("div");
													var flag = false;
													$.each(node,function(i,item){
														if(item.style && item.style.background == "green"){
															flag = true;
														}else{
															flag = false;
														}
													});
													
													if(flag){
														$("#"+id).css({
															"background" : "green",
															"color" : "white"
														})
													}
												}).css({
													"width" : "100px",
													"height" : "30px",
												}).appendTo($("#west"));
												var aa = $("#"+id)[0];
												if(aa.style && aa.style.background == "green"){
													$(wordDiv).css({
														"background" : "green",
														"color" : "white"
													})
												}
											})(j);
										}
										
										var table = $("<table>",{
											"width" : "320px",
											"height" : "200px",
											"border" : "1",
										}).css({
											"border-collapse" : "collapse",
											"margin" : "5px"
										}).appendTo($("#"+groupid));
									}
								})
							}).css({
								"width" : "100px",
								"height" : "30px",
								"float" : "left"
							}).appendTo($("#south"));
						})(d);
					}
					
				}
				var div_lianxi = $("<div>",{
					"id" : "div_lianxi",
					"title" : "练习",
					"text" : "练习"
				}).click(function(){
					$("#wordIframe",window.parent.document).attr("src","page1.jsp?id="+groupid+"&banji="+banji);
				}).css({
					"width" : "100px",
					"height" : "30px",
					"float" : "left"
				}).appendTo($("#south"));
				
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
					$("#wordIframe",window.parent.document).attr("src","");
					$("#word",window.parent.document).hide();
					$("#selectKe",window.parent.document).show();
				}).css({
					"width" : "100px",
					"height" : "30px",
					"float" : "left"
				}).appendTo($("#south"));
				
				$("#ciDiv").bind("click",function(){
					if($(this).html()){
						var _td = $(table).find("td");
						var ciId = $(this).attr("ciId");
						var flag = true;
						for(var x = 0; x < _td.length;x++){
							var td = _td[x];
							if(td.id == ciId){
								flag = true;
								return;
							}
						}
						if(flag){
							$(_td[index]).attr("id",ciId);
							$(_td[index]).html($(this).html());
							index++;
						}
					}
				});
				/* $("#ciImageDiv").find("img").bind("click",function(){
					if($(this)[0].style.display == "block"){
						$(this)[0].style.display = "none";
					}else{
						$(this)[0].style.display = "block";
					}
				}); */
				
			}
		})
	});
</script>
<style type="text/css">
	#west > div{
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
	#south{
		width:80%;
		margin-left:100px;
		margin-top:30px;
		float:left;
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
	.south{
		float:left;
		margin-top:30px;
		font-size : 12px;
		font-family:Tahoma,Verdana,微软雅黑,新宋体;
		background: #E0ECFF;
		cursor:pointer;
		border:1px solid #99BBE8;
		margin: 0 auto;
		margin-left:5px;
		line-height:20px;
		width:10%;
		height:30px;
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
	<!-- <div data-options="region:'north'"
		style="height:80px">
		<div style="float:left;margin:20px;font-size: 32px;">生字</div>
		<div id="wordContainer" style="margin-top:20px;"></div>
	</div> -->
	<div data-options="region:'south'" style="height:100px;">
		<div id="south" >
		</div>
	</div>
	<div id="west" data-options="region:'east'" style="width:200px;">
		
	</div>
	<div id="show" data-options="region:'center'">
		<!-- <div id="ciDiv">
		
		</div>
		<div id="ciImageDiv">
			<img width="100%" height="100%" border='0' src="" />
		</div> -->
	</div>
</body>
</html>
