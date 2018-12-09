<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/head.jsp"/>
</head>
<body>
<c:import url="include/header.jsp"/>
	
	
	
<section class="header-banner">
</section>
<section class="main-header-v2 main-v2-section">
	<div class="container">
		<p class="main-header-small" style="font-weight: 500;">무료음악 스트리밍 사이트</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		
	</div>
</section>

<div class="container">
    <div class="column add-bottom">
        <div id="mainwrap">
            <div id="nowPlay">
                <span id="npAction">Paused...</span><span id="npTitle"></span>
            </div>
            <div id="audiowrap">
                <div id="audio0">
                    <audio id="audio1" preload controls>Your browser does not support HTML5 Audio! 😢</audio>
                </div>
                <div id="tracks">
                    <a id="btnPrev">&larr;</a><a id="btnNext">&rarr;</a>
                </div>
                <div>
                	<button type="button" class="btn btn-info" onclick="plListModal()"><i class="fas fa-list-alt" style="font-size: 25px;"></i></button>

                </div>
            </div>
            <div id="plwrap" style="display: none;">
                <ul id="plList"></ul>
            </div>
        </div>
    </div>
    <div class="column add-bottom center">
        <p></p>        
    </div>
</div>



<div class="visible-sm visible-xs" style="width:100%; height:auto; display:inline-block; padding-left: 16px; padding-right: 16px;padding-bottom:0px; padding-top:25px; background-color: #f7f7f7">
	<div id="mMainUpperAd" style="width:100%; height:auto; display:inline-block;    text-align: center;"><script async="" src="http://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script><ins class="adsbygoogle" style="display:block" data-ad-client="ca-pub-2592940546088488" data-ad-slot="7642374814" data-ad-format="auto" data-full-width-responsive="true"></ins><script>(adsbygoogle=window.adsbygoogle || []).push({});</script></div>
</div>
<section class="main-v2-posts main-v2-section">
	<div class="container">
		<p class="main-section-title">최근 포스트</p>
		<p class="main-section-small">Recent Posts</p>
<!-- 		<ul> -->
<!-- 			<li class="clicked"><p class="main-post-title">선수 덱 공략</p><p class="main-post-title-small">Deck Guide</p></li> -->
<!-- 			<li><p class="main-post-title">티어덱 리포트</p><p class="main-post-title-small">Tier Deck Report</p></li> -->
<!-- 			<li><p class="main-post-title">비셔스 정규</p><p class="main-post-title-small">vS Standard</p></li> -->
<!-- 			<li><p class="main-post-title">비셔스 야생</p><p class="main-post-title-small">vS Wild</p></li> -->
<!-- 			<li><p class="main-post-title">가로쉬 소설</p><p class="main-post-title-small">Song of axe</p></li> -->
<!-- 		</ul> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details »</a></p> -->
<!--         </div> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details »</a></p> -->
<!--        </div> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details »</a></p> -->
<!--         </div> -->
<!--       </div> -->
		<div class="row">
			<div class="col-md-4">
						<a href="http://dda.ac/contents/postView?id=330">
							<div class="main-post-card">
								<div class="main-post-thumbnail" style="background-image: url(&#39;../static/img/vicious.jpg&#39;)"></div>
          						<p class="main-post-card-title ellipse">라스타칸 첫 날에 해볼만 한 20가지 덱들</p>
								<p class="main-post-card-desc ellipse">새로운 확장팩이 나오면 재미있는 요소 중 하나는 덱을 ...</p>
								<div class="main-post-card-tips">
									<img src="./index_files/main_calendar.png">&nbsp;&nbsp;&nbsp;<span class="moment">4 일 전</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_eye.png">&nbsp;&nbsp;&nbsp;<span>113,958</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_comment.png">&nbsp;&nbsp;&nbsp;<span>54</span>
								</div>	
							</div>
						</a>
					</div><div class="col-md-4">
						<a href="http://dda.ac/contents/postView?id=329">
							<div class="main-post-card">
								<div class="main-post-thumbnail" style="background-image: url(&#39;../static/img/wvicious.jpg&#39;)"></div>
          						<p class="main-post-card-title ellipse">vS 야생 Data Reaper Report #14</p>
								<p class="main-post-card-desc ellipse">야생 vS Data Reaper Report에 돌아오신...</p>
								<div class="main-post-card-tips">
									<img src="./index_files/main_calendar.png">&nbsp;&nbsp;&nbsp;<span class="moment">9 일 전</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_eye.png">&nbsp;&nbsp;&nbsp;<span>18,889</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_comment.png">&nbsp;&nbsp;&nbsp;<span>7</span>
								</div>	
							</div>
						</a>
					</div><div class="col-md-4">
						<a href="http://dda.ac/contents/postView?id=328">
							<div class="main-post-card">
								<div class="main-post-thumbnail" style="background-image: url(&#39;../static/img/songofaxe.jpg&#39;)"></div>
          						<p class="main-post-card-title ellipse">이글 도끼와 얼음 파괴자의 노래#20</p>
								<p class="main-post-card-desc ellipse">"흠.. 아마 그 때 보다도 더 나쁠 겁니다. 한번 직...</p>
								<div class="main-post-card-tips">
									<img src="./index_files/main_calendar.png">&nbsp;&nbsp;&nbsp;<span class="moment">9 일 전</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_eye.png">&nbsp;&nbsp;&nbsp;<span>4,693</span>
								</div>
								<div class="main-post-card-tips">
									<img src="./index_files/main_comment.png">&nbsp;&nbsp;&nbsp;<span>7</span>
								</div>	
							</div>
						</a>
					</div>		</div>
	</div>
</section>
<section class="main-v2-boards main-v2-section">
	<div class="container">
		<p class="main-section-title">커뮤니티</p>
		<p class="main-section-small">Community</p>
		<div class="row">
			<div class="col-md-6">
				<div class="main-v2-board-header"><span class="main-v2-board-header-title"><a href="http://dda.ac/board">자유 게시판</a></span></div>
					<ul class="main-v2-board-list">
						<li><a href="http://dda.ac/board/boardView?id=35378"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="board-title ellipsis">돚거 한번에 4장씩 뽑는데 어떻게 이기냐?</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">DDA.AC관리자</span>
				            				<span class="board-list-right moment">6 분 전</span>
											<span class="board-list-right board-view">15</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=35377"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="board-title ellipsis">제이나의 눈물 글 안 내리냐 ㅋㅋㅋ</span><span class="board-right-tip">
											<span class="board-list-right ellipsis">컨냥붐은오냐</span>
				            				<span class="board-list-right moment">8 분 전</span>
											<span class="board-list-right board-view">16</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=35376"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="board-title ellipsis">갓골팩2팩에 난투1팩깟는데</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">협박님</span>
				            				<span class="board-list-right moment">14 분 전</span>
											<span class="board-list-right board-view">15</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=35375"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="count left-count">[1]</span><span class="board-title ellipsis">친선퀘좀 도와줄사람 80골  아님</span><span class="count right-count">[1]</span><span class="board-right-tip">
											<span class="board-list-right ellipsis">123</span>
				            				<span class="board-list-right moment">22 분 전</span>
											<span class="board-list-right board-view">30</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=35373"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="count left-count">[4]</span><span class="board-title ellipsis">접속시 카드팩 왜주는걸까요?</span><span class="count right-count">[4]</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">세이스카나</span>
				            				<span class="board-list-right moment">58 분 전</span>
											<span class="board-list-right board-view">249</span>
										</span>
				            		</a></li>				</ul>
			</div>
			<div class="col-md-6">
				<div class="main-v2-board-header"><span class="main-v2-board-header-title"><a href="http://dda.ac/board/info">정보 게시판</a></span></div>
					<ul class="main-v2-board-list">
						<li><a href="http://dda.ac/board/boardView?id=35264"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="board-title ellipsis">난롯가 이야기 : 폴 웬과 함께하는 대난투 이야기</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">MarKT</span>
				            				<span class="board-list-right moment">22 시간 전</span>
											<span class="board-list-right board-view">384</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=35074"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;0</span><span class="count left-count">[1]</span><span class="board-title ellipsis">이번주 선술집 난투  - 정규 난투장</span><span class="count right-count">[1]</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">블루큐</span>
				            				<span class="board-list-right moment">2 일 전</span>
											<span class="board-list-right board-view">2016</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=34996"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;1</span><span class="board-title ellipsis">라스타칸의 대난투 모험모드 도적,성기사 시작덱</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">IGBA</span>
				            				<span class="board-list-right moment">2 일 전</span>
											<span class="board-list-right board-view">1499</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=34995"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;1</span><span class="board-title ellipsis">라스타칸의 대난투 모험모드 주술사 시작덱</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">IGBA</span>
				            				<span class="board-list-right moment">2 일 전</span>
											<span class="board-list-right board-view">1139</span>
										</span>
				            		</a></li><li><a href="http://dda.ac/board/boardView?id=34936"><span class="thumb" style="color: #d6d6d6">
										<img class="board-star-img" src="./index_files/star_grey.png">&nbsp;3</span><span class="count left-count">[1]</span><span class="board-title ellipsis">[공지] 젠티모 관련 오류 현상 안내</span><span class="count right-count">[1]</span><span class="board-right-tip">
											<span class="board-list-right ellipsis logined">세이스카나</span>
				            				<span class="board-list-right moment">2 일 전</span>
											<span class="board-list-right board-view">1557</span>
										</span>
				            		</a></li>				</ul>
			</div>
		</div>
	</div>
</section>

       


<c:import url="./include/nav-bottom.jsp"/>	
	
<c:import url="./include/footer.jsp"/>
<script src="/resources/mss/js/music.js"></script>	

<script type="text/javascript">

function plListModal(e){
	$("#plwrap").toggle("slow");
}
</script>

	
</body>
</html>