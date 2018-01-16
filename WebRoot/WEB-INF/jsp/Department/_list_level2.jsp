<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<HTML>
<HEAD>
    <TITLE>部门列表</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
    <SCRIPT LANGUAGE="javascript" SRC="${pageCoontext.request.contextPath}/script/jquery.js"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageCoontext.request.contextPath}/script/pageCommon.js" CHARSET="utf-8"></SCRIPT>
    <SCRIPT LANGUAGE="javascript" SRC="${pageCoontext.request.contextPath}/script/PageUtils.js" CHARSET="utf-8"></SCRIPT>
    <LINK TYPE="text/css" REL="stylesheet" HREF="${pageCoontext.request.contextPath}/style/blue/pageCommon.css" />
    <SCRIPT TYPE="text/javascript">
    </SCRIPT>
</HEAD>
<BODY>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageCoontext.request.contextPath}/style/images/title_arrow.gif"/> 部门管理
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<DIV ID="MainArea">
    <TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle">
       
        <!-- 表头-->
        <THEAD>
            <TR ALIGN=center VALIGN=middle ID=TableTitle>
            	<TD WIDTH="150px">部门名称</TD>
				<TD WIDTH="150px">上级部门名称</TD>
				<TD WIDTH="200px">职能说明</TD>
				<TD>相关操作</TD>
            </TR>
        </THEAD>

		<!--显示数据列表-->
        <TBODY ID="TableData" CLASS="dataContainer" dataKey="departmentList2">
			<TR CLASS="TableDetail1 template">
					<TD><A HREF="_list_level2.html">${department.name}</A>&nbsp;</TD>
					<TD>${department.parent.name}&nbsp;</TD>
					<TD>${department.description}&nbsp;</TD>
					<TD><A onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" HREF="#">删除</A>
						<A HREF="saveUI.html">修改</A>
					</TD>
			</TR>
        </TBODY>
    </TABLE>
    
    <!-- 其他功能超链接 -->
    <DIV ID="TableTail">
        <DIV ID="TableTail_inside">
            <A HREF="saveUI.html"><IMG SRC="${pageCoontext.request.contextPath}/style/images/createNew.png" /></A>
			<A HREF="list.html"><IMG SRC="${pageCoontext.request.contextPath}/style/blue/images/button/ReturnToPrevLevel.png" /></A>
        </DIV>
    </DIV>
</DIV>
</BODY>
</HTML>
