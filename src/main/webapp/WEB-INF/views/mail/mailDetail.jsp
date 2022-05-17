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
		
	
		padding-bottom: 170px;
		border-bottom: 1px lightgray solid;
	}
	.mailWriteMenu {
		float: left;
		margin-top: 120px;
		margin-left: 600px;
		
		
	}
	button {
	display: inline-block;
	width: 80px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
	a {
		margin-left: 400px;
		text-decoration-line: none;
		
	}
	#mailRegister {
	
		
		padding-bottom: 40px;
		margin-left: 440px;
		border-bottom: 2px lightgray solid;
		
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
		margin-left: 440px;
	}
#receiver {
	float:left;
}

.m-detail {
	margin-right: 40px;
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
						<div class="m-detail">
					<button type="submit" id="delete" onclick="javascript: form.action='/mail/mailTemListView.sw'"><a href="${mDelete}">메일 삭제</a></button>
					<%-- <c:if test="${mailCategory == 'S' }"> --%>
					<button type="submit"  onclick="javascript: form.action='/mail/mailListView.sw'">목록</button>
				<%-- 	</c:if> --%>
					<%-- <c:if test="${mailCategory == 'R' }">
					<button type="submit"  onclick="javascript: form.action='/mail/RmailListView.sw'">목록</button>
					</c:if>
					<c:if test="${mailCategory == 'M' }">
					<button type="submit"  onclick="javascript: form.action='/mail/MmailListView.sw'">목록</button>
					</c:if>
						<c:if test="${mailCategory == 'F' }">
					<button type="submit"  onclick="javascript: form.action='/mail/FmailListView.sw'">목록</button>
					</c:if> --%>
						</div>
				</div>
	    	</div>
		</div>
		<div>
	
			<div id="mailRegister">
				<div>
				<input type="hidden" name="mailNo" value="${mail.mailNo}" >
				
				<div style="float:right;">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailToDate}</div>
					</div>
				</div>
					<div>
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<h2>&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-star"></i>&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailSubject}</h2></div>
					</div>
					<br>
					<div>
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<strong>보낸 사람</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>${mail.mailSender}</strong></div>
					</div>
					<br>
					<div style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<strong>받는 사람</strong>&ensp;</div>
						<c:forEach items="${mailRec }" var="mailRec">
						<div id="receiver">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>${mailRec.mailReceiver}</strong>
						</div>
						</c:forEach>
					
					<br>
					<br>
					<div style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<strong>참조인</strong>&ensp;</div>
						<c:forEach items="${mailRef }" var="mailRef">
						<div id="receiver">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>${mailRef.mailReferee} </strong>
						</div>
						</c:forEach>
					
				</div>
			</div>	
		
			<br>
			
		<div id="mailContent">	
			<div class="filebox" style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<i class="fa-solid fa-paperclip"></i>&nbsp;&nbsp;<strong>첨부파일</strong>&ensp;</div>
			<br>
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