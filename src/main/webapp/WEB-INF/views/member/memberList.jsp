<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	
	<div class="container">
		<div class="row">
			<h1>Member List</h1>
			
			 <form class="col-xs-6" action="./memberList">
			    <div class="input-group">
			    
			    <select class="form-control" id="sel1" name="kind">
				    <option value="mi">ID</option>
				    <option value="mn">Name</option>
				    <option value="mp">Phone</option>
				    <option value="me">Email</option>
				</select>
			    
			      <input type="text" class="form-control" placeholder="Search" name="search">
			      <div class="input-group-btn">
			        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      </div>
			    </div>
		  	</form>
			
			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
					</tr>
				</c:forEach>
				
			</table>
			
			<div>
				<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
				<li><a href="./memberList?curPage=${pager.startNum-1}">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="ii">
					<li><a href="./memberList?curPage=${ii}">${ii}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
				<li><a href="./memberList?curPage=${pager.lastNum+1}">다음</a></li>
				</c:if>
				</ul>
			</div>
	
	
			<div>
				<a href="./memberWrite" class="btn btn-danger">WRITE</a>
			</div>
			
		</div>
	</div>

</body>
</html>