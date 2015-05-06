<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">

</script>
<div align="center" style="padding: 5px;">
	<form method="post">
		<input type="hidden" name="cid" />
		<table class="tableForm">
			<tr>
				<th>课程名称</th>
				<td><input name="cname" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写菜单名称'" /></td>
				<th>排序</th>
				<td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="10" style="width:150px;" /></td>
			</tr>
			<tr>
				<th>上级课程</th>
				<td><input name="pid" style="width:155px;" />
				</td>
				<th>课程图标</th>
				<td><input name="iconCls" style="width:150px;" />
				</td>
			</tr>
			<tr>
				<th>描述</th>
				<td colspan="2"><textarea name="cdesc"></textarea>
				</td>
			</tr>
		</table>
	</form>
</div>