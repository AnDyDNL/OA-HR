<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<html>
<head>
    <title>岗位列表</title>
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="table">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" >
        <s:iterator value="#roleList">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${description} &nbsp;</td>
				<td><s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除该职位吗？')">删除</s:a>
					<s:a action="role_editUI?id=%{id}">修改</s:a>
					<a href="setPrivilegeUI.jsp">设置权限</a>
				</td>	
			</tr>
        </s:iterator>
        </tbody>
    </table>
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        <s:a action ="role_addUI"><button id="add" class="btn btn-primary btn-sm">新建</button></s:a>
        </div>
    </div>
</div>
</body>
</html>
