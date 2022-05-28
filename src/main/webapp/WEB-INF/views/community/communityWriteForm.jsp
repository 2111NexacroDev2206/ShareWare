<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/community/communityWriteForm.css">
<script src="https://cdn.ckeditor.com/4.18.0/full-all/ckeditor.js"></script>
</head>
<body>
<jsp:include page="communityMenu.jsp"></jsp:include>
<div id="coreDiv">
	<div id="marging">
	</div>
	<div id="position">
		<div id="contents">
			<form action="/community/register.sw" method="POST" enctype="multipart/form-data" id="uploadForm">  
							
				<div class="optionBtnDiv">
					<button type="button" id="comInsertBtn" onclick = "comInsert()">등록</button>
					<button type="button" id="cancleBtn" onclick="location.href='/community/list.sw'">취소</button>
				</div>
				<div id="community-TitleDiv">
					<input type="text" id="comTitle" placeholder="글 제목을 입력해주세요.">
				</div>
				<div id="community-ContentDiv">
					<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
						<textarea id="comContent" name="content" rows="" cols="" placeholder="글 내용을 입력해주세요."></textarea>
						<div id="vote-body-div">
							<div id="returnBtnDiv">
								<input type="button" id="returnBtn" value="&#xf00d;">
							</div>
							<div id="vote-textbox-div">
								<div id="vote-textbox1-div" class="vote-textbox-div">
									<input id="vote-input1" type="text" class="vote-input">
								</div>
								<div id="vote-textbox2-div" class="vote-textbox-div">
									<input id="vote-input2" type="text" class="vote-input">	
									<input type="button" class="btn-delete">
								</div>
								<div id="vote-textbox3-div" class="vote-textbox-div">
									<input id="vote-input3" type="text" class="vote-input">
									<input type="button" id="btn-delete1" class="btn-delete" value="&#xf056;">
								</div>
								<div id="vote-textbox4-div" class="vote-textbox-div">
									<input id="vote-input4" type="text" class="vote-input">
									<input type="button" id="btn-delete2" class="btn-delete" value="&#xf056;">
								</div>
							</div>
								<div id="button-boxDiv">
									<input type="button" id="voteInputAdd" value="&#xf055;">
									<button type="button" id="voteInsert">등록</button>
									<button type="button" id="voteDelete">삭제</button>

								</div>
							</div>
						</div>		
					<div class="fileDiv">
						<input class="upload-name" value="파일선택" disabled="disabled">				

						<label for="comImgName" class="comImgNameLeble">첨부파일</label>
						<input type="file" accept="image/*" id="comImgName" >
						<button type="button" id="comVoteInsert">투표등록</button>
					</div>
				</form>
			</div>
	</div>
</div>
	
	<script>
	
	document.getElementById("vote-body-div").style.display = "none";
	document.getElementById("vote-textbox3-div").style.display = "none";
	document.getElementById("vote-textbox4-div").style.display = "none";
	document.getElementById("btn-delete1").style.display = "none";
	document.getElementById("btn-delete2").style.display = "none";
	
	const voteBodyDiv =document.getElementById('vote-body-div');

	$("#returnBtn").on("click",function(){
		if(voteBodyDiv.style.display === 'block'){
			voteBodyDiv.style.display = 'none';
			}
	});
	
	$(document).ready(function(){ 
		var fileTarget = $('.fileDiv #comImgName'); 
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


	// CKEditor
/* 		CKEDITOR.replace( 'content', {
				height: 350,
				removePlugins: "exportpdf"
			} );
 */
	$("#comVoteInsert").on("click",function(){

	
		if(voteBodyDiv.style.display === 'none'){
			voteBodyDiv.style.display = 'block';
		}

	});
 
 	

	$("#voteInputAdd").on("click",function(){
		const div1 =document.getElementById('vote-textbox3-div');
		const div2 =document.getElementById('vote-textbox4-div');

		const divButton1 =document.getElementById('btn-delete1');
		const divButton2 =document.getElementById('btn-delete2');
		const divButtonAdd =document.getElementById('voteInputAdd');

		//div1 이 생성됐을 때는 -버튼이 보여야함
		if(div1.style.display === 'none'){
			div1.style.display = 'block';
			divButton1.style.display = 'block';
		//div2가 생성됐을 때는 div1의 -버튼이 보이면 안됨
		}else if(div1.style.display === 'block'){
			div2.style.display = 'block';
			divButtonAdd.style.display = 'none';
			divButton1.style.display = 'none';
			divButton2.style.display = 'block';
		}
	});

	$("#btn-delete1").on("click", function(){
		const div1 =document.getElementById('vote-textbox3-div');
		const divButtonAdd =document.getElementById('voteInputAdd');
		

		if(div1.style.display === 'block'){
			div1.style.display = 'none';
			divButtonAdd.style.display = 'block';
			$("#vote-input3").val("");
		
		}
	});

	$("#btn-delete2").on("click", function(){
		const div2 =document.getElementById('vote-textbox4-div');
		const divButton1 =document.getElementById('btn-delete1');
		const divButtonAdd =document.getElementById('voteInputAdd');

		if(div2.style.display === 'block'){
			div2.style.display = 'none';
			divButton1.style.display = 'block';
			divButtonAdd.style.display = 'block';
			$("#vote-input4").val("");
		}
	});

	// const imageInput = $("#comImgName")[0];
	//   console.log("imageInput: ", imageInput.files)

	//   function loadImg(obj){
	// 	console.log(obj.files);
	// 	if(obj.files.length != 0 && obj.files[0] !=0){
	// 		var reader = new FileReader();
	// 		reader.readAsDataURL(obj.files[0]);
	// 		reader.onload = function(e){
	// 			$("#img").attr("src", e.target.result);
	// 		}
	// 	}
	// }
	
	var cVoteText1 ="";
	var cVoteText2 ="";
	var cVoteText3 ="";
	var cVoteText4 ="";

	$("#voteInsert").on("click", function(){
		 cVoteText1 = $("#vote-input1").val();
		 cVoteText2 = $("#vote-input2").val();
		 cVoteText3 = $("#vote-input3").val();
		 cVoteText4 = $("#vote-input4").val();
		
		
		if(voteBodyDiv.style.display === 'block'){
			   if(cVoteText1 == "" && cVoteText2 == ""){
				   //만약 text1이랑  text2가 값이 없으면
				   alert("투표 선택지를 입력해주세요!");
				}else{//투표 선택지에 값이 있으면 데이터 보내기
				   voteBodyDiv.style.display = 'none';
			   }
			   if(div3.style.display != 'none' && cVoteText3 == ""){
					alert("투표 선택지를 입력해주세요!");
				}else{//투표 선택지에 값이 있으면 데이터 보내기
				   voteBodyDiv.style.display = 'none';
			   }
			   if(div4.style.display != 'none' && cVoteText4 == ""){
					alert("투표 선택지를 입력해주세요!");
			   }else{//투표 선택지에 값이 있으면 데이터 보내기
				   voteBodyDiv.style.display = 'none';
			   }
		}
		
	});
	
	$("#voteDelete").on("click",function(){
		if(voteBodyDiv.style.display === 'block'){
			cVoteText1 ="";
			cVoteText2 ="";
			cVoteText3 ="";
			cVoteText4 ="";
			$("#vote-input1").val("");
			$("#vote-input2").val("");
			$("#vote-input3").val("");
			$("#vote-input4").val("");
			voteBodyDiv.style.display = 'none';
		}

	});


	
	//글 등록comInsert
	const imageInput = $("#comImgName")[0];
	
	function comInsert(){
		 //투표가 보여지고 있을 때
		if(voteBodyDiv.style.display === 'block'){
			alert("투표 작성을 끝마쳐주요.");
		}else{
			var comTitle = $("#comTitle").val();
			var comContent = $('#comContent').val();
				 const formData = new FormData();
				  formData.append("uploadFile", imageInput.files[0]);
				   formData.append("comTitle", comTitle);
				   formData.append("comContent", comContent);
				   
				   if(cVoteText1 != "" || cVoteText2 != "" || cVoteText1 != null || cVoteText2 != null ){
					   formData.append("cVoteText1", cVoteText1);
					   formData.append("cVoteText2", cVoteText2);
					   formData.append("cVoteText3", cVoteText3);
					   formData.append("cVoteText4", cVoteText4);
				   }
			if(comTitle == ""){
						alert("제목을 입력해주세요!");
			}else if(comContent == ""){
				alert("본문을 입력해주세요!");
			}else{
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
			}
		}
	};
	 
			
			 
	</script>
</body>
</html>