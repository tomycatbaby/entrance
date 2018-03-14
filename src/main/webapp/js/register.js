$(function(){
	$('#Rusername').focus().blur(checkName);
	$('#Rpassword').blur(checkPassword);
	$('#Rrepassword').blur(checkRePassword);
});

function checkName(){
	var name = $('#Rusername').val();
	if(name == null || name == ""){
		//提示错误
		$('#Rcount-msg').html("用户名不能为空");
		return false;
	}
	$('#Rcount-msg').empty();
	return true;
}

function checkPassword(){
	var password = $('#Rpassword').val();
	if(password == null || password == ""){
		//提示错误
		$('#Rpassword-msg').html("密码不能为空");
		return false;
	}
	
	$('#Rpassword-msg').empty();
	return true;
}
function checkRePassword(){
	var password = $('#Rpassword').val();
	var Repassword = $('#Rrepassword').val();
	if(password != Repassword){
		$('#Rrepassword-msg').html("两次密码不一样");
		return false;
	}
	$('#Rrepassword-msg').empty();
	return true;
}