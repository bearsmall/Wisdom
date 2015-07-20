<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wh.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'navigate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <nav id="menu-left">
			<ul>
			<li class="active"><a href="index.jsp">Home</a></li>
				<%
					User user = (User)session.getAttribute("user");
					if (user != null) {
						System.out.println("session:"+user.getType());
						if(user.getType().equals("0")){
						}else if(user.getType().equals("1")){
						}else if(user.getType().equals("2")){
						}else if(user.getType().equals("3")){
								// 显示个人信息
								out.print("<li><a href=\"DocPerInfoAction\">Personal Information</a></li>");
								// 我的病人
								out.print("<li><a href=\"myPatientsAction\">My Patients</a></li>");
								// 显示我的预约
								out.print("<li><a href=\"doc_ReservationManage.jsp\">Reservations</a></li>");
						}else if(user.getType().equals("4")){
								// 显示个人信息
								out.print("<li><a href=\"PatPerInfoAction\">Personal Information</a></li>");
								// 显示个人电子病历
								out.print("<li><a href=\"EHRInfoAction\">Personal EHR</a></li>");
								// 显示我的预定信息
								out.print("<li><a href=\"pat_Reservations.jsp\">Reserve</a></li>");
								// 显示我的提醒
								out.print("<li><a href=\"reminderAction\">My Reminder</a></li>");
						}
					}
				 %>
			 	<li><a href="drugSearch.jsp">Search</a></li> <!-- 查询药品 -->
			 	<li><a href="scanQRCodeAction">Scan QR Code</a></li> <!-- 扫描二维码 -->
			 	<li><a href="community.jsp">Community</a></li> <!-- 社区新闻 -->
				<div class="clear"> </div>
			</ul>
		</nav>
  </body>
</html>
