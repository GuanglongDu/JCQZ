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
		var groupid = window.location.href.split("?")[1].split("=")[1];
		var groupid = getpam("id");
		var banji = getpam("banji");
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
					"width" : "580px",
					"height" : "320px",
					"border" : "1",
				}).css({
					"border-collapse" : "collapse",
					"margin" : "5px",
					"text-align" : "center"
				}).appendTo($("#west"));
				for(var j = 0; j < 50; j++){
					if(j % 10 == 0){
						var tr = $("<tr>").appendTo($(table));
					}
					(function(j){
						var text = "";
						var id = "";
						var cpath = "";
						if(array.length > 0 && array[j]){
							text = array[j].cname;
							id = array[j].cid;
							cpath = array[j].cpath;
						}
						var td = $("<td>",{
							id : id,
							title : text,
							text : text,
							"path" : cpath
						}).click(function(){
							$("#ciImageDiv").find("img").attr("src",'<%=basePath%>'+cpath);
						}).bind("dblclick",function(){
							$(this).html("");
							setTimeout(function(){
								$("#ciImageDiv").find("img").attr("src","");
							},2000);
						}).css({
							"cursor" : "pointer",
							"width" : "32px",
							"height" : "32px",
							"font-size" : "24px"
						});
						$(table).find("tr:last").append(td);
					})(j)
				}
			}
		})
		$.ajax({
			type:"post",
			url:'<%=basePath%>nclass/getAll',
			success:function(student){
			}
		})
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
	var datagrid;
	$(function() {
		var banji = getpam("banji");
		datagrid = $('#datagrid').datagrid({
			method:'get',
			url : '<%=basePath%>student/getAll',
			queryParams : {classIds:banji},
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40 ],
			fit : true,
			fitColumns : true,
			nowrap : true,
			border : false,
			idField : 'cid',
			sortName : 'cstatus',
			sortOrder : 'asc',
			checkOnSelect : true,
			selectOnCheck : true,
			frozenColumns : [ [ {
				title : '编号',
				field : 'cid',
				width : 10,
				sortable : true,
				checkbox : true
			}, {
				title : '学生编号',
				field : 'code',
				width : 100,
				sortable : true
			}, {
				title : '姓名',
				field : 'name',
				width : 100,
				sortable : true
			}, {
				title : '拼音',
				field : 'py',
				width : 100
			} ] ],
			columns : [ [ {
				title : '生日',
				field : 'birthday',
				width : 10,
				hidden : true
			}, {
				title : '年龄',
				field : 'gender',
				width : 100
			}, {
				title : '曾用名',
				field : 'usedName',
				width : 120
			}, {
				title : '父亲姓名',
				field : 'fatherName',
				width : 80
			}, {
				title : '父亲联系方式',
				field : 'fatherMobile',
				sortable : true,
				width : 120
			}, {
				title : '母亲姓名',
				field : 'motherName',
				sortable : true,
				width : 120
			} , {
				title : '母亲联系方式',
				field : 'motherMobile',
				sortable : true,
				width : 120
			},{
				field:'opt',
				title:'操作',
				width:50,
				align:'center',  
            	formatter:function(value,rec){
            		var id = rec.cid;
                	var btn = '<a class="editcls" onclick="editRow(\''+id+'\')" href="javascript:void(0)">测评</a>';  
                	return btn;  
            	}  
        }] ],
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
		
	});
	function editRow(studentId){
		var p = dj.dialog({
			title : '测评',
			href : '<%=basePath%>html/shouke/cp.jsp',
			width : 450,
			height : 200,
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '<%=basePath%>nword/edit',
						data : {
							id : studentId
						},
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								datagrid.datagrid('reload');
								p.dialog('close');
							}
							dj.messagerShow({
								msg : json.msg,
								title : '提示'
							});
						}
					});
				}
			} ]
		});
	}
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
		margin-top:15px;
		border:1px solid #99BBE8;
	}
</style>
</head>
<body class="easyui-layout">
	<div id="west" data-options="region:'west'" style="width:50%;">
		
	</div>
	<div id="south" data-options="region:'south'" style="height:240px;">
		<div style="width:100%;height:200px;border:1px solid;">
		<table id="datagrid" ></table>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="ciImageDiv">
			<img width="100%" height="100%" border='0' src="" />
		</div>
	</div>
</body>
</html>
