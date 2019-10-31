<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setAttribute("HOME", request.getContextPath()); %>
<c:choose>
	<c:when test="${ likeClientIP eq 'exist' }">
		 <img class="board-star-img" src="${HOME}/resources/mss/images/star.png"><div style="color: rgb(255, 211, 5); display: inline;">추천 취소</div> 
	 <input type="hidden" id="likeCount" value="${likecount}">

	</c:when>
	<c:otherwise>
		<img class="board-star-img" src="${HOME}/resources/mss/images/star_grey.png"> 추천     
		<input type="hidden" id="likeCount" value="${likecount}">
	</c:otherwise>
</c:choose>

       

   
