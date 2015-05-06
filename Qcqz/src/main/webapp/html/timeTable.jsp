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
            <li class="menu-top-li-select">
                <a href="timeTable.jsp">课程列表</a>
            </li>
            <li class="menu-top-li">
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
    <div class="contain-timedata-left">
        <div class="tree well">
            <ul>
                <li>
                    <span><i class="icon-folder-open"></i>课程列表</span>
                    <ul>
                        <li  class="root-lev1">
                            <span><i class="icon-minus-sign"></i>一期</span>
                            <ul>
                                <li>
                                    <span><i class="icon-leaf"></i>A级</span>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>B级</span>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>C级</span>
                                </li>
                            </ul>
                        </li>
                        <li  class="root-lev1">
                            <span><i class="icon-minus-sign"></i>二期</span>
                            <ul>
                                <li>
                                    <span><i class="icon-minus-sign"></i>A级</span>
                                    <ul>
                                        <li>
                                            <span><i class="icon-leaf"></i>A-1级</span>
                                        </li>
                                        <li>
                                            <span><i class="icon-leaf"></i>B-1级</span>
                                        </li>
                                        <li>
                                            <span><i class="icon-leaf"></i>C-1级</span>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>B级</span>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>C级</span>
                                </li>
                            </ul>
                        </li>
                        <li  class="root-lev1">
                            <span><i class="icon-minus-sign"></i>三期</span>
                            <ul>
                                <li>
                                    <span><i class="icon-leaf"></i>A级</span>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>B级</span>
                                </li>
                                <li>
                                    <span><i class="icon-leaf"></i>C级</span>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="contain-timedata-right">

    </div>
</div>
</body>
</html>