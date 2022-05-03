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
border-top: 1px solid gray;
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
							if(mailCategory =='R'){
							 location.replace("/mail/RmailListView.sw")//page로 새로고침 */
							} else if(mailCategory =='S'){
							 location.replace("/mail/SmailListView.sw")//page로 새로고침 */
							} else if(mailCategory =='M'){
							 location.replace("/mail/MmailListView.sw")//page로 새로고침 */
							} else if(mailCategory =='F'){
							 location.replace("/mail/FmailListView.sw")//page로 새로고침 */
							}
						} else {
							alert("삭제 실패했습니다.")
						}
					}
				});
			}
		}
	</script>
	
		<div class="s-menu">
			<div class="s-menu-title">
				<p>메일
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
			</div>
			<div>
			 	&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" onclick="location.href= 'WriteView.sw';" style="width:90px; height: 35px;">메일쓰기</button>
				&nbsp;&nbsp;<button type="submit" onclick="location.href= 'WriteView.sw';" style="width: 90px; height: 35px;">내게쓰기</button>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="read"><a href="#"><small>안읽음</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="bmk"><a href="#"><small>중요</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="file"><a href="/mail/FmailListView.sw"><small>첨부</small></a></div>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}"><a href="/mail/SmailListView.sw">받은 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="/mail/RmailListView.sw">보낸 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="/mail/MmailListView.sw">내게 쓴 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">보낸 승인 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">즐겨찾는 그룹</a></div>
				<div class="s-list-item ${listCondition eq 'temporary' ? 'active' : ''}"><a href="/mail/mailTemListView.sw">임시 저장함</a></div>

			</div>
		</div>
		
	
	
	<div id="mailRList">
	<button type="submit" onclick="deleteValue();">삭제하기</button>
	<form action="/mail/${mailCategory}mailSearch.sw" method="get">
				<select name="searchCondition">
					<option value="all">전체</option>
					<c:if test="${mailCategory == 'R'}">
					<option value="receiver">수신인</option></c:if>
					<c:if test="${mailCategory == 'S'}">
					<option value="sender">발신인</option></c:if>
					<c:if test="${mailCategory == 'F'}">
					<option value="fileName">파일이름</option></c:if>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select>
			<input type="text" name="searchValue">
			<input type="submit" value="검색">
			
	</form> 	
		<table id="rMail" border="0">
		
			<tr>
				<th colspan="8"><input name="allCheck" type="checkbox" id="allCheck" /></th>
				
			</tr>
			
			<c:forEach items="${mList }" var="mail">
			<!-- 받은 메일 함 -->
			<c:if test="${mailCategory == 'S' }">
				<tr>
					 <c:url var="mDetail" value="/mail/mailDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span><c:if test="${mail.iStatus eq '0'}"><i class="fa-solid fa-paperclip-vertical"></i></c:if>
					<c:if test="${mail.iStatus eq '1'}"></c:if></span><c:out value="${mail.iStatus}"/>
					</td>
					<td width="30px;">${mail.readType }</td>
					<td width="30px;"><c:if test="${mail.mailFileName ne null }"><i class="fa-solid fa-file"></i></c:if>
					<c:if test="${mail.mailFileName eq null }"></c:if>
					</td>
					<td width="150px;">${mail.mailSender }</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="150px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/ddHH:mm:ss" /></td>
				</tr>
				</c:if>
				<!-- 보낸 메일 함 --> 
				<c:if test="${mailCategory == 'R' }">
				<tr>
				
					 <c:url var="mDetail" value="/mail/mailDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
						
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span><c:if test="${mail.iStatus eq '0'}"><i class="fa-solid fa-paperclip-vertical"></i></c:if>
					<c:if test="${mail.iStatus eq '1'}"></c:if></span><c:out value="${mail.iStatus}"/>
					</td>
					<td width="30px;">${mail.readType }</td>
					<td width="30px;"><c:if test="${mail.mailFileName ne null }"><i class="fa-solid fa-file"></i></c:if>
					<c:if test="${mail.mailFileName eq null }"></c:if>
					</td>
					<td width="150px;">${mail.mailReceiver }</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="150px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/ddHH:mm:ss" /></td>
				</tr>
				</c:if>
				<!-- 내게 쓴 메일 함 -->
				<c:if test="${mailCategory == 'M' }">
				
				<tr>
					 <c:url var="mDetail" value="/mail/mailDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox" value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span><c:if test="${mail.iStatus eq '0'}"><i class="fa-solid fa-paperclip-vertical"></i></c:if>
					<c:if test="${mail.iStatus eq '1'}"></c:if></span><c:out value="${mail.iStatus}"/>
					</td>
					<td width="30px;">${mail.readType }</td>
					<td width="30px;"><c:if test="${mail.mailFileName ne null }"><i class="fa-solid fa-file"></i></c:if>
					<c:if test="${mail.mailFileName eq null }"></c:if>
					</td>
					<td width="150px;">${mail.mailReceiver }</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="150px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/ddHH:mm:ss" /></td>
				</tr>
				</c:if>
				<c:if test="${mailCategory == 'F' }">
				<tr>
					 <c:url var="mDetail" value="/mail/mailDetailView.sw">
					<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
						</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}" /></td>
					<td width="30px;">
					<span><c:if test="${mail.iStatus eq '0'}"><i class="fa-solid fa-paperclip-vertical"></i></c:if>
					<c:if test="${mail.iStatus eq '1'}"></c:if></span><c:out value="${mail.iStatus}"/>
					</td>
					<td width="30px;">${mail.readType }</td>
					<td width="30px;"><c:if test="${mail.mailFileName ne null }"><i class="fa-solid fa-file"></i></c:if>
					<c:if test="${mail.mailFileName eq null }"></c:if>
					</td>
					<td width="150px;">${mail.mailReceiver }</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="150px;"><a href="/resources/mUploadFiles/${mail.mailFileRename}" download>${mail.mailFileName}</a></td>
					<td width="150px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/ddHH:mm:ss" /></td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
		<jsp:include page="mailPaging.jsp"></jsp:include>
	</div>
</body>
</html>