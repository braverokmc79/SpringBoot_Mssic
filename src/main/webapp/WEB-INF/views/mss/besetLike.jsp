<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% request.setAttribute("HOME", request.getContextPath()); %>
    
<c:forEach items="${likeList}"  var="row" varStatus="status">
<li style="width: 100%; padding-right: 15px; height: 50px; padding-top: 2px"
		class="post-rank ellipsis"><a class="a-click"
		href="${HOME}/recommendation/read/${row.bno}">
		<span class="txt-point">${status.count}</span>${row.title}</a></li>
</c:forEach>
