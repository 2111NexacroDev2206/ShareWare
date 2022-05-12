<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정 페이지</h1>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<span>작성일 : ${fileBoard.fileBoardDate}</span>
	<form action="/fileBoard/update.sw" method="POST" enctype="multipart/form-data" id="updateForm">  
			<button type="button" id="cancel" onClick="location.href='/fileBoard/list.sw'">취소</button>
			<button type="button" id="modify">수정</button>
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="fileBoardTitle" value="${fileBoard.fileBoardTitle}"></td>
			
		</tr>
		<tr>
			<td>본문</td>
			<td>
				<input type="text" id="fileBoaedContent" value="${fileBoard.fileBoaedContent}">
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" id="fileName"></td>
		
		</tr>
	</table>
	</form>
	
	<script>
	const fileInput = $("#fileName")[0];
	  console.log("fileInput: ", fileInput.files)
	  
		$("#modify").on("click", function(){
			
			if(fileInput.files.length == 0){
				  alert("파일을 등록해주세요");
		           }else{
		        	   var fileBoardTitle = $("#fileBoardTitle").val();
						var fileBoaedContent = $("#fileBoaedContent").val();
						var fileBoardNo = "${fileBoard.fileBoardNo}";
						
						 const formData = new FormData();
						 formData.append("uploadFile", fileInput.files[0]); //컨트롤러에서 받을 때  "upload File"
						   formData.append("fileBoardTitle", fileBoardTitle);
						   formData.append("fileBoaedContent", fileBoaedContent);
						   formData.append("fileBoardNo", fileBoardNo);
						   
						jQuery.ajax({
				             url : "/fileBoard/modify.sw"
				           ,processData: false
				           ,contentType: false
				           , type : "POST"
				           , data : formData
				           , success:function(data){
				        	   if(data == "success"){
				        		   location.href = '/fileBoard/list.sw';
		        	   }else{
		        	   alert("수정 실패!");
		        	   }
		        },error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
			})
			}	
		});
	</script>
</body>
</html>