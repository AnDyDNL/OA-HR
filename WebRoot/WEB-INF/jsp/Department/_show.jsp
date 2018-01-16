<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/public/commons.jsp" %>
<html>
<head>
<title>������Ϣ</title>
<meta http-equiv=Content-Type content="text/html; charset=gbk" />
<script language="javascript" src="../js/jquery.js"></script>
<script language="javascript" src="../js/pageCommon.js"></script>
<script language="javascript" src="../js/general.js"></script>
<link href="../style/blue/cn_mainWin.css" type=text/css  media=screen rel=stylesheet />
<link href="../style/blue/query.css" type=text/css  media=screen rel=stylesheet />
<link href="../style/blue/comm_mainWin.css" type=text/css  media=screen rel=stylesheet />
<base target="_self" />
<script type="text/javascript">
</script>
</head>
<body marginwidth="0" topmargin="0" leftmargin="0" marginheight="0">
<div id=Title_bar>
    <div id=Title_bar_Head>
        <div id=Title_Head></div>
        <div id=Title>
            <!--ҳ�����-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif" /> ������Ϣ��ʾ </div>
        <div id=Title_End> </div>
    </div>
    <div id=Title_bar_bg_up>
        <div id=Title_bar_bg> </div>
    </div>
    <!--��ز����б�-->
    <div id=Title_bar_Tail>
        <div id=Title_FuncBar>
            <ul  style="margin:0;">
                <li class=line ></li>
                <li class=title>
                    <div class="Btn"> <a href="javascript: history.go(-1)">����</a> </div>
                </li>
                <li class=line></li>
            </ul>
        </div>
    </div>
</div>
<!--��ʾ�?����-->
<div id=MainArea>
    <center>
            <div class=ItemBlock_Title1>
                <!--��Ϣ˵��
                <img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" /> ������Ϣ--></div>
            <div class=ItemBlockBorder>
                <div class=ItemBlock>
                    <table border=0 cellpadding=0 cellspacing=0 width=80% style="margin-left: 50px;">
                        <tr height=25>
                            <td width=100 height=22>�ϼ�����</td>
                            <td><input type="text" class="InputStyle" readonly="true" value="�ܾ�����"/></td>
                        </tr>
                        <tr height=25>
                            <td width=100 height=22>�������</td>
                            <td><input type="text" class="InputStyle" readonly="true" value="�г���"/></td>
                        </tr>
                        <tr>
                            <td>ְ��˵��</td>
                            <td><textarea class="TextareaStyle" readonly="true">xxxxxxxx</textarea></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id=InputDetailBar>
                <table border=0 cellspacing=0 cellpadding=10 align=center>
                    <tr>
                        <td><div onClick="history.go(-1);" class="FuncBtn">
                                <div class=FuncBtnHead></div>
                                <div class=FuncBtnMemo>����</div>
                                <div class=FuncBtnTail></div>
                            </div></td>
                    </tr>
                </table>
            </div>
        
    </center>
</div>
</body>
</html>
