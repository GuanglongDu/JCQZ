<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 5px;overflow: hidden;">
	<form id="userForm" method="post">
		<table class="tableForm">
			<tr>
				<th style="width: 55px;">用户名</th>
				<td><input name="cname" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录名称'" />
				</td>
				<th style="width: 55px;">所属角色</th>
				<td><input name="roleIds" style="width: 145px;"  data-options="required:'true',missingMessage:'请选择所属角色'"/>
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="cpwd" type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录密码'" />
				</td>
				<th>重复密码</th>
				<td><input type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请再次填写密码',validType:'eqPassword[\'#userForm input[name=cpwd]\']'" />
				</td>
			</tr>
			<tr>
				<th>真实姓名</th>
				<td><input name="crealname" type="text" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写真实姓名'" />
				</td>
				<th>部门</th>
				<td><input type="text" name="deptId" style="width: 145px;" data-options="required:'true',missingMessage:'请选择所属部门'"/>
				</td>
			</tr>
			<tr>
				<th>邮箱</th>
				<td><input name="cemail" type="text" />
				</td>
				<th>状态</th>
				<td><select name="cstatus">
					<option value="0" selected="selected">启用</option>
					<option value="1">停用</option>
				</select>
				</td>
			</tr>
		</table>
	</form>
</div>