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

var request;
var select_identity;

//检测账号
function CheckName(){
	if(document.getElementById("Rusername").value>20)
		alert("请输入有效的账号");
}

//检测密码
function CheckPassword(){
	
	var Ruserpwd=document.getElementById("Ruserpwd").value;
	var pwd_confirm=document.getElementById("pwd_confirm").value;
	
	if(Ruserpwd.length>0)
		if(Ruserpwd!=pwd_confirm){
			alert("密码错误，请重新填写密码");
			document.getElementById("bn_register").setAttribute("type", "hidden");
		}
		else{
			document.getElementById("bn_register").setAttribute("type", "button");
		}
}

//检测电话号码
function CheckTele(){
	
	if(document.getElementById("Rusertele").value.length!=11)
		alert("请输入有效的电话号码！！");
}

function getIdentity(){
	
	return select_identity=document.getElementById("select_identity").value;
}

//创建注册请求
function CreateRegisterRequest(){
	var req=null;
	
	if(window.XMLHttpRequest)
		req=new XMLHttpRequest();
	else
		req=new ActiveXObject("Microsoft.XMLHTTP");
	
	return req;
}

//创建注册参数
function CreateRegisterParamter(){
	
	
	//账号
	var Rusername=document.getElementById("Rusername").value;
	//密码
	var Ruserpwd=document.getElementById("Ruserpwd").value;
	//电话号码
	var Rusertele=document.getElementById("Rusertele").value;
	//性别
	var select_sex=document.getElementById("select_sex").value;
	//注册身份
	select_identity=document.getElementById("select_identity").value;
	
	
	if(select_identity==1){
		alert("cusname="+Rusername+"&cuspassword="+Ruserpwd+"&custele="+Rusertele+"&cussex="+select_sex);
		return "cusname="+Rusername+"&cuspassword="+Ruserpwd+"&custele="+Rusertele+"&cussex="+select_sex;
	
	}
		else{
		alert("mername="+Rusername+"&merpassword="+Ruserpwd+"&mertele="+Rusertele+"&mersex="+select_sex);
		return "cusname="+Rusername+"&cuspassword="+Ruserpwd+"&custele="+Rusertele+"&cussex="+select_sex;
		}
	
}

//发送注册请求
function SendRegisterRequest(){
	
	request=CreateRegisterRequest();
	
	select_identity=getIdentity();
	
	alert(select_identity);
	
	if(select_identity==1)
		request.open("POST","http://localhost:8080/E-Commerce/DoCusRegister",true);
	else
		request.open("POST","http://localhost:8080/E-Commerce/DoMerRegister",true);
	request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	request.onreadystatechange=parseRegisterRequest;
	alert("你确定注册吗？");
	request.send(CreateRegisterParamter());
}

function parseRegisterRequest(){
	
	if(request.status==200&&request.readyState==4){
		
		alert(request.responseText);
		
//		var login_msg=JSON.parse(request.responseText);
//		
//		if(login_msg.Status){
//			var user_msg=login_msg.message;
//			var name=user_msg.username;
//			alert(name);
//			
//			var login_li=document.getElementById("login_li");
//			
//			login_li.innerHTML="<a >"+name+"</a>";
//			
//		}
//		else
//			alert(login_msg.detail);
//		
		closeLogin();
	}
	
}
