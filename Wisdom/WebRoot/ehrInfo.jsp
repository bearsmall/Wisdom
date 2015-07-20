<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		 <p class="about-title">EHR Details</p>
			<div class="wrap">
                           <div class="row-fluid">

                               <div class="row_side-left">
                                   <div class="skills">
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Case number</p>
                                           <p class="flx-skill-content">000003</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Patient Name</p>
                                           <p class="flx-skill-content">Tom</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Patient Sex</p>
                                           <p class="flx-skill-content">Male</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Patient Age</p>
                                           <p class="flx-skill-content">24</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Diagnosis stage</p>
                                           <p class="flx-skill-content">first visit</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                   </div>
                               </div>

                               <div class="row_side-right">
                                   <div class="skills">
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Operation Or Not</p>
                                           <p class="flx-skill-content">No</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Transfer Or Not</p>
                                           <p class="flx-skill-content">No</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Doctor Name</p>
                                           <p class="flx-skill-content">Mike</p>
                                           <div class="progress-bar flexible animate"> <span class="progress-100" style="width: 100%"><span> </span></span> </div>
                                           <div class="clear"> </div>
                                       </div>
                                       <div class="flx-skill">
                                           <p class="flx-skill-title">Diagnostic time</p>
                                           <p class="flx-skill-content">2015-7-11</p>
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
					 			<h3>Symptoms</h3>
					 			<p>Accompanied by a temperature rise of fatigue, weakness, muscle pain, pale skin, chills or chills and other phenomena. Pale skin because of the thermoregulatory center impulses emitted by the sympathetic cause skin vasoconstriction, reducing blood flow due to the shallow, even with the skin temperature drops. Because the skin cooling reduces irritation of the skin and spread to the central cold sensation receptor causes chills. Central impulses emitted by the motor is transmitted to then motor endplates, cyclical involuntary skeletal muscle contractions, shivering and vertical hair muscle contraction, so that heat production is increased. The heat of the heat so that the temperature rise is greater than.</p>
							</div>
							<div class="grid_1_of_4 images_1_of_4">
								 <h3>Check range</h3>
								 <p>Measuringbody temperature</p>
							</div>
							<div class="grid_1_of_4 images_1_of_4">
							 	<h3>Diagnosis result </h3>
                                   <p>Due tothe action ofpyrogentemperatureset pointmoveonthe regulationcaused byhyperthermia(over0.5 ℃),also known asfever</p>
							</div>
                               <div class="grid_1_of_4 images_1_of_4">
                                   <h3>Doctor advice </h3>
                                   <p>Fever people's clothes do not wear too much, do not cover too thick quilt, so as not to affect the body heat dissipation. Fever in children with fever in the process, to a lot of sweat, then use a hot towel to wipe the chest, back, armpit sweat and denominations portion, and the timely replacement of underwear; Note added nutrients and moisture. Fever nutrients and water consumption increased, and digestive dysfunction, and should therefore be appropriate to reduce diet, eat nutritious and digestible liquid food or semi-liquid food, such as milk, rice, noodle soup, ravioli, etc; as much watering fruit juice, sugar, boiled water or soft drinks and the like; more water is not only beneficial to cool, but also helps the bacteria excrete toxins.</p>
                               </div>
                               <div class="grid_1_of_4 images_1_of_4">
                                   <h3>Drugs </h3>
                                   <p>Metamizole Sodium Tablets</p>
                                   <p>aspirin</p>
                               </div>

								<div class="rqimage">		 			
								<img alt="" src="images/EHR280.png">
					 			</div>	
							 <div class="clear"> </div>
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