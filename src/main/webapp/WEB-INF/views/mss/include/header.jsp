<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<c:set var="URI" value="${pageContext.request.requestURI}" />
	<header class="navbar-fixed-top">
<div class="visible-md visible-lg" >
<nav class="container" id="nav" role="navigation" style="max-width: 1024px; ">
	<ul>
		<li id="logo"><a href="/" >
			<img src="/resources/mss/images/home.svg" >
			</a>
		</li>
		
		<li id="navli"   >
		  <a class="nav-title"  href="/recommendation/list"  style="<c:if test="${fn:contains(URL, 'recommendation')}" >color: red; opacity: 0.5;</c:if>">추천할 곡을 적어 주세요!</a>
		 </li>
		
		<li id="navli">
		  <a class="nav-title" href="/music/site"   style="<c:if test="${fn:contains(URL, '/music')}" >color: red; opacity: 0.5;</c:if>">음악사이트</a>
		</li>
		
		<li id="navli" style="width: 100px;">
		  <a class="nav-title" href="/audio/list"   style="<c:if test="${fn:contains(URL, '/audio')}" >color: red; opacity: 0.5;</c:if>">스트리밍 리스트</a>
		</li>		
		
	</ul>

	<ul id="loginUl" style="float: right; background-color: white;  margin-top: 0px; box-shadow: none; width: 350px; height: 45px">
	<c:choose>
		<c:when test="${empty sessionScope.USER }">
		<li style="width: 25%;  display: inline-block; float: right; margin-top: -2px" id="navli">		  
		  <a href="/login" style="width: 100%; text-align: right; margin-left: 0px; opacity: 0.5; "
						class="nav-title">로그인</a>
		</li>
		</c:when>
		<c:otherwise>
		<li style="width: 25%;  display: inline-block; float: right; margin-top: -2px" id="navli">		  
		  <a href="/logout" style="width: 100%; text-align: right; margin-left: 0px; opacity: 0.5; "
						class="nav-title">로그아웃</a>
		</li>
		</c:otherwise>
	</c:choose>
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
									src="/resources/mss/images/four-leaf-clover.png">로그인<span>&gt;</span></a></li>
									
<li class="mobilenav"><a href="/"><img
						src="/resources/mss/images/mobilenav-contents.png">Home<span>&gt;</span></a></li>									
<li class="mobilenav"><a href="/recommendation/list"><img
						src="/resources/mss/images/mobilenav-board.png">추천할 곡을 적어 주세요!<span>&gt;</span></a></li>
							
							
<li class="mobilenav"><a href="/music/site">
<img src="/resources/mss/images/mobilenav-deck.png">음악사이트<span>&gt;</span></a>
</li>
	
<li class="mobilenav"><a href="/audio/list">
<img src="/resources/mss/images/mobilenav-kobold.png">스트리밍 리스트<span>&gt;</span></a>
</li>	
	
						</ul>
						<ul
							style="clear: both; text-align: left; padding-left: 20px; font-size: 14px; margin-right: 20px">
							<span style="color: white">.</span>
							<br>베스트 추천 글
							
			<c:import url="/recommendation/besetLike" />
			
						</ul>
					</div>
				</div>
<div id="dark"
					style="width: 100%; height: 5000px; background-color: black; opacity: 0.5; position: absolute; top: 0px; display: none; z-index: 200;"></div>
				
				
			</nav>
		</div>
	
	
	</header>
	