<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
					<td><input type="checkbox" id="chAll"><button id="del" class="btn btn-danger">Delete</button> </td>
				</tr>
				<c:forEach items="${list}" var="vo" varStatus="i">
					<tr>
						<td id="id${i.index}">${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
						<td><input type="checkbox" name="del" class="ch" title="id${i.index}" id="${vo.id}"></td>
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