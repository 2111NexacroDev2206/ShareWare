<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>게시글 등록 페이지(임시)</h1>
<form action="/community/register.sw" method="POST" enctype="multipart/form-data" id="uploadForm">  
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="comTitle"></td>
		</tr>
		<tr>
			<td>본문</td>
			<td><div contentEditable="true" id="comContent" style="height:500px;">
				<img id ="img" /></div>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" accept=".jpg,.pdf,.bmp,.png,.jpeg" id="comImgName" onchange="loadImg(this);" ></td>
			<!--onchange="loadImg(this)주기->function loadImg(obj)받기-->
		</tr>
		<tr>
			<td>
				<button type="button" id="comInsert">등록</button>
				<button>취소</button>
				<button>투표등록</button>
			</td>
		</tr>
	</table>
	</form>
	
	<script>
	
	

	const imageInput = $("#comImgName")[0];
	  console.log("imageInput: ", imageInput.files)

	  function loadImg(obj){
		console.log(obj.files);
		if(obj.files.length != 0 && obj.files[0] !=0){
			var reader = new FileReader();
			reader.readAsDataURL(obj.files[0]);
			reader.onload = function(e){
				$("#img").attr("src", e.target.result);
			}
		}
	}
	
	  $("#comInsert").on("click", function(){
			var comTitle = $("#comTitle").val();
			var comContent = $("div").text();
			
			 const formData = new FormData();
			  formData.append("uploadFile", imageInput.files[0]);
			   formData.append("comTitle", comTitle);
			   formData.append("comContent", comContent);
			   
			console.log(comTitle);
			console.log(comContent);
			console.log(comImgName);
			  jQuery.ajax({
		             url : "/community/register.sw"
		           ,processData: false
		           ,contentType: false
		           , type : "POST"
		           , data : formData
		           , success:function(data){
		        	   if(data == "success"){
		        		   location.href = '/community/list.sw';
		           }else{
		        	   alert("삭제 실패!");
		        	   }
		        },error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
			})
		});
	</script>
</body>
</html>