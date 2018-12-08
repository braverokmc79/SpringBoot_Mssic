<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
   
	<header class="navbar-fixed-top">
<div class="visible-md visible-lg" >
<nav class="container" id="nav" role="navigation" style="max-width: 1024px; ">
	<ul>
		<li id="logo"><a href="/" >
			<img src="/resources/mss/images/home.svg" >
			</a>
		</li>
		
		<li id="navli">
		  <a class="nav-title"  href="http://dda.ac/contents">추천할 곡을 적어 주세요!</a>
		 </li>
		
		<li id="navli">
		  <a class="nav-title" href="http://dda.ac/deck">음악사이트</a>
		</li>
		
	</ul>
	<ul id="" style="float: right; background-color: white;  margin-top: 0px; box-shadow: none; width: 350px; height: 45px">
		<li style="width: 25%;  display: inline-block; float: right; margin-top: -2px" id="navli">
		  <a href="/login" style="width: 100%; text-align: right; margin-left: 0px; opacity: 0.5; "
						class="nav-title">로그인</a>
		</li>
	</ul>
</nav>	
	</div>
	
	
		<div class="visible-xs visible-sm"
			style="width: 100%; border-bottom: 1px solid #dadada; border-top: 1px solid #f78f24; background-color: white; position: absolute; z-index: 30000;">
			<nav class="container" id="nav" role="navigation"
				style="max-width: 1024px; width: 100%; height: 50px; text-align: center; box-shadow: none;">
				<div style="width: 40px">
					<a class="icon-menu"><img width="23px" height="19px"
						style="display: inline; position: absolute; top: 15px; left: 15px;"
						src="/resources/mss/images/iconmenu.jpg"></a>
					<div id="menu" class="menu"
						style="overflow-y: auto; -webkit-overflow-scrolling: touch; overflow-x: hidden; display: block; height: 100%; z-index: 300; opacity: 1 !important;">
						<ul>
							<li class="mobilenav"
								style="background-color: #fff; color: #333 !important"><a
								style="color: #333 !important" href="/login"><img
									src="/resources/mss/images/mobilenav-logo.png">로그인<span>&gt;</span></a></li>
							<li class="mobilenav"><a href="http://dda.ac/contents"><img
									src="/resources/mss/images/mobilenav-contents.png">컨텐츠<span>&gt;</span></a></li>
							<li class="mobilenav"><a href="http://dda.ac/deck"><img
									src="/resources/mss/images/mobilenav-deck.png">덱리스트<span>&gt;</span></a></li>
							<li class="mobilenav"><a href="http://dda.ac/twitter"><img
									src="/resources/mss/images/mobilenav-twitter.png">해외 프로 실시간 덱
									트위터<span>&gt;</span><span
									style="width: 8px; height: 8px; background-color: red; float: right; margin-top: 15px; margin-right: 32px; border-radius: 4px;"></span></a></li>
							<li class="mobilenav"><a href="http://dda.ac/cardEstimate"><img
									src="/resources/mss/images/mobilenav-kobold.png">카드평가<span>&gt;</span></a></li>
							<li class="mobilenav"><a href="http://dda.ac/board"><img
									src="/resources/mss/images/mobilenav-board.png">게시판<span>&gt;</span></a></li>
							<!-- 
                                <li class="mobilenav"><a href="https://twip.kr/donate/psc2321" target="_blank"><img src="/static/img/mobilenav-donate.png">후원하기<span>></span><span style="width: 8px;height: 8px;background-color:red;float: right;margin-top: 15px;margin-right: 138px;border-radius: 4px;"></span></a></li>
								-->
						</ul>
						<ul
							style="clear: both; text-align: left; padding-left: 20px; font-size: 14px; margin-right: 20px">
							<span style="color: white">.</span>
							<br>최근 인기 컨텐츠
							<li
								style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
								class="post-rank ellipsis"><a class="a-click"
								href="http://dda.ac/contents/postView?id=330"><span
									class="txt-point">1</span> 라스타칸 첫 날에 해볼만 한 20가지 덱들</a></li>
							<li
								style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
								class="post-rank ellipsis"><a class="a-click"
								href="http://dda.ac/contents/postView?id=329"><span
									class="txt-point">2</span> vS 야생 Data Reaper Report #14</a></li>
							<li
								style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
								class="post-rank ellipsis"><a class="a-click"
								href="http://dda.ac/contents/postView?id=328"><span
									class="txt-point">3</span> 이글 도끼와 얼음 파괴자의 노래#20</a></li>
							<li
								style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
								class="post-rank ellipsis"><a class="a-click"
								href="http://dda.ac/contents/postView?id=327"><span
									class="txt-point">4</span> vS Data Reaper Report #113</a></li>
							<li
								style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
								class="post-rank ellipsis"><a class="a-click"
								href="http://dda.ac/contents/postView?id=326"><span
									class="txt-point">5</span> vS Data Reaper Report #112</a></li>
						</ul>
					</div>
				</div>
				<div id="dark"
					style="width: 100%; height: 5000px; background-color: black; opacity: 0.5; position: absolute; top: 0px; display: none; z-index: 200;"></div>
				<a href="http://dda.ac/"
					style="display: -webkit-inline-box; text-align: center; margin: 0 auto;"><img
					src="/resources/mss/images/hr_logo.png"
					style="width: 76px; height: 16px; margin-top: -17px; margin-left: 5px"></a>
				<!--<a href="#" class="nav-title" style="width:56px; display:inline; position: absolute; top: -4px; right: 15px;">Sign up</a>-->
			</nav>
		</div>
	
	
	</header>
	