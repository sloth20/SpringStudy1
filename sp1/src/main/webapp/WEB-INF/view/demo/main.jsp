<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="<%=cp%>/demo/request">확인1</a>
	</p>
	<p>
		<a href="<%=cp%>/demo/request?a=20">확인2</a>
	</p>
	<p>
		<a href="<%=cp%>/demo/request?a=20&gender=m">확인3</a>
	</p>


</body>
</html>