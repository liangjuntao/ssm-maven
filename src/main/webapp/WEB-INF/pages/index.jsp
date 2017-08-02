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
<!-- <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>
<h4>Index Page</h4>
${sessionScope.currentUser.name}，欢迎登录！<br></br>

<c:forEach items="${menus.menu }"  var="menu">
		<li>
			${menu.name}
			<c:if test="${menu.childMenus !=null }">
				<c:forEach items="${menu.childMenus }" var="childList">
				<ul>
					${childList.name}
				</ul>
				</c:forEach>
			</c:if>
		
		</li>
</c:forEach>


<button id="logout" >退出登录</button>
</body>

<script type="text/javascript" src="${ctx }/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript">

$(function(){
	
	console.log("${menus}");
	console.log("${menus.childMenus}");
	

    $("#logout").click(function() {
      
            $.ajax({
                url: "${ctx}/user/logout",
                method: "post",
				dataType: "json",
                success : function(result){
                    console.log(result);
                    if(result.code == 1){
                         window.location.href = "${ctx}/login.jsp";
                    }
                    if(result.code == 0){
                    	alert(result.msg)
                    }
                }
            });
		})
});

</script>
</html>