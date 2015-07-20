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
		<!--<link href='http//fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>-->
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
			<div class="login">
				 <p class="about-title">Information Edit</p>
					<div class="wrap">
	                     <div class="row-fluid">
			                   <form id="signupForm" action="RegistAction" method="post">
			                        <fieldset id="signupbody">
			                            <fieldset>
			                                <label for="name">Doctor Name <span>*&nbsp;&nbsp;&nbsp;6~12 characters</span></label>
			                                <div id="msg_name3"></div>
			                                <input type="text" name="doctor.name" id="name" />
			                            </fieldset>
			                            <fieldset>
			                                <label for="gender">Gender <span>*</span></label>
			                                <div class="sexCheckBox">
				                                <input type="radio" value="0" name="doctor.gender">male
				                                <input type="radio" value="1" name="doctor.gender">female
			                                </div>
			                               <!--  <input type="text" name="doctor.gender" id="gender" /> -->
			                            </fieldset>
			                            <fieldset>
			                                <label for="birthday">BirthDay<span>*&nbsp;&nbsp;&nbsp;yyyy-mm-dd</span></label>
			                                <div id="msg_birth"></div>
			                                <input type="text" name="doctor.birth" id="birthday" />
			                            </fieldset>
			                            <fieldset>
			                                <label for="job">Job<span></span></label>
			                                <div id="msg_job"></div>
			                                <input type="text" name="doctor.job" id="job" />
			                            </fieldset>
			                            <fieldset>
			                                <label for="phoneNum">PhoneNumber<span>*&nbsp;&nbsp;&nbsp;number</span></label>
			                                <div id="msg_phoneNum"></div>
			                                <input type="text" name="doctor.phoneNum" id="phoneNum" />
			                            </fieldset>
			                             <fieldset>
			                                <label for="introduction">Introduction<span>*&nbsp;&nbsp;&nbsp;</span></label>
			                                <div id="msg_intro"></div>
			                                <input type="text" name="doctor.introduction" id="introduction" />
			                            </fieldset>			                            
			                            <input type="button" id="signup" value="Edit Now!" />
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
		<div class="footer">
	   	    <jsp:include page="commons/footer.jsp"></jsp:include>   
		</div>
	 <div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
	</body>
</html>