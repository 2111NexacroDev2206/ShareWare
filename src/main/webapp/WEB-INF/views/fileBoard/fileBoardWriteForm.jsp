<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료게시판 글쓰기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
		<h1>게시글 등록 페이지(임시)</h1>
	<form action="/community/register.sw" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="fileTitle"></td>
			
		</tr>
		<tr>
			<td>본문</td>
			<td><textarea id="fileContent" rows="" cols=""></textarea></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" id="fileIn"></td>
		</tr>
		<tr>
			<td>
				<button type="button" id="fileInsert">등록</button>
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
	<script>
	 $("#fileInsert").on("click", function(){
		 var fileTitle = $("#fileTitle").val();
		var fileContent = $("#fileContent").val();
		const fileInput = $("#fileIn")[0];
		
		if(uploadFile =! null){
			 const formData = new FormData();
			  formData.append("uploadFile", fileInput.files[0]);
			   formData.append("fileTitle", fileTitle);
			   formData.append("fileContent", fileContent.trim());
			   
			  jQuery.ajax({
		             url : "/fileBoard/register.sw"
		           ,processData: false
		           ,contentType: false
		           , type : "POST"
		           , data : formData
		           , success:function(data){
		        	   if(data == "success"){
		        		   alert("등록 완료!");
		           }else{
		        	   alert("등록 실패!");
		        	   }
		        },error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
			})
		}else{
			alert("파일을 등록해주세요!");
		}
		
	});
	
	</script>
</body>
</html>