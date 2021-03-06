<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>识字软件管理系统</title>
    <link rel="stylesheet" type="text/css" href="../css/base.css" />
    <link rel="stylesheet" type="text/css" href="../css/index.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <link rel="stylesheet" type="text/css" href="../css/icon.css" />
    <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../js/tree.js"></script>
</head>
<body>
<div class="top">
    <div class="top-title">
        晶橙启智—识字系统
    </div>
    <div class="menu-lev1">
        <ul>
            <li class="menu-top-li">
                <a href="propertyDefine.jsp">属性定义</a>
            </li>
            <li class="menu-top-li">
                <a href="enterData.jsp">数据录入</a>
            </li>
            <li class="menu-top-li">
                <a href="timeTable.jsp">课程列表</a>
            </li>
            <li class="menu-top-li-select">
                <a href="academicControl.jsp">教务管理</a>
            </li>
            <li class="menu-top-li">
                <a href="userControl.jsp">用户管理</a>
            </li>
            <li class="menu-top-li">
                <a href="jinChengQiZhi.jsp">晶橙启智</a>
            </li>
        </ul>
    </div>
</div>
<div class="contain">
    <div class="contain-left">
        <div class="tree well">
            <ul>
                <li>
                    <span><i class="icon-folder-open"></i>教务管理</span>
                    <ul>
                        <li  class="root-lev1">
                            <span><i class="icon-leaf"></i>测评</span>
                        </li>
                        <li  class="root-lev1">
                            <span><i class="icon-leaf"></i>班级查询</span>
                        </li>
                        <li class="root-lev1">
                            <span><i class="icon-leaf"></i>学院查询</span>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="contain-right">

    </div>
</div>
</body>
</html>