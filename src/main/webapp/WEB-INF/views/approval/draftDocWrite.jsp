<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include>
	<div class="s-container">
		<h1>기안서</h1>
		<form action="/approval/draftDocWrite.sw" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td>문서번호</td>
					<td></td>
					<td rowspan="3">결재</td>
					<td>담당</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>기안일</td>
					<td>${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
					<td></td>
					<td><button>선택</button></td>
					<td><button>선택</button></td>
					<td><button>선택</button></td>
				</tr>
				<tr>
					<td>기안자</td>
					<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
					<td>${loginUser.memberName }</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="6">참조자</td>
					<td><button>선택</button></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="6"><input type="text" name="docTitle"></td>
				</tr>
				<tr>
					<td colspan="7" align="center">내용</td>
				</tr>
				<tr>
					<td colspan="7" align="center"><textarea cols="50" rows="10" name="docContent"></textarea></td>
				</tr>
			</table>
			<p>파일 첨부
			<input type="file" name="uploadFile">
			<br>
			<input type="submit" value="결재 요청">
			<input type="button" value="임시 저장">
			<input type="reset" value="취소">
		</form>
	</div>
</body>
</html>