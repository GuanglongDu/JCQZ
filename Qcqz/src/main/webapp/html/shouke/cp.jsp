<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../inc.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<body class="easyui-layout">
	<input class="easyui-textbox" name="message"
			data-options="multiline:true,prompt:'测评意见'"
			style="float:left;width:100%;height:100%;margin:5px;"></input>
</body>
</html>
