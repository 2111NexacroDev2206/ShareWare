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
		margin-left: 480px;
		
		
	}
	.btn-mail {
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
#file-square {
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	 padding-bottom: 30px;
	 padding-top: 20px;
	 margin-right: 200px;
	 margin-left: 100px;
	 
	
}
</style>


</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<script type="text/javascript">
	function refreshList(){ //실행시 재로드
		location.reload();
	}
	function detailDelete(obj) {
		if(confirm("메일을 삭제하시겠습니까?")) {
			var inputTag = $(obj).prev();
			var paramObj = {};
			var paramData = inputTag[0].value.split("/");
			paramObj.mailNo = paramData[0];
			paramObj.rNo = paramData[1]; 
			paramObj.refYn = paramData[2];
			paramObj.mailCate = paramData[3];
			paramObj.mailType = paramData[4];
			$.ajax({				
				url : '/mail/mailDelete.sw',
				type : 'get',
				data : { "paramObj" : JSON.stringify(paramObj) },
				success : function(data) {
					debugger;
					if (data == "success") {
						alert("삭제되었습니다.");
						location.href="/mail/"+paramData[3]+"mailListView.sw"
// 						refreshList();
					} else {
						alert("실패했습니다.")
					}
				}
			});
		}
	}
	// 답장
    function replyMail() {
       var mailNo= ${mail.mailNo};
          location.href='/mail/mailReplyView.sw?mailNo='+mailNo;
       
    }
 // 전달
    function relayMail() {
       var mailNo= ${mail.mailNo};
          location.href='/mail/mailRelayView.sw?mailNo='+mailNo;
       
    }
    function impValue(obj) {
		var mailCategory = document.querySelector("#mailCategory").value;
		var inputTag = $(obj).prev();
		var paramObj = {};
		var paramData = inputTag[0].value.split("/");
		paramObj.mailNo = paramData[0];
		paramObj.rNo = paramData[1]; 
		paramObj.refYn = paramData[2];
		paramObj.mailCate = paramData[3];
		paramObj.mailType = paramData[4];
			
		console.log(paramObj);
		$.ajax({				
			url : '/mail/registerI.sw',
			type : 'get',
			traditional : true,
			data : { "paramObj" : JSON.stringify(paramObj) },
			success : function(data) {
				if (data) {
					alert("중요메일함에 추가되었습니다.");
					
					refreshList();
				} else {
					alert("실패했습니다.")
				}
			}
		});
	}
	function impCancel(obj) {
		var mailCategory = document.querySelector("#mailCategory").value;
		var inputTag = $(obj).prev();
		var paramObj = {};
		var paramData = inputTag[0].value.split("/");
		paramObj.mailNo = paramData[0];
		paramObj.rNo = paramData[1]; 
		paramObj.refYn = paramData[2];
		paramObj.mailCate = paramData[3];
		paramObj.mailType = paramData[4];
			
		console.log(paramObj);
		$.ajax({				
			url : '/mail/cancelI.sw',
			type : 'get',
			traditional : true,
			data : { "paramObj" : JSON.stringify(paramObj) },
			success : function(data) {
				if (data) {
					alert("중요메일함에서 삭제되었습니다.");
					
					refreshList();
				} else {
					alert("실패했습니다.")
				}
			}
		});
	}
	</script>
	<form action="/mail/${mailCategory }mailDetailView.sw" method="post" enctype="multipart/form-data">
		<div>
	 		<div class="mailHeader">
	   	 		<div class= "mailWriteMenu">
					<div class="m-detail">
					<input name="m-value" type="hidden" value="${mail.mailNo}/${mail.recNo}/${mail.refYn }/${mailCategory}/${mail.mailType}" />
					<button type="submit" id="delete" class="btn-mail " onclick="detailDelete(this);">메일 삭제</button>
					<button type="button" class="btn-mail" onclick= "replyMail();" > 답장하기</button>
					<button type="button" class="btn-mail"  onclick= "relayMail();"> 전달하기</button>
					<%-- <c:if test="${mailCategory == 'S' }"> --%>
					<button type="submit" class="btn-mail "  onclick="javascript: form.action='/mail/${mailCategory}mailListView.sw'">목록</button>
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
				<br>
				<div style="float:right; margin-right: 200px;">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;<strong>${mail.mailToDate}</strong>&nbsp;&nbsp;</div>
					</div>
				</div>
				<br>
					<div>
						<div>
						<h2>
						
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-circle-check" style="color:grey;"></i>&nbsp;&nbsp;${mail.mailSubject}</h2></div>
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
			<div class="filebox" style="float:left;">&emsp;&emsp;&nbsp;&nbsp;<strong><i class="fa-solid fa-paperclip" style="color:grey;"></i></strong>&nbsp;&nbsp;<strong>첨부파일</strong>&ensp;</div>
			<br>
			<br>			<c:if test="${mail.fStatus eq '1' }">
							<div id="file-square">
							<c:forEach items="${mailFile }" var="mailFile">
							&emsp;<i class="fa-solid fa-file-arrow-down" style="color: grey"></i>&nbsp;&nbsp;<a href="/resources/mUploadFiles/${mailFile.mailFileRename}"download>${mailFile.mailFileName}</a><br>
							</c:forEach>
							</div>
							</c:if>
							<c:if test="${mail.fStatus eq '0' }">
							</c:if>
			
			<br>
			<br>
			
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mail.mailContent}</div>
			</div>	
			
	
		</form>
</body>
</html>