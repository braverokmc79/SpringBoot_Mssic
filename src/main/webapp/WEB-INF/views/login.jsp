<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/header.jsp"/>
</head>
<body>
<c:import url="include/top.jsp"/>
	
<c:if test="${not empty congratulations || param.congratulations eq  'ok'}" >
<div class="container">
	<div class="alert alert-danger" role="alert">
	  <button type="button" class="close" data-dismiss="alert">
	  <span aria-hidden="true">×</span>
	  </button>
	  <div style="text-align: center; vertical-align:">
	  	<strong>Congratulations!</strong> 
	  	<h1>${congratulations}</h1>
	  </div>
	</div>
</div>
</c:if>	
	
	
<div class="account-container ">	
	<div class="content clearfix">
		
		<form:form action="/login" method="post"  commandName="loginUserVO">
		
			<h1>로그인</h1>		
			
			<div class="login-fields">				
				
			    <c:choose>
					<c:when test="${empty errorMessage }">
						<p>세부 정보를 입력하세요.</p>
					</c:when>					
					<c:otherwise>
						<p class="error">${errorMessage } </p>
					</c:otherwise>
				</c:choose>
		
				<div class="form-group" style="margin-bottom: 20px;">
					<label for="id">Username</label>					
					<form:input path="id"  placeholder="아이디" cssClass="form-control"  />
					<form:errors path="id"  cssClass="error" />
				</div> <!-- /field -->
				
				<div class="form-group" style="margin-bottom: 15px;">
					<label for="pw">Password:</label>
					<form:password path="pw"  placeholder="비밀번호" cssClass="form-control" />
					<form:errors path="pw"  cssClass="error" />
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
			    <span class="login-checkbox">				
					<a href="/join" class="choice">회원 가입</a>
				</span>									
				<button class="button btn btn-success btn-large">로그인</button>				
			</div> <!-- .actions -->
									
		</form:form>
		
	</div> <!-- /content -->
	
	
</div> <!-- /account-container -->






<div id="footer">
<c:import url="include/footer.jsp"/>
</div>

</body>
</html>