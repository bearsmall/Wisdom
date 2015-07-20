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
		
			<div class="login">
				 <p class="about-title">Reservate Now</p>
					<div class="wrap">
	                     <div class="row-fluid">
			                   <form id="signupForm" action="" method="post">
			                        <fieldset id="signupbody">
					                     <fieldset>
					                         <label for="hospital">Hospital <span>*<a href="#">More</a></span></label><br/>
					                         <select style="width:100%" name="hospital.type">
					                         	<option value="WUHAN ZHENAI MATERNITY HOSPITAL">WUHAN ZHENAI MATERNITY HOSPITAL</option>
												<option value="WUHAN CITY MATERNITY HOSPITAL">WUHAN CITY MATERNITY HOSPITAL</option>
												<option value="WUHAN MODERN WOMAN HOSPITAL">WUHAN MODERN WOMAN HOSPITAL</option>
												<option value="TONGJI MEDICAL COLLEGE OF HUST">TONGJI MEDICAL COLLEGE OF HUST</option>
												<option value="WUHAN INTEGRATED TCM & WESTERN MEDICINE HOSPITAL">WUHAN INTEGRATED TCM & WESTERN MEDICINE HOSPITAL</option>
												<option value="HUBEI GENERAL HOSPITAL">HUBEI GENERAL HOSPITAL</option>
												<option value="HUBEI PROVINCIAL HOSPITAL OF TCM">HUBEI PROVINCIAL HOSPITAL OF TCM</option>
												<option value="WUHAN RENAI HOSPITAL">WUHAN RENAI HOSPITAL</option>
												<option value="THE CENTRAL HOSPITAL OF WUHAN">THE CENTRAL HOSPITAL OF WUHAN</option>
												<option value="HOSPITAL OF STOMATOLOGY WUHAN UNIVERSITY">HOSPITAL OF STOMATOLOGY WUHAN UNIVERSITY</option>
																	                         	
												</select>
					                        <!--  <input type="text" name="user.gender" id="gender" /> -->
					                     </fieldset>
					                     <fieldset>
					                         <label for="department">Department <span>*<a href="#">More</a></span></label><br/>
					                         <select style="width:100%" name="hospital.type">
												  <option value="Pediatrics department">Pediatrics department</option>
													<option value="Obstetrics and gynecology department">Obstetrics and gynecology department</option>
													<option value="Ophtalmology department">Ophtalmology department</option>
													<option value="Dental department">Dental department</option>
													<option value="ENT(ear-nose-throat) department">ENT(ear-nose-throat) department</option>
													<option value="Skin department">Skin department</option>
													<option value="Plastic surgery">Plastic surgery</option>
													<option value="Orthopedics department">Orthopedics department</option>
													<option value="Neurology department">Neurology department</option>
													<option value="Hematology department">Hematology department</option>

												</select>
					                        <!--  <input type="text" name="user.gender" id="gender" /> -->
					                     </fieldset>
					                     <fieldset>
					                         <label for="doctor">Doctor <span>*<a href="#">More</a></span></label><br/>
					                         <select style="width:100%" name="hospital.type">
												  <option value=""></option>
												  <option value="Mike">Mike</option>
													<option value="Marry">Marry</option>
												</select>
					                        <!--  <input type="text" name="user.gender" id="gender" /> -->
					                     </fieldset>
					                     <div class="sign_up sign_up1 ">
											<a href="pat_Reservations.jsp">Reservate Now</a>
										</div>
					                 </fieldset>
			                        
			                    </form>
	                         <div class="clear"> </div>
	                      </div> 
	                      <div class="team" id="team">
						<div class="clear"> </div>
					</div>
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