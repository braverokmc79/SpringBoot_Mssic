<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../include/head2.jsp" %>
</head>
<body>

<%@ include file="../include/header.jsp" %>

	<section>
		<div class="container"
			style="padding-top: 120px; max-width: 1024px; padding-bottom: 60px;">
			<ul class="board-left-tab" style="visibility: hidden;">
				<li><a class="clicked" href="#">&nbsp;</a></li>
			</ul>
			<ul class="board-right-tab">
				<li><a class="button right-board" href="${HOME}/recommendation/write">글쓰기</a></li>
			</ul>


			<form action="${HOME}/recommendation/update"   action="${HOME}/recommendation/write"  method="post"  >
			
<input type="hidden" value="${boardVO.bno}" name="bno">
<input type="hidden" name="imgcnt" id="imgcnt" />

				<div class="board-view-header">					
					<p class="clientIp" style="display: none">${boardVO.ip}</p>
					<p style="display: none">
						<input name="bid" value="35540">
					</p>
					<p>
						<span><strong>${boardVO.bnickname }</strong><span class="userIp">.***</span></span>
<span class="moment"><fmt:formatDate value="${boardVO.regdate}"  pattern="yyyy-MM-dd hh:mm:ss"/></span>
					</p>
					<h4>
<input class="board-edit-title" maxlength="50" name="title" aria-required="true" value="${boardVO.title }">
					</h4>
					<p>
						<span>
<img class="board-star-img" src="${HOME}/resources/mss/images/star_grey.png">${boardVO.likecnt}</span><span>조회 ${boardVO.viewcnt}</span>
				</div>
				<div class="board-view-body">
					<textarea id="summernote" name="content">${boardVO.content}</textarea>

					<p class="addThumb">
						<a><input type="submit" value="수정하기"> </a>
					</p>

					
				</div>
			</form>



			<script>
				$('.toolbar_unit:last-child').css('display', 'none');
				$('.toolbar_unit:first-child').css('display', 'none');
				$(document).ready(
						function() {
							$('#summernote').summernote(
									{
										tabsize : 4,
										height : 300,
										lang : 'ko-KR',
										callbacks : {
											onImageUpload : function(files,
													editor, welEditable) {
												sendFile(files[0], editor,
														welEditable);
											}
										}
									});

							function sendFile(file, editor, welEditable) {
								data = new FormData();
								data.append("file", file);
								console.log('image upload:', file);
								$.ajax({
									url : "${HOME}/summernote/upload",
									data : data,
									cache : false,
									contentType : false,
									processData : false,
									type : 'POST',
									success : function(data) {
										var image = $('<img>').attr('src',
												'' + data);
										$('#summernote').summernote(
												"insertNode", image[0]);
										$("#imgcnt").val("1");

										//console.log(data);
									},
									error : function(jqXHR, textStatus,
											errorThrown) {
										console.log(textStatus + " "
												+ errorThrown);
									}
								});
							}

						});
				
				dateFormat();
			function dateFormat(){
				var moments = document.getElementsByClassName('moment');
				for (var i = 0; i < moments.length; ++i) {
				    var item = moments[i];  
				    item.innerHTML = moment(item.textContent, "YYYY-MM-DD hh:mm:ss").fromNow();
				}
			}	
				
			</script>

		</div>

	</section>



	<%@ include file="../include/nav-bottom.jsp" %>
	<%@ include file="../include/footer.jsp" %>
	<script src="${HOME}/resources/mss/js/summernote-ko-KR.js"></script>
</body>
</html>