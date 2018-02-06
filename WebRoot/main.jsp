<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>主页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script language="javascript" type="text/javascript" src="js/javascript.js"></script>
</head>
<script language="javascript" type="text/javascript" src="js/zimu.js"></script>

<body onLoad="glowtext()"onResize="fix()"onScroll="fix()" >
	<div id="wrap">
	<div id="header">
		<div  align="center" id="glowdiv" style="position:absolute; visibility:visible; width:649px; text-align:center; top:6px; font-family:隶书; font-size:30pt; color:000000; height: 60px; right:150px;">  
</div>
	</div>
	<div class="clear"></div>
      <div id="top">
	  	<div class="clear"></div>
			<ul id="nav2">
				<li><a href="#">主页</a></li>
				<li><a href="ModifyServlet">修改个人信息</a></li>
				<li><a href="ViewServlet">查看个人信息</a></li>
				<li><a href="passwordmodify.jsp">修改密码</a></li>
				<li><a href="AddServlet">添加影片信息</a></li>
				<li><a href="MyOrderServlet">我的订单</a></li>
				
		</ul>
	  </div>
	  <div class="clear"></div>
	  
      <div id="content">	  
        <div id="sub"><!-- 右浮动-->
	         <p align="center">西科大影城</p>
		   		<img style="margin-left: -35.0px" src="images/002.jpg"/>
        </div>
		   <div id="sub2">
				<hr>
				<p align="center"><font size="6" color="blue">
				欢迎您<%=session.getAttribute("userName")%>进入本系统
				</font></p>
				<hr>
		   		<p align="center">查询电影票信息</p>
		   		<form name="form1" method="post" action="QueryServlet" onSubmit="return check()">
					<table width="280"cellpadding="1" cellspacing="1" border="1" align="center">
						<tr>
							<td width="100" height="12" align="center">影片</td>
							<td  width="100" height="12"> <input name="fname" type="text"/></td>
						</tr>						
					</table>
					<p align="center">
						<input name="chaxun" type="submit" id="chaxun" value="查询">
					</p>
				</form>
        </div>		   
	  </div>
	  
	  <div class="clear"></div>
	  
      <div id="footer">
	  		<ul>
				<li><a href="#">保密和安全</a></li>
				<li><a href="#">联系我们</a></li>
				<li><a href="#">辅助功能</a></li>
				<li><a href="#">举报盗版</a></li>
				<li><a href="#cn">许可和商标</a></li>
				<li><a href="#">产品许可协议</a></li>
				<li><a href="#">发送反馈</a></li>
        	</ul>
        <div class="clear"></div>
		<center>
        <p id="copyright">版权所有 2018 周雷 <a href="#">保留所有权利</a>。</p>
        <p id="terms">使用此网站即表示您同意接受<a href="#">使用条款</a>。</p>
        <p id="searchengine">由 <a href="#" target="new">Baidu</a> 提供搜索支持<br>
            英文网页</p>
		</center>
    </div>
	  
	  </div>
	</div>
</body>
</html>
