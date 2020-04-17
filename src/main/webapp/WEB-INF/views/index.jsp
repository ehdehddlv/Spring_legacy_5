<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./template/boot.jsp"></c:import>

</head>
<body>
	<!-- import는 경로를 WEB-INF/views 까지를 루트라고 생각하고 주소를 입력해야함 -->
	<c:import url="./template/header.jsp"></c:import>

	<h1>Add Point Branch</h1>
	<% config.getInitParameter(""); %>
</body>
</html>