<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
</head>
<body>
	ds
	<s:iterator value="#roleList">
		<!-- 从page request valueStack(先找对象栈再找map) session 中找 等获取数据 -->
		${id}
		${name} 
		${description} 
		<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除该职位吗？')">删除</s:a>
		<s:a action="role_editUI?id=%{id}">修改</s:a>
	</s:iterator>
	<br>
	<s:a action="role_addUI">添加</s:a>
</body>
</html>
