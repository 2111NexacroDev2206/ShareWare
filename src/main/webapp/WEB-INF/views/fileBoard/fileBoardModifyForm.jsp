<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../resources/css/fileBoard/fileBoardModifyForm.css">
</head>
<body>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>자료실
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'community' ? 'active' : ''}"><a href="/community/list.sw?docStatus=전체">자유게시판</a></div>
		<div class="s-list-item ${listCondition eq 'notice' ? 'active' : ''}"><a href="/notice/list.sw?docStatus=전체">공지게시판</a></div>
		<div class="s-list-item ${listCondition eq 'fileBoard' ? 'active' : ''}"><a href="/fileBoard/list.sw?docStatus=전체">자료실</a></div>
	</div>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
		
			
			<form action="/fileBoard/update.sw" method="POST" enctype="multipart/form-data" id="updateForm">
				<div class="optionBtnDiv">
					<button type="button" id="updateBtn">수정</button>
					<button type="button" id="cancleBtn" onClick="location.href='/fileBoard/list.sw'">취소</button>
				</div>
				<div class="dateDiv">작성일 : ${fileBoard.fileBoardDate}</div>
				<div id="fileBoard-TitleDiv">
					<input type="text" id="fileBoardTitle" value="${fileBoard.fileBoardTitle}">
				</div>
				<div id="fileBoard-ContentDiv">
					<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
					<textarea id="fileBoaedContent" name="fileBoaedContent" rows="" cols="">${fileBoard.fileBoaedContent}</textarea>
				</div>
				<div class="fileDiv">
					<input class="upload-name" value="파일선택" disabled="disabled">				

					<label for="fileName" class="fileNameLeble">첨부파일</label>
					<input type="file" id="fileName" >
				</div>
					<!--<td><input type="file" id="fileName"></td>-->	
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
	  console.log("fileInput: ", fileInput.files)

	  
	  
		$("#updateBtn").on("click", function(){
			
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