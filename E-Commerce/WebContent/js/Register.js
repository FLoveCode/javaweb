/**
 * 注册
 */
//弹出注册框
function openRegister(){
$('body').css("overflow","hidden")
var upRegister = document.getElementById("registercontainer");
upRegister.style.display = "block";
}
//关闭注册框
function closeRegister(){
	$('body').css("overflow","visible")
	var cRegister = document.getElementById("registercontainer");
	cRegister.style.display="none";
}

//创建注册参数
function CreateRegisterParamter(){
	
	var Ruesrid=document.getElementById("Ruserid").value;
	var Ruserpwd=document.getElementById("Ruserpwd").value;
	var confirm=document.getElementById("confirm").value;
	var Rusername=document.getElementById("Rusername").value;
	var Rusertele=document.getElementById("Rusertele").value;
	
	alert(Ruesrid);
}
