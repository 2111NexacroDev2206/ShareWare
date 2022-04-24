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
			<td>
				<div contentEditable="true" id="comContent" style="height:500px;">
					<img id ="img" />
				<div id="vote-body-div">
					<div id="vote-textbox-div">
						<div id="vote-textbox1-div">
							<input id="vote-input1" type="text">
						</div>
						<div id="vote-textbox2-div">
							<input id="vote-input2" type="text">	
						</div>
						<div id="vote-textbox3-div">
							<input id="vote-input3" type="text">
							<button type="button" id="btn-delete1">-</button>
						</div>
						<div id="vote-textbox4-div">
							<input id="vote-input4" type="text">
							<button type="button" id="btn-delete2">-</button>
						</div>
					</div>
						<div id="button-box">
							<button type="button" id="voteDelete">삭제</button>
							<button type="button" id="voteInsert">등록</button>
							<button type="button" id="voteInputAdd">+</button>
						</div>
				</div>
				</div>
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
				<button type="button" id="comVoteInsert">투표등록</button>
			</td>
		</tr>
	</table>
	</form>
	
	<script>

	document.getElementById("vote-body-div").style.display = "none";
	document.getElementById("vote-textbox3-div").style.display = "none";
	document.getElementById("vote-textbox4-div").style.display = "none";
	document.getElementById("btn-delete1").style.display = "none";
	document.getElementById("btn-delete2").style.display = "none";

	$("#comVoteInsert").on("click",function(){
		const div =document.getElementById('vote-body-div');


		if(div.style.display === 'none'){
			div.style.display = 'block';
		}

	});

	$("#voteDelete").on("click",function(){
		const div =document.getElementById('vote-body-div');


		if(div.style.display === 'block'){
			div.style.display = 'none';
		}

	});


	$("#voteInputAdd").on("click",function(){
		const div1 =document.getElementById('vote-textbox3-div');
		const div2 =document.getElementById('vote-textbox4-div');

		const divButton1 =document.getElementById('btn-delete1');
		const divButton2 =document.getElementById('btn-delete2');

		//div1 이 생성됐을 때는 -버튼이 보여야함
		if(div1.style.display === 'none'){
			div1.style.display = 'block';
			divButton1.style.display = 'block';
		//div2가 생성됐을 때는 div1의 -버튼이 보이면 안됨
		}else if(div1.style.display === 'block'){
			div2.style.display = 'block';
			divButton1.style.display = 'none';
			divButton2.style.display = 'block';
		}
	});

	$("#btn-delete1").on("click", function(){
		const div1 =document.getElementById('vote-textbox3-div');
		

		if(div1.style.display === 'block'){
			div1.style.display = 'none';
		
		}
	});

	$("#btn-delete2").on("click", function(){
		const div2 =document.getElementById('vote-textbox4-div');
		const divButton1 =document.getElementById('btn-delete1');

		if(div2.style.display === 'block'){
			div2.style.display = 'none';
			divButton1.style.display = 'block';
		}
	});

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
			var comContent = $("#comContent").text();
			
		//	var cVoteText1 = $("#vote-input1").val();
		//	var cVoteText2 = $("#vote-input2").val();
		//	var cVoteText3 = $("#vote-input3").val();
		//	var cVoteText4 = $("#vote-input4").val();
			
			 const formData = new FormData();
			  formData.append("uploadFile", imageInput.files[0]);
			   formData.append("comTitle", comTitle);
			   formData.append("comContent", comContent);
			   
		//	   if(cVoteText1 != null && cVoteText2 != null){
			//	   formData.append("cVoteText1", cVoteText1);
			//	   formData.append("cVoteText2", cVoteText2);
			//	   formData.append("cVoteText3", cVoteText3);
			//	   formData.append("cVoteText4", cVoteText4);
			//   }else{
			//	   alert("투표 선택지를 입력해주세요!");
			//   }
			   

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
		        	   alert("등록 실패!");
		        	   }
		        },error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
			})
		});
	</script>
</body>
</html>