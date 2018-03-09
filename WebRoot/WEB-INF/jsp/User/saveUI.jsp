<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
	<title>用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    
    <script type="text/javascript">
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="user_add"  onsubmit="return validateAll()" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                	<tr>
                		<td width="250px">上级部门</td>
                    	<td>
                	<s:select name="parentId" cssClass="InputStyle"
                        list="#departmentList" listKey="id" listValue="name" 
                        headerKey="" headerValue="=====请选择上级部门====="
                        />
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td id="loginName"><input type="text" name="loginName" onblur="validateName(this)" class="InputStyle"/> 
							<td ><span id="user_message">（登录名要唯一）</span></td>	
                    </tr>
                    <tr><td>姓名</td>
                   		<td><input type="text" name="name" class="InputStyle"/></td>
                    </tr>
					<tr><td>性别</td>
                        <td>
                        <s:radio name="gender" list="{'男','女'}"></s:radio><!-- 构建ognl表达式 -->
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><input type="text" name="phoneNumber" class="InputStyle" onblur="checkMobile(this)"/></td>
                    	<td ><span id="phone_message"></span></td>	
                    </tr>
                    <tr><td>E-mail</td>
                        <td><input type="text" name="email" class="InputStyle" onblur="checkEmail(this)"/></td>
                        <td ><span id="email_message"></span></td>	
                    </tr>
                    <tr><td>备注</td>
                        <td><textarea name="description" class="TextareaStyle"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="roleForm" >
                    <tr>
						<td >岗位</td>
                        <td>
                        	<%-- <s:select name="roleIdList" multiple="true" size="10" cssClass="SelectStyle" 
                               list="#roleList" listKey="id" listValue="name" 
                               >
                            </s:select> --%>
                            <s:checkboxlist  name="roleIdList"
   							list="#roleList" listKey="id" listValue="name"></s:checkboxlist>                 
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
        	<input type="submit"  class="btn btn-primary btn-sm" value="保存">
            <a href="javascript:history.go(-1);"><button id="add" class="btn btn-primary btn-sm">返回</button></a>
        </div>
    </s:form>
    <script language="javascript" src="${pageContext.request.contextPath}/script/validateUser.js" charset="utf-8"></script>
</div>

<div class="Description">
	说明：<br />
	1，新建用户后，密码被初始化为"1234"。<br />
	2，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	3，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	4，修改用户信息时，登录名不可修改。
</div>

</body>
</html>
