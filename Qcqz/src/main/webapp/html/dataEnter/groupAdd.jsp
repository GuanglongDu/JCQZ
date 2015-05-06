<%@ page language="java" pageEncoding="UTF-8"%>
<div style="padding: 5px;overflow: hidden;">
	<form id="groupForm" method="post">
		<table class="tableForm">
			<tr>
				<td>组名称</td>
				<td><input name="cname" type="text" class="easyui-textbox" /></td>
				<th>排序</th>
				<td><input name="cseq" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择组排序'" value="10" style="width:150px;" />
				</td>
			</tr>
			<tr><!-- 
				<td>类别名称</td>
				<td><input name="category" class="easyui-validatebox" /></td> -->
				<td>课程列表</td>
				<td><input name="tpropertyId" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td colspan="3"><textarea style="width:100%;height:60px;" name="cdesc"></textarea></td>
			</tr>
		</table>
	</form>
</div>