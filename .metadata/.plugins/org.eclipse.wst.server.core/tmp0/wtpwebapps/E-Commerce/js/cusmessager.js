// JavaScript Document
//加载个人信息
$(document).ready(function(){
	Cus_SendRequest();
});
function Cus_CreateRequest(){
	var req=null;
	if(window.XMLHttpRequest)
		req=new XMLHttpRequest();
	else
		req=new ActiveXObject("Microsoft.XMLHTTP");
	
	return req;
}

发送请求
function Cus_SendRequest(){
	
	request=Cus_CreateRequest();
	request.open("GET","http://localhost:8080/E-Commerce/CusSelf",true);
	request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	request.onreadystatechange=Cus_parseRequest;
	request.send();
}
//解析请求
function Cus_parseRequest(){
	if(request.status==200&&request.readyState==4){
		alert(request.responseText);
		
		var cusself=JSON.parse(request.responseText);
		if(cusself.status){
			var cus_msg=cusself.message;
			$("#cusname").html(cus_msg.cusname);
			$("#cuspassword").html(cus_msg.cuspassword);
			if(cus_msg.cussex=="1"){
				$("#cussex").html("男");
			}else if(cus_msg.cussex=="2"){
				$("#cussex").html("女");
			}else{
				$("#cussex").html("保密");
			}
			$("#cusyear").html(cus_msg.cusyear);
			$("#custele").html(cus_msg.custele);
		}
		else
			alert(cusself.detail);
	}		
}

function ensure(){
	var ensure=confirm("是否修改信息？");
	
	if(ensure==true){
		CusAlter_SendRequest();
		alert("修改成功！");
	}
	else{
		alert("未进行修改！");
	}
}

function CusAlter_SendRequest(){
	request=Cus_CreateRequest();
	request.open("POST","http://localhost:8080/E-Commerce/CusAlter",true);
	request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	request.onreadystatechange=CusAlter_parseRequest;
	request.send(CreatCusParams());
}


function CreatCusParams(){
	var password=document.getElementById("cuserpassword2").value;
	var sex=document.getElementById("cusersex2").value;
	var year=document.getElementById("cuseryear2").value;
	var tele=document.getElementById("cusertele2").value;
	alert("password="+password+"&sex="+sex+"&year="+year+"&tele="+tele);
	return "password="+password+"&sex="+sex+"&year="+year+"&tele="+tele;
}
//解析请求
function CusAlter_parseRequest(){
	if(request.status==200&&request.readyState==4){
		alert(request.responseText);
		var cusalterself=JSON.parse(request.responseText);
		if(cusalterself.status){
			alert(cusalterself.detail);
			location.reload(); 
		}else{
			alert(cusalterself.detail);
		}
	}		
}
