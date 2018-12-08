<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/head.jsp" />
</head>
<body>
	<c:import url="include/header.jsp" />


	<section>
		<div class="container" id="sectionContainer">			
			<div class="panel panel-warning">
				<div class="panel-title" >
	<h3 class="signupTitle"	>MSS.IC로그인</h3>						
					<form name="signup" method="post"  id="loginForm" onsubmit="return check();">						
						<table id="loginTable">							
							<tbody>
								<tr>
									<td class="td-left">
										<p class="userIdValidation">아이디를 입력해주세요.</p>
									</td>
								</tr>
								<tr>
									<td>
<input check="1" id="userID" type="text" name="userID" class="form-control tooltipstered" minlength="1"
										maxlength="10" required aria-required="true" placeholder="최대 10자">																				
									</td>
								</tr>
								<tr>
									<td class="td-left">
										<p check="1" class="passwordValidation">비밀번호를 입력해주세요.</p>
									</td>
								</tr>
								<tr>
									<td><input id="pw" type="password" size="17" 
										maxlength="20" name="pw" class="form-control tooltipstered"
										minlength="1" required="" aria-required="true"										
										placeholder="최소 8자">
									</td>
								</tr>
								<tr>
									<td style="padding-top: 10px; text-align: center">
										<p>로그인하셔서 더욱 편하게 MSS.IC을 이용하세요.</p>
									</td>
								</tr>
								<tr>
									<td id="signupBtnTd">
<input type="submit" value="로그인" id="signupBtn"
										class="button form-control tooltipstered"
										style="background-color: rgb(247, 143, 36); border: 0px solid rgb(247, 143, 36);">
									</td>
								</tr>
								<tr>
									<td class="joinTd">										
					<a href="/join/signup">
					<input value="회원가입" id="signupBtn" class="button form-control tooltipstered"></a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		
		<script>
			var userIdValidation = $('.userIdValidation');
			var passwordValidation = $('.passwordValidation');

			var userID = $('#userID');
			var pw = $('#pw');

			function check() {
				// 로그인 api ajax 통신
				// 태그에서 check값만 바꾸고 넘길 수도 있으니 api단에서 validation 또 해야함.
				$.ajax({
							type : "POST",
							dataType : "json",
							url : "/api/logIn/",
							data : {
								userId : userID.val(),
								password : pw.val(),
								token : "5c08a379457c15.85162198",
								userAgent : "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36"
							},
							success : function(d) {
								// 환영 페이지 이동 
								if (d.state == "SUCCESS")
									location.href = "http://dda.ac/signup";
								else
									alert(d.error);
							}
						});

				return false;
			}
		</script>
	</section>


	<c:import url="./include/nav-bottom.jsp" />
	<c:import url="./include/footer.jsp" />

</body>
</html>