<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>




	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
		<a class="navbar-brand" href="${contextRoot}/comments/all">MoPet＞ω＜論壇</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-link active" href="${contextRoot}/comments/add">發布文章</a>
				<a class="nav-link active" href="${contextRoot}/replies/all">所有留言</a>
				<a class="nav-link active" href="${contextRoot}/replies/add">新增留言</a>
				<%--       <a class="nav-link active" href="${contextRoot}/">毛Pet●ω●</a> --%>
			</div>
		</div>
	</nav>





	<script src="${contextRoot}/js/jquery-3.6.0.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

</body>
</html>