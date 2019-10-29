<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../include/head2.jsp" %>
<style type="text/css">
#form1{
	padding-left:20px; 
	padding-right:20px; 
	margin-top:40px; 
	margin-bottom:40px;
}
.winput{
	margin-bottom:25px; 
	width:100%; 
	height:40px; 
	border: 1px solid #d9d9de;
}
.wsubmit{
	height:40px; 
	color:white; 
	background-color:#f78f24;
	 border:0px solid #f78f24; 
	 opacity:0.8;
}
.error{
  color:red;
}
</style>

<c:if test="${USER.userID != 'admin' }">
<script>
	alert("관리자만 접근 가능합니다.");
	location.href="${HOME}/";
</script>
</c:if>
</head>
<body>
		<%@ include file="../include/header.jsp" %>
        <section>
            <div class="container" style="padding-top:120px; max-width:1024px; padding-bottom:20px;">
                <div class="panel panel-warning" style="border:1px solid #dadada;">
                    <div class="panel-title box-subject" style="border-bottom: 1px solid #dadada;">
                       mp3 업로드
                    </div>
                    <div class="container boardWriteForm" style="width:100%;">	
						
<form  name="form1" id="form1" 
	action="${HOME}/audio/upload" enctype="multipart/form-data" method="post"   >
							
							<p></p>
<p>
<input  class="form-control tooltipstered winput" minlength="1" maxlength="50" required  aria-required="true"
name="title"  placeholder="제목을 입력해주세요 (최대 50자)" />
</p>
                         
                        
 	
 	
 <input  type="file" class="form-control tooltipstered winput" minlength="1" maxlength="50" required  aria-required="true"
name="file"  id="file" placeholder="제목을 입력해주세요 (최대 50자)" />	
 				
	
<input class="button form-control tooltipstered wsubmit" type="submit" value="업로드" style="color:#fff">
  
	
</form>

                    </div>
                </div>
            </div>
            
        
<script>
	$('.toolbar_unit:last-child').css('display', 'none');
	$('.toolbar_unit:first-child').css('display', 'none');
	$(document).ready(function() {
		$('#summernote').summernote({
			tabsize: 4,
			height: 300,
			lang: 'ko-KR',
			callbacks: {
				onImageUpload: function(files, editor, welEditable) {
					sendFile(files[0], editor, welEditable);
				}
			}
		});

		function sendFile(file, editor, welEditable) {
			data = new FormData();
			data.append("file", file);
			console.log('image upload:', file);
			$.ajax({
				url: "${HOME}/summernote/upload",
				data: data,
				cache: false,
				contentType: false,
				processData: false,
				type: 'POST',
				success: function(data) {
					var image = $('<img>').attr('src', '' + data);
					$('#summernote').summernote("insertNode", image[0]);
					$("#imgcnt").val("1");
					
					//console.log(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(textStatus + " " + errorThrown);
				}
			});
		}

	
		$("input[id=file").change(function(){
			 
		    // 필드 채워지면
		    if($(this).val() != ""){
		        // 확장자 체크
		            var ext = $(this).val().split(".").pop().toLowerCase();
		            if($.inArray(ext, ["mp3"]) == -1){
		                alert("mp3 파일만 업로드 해주세요.");
		                $(this).val("");
		                return;
		            }
		            
		            // 용량 체크
		            var fileSize = this.files[0].size;
		            var maxSize = 1024 * 1024*100;
		            if(fileSize > maxSize){
		                alert("파일용량 100MB을 초과했습니다.");
		                $(this).val("");
		            }		            
		    }
		});
	
	
	
	
});
	
	
	
	
	
</script>        </section>


	<%@ include file="../include/nav-bottom.jsp" %>
	<%@ include file="../include/footer.jsp" %>
	 <script src="${HOME}/resources/mss/js/summernote-ko-KR.js"></script>   



</body>
</html>