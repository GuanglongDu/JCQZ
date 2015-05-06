<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="../inc.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>识字软件管理系统</title>
<script type="text/javascript" charset="utf-8">
	var banji_v = "";
	$(function(){
		var ji = $("#jibie");
		var ptree = ji.combotree({
			lines : true,
			url : '<%=basePath%>property/doNotNeedSession_course'
		});
		var banji = $("#banji");
		var ptree = banji.combotree({
			lines : true,
			url : '<%=basePath%>nclass/doNotNeedSession_treeRecursive',
			onClick: function(node){
				banji_v = node.id;
        	}
		});
		$("#selectKeCheng").show();
	})
	function go(){
		//$("#selectKeCheng").hide();
		var jibieId = $("input[name=jibie]").val();
		if(jibieId){
			$("#selectKeCheng").hide();
			$.ajax({
				type:"get",
				url:'<%=basePath%>property/getPropertyByPId?pid='+jibieId,
				success:function(data){
					$("#selectKe").show();
					data = eval("("+data+")");
					for(var i = 0; i < data.length; i++){
						var singleDiv = $("<div>").css({
							"width" : "50%",
							"float" : "left",
							"margin-top" : "20px"
						});
						$("#selectKe").append(singleDiv);
						var d = data[i];
						var name = d.cname;
						var id = d.cid;
						(function(d,id,name){
							var keDiv = $("<div>",{
								id : id,
								text : name
							}).click(function(){
									$("#selectKe").hide();
									$("#wordIframe").attr("src","page.jsp?id="+id+"&banji="+banji_v);
									$("#word").show();
							}).css({
								"width" : "150px",
								"border" : "1px solid #95B8E7",
								"height" : "24px",
								"line-height" : "24px",
								"background" : "#E0ECFF",
								"font-size" : "14px",
								"text-align" : "center",
								"border-radius" : "5px",
								"margin" : "0 auto"
							}).appendTo(singleDiv);
						})(d,id,name);
					}
					
				}
			})
		}else{
			dj.messagerShow({
				msg : "请选择要进入的级",
				title : '提示'
			});
		}
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',border:true" style="overflow: hidden;">
		
		<div id="selectKeCheng" style="width:500px;height:300px;border:1px solid #95B8E7;margin:0 auto;margin-top:150px;border-radius:5px;">
			<div style="float:left;width:500px;margin-top:30px;font-size:36px;text-indent:36px;">
				请选择课程
			</div>
			<div style="float:left;width:250px;margin-top:30px;font-size:24px;text-align:center;">
				级：<input id='jibie' name='jibie' type="text" />
			</div>
			<div style="float:left;width:250px;margin-top:30px;font-size:24px;text-align:center;">
				班级：<input id='banji' name='jibie' type="text" />
			</div>
			<div style="float:left;width:500px;margin-top:130px;font-size:24px;text-align:center;">
				<button style="height:24px;width:100px;" onclick="javascript:go()">
					进入
				</button>
			</div>
		</div>
		<div id="selectKe" style="display:none;width:500px;height:300px;border:1px solid #95B8E7;margin:0 auto;margin-top:150px;border-radius:5px;">
			
		</div>
		<div id="word" style="display:none;" data-options="fit:true">
			<iframe id="wordIframe" scrolling="auto" frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
</body>
</html>