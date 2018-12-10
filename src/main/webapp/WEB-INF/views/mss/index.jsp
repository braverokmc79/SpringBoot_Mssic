<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<section class="main-v2-boards main-v2-section" >
	<div class="container">
		<p class="main-section-title">추천음악 커뮤니티</p>
		<p class="main-section-small">Recommended Music Community</p>
		<div class="row">
			<div class="col-md-6">
				<div class="main-v2-board-header">
				<span class="main-v2-board-header-title"><a href="/recommendation/list">베스트 뷰</a>
				</span>
				</div>
					<ul class="main-v2-board-list">
					<c:forEach items="${bestViewList}" var="row">															
						<li><a href="/recommendation/read/${row.bno }">
						<span class="thumb" style="color: #d6d6d6">
							<img class="board-star-img" src="/resources/mss/images/star_grey.png">&nbsp;${row.likecnt}</span>
							
							<span class="board-title ellipsis">${row.title}</span><span class="board-right-tip">
								<span class="board-list-right ellipsis logined">${row.bnickname}</span>
	            				<span class="board-list-right moment">
	            				<fmt:formatDate value="${row.regdate}"  pattern="yyyy-MM-dd hh:mm:ss"/></span>
	            				&nbsp;<i class="item-icon fa fa-eye" style="color:#999;"></i>&nbsp;
				<span class="board-list-right board-view" style="vertical-align: middle;">
				${row.viewcnt}</span>
							</span>
	            		</a>
				          </li>				            						
					</c:forEach>									            		
				    </ul>
			</div>
			
			<div class="col-md-6">
				<div class="main-v2-board-header">
				<span class="main-v2-board-header-title">
				<a href="/recommendation/list">베스트 코멘트</a></span></div>
					<ul class="main-v2-board-list">
						<c:forEach items="${bestCommentList}" var="row">															
						<li><a href="/recommendation/read/${row.bno }">
						<span class="thumb" style="color: #d6d6d6">
							<img class="board-star-img" src="/resources/mss/images/star_grey.png">&nbsp;${row.likecnt}</span>
							
							<span class="board-title ellipsis">${row.title}</span><span class="board-right-tip">
								<span class="board-list-right ellipsis logined">${row.bnickname}</span>
<span class="board-list-right moment"><fmt:formatDate value="${row.regdate}"  pattern="yyyy-MM-dd hh:mm:ss"/></span>
								&nbsp;<i class="item-icon fa fa-eye" style="color:#999;"></i>&nbsp;
							<span class="board-list-right board-view">${row.viewcnt}</span>
							</span>
	            		</a>
				          </li>				            						
					</c:forEach>
	
	
				
				   </ul>
			</div>
		</div>
	</div>
</section>

<section class="main-v2-boards main-v2-section" >
	<div class="container">
	 <p>&nbsp;</p>
	 <p>&nbsp;</p>
	 <p>&nbsp;</p>
	</div>
</section>


<c:import url="./include/nav-bottom.jsp"/>	
	
<c:import url="./include/footer.jsp"/>
<script src="/resources/mss/js/music.js"></script>	

<script type="text/javascript">

function plListModal(e){
	$("#plwrap").toggle("slow");
}

dateFormat();
function dateFormat(){
	var moments = document.getElementsByClassName('moment');
	for (var i = 0; i < moments.length; ++i) {
	    var item = moments[i];  
	    item.innerHTML = moment(item.textContent, "YYYY-MM-DD hh:mm:ss").fromNow();
	}
}	
</script>

	
</body>
</html>