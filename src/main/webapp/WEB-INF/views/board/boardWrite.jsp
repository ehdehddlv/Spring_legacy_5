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
		<div class="row">
		<h1>${board} Write</h1>
			<form class="form-horizontal" action="./${board}Write" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">Title:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="writer">Writer:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="contents">Contents:</label>
					<div class="col-sm-10">
						<textarea rows="20" cols="" class="form-control" id="contents" name="contents"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<label for="files">File:</label>
					<input type="file" class="form-control" name="files">
					<input type="file" class="form-control" name="files">
				</div>
				

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Write</button>
					</div>
				</div>
			</form>

		</div>
	</div>
	
	<script type="text/javascript">
		// $("선택자").action();
		$("#contents").summernote({
			height : 400
		});
	</script>

</body>
</html>