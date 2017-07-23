<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
				 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
<%-- <form id="form1" action="${ctx }/user/login" method="post"> --%>
<form id="form1" method="post">
	<div>
		<input name="name" type="text" id="loginName" placeholder="username" />
	</div>
	<div>
		<input name="password" type="password" id="password" placeholder="password" />
	</div>
	<!-- <button type="submit">login</button> -->
	<button id="loginBtn">login</button>
	</form>
</body>


<script type="text/javascript" src="${ctx }/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	
$(function(){

    $("#loginBtn").click(function() {
        if (checkLogin()) {
            $.ajax({
                url: "${ctx}/user/login",
                method: "post",
                data : $('#form1').serialize(),
				dataType: "json",
                success : function(result){
                    console.log(result);
                    if(result.code == 1){
                    	alert(result.msg);
/*                         window.location.href = "${ctx}/user/toIndex";
 */                    }
                    if(result.code == 0){
                    	alert(result.msg)
                    }
                }
            });
		}
	});
});

function checkLogin(){
    var loginName = $('#loginName').val();
    var password = $('#password').val();
    console.log("ç»å½ï¼",loginName,password);
    if(loginName == null || $.trim(loginName) == ''){
        if(password == null ||  $.trim(password) == ''){
            return false;
        }else{
            return false;
        }
    }else{
        if(password == null || $.trim(password) == ''){
        	return false;
        }else{
            return true;
        }
    }
}
</script>
</html>