<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
				<!-- start main -->
			<div class="mid_bg">
				 <p class="about-title">Personal Information</p>
			<div class="wrap">
					<div class="details">
						<h3 class="infomation">Name:<span class="doctorInfo">${doctor.name }</span></h3>
						<h3 class="infomation">Gender:<span class="doctorInfo">${doctor.gender }</span></h3>
						<h3 class="infomation">Birthday:<span class="doctorInfo">${doctor.birthday }</span></h3>
						<h3 class="infomation">Job:<span class="doctorInfo">${doctor.job }</span></h3>
						<h3 class="infomation">PhoneNumber:<span class="doctorInfo">${doctor.phoneNum }</span></h3>
						<h3 class="infomation">Introduction:</h3>
						<div class="det_text">
							<p class="para">${doctor.introduction }</p>	
							
							<div class="rqimage">		 			
							<img alt="" src="images/${doctor.ID }ID280.png">
				 			</div>						
							<div class="sign_up sign_up1 ">
								<a href="doctorInfoEdit.jsp">Edit</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
			</div>
			</div>
			<div class="footer">
	   	    <div class="wrap">
	   	    	<div class="footer-left">
					<div class="copy">
				       <p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http//www.zjf88.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			        </div>
				</div>
				<div class="social_icons">	
		           <ul>
						<li class="in"><a href="#"><span> </span></a></li>
						<li class="pro"><a href="#"><span> </span></a></li>
						<li class="twitter"><a href="#"><span> </span></a></li>
						<li class="facebook"><a href="#"><span> </span></a></li>
						<div class="clear"> </div>
					</ul>
			   </div>
			   <div class="clear"> </div>
		    </div>
	
	   </div>

	<div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
	</body>
</html>
