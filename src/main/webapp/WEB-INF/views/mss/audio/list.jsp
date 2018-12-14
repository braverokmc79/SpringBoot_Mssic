<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${USER.userID != 'admin' }">
<script>
	alert("관리자만 접근 가능합니다.");
	location.href="/";
</script>
</c:if>

<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="../include/head.jsp" />
<style type="text/css">
.label{
	border: 0px; 
	padding: 7px;
	width: 50.81px;
}
.label:hover{
	background-color: #f78f24;
}
</style>
</head>
<body>
	<c:import url="../include/header.jsp" />

<section>
            <div class="container board-container" style="padding-top:80px; max-width:1024px;">
            	<ul class="board-left-tab" style="visibility: hidden;" >
            		<li ><a class="clicked" href="#">&nbsp;</a></li>       
            	</ul>
            	<ul class="board-right-tab">
            		<li><a class="button right-board" href="/audio/write">글쓰기</a></li>
            	</ul>
            	<ul class="board-list">


			
			
			<c:forEach items="${list }" var="row">            	
				<li style="font-size: 14px;">
					<a href="#">
					<span class="board-title ellipsis">${row.title}</span>

					
					<span class="board-right-tip">
					<span class="board-list-right ellipsis">${row.originalName}</span>	
          			
          			
          			<span class="board-list-right"><fmt:formatDate value="${row.regdate}"  pattern="MM-dd"/></span>
					<span class="board-list-right board-view">
					<c:choose>
						<c:when test="${row.show eq 'no'}">
						<button class="label label-success" id='${row.id}'  onclick="streaming('${row.show}', '${row.id}')" >대기</button>		
						</c:when>
						<c:otherwise>
						<button class="label label-primary" id='${row.id}'  onclick="streaming('${row.show}', '${row.id}')" >스트리밍</button>								
						</c:otherwise>
					</c:choose>
					<button class="label label-danger"   onclick="deleteAudio('${row.id}')" >삭제</button>
					
					
					</span>
					</span>
          			</a>
         		</li>			            	
			</c:forEach>            	
		
		<c:if test="${empty list }">
							<p style="text-align: center; margin: 50px 0 10px 0;">
								<img class="noresult" src="/resources/mss/images/music_board.jpg">
								</p>
								<p style="text-align: center; margin: 50px 0 10px 0;">이런! 검색 결과가 없네요.</p>
								<p style="text-align: center; margin: 10px 0 30px 0;">다른 단어로 검색해보시길 바랍니다.</p> 
		
			</c:if>			            	
			            		
	            	</ul>
        
        
                 ${pagination }
			<form method="get" action="/audio/list">
                <ul class="board-search">                	
            		<li>
	            		<select name="searchType" id="board-search-select">
	            			<option value="t" <c:out value="${pageMaker.searchType eq 't' ? 'selected' : '' }" /> >제목</option>
	            			<option value="tc" <c:out value="${pageMaker.searchType eq 'tc' ? 'selected' : '' }" />>제목+파일이름</option>
	            		</select>
	            	</li> 
            		<li><input type="text" name="keyword" value="${pageMaker.keyword }" placeholder="검색어 입력" length="20" max-length="20"></li>
            		<li><input type="submit" value="검색" class="button border-search-submit"></li>            		            		
            	</ul>
            </form>
            	
            	
            	
            	<div id="boardFooterAd" style="text-align: center;width:100%; height:auto; display:inline-block; 
            	margin-top: 32px; margin-bottom:32px">

            	</div>
            </div>   
            
        </section>




	<c:import url="../include/nav-bottom.jsp" />
	<c:import url="../include/footer.jsp" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>

function streaming(show, id){
 	
	$.ajax({
		url:"/audio/showchange",
		type:"post",
		dataType:"text",
		data:{
			show:show,
			id:id
		},
		success:function(result){
			if($.trim(result)=='success'){
				//alert("설정이 변경 되었습니다.");
				location.reload();
/* 				if(show=='no'){
					$("#"+id).attr("class", "label label-primary");
					$("#"+id).text("스트리밍");
				}else{
					$("#"+id).attr("class", "label label-danger");
					$("#"+id).text("대기");
				} */
				
				return;
			}
		},
		error:function(result){
			alert("전송 오류입니다.");
			console.log(result)	;
		}
	});
 
}

function deleteAudio( id){
 	if(confirm("정말 삭제 하시겠습니까?")){
 		$.ajax({
 			url:"/audio/deleteAudio",
 			type:"post",
 			dataType:"text",
 			data:{
 				id:id
 			},
 			success:function(result){
 				if($.trim(result)=='success'){			
 					location.reload();			
 					return;
 				}
 			},
 			error:function(result){			
 				console.log(result)	;
 			}
 		});
 	}

}


</script>
</body>
</html>