<%@ page language="java" pageEncoding="UTF-8"%>
<div align="center" style="padding: 5px;">
	<form method="post">
		<table class="tableForm">
			<tr>
				<th>课程名称</th>
				<td><input name="cname" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写菜单名称'" />
				</td>
				<th>排序</th>
				<td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="10" />
				</td>
			</tr>
			<tr>
				<th>上级课程</th>
				<td><input name="pid" type="text" />
				</td>
				<th>属性类型</th>
				<td><input name="iconCls" type="text" />
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