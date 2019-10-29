<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="include/head.jsp" %>
</head>
<body>
	<%@ include file="include/header.jsp" %>

	<section>
		<div class="container"
			style="clear: both; padding-top: 100px; text-align: center"></div>
		<div class="container"
			style="margin-top: -40px; max-width: 1024px; padding-bottom: 10px;">
			<p class="main-section-title" id="music-title">Music Streaming Site</p>
			<p class="main-section-small">&nbsp;</p>

			<div class="row">
				<div class="col-md-6">
					<a href="https://www.melon.com/">
							<div class="main-post-card">
							 <img src="${HOME}/resources/mss/images/melon.png"   class="img-fluid img-thumbnail"/>
					<p class="main-post-card-title ellipse text-center" >음악이 필요한 순간, 멜론</p>
					<p>&nbsp;</p>
							</div>						
					</a>
				</div>
				
				<div class="col-md-6">
					<a href="https://genie.co.kr/">
							<div class="main-post-card">
							 <img src="${HOME}/resources/mss/images/gini.png"   class="img-fluid img-thumbnail"/>
					<p class="main-post-card-title ellipse text-center" >음악, 그리고 설레임 - 지니</p>
					<p>&nbsp;</p>
							</div>						
					</a>
				</div>
				
								<div class="col-md-6">
					<a href="https://music.naver.com/">
							<div class="main-post-card">
							 <img src="${HOME}/resources/mss/images/naverlogo.png"   class="img-fluid img-thumbnail"/>
					<p class="main-post-card-title ellipse text-center" >네이버 뮤직</p>
					<p>&nbsp;</p>
							</div>						
					</a>
				</div>
				
								<div class="col-md-6">
					<a href="https://music.bugs.co.kr/">
							<div class="main-post-card">
							 <img src="${HOME}/resources/mss/images/bugs.png"   class="img-fluid img-thumbnail"/>
					<p class="main-post-card-title ellipse text-center" >슈퍼사운드 벅스 뮤직</p>
					<p>&nbsp;</p>
							</div>						
					</a>
				</div>
				
				
				<div class="col-md-6">
					<a href="http://www.mnet.com/newrelease/track/Kpop/all">
							<div class="main-post-card">
							 <img src="${HOME}/resources/mss/images/mnet.png"   class="img-fluid img-thumbnail"/>
					<p class="main-post-card-title ellipse text-center" >가요 최신곡 - 엠넷 최신음악</p>
					<p>&nbsp;</p>
							</div>						
					</a>
				</div>
			
			</div>
		</div>

<div id="deckFooterAd"> </div>
			
			
		

	</section>


	
	<%@ include file="./include/nav-bottom.jsp" %>
	<%@ include file="./include/footer.jsp" %>

</body>
</html>