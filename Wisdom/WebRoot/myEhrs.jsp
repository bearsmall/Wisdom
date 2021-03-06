<%@page import="com.wh.service.DoctorService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@page import="com.wh.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- <link href='http//fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'> -->
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
		<link href="css/my.css" rel="stylesheet" type="text/css" media="all" />
		<script src="js/jquery.min.js"></script>
		<!---start-login-script--->
		<script src="js/login.js"></script>
			<!---//End-login-script--->
			<!-----768px-menu----->
			<link type="text/css" rel="stylesheet" href="css/jquery.mmenu.all.css" />
			<script type="text/javascript" src="js/jquery.mmenu.js"></script>
				<script type="text/javascript">
					//	The menu on the left
					$(function() {
						$('nav#menu-left').mmenu();
					});
		</script>
		<!-----//768px-menu----->
	</head>
	<body>
	<div class="content">
		<!------start-768px-menu---->
				<div id="page">
						<div id="header">
							<a class="navicon" href="#menu-left"> </a>
						</div>
						<jsp:include page="commons/navigate.jsp"></jsp:include>
				</div>
			<!------end-768px-menu---->
				<!---start-header---->
				<div class="header">
			   <!---start-wrap---->
			   
					
				<div class="wrap">
				<div class="header-left">
					<div class="logo">
						<a href="index.jsp"><img src="images/logo.jpg"/></a>
					</div>
				</div>
				
				<%
					User user = (User)session.getAttribute("user");
					if (user != null) {
			    %>
					<div class="header-right">
					<div class="sign-ligin-btns">
						<ul>
		
							<li id="loginContainer"><a class="login" id="loginButton" href="#"><span>${user.username }</span></a>
								 <div class="clear"> </div>
								 <!-- Login Ends Here -->
							</li>
							<li id="signupContainer"><a class="signup" id="signupButton" href="LogoutAction"><span>LOGOUT</span></a>
								 <div class="clear"> </div>
					            <!-- Login Ends Here -->
							</li>
						</ul>
					</div>
					</div>
				
				<%
					}else{
					
				 %>
					<div class="header-right">
					<div class="sign-ligin-btns">
						<ul>
		
							<li id="loginContainer"><a class="login" id="loginButton" href="login.jsp"><span>LOGIN</span></a>
								 <div class="clear"> </div>
								 <!-- Login Ends Here -->
							</li>
							<li id="signupContainer"><a class="signup" id="signupButton" href="register.jsp"><span>SIGNUP</span></a>
								 <div class="clear"> </div>
		
					            <!-- Login Ends Here -->
							</li>
						</ul>
					</div>
					</div>
				 <%
				 		
				 	}
				  %>
				<div class="clear"> </div>
				<div class="clear"> </div>
			</div>
			
				</div>
				<div class="wrap">
					<div class="section-title">
		            </div><!--section-title-->
				</div>
			</div>
	<div class="main_bg">
		 <p class="about-title">EHR List</p>
	<div class="wrap">
	 <div >
	 	<!-- start main_content -->
		<div class="rsidebar span_1_of_3">	               
	               
				 	<div class="Categories">
					 	<ul class="sidebar">
					 		<c:forEach items="${ehrList}" var="ehr" varStatus="status">
					 			<div class="hover">
					 				<div style="float:right;">
					           			<a href="#"><img alt="" src="images/EHR44.png"></a>
					           		</div>
					           		<div style="float:left;">
					 					<li><a href="ehrInfo.jsp">${ehr.ID }&nbsp;&nbsp;${ehr.doctorName}&nbsp;&nbsp;${ehr.createTime}</a></li>
					 				</div>
					 			</div>
					 		</c:forEach>
				        </ul>
			        </div>
			</div>
		<div class="clear"></div>		
		<div class="clear"></div>
		<!-- end main_content -->
	</div>
	</div>
	<div class="wrap">
          <div class="row-fluid">

          </div>
          <div class="row-fluid">

          </div>
          <div class="row-fluid">

          </div>
          <div class="row-fluid">

          </div>
       </div> 
	</div>
	<!-- start footer -->
	<div class="footer">
	    <jsp:include page="commons/footer.jsp"></jsp:include>   
	</div>
	<div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
	</body>
</html>