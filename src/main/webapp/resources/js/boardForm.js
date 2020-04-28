/**
 * 
 */

// $("선택자").action();

//		$("#contents").summernote({
//			height : 400,
//			callbacks:{
//				onImageUpload:function(file){
//					console.log("upload");
//				}
//			}
//		});
		
		$("#btn").click(function() {
			//title, contents 데이터 유무 검증
			var title = $("#title").val();
			var contents = $("#contents").val();
			var ch3 = true;
			
			$(".files").each(function() {
				if($(this).val()==""){
					ch3 = false;
				};
			});
			
			var ch1 = title != "";
			var ch2 = $("#contents").summernote('isEmpty');
			
			
			if(ch1 && !ch2 && ch3){
				//form 전송(submit event 강제 발생)
				$("#frm").submit();
				
			}else {
				//submit event 종료
				alert("필수 요소는 다 입력하세요.");
			}
			
			/* console.log(title=='');
			console.log(contents=="");
			console.log(title.length);
			console.log(contents.length);
			
			contents = $("#contents").summernote('code');
			console.log($("#contents").summernote('isEmpty')); */
		});
		
		var count = 1;
		
		
		$("#file").on("click", ".remove", function() {
			$(this).parent().remove();
			count--;
		});
		
		$("#add").click(function() {
			if(count < 6){
				$("#file").append('<div class="form-group"> <div class="col-sm-10"> <input type="file" class="form-control files" name="files"> </div> <i class="glyphicon glyphicon-remove remove"></i> </div>');
				count++;
			}else{
				alert("파일은 최대 5개 만 가능");
			}
		});
		
		