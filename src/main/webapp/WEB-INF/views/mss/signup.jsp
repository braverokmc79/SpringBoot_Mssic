<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="include/head.jsp" %>
</head>
<body>
	
<%@ include file="include/header.jsp" %>

<section>
    <div class="container"  id="sectionContainer">
        <div class="panel panel-warning" >
            <div class="panel-title" >
<h3 class="signupTitle" >MSSIC 회원가입</h3>
                <form name="signup" method="post" id="loginForm" onsubmit="return check();">
                    <table id="loginTable">
                        <tbody>
                        <tr>
                            <td class="td-left">
                                <p class="userIdValidation">아이디를 입력해주세요.</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
<input check="1" id="userID"  type="text" name="userID" class="form-control tooltipstered" minlength="1" maxlength="10" required aria-required="true"  placeholder="최대 10자">
                            </td>
                        </tr>
                        <tr>
                            <td class="td-left">
                                <p class="nicknameValidation">닉네임을 입력해주세요.</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
<input check="1" id="nickname" type="text" name="nickname" class="form-control tooltipstered" minlength="1" maxlength="10" required
 aria-required="true"  placeholder="최대 10자">
                            </td>
                        </tr>
                        <tr>
                            <td class="td-left">
                                <p check="1" class="passwordValidation">비밀번호를 입력해주세요.</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
<input id="pw" type="password" size="17" maxlength="20" name="pw" class="form-control tooltipstered" 
minlength="8" required aria-required="true"  placeholder="최소 8자">
                            </td>
                        </tr>
                        <tr>
                            <td class="td-left">
                                <p check="1" class="passwordReValidation">비밀번호를 재확인해주세요.</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
<input id="pwre" type="password" size="17" 
             maxlength="20" name="pw" class="form-control tooltipstered" min="1" required aria-required="true"  placeholder="비밀번호가 일치해야합니다.">
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top:10px; text-align: center">
                                <p>회원가입하셔서 더욱 편하게 MSS을 이용하세요.</p>
                            </td>
                        </tr>
                        <tr>
                            <td style="width:100%; text-align:center; colspan:2;">
<input type="submit" value="회원가입" id="signupBtn1" class="button form-control tooltipstered" 
style=" background-color:#64DD17; border:0px solid #388E3C;">
                            </td>
                        </tr>
                        <tr>
                            <td class="joinTd">
                                <a href="${HOME}/login">
 <input value="로그인" id="signupBtn2" class="button form-control tooltipstered"
style="background-color:#f78f24; border:0px solid #f78f24; "></a>
                            </td>
                        </tr>
                    </tbody></table>
                </form>
            </div>
        </div>
    </div>
    
<script>
var userIdValidation = $('.userIdValidation');
var nicknameValidation = $('.nicknameValidation');
var passwordValidation = $('.passwordValidation');
var passwordReValidation = $('.passwordReValidation');

var userID = $('#userID');
var nickname = $('#nickname');
var pw = $('#pw');
var pwre = $('#pwre');

var checkedValueColor = "#4CAF50";
var usedValueColor = "#ff1744";
var defaultColor = "#aaa";

$('#userID').on('keyup', function() {
	userID.removeClass("checkedValue");
	userID.removeClass("usedValue");
	userID.attr("check", "1");

	if (userID.val() == "") {
		userIdValidation.text("아이디를 입력해주세요.");
		userIdValidation.css("color", defaultColor);
	}

	$.ajax({
		type: "POST",
	    dataType: "text",
	    data:{
	    	userID: userID.val()
	    },
        url: "${HOME}/join/checkUserId",
        success: function (result) {
        	var d=parseInt($.trim(result));
        	if (d == 0) {
        		
        		if (userID.val() == "") {
        			userIdValidation.text("아이디를 입력해주세요.");
        			userIdValidation.css("color", defaultColor);
        		}else{
		        	// 중복 없음
	        		userID.addClass("checkedValue");
	        		userID.attr("check", "0");
	        		userIdValidation.text("사용 가능한 아이디입니다.");
		        	userIdValidation.css("color", checkedValueColor);        			
        		}        		
        	} else if (d >0) {
	        	// 중복 있음
	        	userID.addClass("usedValue");
	        	userIdValidation.text("이미 사용 중인 아이디입니다.");
	        	userIdValidation.css("color", usedValueColor);
	        }
        }
	});
});

$('#nickname').on('keyup', function() {
	nickname.removeClass("checkedValue");
	nickname.removeClass("usedValue");
	nickname.attr("check", "1");

	if (nickname.val() == "") {
		nicknameValidation.text("닉네임을 입력해주세요.");
		nicknameValidation.css("color", defaultColor);
	}

	$.ajax({
		type: "POST",
	    dataType: "text",
	    data:{
	    	nickname:nickname.val()
	    },
        url: "${HOME}/join/checkUserNickname",
        success: function (result) {
        	var d=parseInt($.trim(result));
        	
        	if (d==0) {
        		
        		if (nickname.val() == "") {
        			nicknameValidation.text("닉네임을 입력해주세요.");
        			nicknameValidation.css("color", defaultColor);
        		}else{
    	        	// 중복 없음
            		nickname.addClass("checkedValue");
            		nickname.attr("check", "0");
            		nicknameValidation.text("사용 가능한 닉네임입니다.");
            		nicknameValidation.css("color", checkedValueColor);
        		}

        	} else if (d > 0) {
	        	// 중복 있음
	        	nickname.addClass("usedValue");
	        	nicknameValidation.text("이미 사용 중인 닉네임입니다.");
	        	nicknameValidation.css("color", usedValueColor);
	        }
        }
	});
});

$('#pw').on('keyup', function() {
	pw.removeClass("checkedValue");
	pw.removeClass("usedValue");
	pw.attr("check", "1");

	if (pw.val() == "") {
		passwordValidation.text("비밀번호를 입력해주세요.");
		passwordValidation.css("color", defaultColor);
	} else {
	
	if (pw.val().length < 8) {
		pw.addClass("usedValue");
		pw.attr("check", "1");
		passwordValidation.text("입력값이 8자리 미만입니다.");
		passwordValidation.css("color", usedValueColor);
	} else {
		pw.addClass("checkedValue");
		pw.attr("check", "0");
		passwordValidation.text("사용 가능한 비밀번호입니다.");
		passwordValidation.css("color", checkedValueColor);
	}
	}
});

$('#pwre').on('keyup', function() {
	pwre.removeClass("checkedValue");
	pwre.removeClass("usedValue");
	pwre.attr("check", "1");

	if (pwre.val() == "") {
		passwordReValidation.text("비밀번호를 재확인해주세요.");
		passwordReValidation.css("color", defaultColor);
	}
	
	if (pw.val() != pwre.val()) {
		pwre.addClass("usedValue");
		pwre.attr("check", "1");
		passwordReValidation.text("입력값이 비밀번호와 다릅니다.");
		passwordReValidation.css("color", usedValueColor);
	} else {
		if ((pw.val().length >= 8 && pwre.val().length >= 8) && (pw.val() != "" && pwre.val() != "")) {
			pwre.addClass("checkedValue");
			pwre.attr("check", "0");
			passwordReValidation.text("입력값이 일치합니다.");
			passwordReValidation.css("color", checkedValueColor);
		}
	}
});

function check() {
	// id check값 확인
	if (userID.attr("check") == "0") {

		// nickname check값 확인
		if (nickname.attr("check") == "0") {
	
			// 비밀번호 8자 이상 확인
			if (pw.attr("check") == "0") {

				//비밀번호 일치여부 확인
				if (pwre.attr("check") == "0") {
					// 회원가입 api ajax 통신
					// 태그에서 check값만 바꾸고 넘길 수도 있으니 api단에서 validation 또 해야함.
					$.ajax({
						type: "POST",
					    dataType: "text",
				        url: "${HOME}/join/signUp",
				        data: {
					        userID: userID.val(),
					        nickname: $('#nickname').val(),
					        pw: pw.val(),
					        pwConfirm: pwre.val()
					    },
				        success: function (d) {				        	
				        	// 환영 페이지 이동 				        	
				        	if ($.trim(d)== "SUCCESS"){
				        		alert("회원 가입을 축하합니다.");
					        	location.href = "${HOME}/login";				        		
				        	}else{
				        		alert(d);
				        	} 					        	
				        }
					});
				}
			}
		}
	
	}
	
	return false;
}
</script>       
 </section>



<%@ include file="./include/nav-bottom.jsp" %>
<%@ include file="./include/footer.jsp" %>
</body>
</html>