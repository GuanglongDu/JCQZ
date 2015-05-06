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
	var datagrid;
	$(function() {

		datagrid = $('#datagrid').datagrid({
			method:'get',
			url : '<%=basePath%>student/getAll',
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
                	var btn = '<a class="editcls" onclick="editRow(rec.cid)" href="javascript:void(0)">查看</a>';  
                	return btn;  
            	}  
        }  ] ],
			toolbar : [ {
				text : '测评',
				iconCls : 'icon-add',
				handler : function() {
					var rows = datagrid.datagrid('getChecked');
					var ids = [];
					if (rows.length > 0) {
						if(rows.length > 1){
							dj.messagerAlert('提示', '请选择单条学员数据测评！', 'error');
						}else{
							ceping();
						}
					} else {
						dj.messagerAlert('提示', '请选择要测评的学员！', 'error');
					}
				}
			} ,'-', {
				text : '增加',
				iconCls : 'icon-remove',
				handler : function() {
					append();
				}
			}],
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
		//evalutative/query?studentId=studentId;
	}
	
	function ceping() {
		var p = dj.dialog({
			title : '测评页面',
			href : '<%=basePath%>evalutative/ceping',
			width : 540,
			height : 450,
			buttons : [ {
				text : '添加',
				handler : function() {
					//evalutative/add
				}
			} ],
			onLoad : function() {
				var kecheng = $("input[name=kecheng]");
				var table = $("#win");
				var createTable = function(){
					$("#win").empty();
					var str = "";
					for(var i = 0; i < 5; i++){
						str += "<tr style='width:320px;height:32px;'>"; 
						for(var j = 0; j < 10; j++){
							str += "<td style='width:32px;height:32px;'>"
							str += "</td>"
						}
						str += "</tr>";
					}
					table.html(str);
					table.find("td").bind("click",function(){
						this.style.background="green";
					});
				}
				createTable();
				var kechengTree = kecheng.combotree({
					lines : true,
					url : '<%=basePath%>property/doNotNeedSession_treeRecursive',
					onClick: function(node){
						createTable();
						var id = node.id;
						$.ajax({
							type:"get",
							url:'<%=basePath%>nword/getAll?groupId='+id+'&page=1&rows=50',
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
								for(var j = 0; j < array.length; j++){
									(function(j){
										var text = array[j].cname;
										var id = array[j].cid;
										var cpath = array[j].cpath;
										
										$(table).find("td").eq(j).attr("id",id).bind("click",function(){
											$("#showImage").find("img").attr("src",'<%=basePath%>'+cpath);
										}).append(text);
									})(j)
								}
							}
						})
					}
				});
				
				
				
			}
		});
	}
	
	function append() {
		var p = dj.dialog({
			title : '添加数据',
			href : '<%=basePath%>student/studentAdd',
			width : 500,
			height : 480,
			buttons : [ {
				text : '添加',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '<%=basePath%>student/add',
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
			} ],
			onLoad : function() {
				var f = p.find('form');
					var deptId = f.find('input[name=classIds]');
					var deptIdComboboxTree = deptId.combotree({
						url : '<%=basePath%>nclass/doNotNeedSession_treeRecursive',
						multiple : false,
						editable : false,
						panelHeight : 'auto'
					});
					
			}
		});
	}
	function _search() {
		datagrid.datagrid('load', dj.serializeObject($('#searchForm')));
	}
	function cleanSearch() {
		datagrid.datagrid('load', {});
		$('#searchForm input').val('');
	}
	
	function loadTable(node){
	 	$('#datagrid').datagrid('load',{classIds:node.id});   
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'west',title:'班级列表结构树',split:true"
		style="width:220px;background:#eee;">
		<div class="easyui-panel" fit="true" style="padding:5px">
			<!-- <input id="tt" class="easyui-textbox" style="width:100%" data-options="
			prompt: '请输入学员编号',
			iconWidth: 22,
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					var v = $(e.data.target).textbox('getValue');
					
				}
			}]
			"> -->
			<ul id="tt" class="easyui-tree" data-options="url:'<%=basePath%>nclass/doNotNeedSession_treeRecursive',method:'post',onClick: function(node){
                   loadTable(node);
                } ">
			</ul>
		</div>

	</div>
	<div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="datagrid"></table>
	</div>

	<div id="menu" class="easyui-menu" style="width:120px;display: none;">
		<div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
		<div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
		<div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
	</div>
</body>
</html>