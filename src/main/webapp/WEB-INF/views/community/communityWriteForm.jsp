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
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>자유게시판
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
			<form action="/community/register.sw" method="POST" enctype="multipart/form-data" id="uploadForm">  
							
				<div class="optionBtnDiv">
					<button type="button" id="comInsert">등록</button>
					<button type="button" id="cancle" onclick="location.href='/community/list.sw'">취소</button>
				</div>
				<div id="community-TileDiv">
					<input type="text" size="50" id="comTitle">
				</div>
				<div id="community-ContentDiv">
					<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
						<textarea id="comContent" name="content" rows="" cols=""></textarea>
						<div>
							<img id ="img" />
						</div>
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
									<button type="button" id="voteInputAdd">+</button>
								</div>
							</div>
					</div>		
					<div>
						첨부파일<input type="file" accept=".jpg,.pdf,.bmp,.png,.jpeg" id="comImgName" onchange="loadImg(this);" >
					</div>
						<!--onchange="loadImg(this)주기->function loadImg(obj)받기-->
					
							<button type="button" id="voteDelete">삭제</button>
							<button type="button" id="comVoteInsert">투표등록</button>
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
	
	
	// CKEditor
		CKEDITOR.replace( 'content', {
				height: 350,
				removePlugins: "exportpdf"
			} );

	$("#comVoteInsert").on("click",function(){

	
		if(voteBodyDiv.style.display === 'none'){
			voteBodyDiv.style.display = 'block';
		}

	});

	$("#voteDelete").on("click",function(){


		if(voteBodyDiv.style.display === 'block'){
			voteBodyDiv.style.display = 'none';
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

	
	//글 등록comInsert
	  $("#comInsert").on("click", function(){
		    
			var comTitle = $("#comTitle").val();
			var comContent = $('#comContent').val();
			var cVoteText1 = $("#vote-input1").val();
			var cVoteText2 = $("#vote-input2").val();
			var cVoteText3 = $("#vote-input3").val();
			var cVoteText4 = $("#vote-input4").val();
			var insertTrue = 1; //0이면 ajax 동작 x 1이면 동작 되게

			
			 const formData = new FormData();
			  formData.append("uploadFile", imageInput.files[0]);
			   formData.append("comTitle", comTitle);
			   formData.append("comContent", comContent.trim());
			   
			   //투표가 보여지고 있을 때
			   if(voteBodyDiv.style.display === 'block'){
				   if(cVoteText1 == "" && cVoteText2 == ""){
					   //만약 text1이랑  text2가 값이 없으면
					   alert("투표 선택지를 입력해주세요!");
					   insertTrue = 0;
				   }else{//투표 선택지에 값이 있으면 데이터 넣어주기
					   formData.append("cVoteText1", cVoteText1);
					   formData.append("cVoteText2", cVoteText2);
					   formData.append("cVoteText3", cVoteText3);
					   formData.append("cVoteText4", cVoteText4);
					   insertTrue = 1;
				   }
			   }
		if(insertTrue == 1){
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
			
		});
			
			 
	</script>
</body>
</html>