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
	display: inline-block;
	width: 80px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}

#rMail {
	width: 1300px;
	margin: 20px 0;
	font-size: 14px;
	text-align: center;
	border-collapse: collapse;
	border-top: 2px solid rgb(200, 200, 200);
	border-bottom: 2px solid rgb(200, 200, 200);
}
#rMail tr {
	border-top: 1px solid rgb(200, 200, 200);
	height: 45px;
}
#rMail tr:hover {
background-color: rgb(250, 250, 250);
}
#rMail th{
background-color: rgb(240, 240, 240);


}
#rMail td {
border-top: 1px solid gray;
border-bottom: 1px solid lightgray;
}
#rMail a {
	text-decoration: none;
	color: black;
	cursor: pointer;
}

#mailRList {
	float: right;
	margin-top: 10%;
	margin-right: 30px;
	}
.l-search {
	display: flex;
	height:40px;
	margin-bottom: 10px;
	float: left;
	display: inline-block;
	width: 100px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(190, 190, 190);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
}
.l-search form{
	display: inline-flex;
}
.l-select {
	height: 40px;
	width: 80px;
	border-radius: 4px;
	border: solid 1px rgb(190, 190, 190);
	margin-right: 5px;
	text-align: center;
	float:left;
}
.l-input {
	display: flex;
	height: 40px;
	width: 190px;
	border-radius: 4px;
	border: solid 1px rgb(190, 190, 190);
}
.l-text {
	display: inline-flex;
	width: 137px;
	border: none;
}
#delete {
	float:left;
	
}
</style>
</head>


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
							location.replace("/mail/mailAppListView.sw")//page로 새로고침
						} else {
							alert("삭제 실패했습니다.")
						}
					}
				});
			}
		}
	</script>
	
	
	<div id="mailRList">
		<button type="submit" id="delete" onclick="deleteValue();">삭제하기</button>
		<form action="/mail/AmailSearch.sw" method="get">
				<select class= "l-select" name="searchCondition" style="text-align: left; width:80px; margin-left:10px;">
					<option value="all">전체</option>
					<option value="receiver">수신인</option>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select>
			<div class="l-input">
			<input type="text" name="searchValue" class="l-text">
			<input type="submit" value="검색" class="l-search" >
			</div>
	</form> 
			<br>
			<div style="width:1300px ;background-color: rgb(145, 168, 210); border:1px solid grey; padding-bottom: 15px; margin-bottom: -20px;">
				<input style="zoom:1.5; margin-left: 5px; margin-top: 5px;" name="allCheck" type="checkbox" id="allCheck" />
			</div>
			<table id="rMail" border="0">
			<c:forEach items="${iList }" var="mail">
				<tr>
					 <c:url var="mDetail" value="/mail/mailIDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
							<c:url var="iRegister" value="/mail/registerI.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span><c:if test="${mail.iStatus eq '0'}"><a href="${iRegister}">
					<i class="fa-regular fa-star"></i></a>
					</c:if>
					<c:if test="${mail.iStatus eq '1'}">
					<i class="fa-solid fa-star"></i>
					</c:if>
					</span>
					</td>
					<td width="30px;"><c:if test="${mail.readType eq '0'}"><i class="fa-regular fa-envelope"></i></c:if>
					<c:if test="${mail.readType eq '1'}"><i class="fa-solid fa-envelope-open-text"></i></c:if>
					</td>
					<td width="30px;"><c:if test="${mail.fStatus eq '0' }"></c:if>
					<c:if test="${mail.fStatus eq '1' }"><i class="fa-regular fa-file"></i></c:if>
					</td>
					<td width="200px;">${mail.mailReceiver }</td>
					<td width="80px;"><c:if test="${mail.mailReceiver eq loginUser.mail && mail.mailSender ne loginUser.mail}">[받은 메일함]</c:if>
						<c:if test="${mail.mailReceiver ne loginUser.mail && mail.mailSender eq loginUser.mail}">[보낸 메일함] </c:if>
						<c:if test="${mail.mailReceiver eq loginUser.mail && mail.mailSender eq loginUser.mail}">[내게 쓴 메일함]</c:if>
					</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="200px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/dd/HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="mailPaging.jsp"></jsp:include>
	</div>
	
</body>
</html>