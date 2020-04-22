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
	<h1>${board} Update</h1>
	<div class="row">
	<form action="./${board}Update" method="post">
	
	<input type="hidden" name="num" value="${vo.num}">
	
	<div class="form-group">
      <label for="Title">Title:</label>
      <input type="text" value="${vo.title}" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
	
    <div class="form-group">
      <label for="Writer">Writer:</label>
      <input type="text" value="${vo.writer}" disabled="disabled" class="form-control" id="writer" name="writer">
    </div>

    <div class="form-group">
      <label for="Contents">Contents:</label>
      <textarea rows="5" cols="" class="form-control" id="contents" name="contents">${vo.contents}</textarea>
    </div> 
       
   
    <button type="submit" class="btn btn-default">Update</button>
    
  </form>
	</div>
</div>

</body>
</html>