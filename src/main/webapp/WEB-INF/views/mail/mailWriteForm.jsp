<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bmk {
		float: left;
		width: 40%;
	}
	#read{
		
		width: 50%;
	}
	#file{
		float: left;
		width: 40%;
	}
	.mailHeader {
		
		
		padding-bottom: 170px;
		border-bottom: 2px solid rgb(200, 200, 200);
	}
	.mailWriteMenu {
		float: left;
		margin-top: 100px;
		margin-left:500px;
		
	}
	.btn-mail {
	display: inline-block;
	width: 100px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
	#mailRegister {
	
		float: left;
		margin-top: 25px;
		margin-left: 470px;
	}
	#mFile{
    width: 0.1px;
	height: 0.1px;
	
	
	
	}
	
	#mFile + label {
	    border: 1px solid #d9e1e8;
	    background-color: #fff;
	    color: #2b90d9;
	    border-radius: 2rem;
	    padding: 8px 17px 8px 17px;
	    font-weight: 500;
	    font-size: 15px;
	    box-shadow: 1px 2px 3px 0px #f2f2f2;
	    outline: none;
	}
	
	#mFile:focus + label,
	#mFile + label:hover {
	    cursor: pointer;
	}
.fa-paper-plane { 
	color: orange;
}
.fa-user-check {
	color: green;
}
#write {
	color: grey;
}
</style>


</head>

<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<form action="/mail/mailRegister.sw" method="post" enctype="multipart/form-data">
		
		
		
   	 	<div class="mailHeader">
	   	 	<div class= "mailWriteMenu">
					<div>
					<button type="submit"class="btn-mail"  style=" width:110px;" onclick= "javascript: form.action='mailRegister.sw'"><i class="fa-solid fa-paper-plane"></i>&nbsp;<strong>보내기</strong></button>&nbsp;&nbsp;
						<button type="submit" class="btn-mail" onclick= "javascript: form.action='mailTemRegister.sw'"><i class="fa-solid fa-download"></i>&nbsp;<strong>임시 저장</strong></button>
						<button type="submit" class="btn-mail" onclick= "javascript: form.action='mailAppRegister.sw'"><i class="fa-solid fa-user-check"></i>&nbsp;<strong>승인 메일</strong></button>
						<button type="button" class="btn-mail" >발송 예약</button>
						<a href="/mail/WriteMyView.sw"><i class="fa-solid fa-rotate"></i>내게 쓰기</a>&nbsp;&nbsp;
					</div>
				</div>
	    	</div>
		
		<div id="mailRegister">
		<input type="hidden" name="mailSender" value="${loginUser.mail }">
			<div>
				<div><strong id="write">받는사람</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" size="130" style= "height: 30px" id="mailRec"  name="mailReceiver"> &nbsp;<button type="button" class="btn-mail" style="width:80px" onclick="participant2();"><i class="fa-regular fa-address-book"></i>&nbsp;주소록</button>&nbsp;<button type="button" class="btn-mail" style="width: 110px;" onclick="bmk();"><i class="fa-solid fa-at"></i>&nbsp;즐겨찾는 그룹</button></div>
				<!-- <p id="mailReceiver"> -->
			</div>
			<br>
			<div>
				<div><strong id="write">참조인</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" size="130" style= "height: 30px"id="mailReferee" name="mailReferee">&nbsp;&nbsp;<button type="button" class="btn-mail" style="width:80px" onclick="participant3();"><i class="fa-regular fa-address-book"></i>&nbsp;주소록</button>&nbsp;<button type="button" class="btn-mail" style="width: 110px;" onclick="bmk();"><i class="fa-solid fa-at"></i>&nbsp;즐겨찾는 그룹</button></div>
			</div>
			<br>
			<div>
				<div><strong id="write">제목 </strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;<input type="text" size="130" style= "height: 30px" name="mailSubject"></div>
			</div>
			<br>
			<br>
			<div>
				<div class="filebox"><strong id="write">파일첨부 </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="file" id="mFile" name="uploadFiles" multiple/>
					<label for="mFile"><i class="far fa-file-image"/></i>&nbsp;내 PC</label></div>
			</div> 
			<br>
			<br>
			<div>
				<div><textarea rows="25" cols="160" name="mailContent"></textarea></div>
			</div>	
		</div>
		</form>
		<jsp:include page="../mail/mailAddrModal.jsp"></jsp:include>
		<jsp:include page="../mail/mailRecModal.jsp"></jsp:include>
		<jsp:include page="../mail/mailBmkModal.jsp"></jsp:include>
		<jsp:include page="../mail/bmkListModal.jsp"></jsp:include>
		</body>
</html>