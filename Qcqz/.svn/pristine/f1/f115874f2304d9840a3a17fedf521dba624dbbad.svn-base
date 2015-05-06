<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="../inc.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head lang="en">
<script type="text/javascript" charset="utf-8">
	var item = [ {
		"name" : "一节",
		"subItem" : [ {
			"text" : "一"
		}, {
			"text" : "一"
		}, {
			"text" : "一"
		}, {
			"text" : "一"
		}, {
			"text" : "一"
		}, {
			"text" : "一"
		}, {
			"text" : "一"
		} ]
	} ]
	var tree = [{
	    "id":1,
	    "text":"Folder1",
	    "iconCls":"icon-save",
	    "children":[{
			"text":"File1",
			"checked":true
	    },{
			"text":"Books",
			"state":"open",
			"attributes":{
				"url":"/demo/book/abc",
				"price":100
			},
			"children":[{
				"text":"PhotoShop",
				"checked":true
			},{
				"id": 8,
				"text":"Sub Bookds",
				"state":"closed"
			}]
	    }]
	},{
	    "text":"Languages",
	    "state":"closed",
	    "children":[{
			"text":"Java"
	    },{
			"text":"C#"
	    }]
	}]
	var datagrid;
	$(function() {

		datagrid = $('#datagrid').datagrid({
			onDblClickRow: function (index, row) {
                console.info(index);
            }
		});
		
	});
	
	function loadTable(node){
		if(node.iconCls == "2"){
			$("#centerContain").empty();
			var id = node.id;
			$.ajax({
				type:"get",
				url:'<%=basePath%>property/getPropertyByPId?pid='+id,
				success:function(data){
					var data = eval("("+data+")");
					if(data.length > 0){
						for(var i = 0; i < data.length; i++){
							var div = $("<div>",{
								"id" : data[i].cid,
								"title" : data[i].cname,
								"class" : "aaaa"
							}).css({
								"width" : "330px",
								"height" : "240px",
								"float" : "left"
							}).appendTo($("#centerContain"));
							var groupid = data[i].cid;
							$(div).panel();
							
							(function(groupid){
								$.ajax({
									type:"get",
									url:'<%=basePath%>nword/getAll?groupId='+groupid+'&page=1&rows=50',
									success:function(wordData){
										var wordDataRows = wordData.rows;
										var array = new Array();
										if(wordDataRows.length > 0){
											for(var row in wordDataRows){
												var letters = wordDataRows[row].letters;
												if(letters && letters.length > 0){
													for(var l in letters){
														array.push(letters[l]);
													}
												}
											}
										}
										var table = $("<table>",{
											"width" : "320px",
											"height" : "200px",
											"border" : "1",
										}).css({
											"border-collapse" : "collapse",
											"margin" : "5px"
										}).appendTo($("#"+groupid));
										for(var j = 0; j < 50; j++){
											if(j % 10 == 0){
												var tr = $("<tr>").appendTo($(table));
											}
											if(array.length > 0 && array[j]){
												$(table).find("tr:last").append("<td style='width:32px;'>"+array[j].cname+"</td>");
											}else{
												$(table).find("tr:last").append("<td style='width:32px;'>&nbsp;</td>");
											}
											
										}
									}
								})
							})(groupid);
						}
					}
				}
			})
		}
	 	//nword/getAll
	}
</script>
<style type="text/css">
.centerContain>div{
	float:left;
	margin:50px;
}
</style>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',title:'课程列表结构树',split:true"
		style="width:220px;background:#eee;">
		<div class="easyui-panel" fit="true" style="padding:5px">
			<ul id="tt" class="easyui-tree" data-options="url:'<%=basePath%>property/doNotNeedSession_course',method:'post', onClick: function(node){
                   loadTable(node);
                } ">
			</ul>
		</div>

	</div>
	<div id="centerContain" class="centerContain" data-options="region:'center',border:false"
		style="float:left;">
		<!-- <div id="p1" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p2" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p3" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p4" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p5" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p6" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="p7" class="panel easyui-panel" title="一节"
			style="width:330px;height:240px;float:left;">
			<table width="320px" height="200px;" border="1" style="border-collapse:collapse;margin:5px;">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
 -->	
 	</div>
</body>
</html>