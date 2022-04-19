<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>전자결재
			<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}"><a href="">기안 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="">결재 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">참조 문서함</a></div>
		<div class="s-list-item ${listCondition eq 'temporary' ? 'active' : ''}"><a href="">임시 저장함</a></div>
	</div>
	<div class="s-container">
		<h1>기안서</h1>
		<form action="/approval/draftDocWrite.sw" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<td>문서번호</td>
					<td>D010101</td>
					<td rowspan="3">결재</td>
					<td>담당</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>기안일</td>
					<td></td>
					<td></td>
					<td><button>선택</button></td>
					<td><button>선택</button></td>
				</tr>
				<tr>
					<td>기안자</td>
					<td></td>
					<td>김사원</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="5">참조자</td>
					<td><button>선택</button></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="docTitle"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>