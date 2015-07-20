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
				 <p class="about-title">SignUp</p>
					<div class="wrap">
	                     <div class="row-fluid">
			                   <form id="signupForm" action="RegistAction" method="post">
			                        <fieldset id="signupbody">
			                            <fieldset>
			                                <label for="name">User Name <span>*&nbsp;&nbsp;&nbsp;6~12 characters</span></label>
			                                <div id="msg_name2"></div>
			                                <input type="text" name="user.username" id="name" />
			                            </fieldset>
			                            <fieldset>
			                                <label for="idnum">ID Number <span>*</span></label>
			                                <div id="msg_idnum"></div>
			                                <input type="text" name="user.IDnum" id="idnum" />
			                            </fieldset>
			                            <fieldset>
			                                <label for="gender">Type <span>*</span></label><br/>
			                                <select style="width:90%" name="user.type">
											  <option value="4">Patient</option>
											  <option value="3">Doctor</option>
											  <option value ="2">Enterprise</option>
											  <option value ="1" >Department</option>
											</select>
			                               <!--  <input type="text" name="user.gender" id="gender" /> -->
			                            </fieldset>
			                            <fieldset>
			                                <label for="password">Choose Password <span>*&nbsp;&nbsp;&nbsp;6~12 characters</span></label>
			                                <div id="msg_password0"></div>
			                                <input type="password" name="user.password" id="signuppassword" />
			                            </fieldset>
			                             <fieldset>
			                                <label for="password1">Confirm Password <span>*&nbsp;&nbsp;&nbsp;6~12 characters</span></label>
			                                <div id="msg_password1"></div>
			                                <input type="password" name="user.checkPassword" id="signuppassword1" />
			                            </fieldset>
			                            <input type="button" id="signup" value="Register Now!" />
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