<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<h1>${fn:toUpperCase(board)} Update Form</h1>
	<div class="row">
	<form action="./${board}Update" method="post" enctype="multipart/form-data">
	
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
	     
			<input type="button" id="add" class="btn btn-info" value="Add File">
			<c:catch>
	    	<c:forEach items="${vo.boardFileVOs}" var="fileVO">
	    		<p>${fileVO.oriName}<i id="${fileVO.fileNum}" title="${fileVO.board}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
	    	
	    	</c:forEach>
	    	</c:catch>
	    </div>		
				
	<div id="file">	
			
	</div>
     
  
   
    <button type="submit" id="btn" class="btn btn-default">Update</button>
    
  </form>
	</div>
</div>


<script type="text/javascript" src="../resources/js/boardForm.js"></script>
<script type="text/javascript">
	$("#contents").summernote({
		height : 400
	});
	
	//첨부파일 개수
	//var size = ${size};
	size = ${vo.boardFileVOs.size()};
	 
	size = ${fn:length(vo.boardFileVOs)};
	
	//count = count+size;
	
	$(".fileDelete").click(function() {
		
		var check = confirm("정말 지우시겠습니까?");
		
		if(check){
		var s = $(this);
		
		$.post("../boardFile/fileDelete", {fileNum:$(this).attr("id"), board:$(this).attr("title")}, function(data) {
			
			if(data>0){
				s.parent().remove();
				count--;
			}else {
				alert("File Delete Fail");
			}
		});
		}
	});
</script>

</body>
</html>