<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加影片信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script>
	function check(){
		var f = document.form1;
		//判断票价
		if(f.piaojia.value == "")
		{
			alert("票价不能为空！");
			return false;
		}
		if(f.piaojia.value.subString(0,1) == " ")
		{
			alert("第一位不能为空！");
			return false;
		}
		if(isNaN(f.piaojia.value) == ture)
		{
			alert("票价必须为数字！");
		}
		//判断剩余票数
		if(f.shengyu.value == "")
		{
			alert("票数不能为空！");
			return false;
		}
		if(f.shengyu.value.subString(0,1) == " ")
		{
			alert("第一位不能为空！");
			return false;
		}
		if(isNaN(f.shengyu.value) == ture)
		{
			alert("票数必须为数字！");
		}
	}
	</script>

  </head>
  <body  background="images/003.jpg">
	<center>
	<p>&nbsp;</p>
	<p align="center" class="style1">添加影片信息</p>
	<hr>
			<%
				String message = (String)session.getAttribute("message");
			%>
				<font size="5" color="#FF0000"><%=message%></font>
	</center>
	<center>
    <form name="form1" method="post" action="AddFilmServlet" onSubmit="return check()">
					<table width="280"cellpadding="1" cellspacing="1" border="1" align="center">
						<tr>
							<td width="100" height="12" align="center">&nbsp;影片名</td>
							<td>
								<div align="center">
									<input type="text" name="fname" id="fname">
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">导演</td>
							<td>
								<div align="center">
									<input type="text" name="fdirector" id="fdirector">
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">主演</td>
							<td>
								<div align="center">
									<input type="text" name="fmactor" id="fmactor">
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">时长</td>
							<td>
								<div align="center">
									<input type="text" name="shijian" id="shijian">
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">票价</td>
							<td>
								<div align="center">
									<input type="text" name="piaojia" id="piaojia">
								</div>
							</td>
						</tr>
						<tr>
							<td width="100" height="12" align="center">剩余票数</td>
							<td>
								<div align="center">
									<input type="text" name="shengyu" id="shengyu">
								</div>
							</td>
						</tr>						
					</table>
					<p align="center">
						<input name="tianjia" type="submit" id="tianjia" value="添加">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="fanhui" type="button" id="fanhui" value="返回" onclick="back()">
					</p>
				</form>
		</center>
  </body>
</html>
<script type="text/javascript">
function back(){
	var frm = form1;
	frm.action = "main.jsp";
	frm.submit();
	return;
}
</script>
