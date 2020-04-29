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
	<button id="btn">BUTTON</button>
	<button id="btn2">BUTTON2</button>
	
	<script type="text/javascript">
		$("#btn2").click(function() {
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY", function(data) {
				console.log(data);
				console.log(data[1].rate);
			});
		});
	
	
	
		$("#btn").click(function() {
			
			$.get("./json/json1", function(data) {
				
				//0. data가 String 인지 Json Object인지 판별
				//console.log(data); 	"name":"iu" -> String
				//console.log(data); 	object -> json Object
				//만약 data가 Object이면 1번 안해도됌
				
				//1. String 이라면 Json Object 변환
				//data = data.trim();
				
				console.log(data);
				//key를 꺼냄
				console.log(data.num);
				console.log(data.title);
			});
			
			
		});
	</script>
</body>
</html>