<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wh.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div class="main">
				<div class="wrap">
				<div class="main_left">
					<h2>Medical Wisdom Health Platform</h2>
					<p>All the main function of this platform is that using QR code to store patient information and using this information to judge whether the medicine taken by the patient reasonable,scanning QR code to get drug information and to obtain the flow of drugs.The platform’s purpose is to provide users a more convenient, safer medication environment.In addition, online registration、 querying the test,diseases and foods 、communication and feedback platform, measurement service modules are convenient for user's daily lives.</p>
					<div class="buttons">
						<div class="sign_up">
							<a href="register.jsp">SIGN UP</a>
						</div>
						<div class="learn">
							<a href="#" class="arrow_btn">LEARN MORE</a>
						</div>
							<div class="clear"> </div>
					</div>
				</div>
			<div class="main_right">
						<span> </span>
			</div>
			<div class="clear"> </div>
			<!---//End-header---->
			</div>
		</div>
	</div>
		<div class="buttom">
			<div class="wrap">
				<div class="top-grids">
					<div class="top-grid">
						<a href="#"><img src="images/icon2.png"/></a>
						<h3><a href="#">Store past medical records</a></h3>
						<p>The advantages of storing patients’ medical record information in qr code are not only that patients can look over his information or doctors can understand the patient's history comprehensively,but also the patient will be warned timely when he takes the wrong drug. </p>
					</div>
					<div class="top-grid">
						<a href="#"> <img src="images/icon1.png"/></a>
						<h3><a href="#">Monitor drug flow.</a></h3>
						<p>In every link of the drug distribution, different identities (business and personal) user scanning drug two-dimensional code will submits different information of drug flow to the server , which will be beneficial for tracking the drug flow and recalling the drug urgently.Consumers also can judge the authenticity of the drug by scanning qr code on the kit.</p>
						</div>
					<div class="top-grid">
						<a href="#"><img src="images/icon3.png"/> </a>
						<h3><a href="#">Other functions.</a></h3>
						<p>The modules this platform providing such as online registration、querying diseases and foods、measurement service are convenient for users’ daily lives.It also provides users a communication feedback platform to exchange each other.</p>
						</div>
					<div class="clear"> </div>
				</div>
			</div>
		</div>
		<div class="footer">
   	    	<jsp:include page="commons/footer.jsp"></jsp:include>
   		</div>
<div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
