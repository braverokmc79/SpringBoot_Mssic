<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="../include/head2.jsp" />
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
</head>
<body>
	<c:import url="../include/header.jsp" />

        <section>
            <div class="container" style="padding-top:120px; max-width:1024px; padding-bottom:20px;">
                <div class="panel panel-warning" style="border:1px solid #dadada;">
                    <div class="panel-title box-subject" style="border-bottom: 1px solid #dadada;">
                        게시판 글쓰기
                    </div>
                    <div class="container boardWriteForm" style="width:100%;">	
						
<form:form commandName="boardVO" name="form1" id="form1" 
	action="/recommendation/write" enctype="multipart/form-data" method="post"   >
							
							<p></p>
<p>
<input  class="form-control tooltipstered winput" minlength="1" maxlength="50" required  aria-required="true"
name="title"  placeholder="제목을 입력해주세요 (최대 50자)" />
</p>
                            <p class="error"><form:errors  path="title" /></p>
                        
                        
<c:choose>
	<c:when test="${empty sessionScope.USER }">
	
							<p>
<input class="form-control tooltipstered winput" minlength="1" maxlength="10" required aria-required="true"
		 name="bnickname"  placeholder="닉네임을 입력해주세요 (최대10자)"  />
							 </p>
<p class="error"><form:errors  path="bnickname" /></p>                 
                                    
							<p>
<input class="form-control tooltipstered winput" minlength="4" maxlength="4" required aria-required="true" name="pw" 
 placeholder="비밀번호를 입력해주세요 (4자)" />
 </p>			
 <p class="error"><form:errors  path="pw" /></p>   
	
	</c:when>
	<c:otherwise>

			<p>
<input class="form-control tooltipstered winput"  readonly="readonly" name="bnickname" value="${sessionScope.USER.nickname }" />		     
<input type="hidden" name="userID" value="${sessionScope.USER.userID }" />
			 </p>	
	</c:otherwise>
</c:choose>                        
                            							
<input type="hidden" name="imgcnt" id="imgcnt"  /> 	
 	
 	
 	
 				
	<form:textarea id="summernote" path="content"></form:textarea>
<input class="button form-control tooltipstered wsubmit" type="submit" value="글쓰기" style="color:#fff">
 <p class="error"><form:errors  path="content" /></p>   
	
						</form:form>
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
				url: "/summernote/upload",
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
	});
</script>        </section>


	<c:import url="../include/nav-bottom.jsp" />
	<c:import url="../include/footer.jsp" />
	 <script src="/resources/mss/js/summernote-ko-KR.js"></script>   

</body>
</html>