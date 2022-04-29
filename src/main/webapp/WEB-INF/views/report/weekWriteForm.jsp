<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 작성</title>
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 주 간 업 무 일 지</h3>
		<form id="form" action="/report/weekRegister.sw" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${nowTime }" name="wrDate">
		<table border="1">
		<tr> 
			<td rowspan="2">제목</td>
			<td rowspan="2"><input type="text" name="wrTitle" ></td>
			<td>부서명</td>
			<td>${loginUser.division }</td>
		</tr>
		<tr> 
			<td>작성자</td>
			<td><input type="hidden" value="${loginUser.memberName} "name="wrWriter">${loginUser.memberName}</td>
				<input type="hidden" value="${loginUser.memberNum}" name="memNum">
		</tr>
			<tr>
                  <td colspan="4">
                     <textarea name="wrContent" id="t-content">
                     	<table align="center" border="1" cellpadding="1" cellspacing="1" style="width:500px">
							<thead>
								<tr>
									<th scope="col" style="width: 20%;">날짜</th>
									<th scope="col" style="width: 30%;">&nbsp;제목</th>
									<th scope="col">업무 내용</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="width:20%">
									<p>&nbsp;</p>
									</td>
									<td style="width:30%">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
									<p>&nbsp;</p>
									</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
									<p>&nbsp;</p>
									</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
									<p>&nbsp;</p>
									</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
									<p>&nbsp;</p>
									</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>
									<p>&nbsp;</p>
									</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:center"><strong>중 요 사 항</strong></td>
								</tr>
								<tr>
									<td colspan="3">
									<p>&nbsp;</p>
						
									<p>&nbsp;</p>
									</td>
								</tr>
							</tbody>
						</table>
						
						<p>&nbsp;</p>
						                     	
                     </textarea>
				</td>
			</tr>
	 	</table>

		파일첨부 <input type="file"  name="uploadFile"> 
		<input type="reset" value="취소">
		<input type="submit" value="등록" >
	</form>
	</div>
	<script>
	// 주간업무일지 내용	
	CKEDITOR.replace( 'wrContent', {
        height: 500
     } );
	</script>
</body>
</html>