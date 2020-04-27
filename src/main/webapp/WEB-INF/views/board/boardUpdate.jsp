<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>

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
    
    <div class="form-group">
    	<label for="files">Files:</label>
    	<c:forEach items="${vo.boardFileVOs}" var="fileVO">
    		<p>${fileVO.oriName}<i id="${fileVO.fileNum}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
    	
    	</c:forEach>
    	
    </div>
       
   
    <button type="submit" id="btn" class="btn btn-default">Update</button>
    
  </form>
	</div>
</div>


<script type="text/javascript">
	$("#contents").summernote({
		height : 400
	});
	
	$(".fileDelete").click(function() {
		
		var s = $(this);
		
		$.post("../boardFile/fileDelete", {fileNum:$(this).attr("id")}, function(data) {
			
			if(data.trim()>0){
				s.parent().remove(); 
			}else {
				alert("File Delete Fail");
			}
		});
	});
</script>

</body>
</html>