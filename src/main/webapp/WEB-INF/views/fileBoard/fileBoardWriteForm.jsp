<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료게시판 글쓰기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/fileBoard/fileBoardWriteForm.css">
</head>
<body>
	<jsp:include page="../notice/noticeMenu.jsp"></jsp:include>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
					<form action="/fileBoard/register.sw" method="post" enctype="multipart/form-data">
						<div class="optionBtnDiv">
							<button type="button" id="fileInsertBtn">등록</button>
							<button type="button" id="cancleBtn" onclick="location.href='/fileBoard/list.sw'">취소</button>
						</div>
						<div id="fileBoard-TitleDiv">
							<input type="text" id="fileTitle" placeholder="글 제목을 입력해주세요.">
						</div>
						<div id="fileBoard-ContentDiv">
								<textarea id="fileContent" rows="" cols="" placeholder="글 제목을 입력해주세요."></textarea>
						</div>
						<div class="fileDiv">
							<input class="upload-name" value="파일선택" disabled="disabled">				

							<label for="fileName" class="fileNameLeble">첨부파일</label>
							<input type="file" id="fileName" >
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
	
	$(document).ready(function(){ 
		var fileTarget = $('.fileDiv #fileName'); 
		fileTarget.on('change', function(){ 
			// 값이 변경되면 
			if(window.FileReader)
			{ // modern browser
			 var filename = $(this)[0].files[0].name; 
			} else { 
				// old IE 
				var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
			} // 추출한 파일명 삽입 
			$(this).siblings('.upload-name').val(filename); }); });

	const fileInput = $("#fileName")[0];
	
	 $("#fileInsertBtn").on("click", function(){
		 var fileTitle = $("#fileTitle").val();
		 var fileContent = $("#fileContent").val();
		 
		if(fileInput.files.length == 0){
			alert("파일을 등록해주세요!");
		}else{
			const formData = new FormData();
			  formData.append("uploadFile", fileInput.files[0]); //컨트롤러에서 받을 때  "upload File"
			   formData.append("fileTitle", fileTitle);
			   formData.append("fileContent", fileContent);
			   
			  jQuery.ajax({
		             url : "/fileBoard/register.sw"
		           ,processData: false
		           ,contentType: false
		           , type : "POST"
		           , data : formData
		           , success:function(data){
		        	   if(data == "success"){
		        		   location.href = '/fileBoard/list.sw';
		           }else{
		        	   alert("등록 실패!");
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