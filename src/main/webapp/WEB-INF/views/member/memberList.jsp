<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<script type="text/javascript">
	$(function() {
		//전체 체크
		$("#result").on("click", "#chAll", function() {
			$(".ch").prop("checked", $(this).prop("checked"));
			
		});
		
		
		//체크 한거 안한거 확인
		$("#result").on("click", ".ch", function() {
			var result = true;
			$(".ch").each(function() {
				if(!$(this).prop("checked")){
					result = false;
				}
			});
			
			$("#chAll").prop("checked", result);
			
		});
		
		
		//지우기
		$("#result").on("click", "#del", function() {
			var ids = [];	//빈 배열 생성
			$(".ch").each(function() {
				if($(this).prop("checked")){
					//방법1
					//var id = $(this).attr("title");
					//alert($("#"+id).text());
					//방법2
					//alert($(this).attr("id"));
					
					ids.push($(this).attr("id"));
				}	
			});
			
			console.log(ids);
			//foreach 끝
			$.ajax({
				type:"get",
				traditional : true,
				url:"./memberDeletes",
				data:{
					ids:ids
				},
				success:function(data){
					$.get("./memberLists", function(data) {
						$("#result").html(data.trim());
					});
				}
			});
			
		});
		
		
	});//전체 end
</script>
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
			
			<div id="result">
			
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
		
		</div>
	</div>
	
	<!-- <script type="text/javascript">
		$("#chAll").click(function() {
			for(i=0; i<$(".ch").length; i++){
				$(".ch")[i].checked = chAll.checked;
			}
		});
		
		for(i=0; i<$(".ch").length; i++){
			$(".ch").click(function() {
				var result = true;
				
				for(j=0; j<$(".ch").length; j++){
					if(!$(".ch")[j].checked){
						result = false;
						break;
					}	
				}
				$("#chAll").check = result;
			});
		}
		
	</script> -->

</body>
</html>