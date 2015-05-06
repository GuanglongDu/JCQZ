<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div style="padding: 5px;overflow: hidden;">
	<form id="userForm" method="post">
		<table class="tableForm">
			<tr>
				<td>学生编号</td>
				<td><input name="code" type="text" class="easyui-textbox" data-options="required:'true',missingMessage:'请填写学生编号'"/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="name" type="text" class="easyui-textbox "  data-options="required:'true',missingMessage:'请填写学生姓名'"/>
				</td>
				<td>生日</td>
				<td><input name="birthday" type="text" class="easyui-textbox" />
				</td>
			</tr>
			<tr>
				<td>拼音</td>
				<td><input name="py" type="text" class="easyui-textbox" />
				</td>
				<td>性别</td>
				<td><select name="gender">
					<option value="0" selected="selected">男</option>
					<option value="1">女</option>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>曾用名</td>
				<td><input name="usedName" type="text" class="easyui-textbox" />
				</td>
			</tr>
			<tr>
				<td>父亲姓名</td>
				<td><input name="fatherName" type="text" class="easyui-textbox" />
				</td>
				<td>联系方式</td>
				<td><input name="fatherMobile" type="text" class="easyui-textbox"  data-options="required:'true',missingMessage:'请填写联系方式'"/>
				</td>
			</tr>
			<tr>
				<td>母亲姓名</td>
				<td><input name="motherName" type="text" class="easyui-textbox" /></td>
				<td>联系方式</td>
				<td><input name="motherMobile" type="text" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td>其余联系人</td>
				<td><input name="otherConnect" type="text" class="easyui-textbox" /></td>
				<td>联系方式</td>
				<td><input name="otherConnectMobile" type="text" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td>家庭住址</td>
				<td><input name="address" type="text" class="easyui-textbox" /></td>
				<td>幼儿园</td>
				<td><input name="school" type="text" class="easyui-textbox" /></td>
			</tr>
			<tr>
			<td>班级</td>
				<td><input name="classIds" type="text" style="width: 145px;" data-options="required:'true',missingMessage:'请选择班级'" /></td>
			</tr>
		</table>
	</form>
</div>