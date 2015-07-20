<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.wh.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- <link href='http//fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'> -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
			
			
			<div class="clear"> </div>
		</div>
		<div class="wrap">
			<div class="section-title">
            </div><!--section-title-->
		</div>
	</div>
	<div class="mid_bg">
		 <p class="about-title">Drug Information</p>		 	
			<div class="wrap">
                           <div class="row-fluid">

                               <div class="row_side-left">
                                   <div class="skills">
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Drug Name</p>
                                           <p class="flx-skill-content">Amoxicillin</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Drug AnoName</p>
                                           <p class="flx-skill-content">Amoxil, Moxatag, Trimox, Wymox, Amoxil Pediatric Drops, Biomox, Amoxicot, Moxilin, Dispermox</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Drug Type</p>
                                           <p class="flx-skill-content">Capsule</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                   </div>
                               </div>

                               <div class="row_side-right">
                                   <div class="skills">
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Drug Specifi</p>
                                           <p class="flx-skill-content">1.Adult:500 mg orally 3 times a day or 875 mg orally twice a day for six months2.Pediatric:50 mg/kg orally as a single dose 1 hour prior to procedure</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Press Or Not</p>
                                           <p class="flx-skill-content">not Press</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Drug CreateTime</p>
                                           <p class="flx-skill-content">2015-5-10</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                   </div>
                                  </div>
                               <div class="clear"> </div>
                           </div> 
                           <div class="team" id="team">

				 		<div class="middle-grids">
							<div class="grid_1_of_4 images_1_of_4">
					 			<h3>Drug Description</h3>
					 			<p>To reduce the development of drug-resistant bacteria and maintain the effectiveness of Amoxicillin and other antibacterial drugs, Amoxicillin should be used only to treat infections that are proven or strongly suspected to be caused by bacteria. When culture and susceptibility information are available, they should be considered in selecting or modifying antibacterial therapy. In the absence of such data, local epidemiology and susceptibility patterns may contribute to the empiric selection of therapy.</p>
							</div>
							
							 <div class="clear"> </div>
					</div>
					<div class="middle-grids">
							<div class="grid_1_of_4 images_1_of_4">
					 			<h3>Drug QRCode</h3>
				 			</div>
		 			</div>
					<div class="rqimage">		 			
					<img alt="" src="images/drug280.png">
		 			</div>
		 		</div>
	</div>        
</div>
	<div class="footer">
   	    <jsp:include page="commons/footer.jsp"></jsp:include>
   </div>
	<div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>