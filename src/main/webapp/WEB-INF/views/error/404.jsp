<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
 <%@ include file="../include/header.jsp" %>
 <%@ include file="../include/errorCss.jsp" %>
</head>
<body>


<div id="clouds">
            <div class="cloud x1"></div>
            <div class="cloud x1_5"></div>
            <div class="cloud x2"></div>
            <div class="cloud x3"></div>
            <div class="cloud x4"></div>
            <div class="cloud x5"></div>
        </div>
        <div class='c'>
            <div class='_404'>404</div>
            <hr>
            <div class='_1'>THE PAGE</div>
            <div class='_2'>페이지를 찾을 수 없습니다.</div>
            <a class='btn' href='${HOME}/'>HOME</a>
        </div>


 	
</body>
</html>
