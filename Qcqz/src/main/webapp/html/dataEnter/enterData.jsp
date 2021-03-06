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
			url : '<%=basePath%>nword/getAll',
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
				title : '词卡编号',
				field : 'wcnumber',
				width : 100,
				sortable : true
			}, {
				title : '词',
				field : 'cname',
				width : 100,
				sortable : true
			}] ],
			columns : [ [{
				title : '组',
				field : 'propertycname',
				width : 120,
				formatter: function(value,row,index){
          
           			return row.property.cname;
         }}, {
				title : '类别',
				field : 'categorycname',
				sortable : true,
				width : 120,
				formatter: function(value,row,index){
           			return row.category.cname;
         		}}, {
				title : '排序',
				field : 'cseq',
				sortable : true,
				width : 120
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					append();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '取消选中',
				iconCls : 'icon-undo',
				handler : function() {
					datagrid.datagrid('clearSelections');
					datagrid.datagrid('unselectAll');
				}
			}, '-' ],
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
	
	
	function edit() {
		var rows = datagrid.datagrid('getSelections');
		if (rows.length == 1) {
			var p = dj.dialog({
				title : '编辑数据',
				href : '<%=basePath%>nword/editWords',
				width : 450,
				height : 480,
				buttons : [ {
					text : '编辑',
					handler : function() {
						var f = p.find('form');
						f.form('submit', {
							url : '<%=basePath%>nword/edit',
							onSubmit : function(){
								var rows = $("#tableEnterData").datagrid("getRows"); 
								for(var i=0;i<rows.length;i++){
									var node = rows[i];
									$("<input type='hidden' name='letters["+i+"].cseq' value="+node.id+" />").appendTo(f);
									$("<input type='hidden' name='letters["+i+"].cname' value="+node.letter+" />").appendTo(f);
									$("<input type='hidden' name='letters["+i+"].pinyin' value="+node.pinyin+" />").appendTo(f);
								}
								return true;
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
				} ],
				onLoad : function() {
					var f = p.find('form');
					var roleIds = f.find('input[name=categoryId]');
					var pid = f.find('input[name=groupId]');
					var roleIdsCombobox = roleIds.combobox({
						url : '<%=basePath%>categories/doNotNeedSession_combobox',
						valueField : 'cid',
						textField : 'cname',
						multiple : true,
						editable : false,
						panelHeight : 'auto',
						onLoadSuccess : function() {
							roleIds.combobox("setValues",rows[0].category.cid);
							$.messager.progress('close');
						}
					});
					var ptree = pid.combotree({
						url : '<%=basePath%>property/doNotNeedSession_treeRecursive',
						method:'post',
						onLoadSuccess : function() {
							pid.combotree("setValues",rows[0].property.cid);
							$.messager.progress('close');
						},
						onClick: function(node){
	                   		loadTable(node);
	                	}
					});
					if(rows[0].cpath){
						var cpath_parentTD = f.find('input[name=picfiles]').closest("td")[0];
						var image = $("<img>",{
							"src":'<%=basePath%>'+rows[0].cpath,
							"border" : "0px",
							"width" : "350px"
						});
						$(cpath_parentTD).prepend(image);
					}
					f.form('load', {
						cid : rows[0].cid,
						cname : rows[0].cname,
						wcnumber : rows[0].wcnumber,
						pinyi : rows[0].pinyi
					});
				}
			});
		} else if (rows.length > 1) {
			dj.messagerAlert('提示', '同一时间只能编辑一条记录！', 'error');
		} else {
			dj.messagerAlert('提示', '请选择要编辑的记录！', 'error');
		}
	}
	
	function append() {
		var p = dj.dialog({
			title : '添加数据',
			href : '<%=basePath%>nword/addWords',
			width : 450,
			height : 480,
			buttons : [ {
				text : '添加',
				handler : function() {
					var f = p.find('form');
					 f.form('submit', {
						url : '<%=basePath%>nword/add',
						method:'post',
						onSubmit : function(){
							var rows = $("#tableEnterData").datagrid("getRows"); 
							for(var i=0;i<rows.length;i++){
								var node = rows[i];
								$("<input type='hidden' name='letters["+i+"].cseq' value="+node.id+" />").appendTo(f);
								$("<input type='hidden' name='letters["+i+"].cname' value="+node.letter+" />").appendTo(f);
								$("<input type='hidden' name='letters["+i+"].pinyin' value="+node.pinyin+" />").appendTo(f);
							}
							return true;
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
			} ],
			onLoad : function() {
				var f = p.find('form');
				var roleIds = f.find('input[name=categoryId]');
				var pid = f.find('input[name=groupId]');
				var roleIdsCombobox = roleIds.combobox({
					url : '<%=basePath%>categories/doNotNeedSession_combobox',
					valueField : 'cid',
					textField : 'cname',
					multiple : true,
					editable : false,
					panelHeight : 'auto'
				});
				var ptree = pid.combotree({
					url : '<%=basePath%>property/doNotNeedSession_treeRecursive',
					method:'post',
					onClick: function(node){
                   		loadTable(node);
                	}
				});
			}
		});
	}
	function remove() {
		var rows = datagrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			dj.messagerConfirm('请确认', '您要删除当前所选项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].cid);
					}
					$.ajax({
						url : '<%=basePath%>nword/deleteWords',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(d) {
							datagrid.datagrid('load');
							datagrid.datagrid('unselectAll');
							dj.messagerShow({
								title : '提示',
								msg : d.msg
							});
						}
					});
				}
			});
		} else {
			dj.messagerAlert('提示', '请勾选要删除的记录！', 'error');
		}
	}
	function _search() {
		datagrid.datagrid('load', dj.serializeObject($('#searchForm')));
	}
	function cleanSearch() {
		datagrid.datagrid('load', {});
		$('#searchForm input').val('');
	}
	
	function loadTable(node){
	 	$('#datagrid').datagrid('load',{groupId:node.id});   
	}
 

</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<!-- <div data-options="region:'north',border:false,title:'过滤条件'" style="height: 55px;overflow: hidden;" align="left">
		<form id="searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>用户名</th>
					<td><input name="cname" style="width:317px;" />
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div> -->
	<div data-options="region:'west',title:'课程列表结构树',split:true"
		style="width:220px;background:#eee;">
		<div class="easyui-panel" fit="true" style="padding:5px">
			<ul id="tt" class="easyui-tree"
				data-options="url:'<%=basePath%>property/doNotNeedSession_treeRecursive',method:'post',onClick: function(node){
                   loadTable(node);
                } ">
			</ul>
		</div>

	</div>
	<div data-options="region:'center',border:false"
		style="overflow: hidden;">
		<table id="datagrid"></table>
	</div>

	<div id="menu" class="easyui-menu" style="width:120px;display: none;">
		<div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
		<div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
		<div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
	</div>
</body>
</html>