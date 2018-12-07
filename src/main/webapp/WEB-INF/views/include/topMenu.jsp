<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<c:set var="URI" value="${pageContext.request.requestURI}" />

	<!-- /navbar -->
	<div class="subnavbar">
		<div class="subnavbar-inner">
			<div class="container">
				<ul class="mainnav">
							
<%-- 					<li class="dropdown subnavbar-open-right <c:if test="${fn:contains(URL, 'weight')}" >active</c:if>" style="width:200px;"><a
						href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-signal"></i><span>가중치 설정</span> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li>
								<a href="/users/weight/zabbix">Zabbix</a>								
							</li>
							
							<li><a href="/users/weight/checkserver">체크서버</a></li>								
							
							<li class="subnavbar-open-right">
							<a href="/users/weight/crash">크래쉬</a>
							</li>
							
						</ul>
					</li> --%>
					
				  <li class="dropdown subnavbar-open-right <c:if test="${fn:contains(URL, 'host')}" >active</c:if>" style="width:200px;">
					<a
						href="/users/alarm" >
							<i class="icon-signal"></i><span>Alarm</span> <b class="caret"></b>						
					</a>
					</li>					
					
				  <li <c:if test="${fn:contains(URL, 'dash')}" >active</c:if>" style="width:200px;">
					<a
						href="/users/dash" >
							<i class="icon-signal"></i><span>dash</span>					
					</a>
					</li>					
					
				
					<li class="dropdown subnavbar-open-right <c:if test="${fn:contains(URL, 'message')}" >active</c:if>" style="width:200px;"><a
						href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-dashboard"></i><span>대시보드</span> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a
								href="/users/message/fatal">FATAL</a>
							</li>
							<li><a
								href="/users/message/error">ERROR</a>
							</li>
							<li class="subnavbar-open-right"><a
								href="/users/message/warn">WARN</a>									
							</li>
							<li><a
								href="/users/message/info">INFO</a>
							</li>
							<li><a href="/users/message/all">전체</a>
							</li>															
						</ul>
					</li>								
					
				</ul>
			</div>
			<!-- /container -->
		</div>
		<!-- /subnavbar-inner -->
	</div>
	