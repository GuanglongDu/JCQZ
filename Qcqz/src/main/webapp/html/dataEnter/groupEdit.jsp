<%@ page language="java" pageEncoding="UTF-8"%>
<div style="padding: 5px;overflow: hidden;">
	<form id="groupForm" method="post">
		<input type="hidden" name="cid" />
		<table class="tableForm">
			<tr>
				<td>组名称</td>
				<td><input name="cname" type="text" /></td>
				<td>组图标</td>
				<td><input name="ciconcls" type="text" /></td>
			</tr>
			<tr>
				<!-- <td>类别名称</td>
				<td><input name="category" class="easyui-validatebox"
					data-options="required:'true',missingMessage:'请填写类别名称'" /></td> -->
				<td>课程列表</td>
				<td><input name="tpropertyId" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td colspan="3"><textarea style="width:100%;height:60px;"
						name="cdesc"></textarea></td>
			</tr>
		</table>
	</form>
</div>