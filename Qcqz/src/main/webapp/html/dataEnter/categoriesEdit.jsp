<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">

</script>
<div style="padding: 5px;">
	<form id="categoriesForm" method="post">
		<input name="cid" type="hidden" />
		<table class="tableForm">
			<tr>
				<th style="width: 55px;">类别名称</th>
				<td><input name="cname" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写类别名称'" />
				</td>
			</tr>
			<tr>
				<th>描述</th>
				<td><input name="crealname" type="text"/>
				</td>
			</tr>
		</table>
	</form>
</div>