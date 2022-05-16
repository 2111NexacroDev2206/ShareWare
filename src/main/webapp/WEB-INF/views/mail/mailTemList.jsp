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

#read {
	width: 50%;
}

#file {
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
	margin-right: 37%;
}

button {
	width: 80px;
	height: 30px;
	border: 1px lightgray solid;
	background: #ffffff;
}

#rMail {
	border-bottom: 1px solid lightgray;
	border-top: 1px solid lightgray;
	width: 930px;
	border-collapse: collapse;
	
	border-left: none; 
	border-right: none; 
	frame:hsides;
	 rules:cols;
}
th{
border-bottom: 1px solid lightgray;
border-top:1px solid lightgray;
background: rgb(136, 168, 209);


}
td {
border-top: 1px solid lightgray;
border-bottom: 1px solid lightgray;
}

#mailRList {
	float: right;
	margin-top: 10%;
	margin-right: 45px;
}
</style>
</head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<script type="text/javascript">
		$(function() {
			$("#allCheck").click(function() {
				var chk_listArr = $("input[name='RowCheck']");
				for (var i=0; i<chk_listArr.length; i++) {
					chk_listArr[i].checked = this.checked;
				}
			});			
			
		});
		/* $(function() {
			var chkObj = document.getElementsByName("RowCheck");
			var rowCnt = chkObj.length;
	
			
			$("input[name='RowCheck']").click(function() {
				if ($("input[name='RowCheck']:checked").length == rowCnt) {
					$("input[name='allCheck']")[0].checked = true;
				} else {
					$("input[name='allCheck']")[0].checked = false;
				}
			});
		}); */
		function deleteValue() {
	
			var valueArr = new Array();
			var list = $("input[name='RowCheck']");
			for (var i = 0; i < list.length; i++) {
				if (list[i].checked) {
					valueArr.push(list[i].value);
				}
			}
	
			if (valueArr.length == 0) {
				alert("선택된 메일이 없습니다.")
			} else {
				var chk = confirm("정말 삭제하시겠습니까?");
	
				$.ajax({
					url : '/mail/chkMailDelete.sw',
					type : 'get',
					traditional : true,
					data : {
						valueArr : valueArr 
					//보내는 변수
					},
					success : function(data) {
						if (data = 1) {
							alert("삭제되었습니다.");
							location.replace("/mail/mailTemListView.sw")//page로 새로고침
						} else {
							alert("삭제 실패했습니다.")
						}
					}
				});
			}
		}
	</script>
	
	<form action="/mail/mailTemListView.sw" method="post">
	
	<!-- <form action="/mail/mailRListView.sw" method="post"></form> -->
	<div id="mailRList">
		<input type="hidden" name="mailReceiver"
			value="${loginUser.memberName }"> 
			<%-- <input type="hidden"name="mailNo" value="${mail.mailNo}"> --%>
		
		<!-- <input type="submit" value="삭제하기" class="btn_ckeck_no" onclick="">  -->
		<button type="submit" onclick="deleteValue();">삭제하기</button>
		
		<br>
		<table id="rMail" border="0">

			<tr>
				<th colspan="7"><input name="allCheck" type="checkbox" id="allCheck" /></th>
				
			</tr>
			<c:forEach items="${tList }" var="mail">
				<tr>
					 <c:url var="mDetail" value="/mail/mailTemDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span > <c:if test="${mail.iStatus eq '0'}"><i class="fa-solid fa-paperclip-vertical"></i></c:if>
					<c:if test="${mail.iStatus eq '1'}"></c:if></span><c:out value="${mail.iStatus}"/>
					</td>
					<td width="30px;">${mail.readType }</td>
					<td width="30px;">${mail.fStatus }</td>
					<td width="150px;">${mail.mailSender }</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="150px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/dd/HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="mailPaging.jsp"></jsp:include>
	</div>
	</form>
</body>
</html>