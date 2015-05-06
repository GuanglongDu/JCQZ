<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>识字软件管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <script type="text/javascript" src="easyui/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
   
    	function addUser(){
    	var username= $("#username").val();
    		var password = $("#password").val();
	        var jsondata = {"userName":username,"passwd":password}; 
	        $.ajax({ 
	            type:"GET", 
	            url:"login/login",                 
	            data:jsondata, 
	            success:function(data){ 
	            if (data == "login") {
	               window.location.href="html/index.jsp";
	               }else{
	                window.location.href="login.jsp";
	               }                    
	            } 
	         });
         }
    </script>
</head>
<body>

    <div class="login_contain">
        <div class="login-top">
            晶橙启智—识字系统
        </div>
        <div class="login-div">
            <div class="top">
                 用户登录
            </div>
            <div class="bottom">
                <div class="username-div">
                    <div class="username-lable-div">
                        用户名：
                    </div>
                    <div class="username-input-div">
                        <input id="username" type="text" value="admin">
                    </div>
                </div>
                <div class="pwd-div">
                    <div class="pwd-lable-div">
                        密码：
                    </div>
                    <div class="pwd-input-div">
                        <input id="password" type="password" value="admin">
                    </div>
                </div>
                <div class="login-button">
                    <div class="submit-button">
                        <a href="javascript:addUser()">
                            <div >
                                登录
                            </div>
                        </a>
                    </div>
                    <div class="reset-button">
                        <a href="javascript:void(0)">
                            <div>
                                清空
                            </div>
                        </a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>
</html>