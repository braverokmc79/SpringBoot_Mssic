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

<div class="account-container register">
	
	<div class="content clearfix">
		
		<form:form action="/join" method="post"  commandName="userVO">		
			<h1>회원 가입</h1>			
			
			<div class="login-fields">			
				<c:choose>
					<c:when test="${empty errorMessage }">
						<p>계정 만들기 </p>	
					</c:when>					
					<c:otherwise>
						<p class="error">${errorMessage } </p>
					</c:otherwise>
				</c:choose>
				
				
				<div class="field">
					<label for="firstname">아이디</label>
					<form:input path="id"  placeholder="아이디" class="login" />
					<form:errors path="id"  cssClass="error" />
				</div> <!-- /field -->
								
				
				<div class="field">
					<label for="email">이메일:</label>
					<form:input path="email" placeholder="이메일" class="login" />
					<form:errors path="email"  cssClass="error" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">비밀번호:</label>
					<form:password   path="pw"  placeholder="비밀번호" class="login"  />
					<form:errors path="pw"  cssClass="error" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="confirm_password">비밀번호 확인:</label>
					<form:password   path="pwConfirm" placeholder="비밀번호 확인" class="login"  />
					<form:errors path="pwConfirm"  cssClass="error" />
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
													
				<button class="button btn btn-primary btn-large">회원 가입</button>
				
			</div> <!-- .actions -->
			
		</form:form>
		
	</div> <!-- /content -->
		
</div> <!-- /account-container -->



<div id="footer" style="margin-top: 100px;">	
<c:import url="include/footer.jsp"/>
</div>

</body>
</html>