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
<title>unauthorized</title>
</head>
<body>
<h4>Unauthorized</h4>
${sessionScope.currentUser.name}，你没权限！<br></br>

</body>

<script type="text/javascript" src="${ctx }/resources/js/jquery-1.11.3.js"></script>
<script type="text/javascript">

</script>
</html>