// Login Form

$(function() {
	var form = $('#loginForm');
	var login = $('#login');

	login.on("click", function() {
		//if (loginValid() == true) {
			form.submit();
		//}
	});
});

$(function() {
	var form = $('#signupForm');
	var signup = $("#signup");

	signup.on("click", function() {
		//if (registerValid() == true) {
			form.submit();
		//}
	});

});
// 登陆校验
function loginValid() {
	document.getElementById("msg_password").innerHTML="";
	document.getElementById("msg_name").innerHTML="";
	var name = $("#name").val();
	var password = $("#password").val();
	if (name.length >= 6 && name.length <= 12) {
		if (password.length >= 6 && password.length <= 12) {
			return true;
		} else {
			document.getElementById("msg_password").innerHTML="&nbsp;&nbsp;6~12 字符";
			return false;
		}
	} else {
		document.getElementById("msg_name").innerHTML="&nbsp;&nbsp;6~12 字符";
		return false;
	}
}
// 注册校验
function registerValid() {
	document.getElementById("msg_name2").innerHTML="";
	document.getElementById("msg_idnum").innerHTML="";
	document.getElementById("msg_password0").innerHTML="";
	document.getElementById("msg_password1").innerHTML="";
	var name = $("#name").val();
	var idnum = $("#idnum").val();
	var password = $("#signuppassword").val();
	var password1 = $("#signuppassword1").val();
	
	if (name.length >= 6 && name.length <= 12) {
		if(validateIDNum(idnum)){
				if (password == password1) {
					if (password.length >= 6 && password.length <= 12) {
						return true;
					} else {
						document.getElementById("msg_password0").innerHTML="&nbsp;&nbsp;6~12 字符";
						return false;
					}
				} else {
					document.getElementById("msg_password0").innerHTML="&nbsp;&nbsp;两次输入的密码不同！";
					return false;
				}
		}else{
			document.getElementById("msg_idnum").innerHTML="&nbsp;&nbsp;格式不对！";
		}
		
	} else {
		document.getElementById("msg_name2").innerHTML="&nbsp;&nbsp;6~12 字符";
		return false;
	}
}
//身份证校验
function validateIDNum(id){
	var reg = /^\d{18}$/;
	return id.match(reg);
}
//日期校验
function validateTime(RQ) {
    var date = RQ;
    var result = date.match(/^(\d{4})(-|\/)(\d{2})\2(\d{2})$/);

    if (result == null)
        return false;
    var d = new Date(result[1], result[3] - 1, result[4]);
    return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);
}