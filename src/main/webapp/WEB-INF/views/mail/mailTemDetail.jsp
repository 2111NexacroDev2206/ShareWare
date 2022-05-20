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
		margin-right: 5%;
		
	}
	.btn-mail {
		width: 80px;
		height: 30px;
		border : 1px lightgray solid;
		background: #ffffff;
		
			
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
#receiver {
	float:left;
}
a{
	text-decoration-line: none;
}
</style>


</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<form action="/mail/mailTemDetailView.sw" method="post" enctype="multipart/form-data">
		
		
		
   	 		<div class="mailHeader">
	   	 		<div class= "mailWriteMenu">
					
					<button type="submit" class="btn-mail" onclick="javascript: form.action='mailRegister.sw'">메일보내기</button>
					<c:url var="mModify" value="/mail/temModifyView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<a href="${mModify }"><button type="button" class="btn-mail">수정하기</button></a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:url var="mDelete" value="/mail/mailDelete.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<button type="submit" id="delete" class="btn-mail" onclick="javascript: form.action='/mail/mailTemListView.sw'"><a href="${mDelete}">메일 삭제</a></button>
					<button type="submit" class="btn-mail" onclick="javascript: form.action='/mail/mailTemListView.sw'">목록</button>
					
				</div>
	    	</div>
		
		
			<div id="mailRegister">
				<div>
				<input type="hidden" name="mailNo" value="${mail.mailNo}" >
				
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
					<div style="float:left;">&emsp;&emsp;&nbsp;<strong>받는 사람</strong>&ensp;</div>
						<c:forEach items="${mailRec }" var="mailRec">
						<div id="receiver">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mailRec.mailReceiver} 
						</div>
						</c:forEach>
					<br>
					<div style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<strong>참조인</strong>&ensp;</div>
						<c:forEach items="${mailRef }" var="mailRef">
						<div id="receiver">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mailRef.mailReferee} 
						</div>
						</c:forEach>
				</div>
			</div>	
		
			<br>
			
		<div id="mailContent">	
			<div class="filebox" style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<i class="fa-solid fa-paperclip"></i>&nbsp;&nbsp;<strong>첨부파일</strong>&ensp;</div>
							<c:forEach items="${mailFile }" var="mailFile">
							<div id=""><a href="/resources/mUploadFiles/${mailFile.mailFileRename}"download>${mailFile.mailFileName}</a>
							</div>
							</c:forEach>
			<br>
			<br>
			
			<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailContent}</div>
		</div>	
	
		</form>
</body>
</html>