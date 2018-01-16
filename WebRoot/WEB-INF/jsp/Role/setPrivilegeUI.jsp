<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<html>
<head>
<title>配置权限</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="${pageCoontext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageCoontext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageCoontext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
	<link type="text/css" rel="stylesheet" href="${pageCoontext.request.contextPath}/style/blue/pageCommon.css" />
	<script language="javascript" src="${pageCoontext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageCoontext.request.contextPath}/style/blue/file.css" />
	<link type="text/css" rel="stylesheet" href="${pageCoontext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />

	<script type="text/javascript">
 		// 选择所有
    	function selectAll(checkedValue){
    		$("input[type=checkbox][name=resourceIdList]").attr("checked", checkedValue);
    	}
    	
    	function doChecked( liID, checkedValue ){
			// 当前点击的checkbox元素所在的li元素
    		var jLi = $("#" + liID);

    		// 选中所有的直属下级。（children()方法是筛选下一级，find()是筛选所有后代）
    		jLi.children("ul").find("input[type=checkbox]").attr("checked", checkedValue);
    		
    		// 选中或取消选中直属上级
    		if( checkedValue ){ // checkedValue是boolean型，表示是否选中了当前复选框
    			// 如果当前是选中，则选中所有的直属上级
				jLi.parents("li").children("input[type=checkbox]").attr("checked", checkedValue);
			}else{
				// 如果当前是取消选中，并且同级中没有被选中的项，则也取消上级的选中状态
				var jCheckedSibingCB = jLi.siblings("li").children("input[type=checkbox]:checked");
				if(jCheckedSibingCB.size() == 0){
					var jCheckboxInput = jLi.parent("ul").prev("label").prev("input[type=checkbox]");
					jCheckboxInput.attr("checked", checkedValue);
					
					// 递归操作每一层直属上级
					var jParentLi = jCheckboxInput.parent("li");
					if(jParentLi.size() > 0){
						doChecked(jParentLi.attr("id"), checkedValue);
					}
				}
			}
    	} 
    	
    	$(function(){
    		$("#tree").treeview();
    	});
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageCoontext.request.contextPath}/style/images/title_arrow.gif"/> 配置权限
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="list.html">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageCoontext.request.contextPath}/style/blue/images/item_point.gif" /> 正在为【部门经理】配置权限 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="CHECKBOX" id="cbSelectAll" onClick="selectAll(this.checked)"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
<ul id='tree'>
	<li id='li_45'>
		<input type='checkbox' name='resourceIdList' id='cb_45' onclick='doChecked("li_45", this.checked)'/>
		<label for='cb_45'><span class='folder' id='45'>系统管理</span></label>
		<ul>
			<li id='li_46'>
				<input type='checkbox' name='resourceIdList' id='cb_46' onclick='doChecked("li_46", this.checked)'/>
				<label for='cb_46'><span class='folder' id='46'>部门管理</span></label>
				<ul>
					<li id='li_128'>
						<input type='checkbox' name='resourceIdList' id='cb_128' onclick='doChecked("li_128", this.checked)'/>
						<label for='cb_128'><span class='folder' id='128'>部门列表</span></label>
					</li>
					<li id='li_28'>
						<input type='checkbox' name='resourceIdList' id='cb_28' onclick='doChecked("li_28", this.checked)'/>
						<label for='cb_28'><span class='folder' id='28'>部门添加</span></label>
					</li>
					<li id='li_29'>
						<input type='checkbox' name='resourceIdList' id='cb_29' onclick='doChecked("li_29", this.checked)'/>
						<label for='cb_29'><span class='folder' id='29'>部门删除</span></label>
					</li>
					<li id='li_30'>
						<input type='checkbox' name='resourceIdList' id='cb_30' onclick='doChecked("li_30", this.checked)'/>
						<label for='cb_30'><span class='folder' id='30'>部门修改</span></label>
					</li>
				</ul>
			</li>
			<li id='li_47'>
				<input type='checkbox' name='resourceIdList' id='cb_47' onclick='doChecked("li_47", this.checked)'/>
				<label for='cb_47'><span class='folder' id='47'>岗位管理</span></label>
				<ul>
					<li id='li_131'>
						<input type='checkbox' name='resourceIdList' id='cb_131' onclick='doChecked("li_131", this.checked)'/>
						<label for='cb_131'><span class='folder' id='131'>岗位列表</span></label>
					</li>
					<li id='li_31'>
						<input type='checkbox' name='resourceIdList' id='cb_31' onclick='doChecked("li_31", this.checked)'/>
						<label for='cb_31'><span class='folder' id='31'>岗位添加</span></label>
					</li>
					<li id='li_32'>
						<input type='checkbox' name='resourceIdList' id='cb_32' onclick='doChecked("li_32", this.checked)'/>
						<label for='cb_32'><span class='folder' id='32'>岗位删除</span></label>
					</li>
					<li id='li_33'>
						<input type='checkbox' name='resourceIdList' id='cb_33' onclick='doChecked("li_33", this.checked)'/>
						<label for='cb_33'><span class='folder' id='33'>岗位修改</span></label>
					</li>
					<li id='li_34'>
						<input type='checkbox' name='resourceIdList' id='cb_34' onclick='doChecked("li_34", this.checked)'/>
						<label for='cb_34'><span class='folder' id='34'>岗位设置权限</span></label>
					</li>
				</ul>
			</li>
			<li id='li_48'>
				<input type='checkbox' name='resourceIdList' id='cb_48' onclick='doChecked("li_48", this.checked)'/>
				<label for='cb_48'><span class='folder' id='48'>用户管理</span></label>
				<ul>
					<li id='li_135'>
						<input type='checkbox' name='resourceIdList' id='cb_135' onclick='doChecked("li_135", this.checked)'/>
						<label for='cb_135'><span class='folder' id='135'>用户列表</span></label>
					</li>
					<li id='li_35'>
						<input type='checkbox' name='resourceIdList' id='cb_35' onclick='doChecked("li_35", this.checked)'/>
						<label for='cb_35'><span class='folder' id='35'>用户添加</span></label>
					</li>
					<li id='li_36'>
						<input type='checkbox' name='resourceIdList' id='cb_36' onclick='doChecked("li_36", this.checked)'/>
						<label for='cb_36'><span class='folder' id='36'>用户删除</span></label>
					</li>
					<li id='li_37'>
						<input type='checkbox' name='resourceIdList' id='cb_37' onclick='doChecked("li_37", this.checked)'/>
						<label for='cb_37'><span class='folder' id='37'>用户修改</span></label>
					</li>
					<li id='li_38'>
						<input type='checkbox' name='resourceIdList' id='cb_38' onclick='doChecked("li_38", this.checked)'/>
						<label for='cb_38'><span class='folder' id='38'>用户初始化密码</span></label>
					</li>
				</ul>
			</li>
		</ul>
	</li>
	<li id='li_1'>
		<input type='checkbox' name='resourceIdList' id='cb_1' onclick='doChecked("li_1", this.checked)'/>
		<label for='cb_1'><span class='folder' id='1'>审批流转</span></label>
		<ul>
			<li id='li_2'>
				<input type='checkbox' name='resourceIdList' id='cb_2' onclick='doChecked("li_2", this.checked)'/>
				<label for='cb_2'><span class='folder' id='2'>起草申请</span></label>
			</li>
			<li id='li_3'>
				<input type='checkbox' name='resourceIdList' id='cb_3' onclick='doChecked("li_3", this.checked)'/>
				<label for='cb_3'><span class='folder' id='3'>我的申请查询</span></label>
			</li>
			<li id='li_4'>
				<input type='checkbox' name='resourceIdList' id='cb_4' onclick='doChecked("li_4", this.checked)'/>
				<label for='cb_4'><span class='folder' id='4'>待我审批</span></label>
			</li>
			<li id='li_5'>
				<input type='checkbox' name='resourceIdList' id='cb_5' onclick='doChecked("li_5", this.checked)'/>
				<label for='cb_5'><span class='folder' id='5'>经我审批</span></label>
			</li>
			<li id='li_6'>
				<input type='checkbox' name='resourceIdList' id='cb_6' onclick='doChecked("li_6", this.checked)'/>
				<label for='cb_6'><span class='folder' id='6'>文档模板管理</span></label>
			</li>
			<li id='li_7'>
				<input type='checkbox' name='resourceIdList' id='cb_7' onclick='doChecked("li_7", this.checked)'/>
				<label for='cb_7'><span class='folder' id='7'>审批流程管理</span></label>
			</li>
		</ul>
	</li>
	<li id='li_20'>
		<input type='checkbox' name='resourceIdList' id='cb_20' onclick='doChecked("li_20", this.checked)'/>
		<label for='cb_20'><span class='folder' id='20'>实用工具</span></label>
		<ul>
			<li id='li_21'>
				<input type='checkbox' name='resourceIdList' id='cb_21' onclick='doChecked("li_21", this.checked)'/>
				<label for='cb_21'><span class='folder' id='21'>公司网站</span></label>
			</li>
			<li id='li_22'>
				<input type='checkbox' name='resourceIdList' id='cb_22' onclick='doChecked("li_22", this.checked)'/>
				<label for='cb_22'><span class='folder' id='22'>火车时刻</span></label>
			</li>
			<li id='li_23'>
				<input type='checkbox' name='resourceIdList' id='cb_23' onclick='doChecked("li_23", this.checked)'/>
				<label for='cb_23'><span class='folder' id='23'>飞机航班</span></label>
			</li>
			<li id='li_24'>
				<input type='checkbox' name='resourceIdList' id='cb_24' onclick='doChecked("li_24", this.checked)'/>
				<label for='cb_24'><span class='folder' id='24'>邮编区号</span></label>
			</li>
			<li id='li_25'>
				<input type='checkbox' name='resourceIdList' id='cb_25' onclick='doChecked("li_25", this.checked)'/>
				<label for='cb_25'><span class='folder' id='25'>国际时间</span></label>
			</li>
		</ul>
	</li>
</ul>
</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageCoontext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageCoontext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	说明：<br />
	1，选中一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br />
	2，取消选择一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br />

	3，全选/取消全选。<br />
	4，默认选中当前岗位已有的权限。<br />
</div>

</body>
</html>
