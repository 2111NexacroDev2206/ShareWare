<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="/resources/css/login-style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Changa:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<header>
	<span class="material-icons" style="font-size: 50px;">
		share
	</span>
	<span class="logo">ShareWare</span>
</header>
<form action="/member/login.sw" method="POST" onsubmit="return frm_check();">
	<div class="d-login">
		<div class="d-id">
			<label class="l-text" for="loginId">USERID</label>
			<input type="text" name="memberNum" id="loginId" class="i-login" placeholder="사원번호" required>
		</div>
		<div class="d-pw">
			<label class="l-text" for="loginPw">PASSWORD</label>
			<input type="password" name="password" id="loginPw" class="i-login" placeholder="비밀번호" required>
		</div>
		<div class="d-chk">
			<input type="checkbox" class="save-id" name="checkId" id="saveId" checked>
			<label for="saveId">계정 저장</label>
		</div>
		<div class="d-btn">
			<input type="submit" class="login-btn" value="로그인">
		</div>
	</div>
</form>
<!-- 비밀번호 변경 모달 -->
<div class="d-password">
	<div class="m-password">
		<div class="h-password">
			<span class="h-p-logo">ShareWare</span>
			<span class="h-p-text">에 오신 것을 환영합니다 !</span>
		</div>
		<form action="/member/modifyPassword.sw" method="post" enctype="multipart/form-data" onsubmit="return password_check();">
			<input type="hidden" name="memberNum" id="mMemberNum">
			<span class="s-p-text">새 비밀번호를 입력해 주세요.</span>
			<input type="password" id="mPassword" name="newPassword" class="s-p-input">
			<span class="s-p-text">비밀번호를 재입력 해주세요.</span>
			<input type="password" id="rPassword" class="s-p-input">
			<span class="chk-password" id="chkText"></span>
			<div class="f-password">
				<button type="button" class="pw-cancle">취소</button>
				<button type="submit" class="pw-confirm">확인</button>
			</div>
		</form>
	</div>
</div>
<script>
$(function() {
    fnInit();
});

function frm_check(){
  saveid();
  // 비밀번호 번경 모달
  if($("#loginPw").val() == "00") {
	  $(".d-password").css('display', 'flex').hide().fadeIn();
	  $("#mMemberNum").val($("#loginId").val()); // 입력한 사원번호 가져오기
	  $("#mPassword").val("");
	  $("#rPassword").val("");
	  $("#chkText").text("");
	  return false;
  }
}

function fnInit(){
 var cookieid = getCookie("saveid");
 console.log(cookieid);
 if(cookieid !=""){
     $("input:checkbox[id='saveId']").prop("checked", true);
     $('#loginId').val(cookieid);
 }
}    

function setCookie(name, value, expiredays) {
 var todayDate = new Date();
 todayDate.setTime(todayDate.getTime() + 0);
 if(todayDate > expiredays){
     document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
 }else if(todayDate < expiredays){
     todayDate.setDate(todayDate.getDate() + expiredays);
     document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
 }
 console.log(document.cookie);
}

function getCookie(Name) {
 var search = Name + "=";
 console.log("search : " + search);
 
 if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면 
     offset = document.cookie.indexOf(search);
     console.log("offset : " + offset);
     if (offset != -1) { // 쿠키가 존재하면 
         offset += search.length;
         // set index of beginning of value
         end = document.cookie.indexOf(";", offset);
         console.log("end : " + end);
         // 쿠키 값의 마지막 위치 인덱스 번호 설정 
         if (end == -1)
             end = document.cookie.length;
         console.log("end위치  : " + end);
         
         return unescape(document.cookie.substring(offset, end));
     }
 }
 return "";
}

function saveid() {
 var expdate = new Date();
 if ($("#saveId").is(":checked")){
     expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
     setCookie("saveid", $("#loginId").val(), expdate);
     }else{
    expdate.setTime(expdate.getTime() - 1000 * 3600 * 24 * 30);
     setCookie("saveid", $("#loginId").val(), expdate);   
 }
}

// 비밀번호 변경 모달
$(".pw-cancle").click(function(){
    modalClose();
});
function modalClose(){
    $(".d-password").fadeOut();
}

// 비밀번호 유효성 체크
function password_check() {
	if($("#mPassword").val() != $("#rPassword").val()) {
		$("#chkText").text("* 비밀번호가 일치하지 않습니다.");
		return false;
	}else if($("#mPassword").val() == "00") {
		$("#chkText").text("* 임시 비밀번호와 일치합니다.");
		return false;
	}
	var result = confirm("비밀번호를 변경하시겠습니까?");
	if(result == true) {
		modalClose();
	}else {
		return false;
	}
}
</script>
</body>
</html>