var nameFlag = false;
var phoneFlag = false;
var emailFlag = false;
function validateName(obj) {
	var name_message = document.getElementById("user_message");
	if (obj.value == null || obj.value == "") {
		name_message.innerHTML = "<font color='red'>用户名不能为空</font>";
		nameFlag = false;
	} else {
		nameFlag = true;
		name_message.innerHTML = "<img height='25px' src='./style/blue/images/right.png' />";
	}
}

function checkMobile(str) {
	var phone_message = document.getElementById("phone_message");
	//先判断不为空
	if (str.value == null || str.value == "") {
		phoneFlag = true;
		phone_message.innerHTML = "<font color='red'>手机号不能为空</font>";
		return false;
	}
	var phoneReg = /^1[3-578]\d{9}$/;
	if (!phoneReg.test(str.value)) {
		phoneFlag = true;
		phone_message.innerHTML = "<font color='red'>手机格式错误</font>";
	}
	 else {
		phoneFlag = false;
		phone_message.innerHTML = "<img height='25px' src='./style/blue/images/right.png' />";
	}
}
function checkEmail(str) {
	var email_message = document.getElementById("email_message");
	if (str.value == null || str.value == "") {
		emailFlag = true;
		email_message.innerHTML = "<font color='red'>邮箱不能为空</font>";
		return false;
	}
	var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	if (!mailReg.test(str.value)) {
		emailFlag = true;
		email_message.innerHTML = "<font color='red'>邮箱格式错误</font>";
	} else {
		emailFlag = false;
		email_message.innerHTML = "<img height='25px' src='./style/blue/images/right.png' />";
	}
}
function validateAll() {
	if (nameFlag == false || emailFlag == false || phoneFlag == false) {
		alert("表单不和法,提交失败");
		return false;
	} else {
		return true;
	}
}
