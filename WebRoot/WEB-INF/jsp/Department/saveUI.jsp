<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<html>
<head>
	<title>HR-部门设置</title>
    <script language="javascript" "taShowManager.js" charset="utf-8"></script>
</head>
<body>

<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="department_%{name == null ? 'add' : 'edit'}">
    <s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="250px">上级部门</td>
                        <td>
                        <s:select name="parentId" cssClass="SelectStyle" 
                        list="#departmentList" listKey="id" listValue="name" 
                        headerKey="" headerValue="=====请选择上级部门====="
                        />
                                <!-- <option value="0" selected="selected">请选择部门</option>
                                <option value="7">┠总经理室</option>
                                <option value="1">┠市场部</option>
                                <option value="2">　┠咨询部</option>
                                <option value="3">　┠招生部</option>
                                <option value="4">┠教学部</option>
                                <option value="5">┠后勤部</option> -->
                        </td>
                    </tr>
                    <tr><td>部门名称</td>
                        <td><s:textfield type="text" name="name" Class="InputStyle"/> </td>
                    </tr>
                    <tr><td>职能说明</td>
                        <td><s:textarea name="description" Class="TextareaStyle"></s:textarea ></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" class="btn btn-primary btn-sm" value="保存">
            <a href="javascript:history.go(-1);"><button id="add" class="btn btn-primary btn-sm">返回</button></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>
</body>
</html>
