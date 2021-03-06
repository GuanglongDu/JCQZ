<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="../inc.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<script type="text/javascript" charset="utf-8">
	var treegrid;
	var iconData;
	var treegrid_group;
	$(function() {
		
		iconData = [ {
			value : '0',
			text : '课程列表'
		}, {
			value : '1',
			text : '期'
		}, {
			value : '2',
			text : '级'
		}, {
			value : '3',
			text : '节'
		} , {
			value : '4',
			text : '组'
		}];

		treegrid = $('#treegrid').treegrid({
			url : '<%=basePath%>property/getAll',
			toolbar : [ {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('expandAll', node.cid);
					} else {
						treegrid.treegrid('expandAll');
					}
				}
			}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('collapseAll', node.cid);
					} else {
						treegrid.treegrid('collapseAll');
					}
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					treegrid.treegrid('reload');
				}
			}, '-', {
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
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '取消选中',
				iconCls : 'icon-undo',
				handler : function() {
					treegrid.treegrid('unselectAll');
				}
			}, '-' ],
			title : '',
			iconCls : 'icon-save',
			fit : true,
			fitColumns : false,
			nowrap : false,
			animate : false,
			border : false,
			idField : 'cid',
			treeField : 'cname',
			frozenColumns : [ [ {
				title : 'cid',
				field : 'cid',
				width : 150,
				hidden : true
			}, {
				field : 'cname',
				title : '课程名称',
				width : 180,
				formatter : function(value) {
					if (value) {
						return dj.fs('<span title="{0}">{1}</span>', value, value);
					}
				}
			} ] ],
			columns : [ [ {
				field : 'iconCls',
				title : '课程图标',
				width : 70,
				formatter : function(value) {
					if (!value) {
						return '';
					} else {
						return dj.fs('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>', value);
					}
				}
			}, {
				field : 'cseq',
				title : '排序',
				width : 40
			}, {
				field : 'pid',
				title : '上级课程ID',
				width : 150,
				hidden : true
			}, {
				field : 'pname',
				title : '上级课程',
				width : 150
			}, {
				field : 'cdesc',
				title : '课程描述',
				width : 250
			} ] ],
			onContextMenu : function(e, row) {
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.cid);
				$('#menu').dept('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onLoadSuccess : function(row, data) {
				/*var t = $(this);
				if (data) {
					$(data).each(function(index, d) {
						if (this.state == 'closed') {
							t.treegrid('expandAll');
						}
					});
				}*/
			},
			onExpand : function(row) {
				treegrid.treegrid('unselectAll');
			},
			onCollapse : function(row) {
				treegrid.treegrid('unselectAll');
			},
			onClickRow: function(row){
				
				$('#treegrid_group').datagrid('load',{tpropertyId:row.cid});   
			}
		});
		
	});
	function edit() {
		var node = treegrid.treegrid('getSelected');
		if (node) {
			var p = dj.dialog({
				title : '编辑课程',
				href : '<%=basePath%>property/propertyEdit',
				width : 460,
				height : 220,
				buttons : [ {
					text : '编辑',
					handler : function() {
						var f = p.find('form');
						f.form('submit', {
							url : '<%=basePath%>property/edit',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									treegrid.treegrid('reload');
									p.dialog('close');
									ctrlTree.tree('reload');
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
					var pid = f.find('input[name=pid]');
					var iconCls = f.find('input[name=iconCls]');
					var iconCombo = iconCls.combobox({
						data : iconData
					});
					var ptree = pid.combotree({
						lines : true,
						url : '<%=basePath%>property/doNotNeedSession_treeRecursive',
						onLoadSuccess : function() {
							pid.combotree("setValue",node.pid);
							$.messager.progress('close');
						}
					});
					f.form('load', node);
				}
			});
		} else {
			dj.messagerAlert('提示', '请选中要编辑的记录！', 'error');
		}
	}
	function append() {
		var p = dj.dialog({
			title : '添加课程',
			href : '<%=basePath%>property/propertyAdd',
			width : 460,
			height : 220,
			buttons : [ {
				text : '添加',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '<%=basePath%>property/add',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								treegrid.treegrid('reload');
								p.dialog('close');
								//ctrlTree.tree('reload');/*刷新左侧菜单树*/
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
				var pid = f.find('input[name=pid]');
				var iconCls = f.find('input[name=iconCls]');
				var iconCombo = iconCls.combobox({
					data : iconData
				});
				var ptree = pid.combotree({
					lines : true,
					url : '<%=basePath%>property/doNotNeedSession_tree'
				});
			}
		});
	}
	function remove() {
		var node = treegrid.treegrid('getSelected');
		if (node) {
			dj.messagerConfirm('询问', '您确定要删除【' + node.cname + '】？', function(b) {
				if (b) {
					$.ajax({
						url : '<%=basePath%>property/deleteProperty',
						data : {
							cid : node.cid
						},
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								treegrid.treegrid('remove', r.obj);
								//ctrlTree.tree('reload');/*刷新左侧菜单树*/
							}
							dj.messagerShow({
								msg : r.msg,
								title : '提示'
							});
						}
					});
				}
			});
		}
	}
	
	
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'" style="overflow: hidden;" >
		<table id="treegrid"></table>
	</div>
	<div id="menu" class="easyui-menu" style="width:120px;display: none;">
		<div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
		<div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
		<div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
	</div>

</body>
</html>