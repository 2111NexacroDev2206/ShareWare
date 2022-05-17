<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		
	
		padding-bottom: 210px;
		border-bottom: 1px lightgray solid;
	}
	.mailWriteMenu {
		float: right;
		margin-top: 12%;
		
		
	}
	button {
		width: 80px;
		height: 30px;
		border : 1px lightgray solid;
		background: #ffffff;
		
			
	}
	#delete {
		margin-left: 400px;
		
	}
	#mailRegister {
	
		
		margin-top: 1%;
		margin-left: 30%;
		padding-bottom: 1%;
		border-bottom: 1px lightgray solid;
		
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
	#mailContent {
		margin-left: 30%;
	}

</style>


</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<script type="text/javascript">
		function deleteAll() {
			$.ajax({
				url : '/mail/mailDelete.sw',
				type : 'get',
				traditional : true,
				data : {
					mailNo : mailNo
				//보내는 변수
				},
				success : function(data) {
						
						location.replace("/mail/mailListView.sw")//page로 새로고침
					
				}
			});
		};
	</script>
	<form action="/mail/mailIDetailView.sw" method="post" enctype="multipart/form-data">
		<div>
		
   	 			<div class="mailHeader">
	   	 		<div class= "mailWriteMenu">
					<c:url var="mDelete" value="/mail/mailDelete.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<button type="submit" id="delete" onclick="javascript: form.action='/mail/mailTemListView.sw'"><a href="${mDelete}">메일 삭제</a></button>
					<button type="submit" onclick="javascript: form.action='/mail/mailListView.sw'">목록</button>
					
				</div>
	    	</div>
		</div>
		<div>
			<div id="mailRegister">
				<div>
				<input type="hidden" name="mailNo" value="${mail.mailNo}" >
				<input type="hidden" name="mailSubject" value="${mail.mailSubject}" >
				
					<div>
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<h1>&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-star"></i>&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailSubject}</h1></div>
					</div>
					<br>
					<div>
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<small>보낸 사람</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailSender}</div>
					</div>
					<br>
					<div>
					
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<small>받는 사람</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mailRec.mailReceiver}</div>
						
					</div>
					<br>
					<div>
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<small>참조인</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mailRef.mailReferee}</div>
					</div>
					
				</div>
			</div>	
		
			<br>
			
		<div id="mailContent">	
			<div>
				<div class="filebox"><small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<i class="fa-solid fa-paperclip"></i>&nbsp;&nbsp;<b>첨부파일 </b></small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <a href="/resources/mUploadFiles/${mailFile.mailFileRename}" download>${mailFile.mailFileName}</a></div>
			</div>
			<br>
			<br>
			
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailContent}</div>
			</div>	
		</div>
		</form>
</body>
</html>