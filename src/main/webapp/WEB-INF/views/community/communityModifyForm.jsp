<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/community/communityModifyForm.css">
</head>
<body>
	<jsp:include page="communityMenu.jsp"></jsp:include>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
				<form action="/community/update.sw" method="POST" enctype="multipart/form-data" id="updateForm"> 
					<div class="optionBtnDiv">
						<button type="button" id="updateBtn">수정</button>
						<button type="button" id="cancleBtn" onclick="location.href='/community/list.sw'">취소</button>
					</div> 
					<div class="dateDiv">작성일 : ${community.comDate}</div>
					
					<div id="community-TitleDiv">
						<input type="text" id="comTitle" value="${community.comTitle}">
					</div>
					<div id="community-ContentDiv">
						<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
							<textarea id="comContent" name="comContent" rows="" cols="">${community.comContent}</textarea>
							<div id="vote-body-div">
								<div>
									<input type="button" id="returnBtn" value="&#xf00d;">
								</div>
								
								<div id="vote-textbox-div">
									<div id="vote-textbox1-div"  class="vote-textbox-div">
										<input id="vote-input1" type="text" class="vote-input">
									</div>
									<div id="vote-textbox2-div"  class="vote-textbox-div">
										<input id="vote-input2" type="text" class="vote-input">	
										<input type="button"  class="btn-delete">
									</div>
									<div id="vote-textbox3-div"  class="vote-textbox-div">
										<input id="vote-input3"  type="text" class="vote-input">
										<input type="button" id="btn-delete1" class="btn-delete" value="&#xf056;">
									</div>
									<div id="vote-textbox4-div"  class="vote-textbox-div">
										<input id="vote-input4"  type="text" class="vote-input">
										<input type="button" id="btn-delete2" class="btn-delete" value="&#xf056;">
									</div>
								</div>
									<div id="button-boxDiv">
										<input type="button" id="voteInputAdd" value="&#xf055;">
										<button type="button" id="voteInsert">확인</button>
										<button type="button" id="voteDelete">삭제</button>
									</div>
								</div>
							</div>			

							<div class="fileDiv">
								<input class="upload-name" value="파일선택" disabled="disabled">				
		
								<label for="comImgName" class="comImgNameLeble">첨부파일</label>
								<input type="file" accept=".jpg,.pdf,.bmp,.png,.jpeg" id="comImgName" >
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
	const div1 =document.getElementById('vote-textbox1-div');
	const div2 =document.getElementById('vote-textbox2-div');
	const div3 =document.getElementById('vote-textbox3-div');
	const div4 =document.getElementById('vote-textbox4-div');
	const divAddButton = document.getElementById('voteInputAdd');
	const divButton1 =document.getElementById('btn-delete1');
	const divButton2 =document.getElementById('btn-delete2');
	const divButtonAdd =document.getElementById('voteInputAdd');
	const bookedImg = "${community.comImgName}";
	const bookedImgbox = document.getElementById('viewImg');
	var divText1 ="${communityVote.cVoteText1}";
	var divText2 ="${communityVote.cVoteText2}";
	var divText3 ="${communityVote.cVoteText3}";
	var divText4 ="${communityVote.cVoteText4}";
	var voteState = "${communityVote.cVoteState}";
	var voteResult = "${communityVote.comVoteNo}";
	var cVoteText1 ="";
	var cVoteText2 ="";
	var cVoteText3 ="";
	var cVoteText4 ="";

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ파일이름 추출&출력ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

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
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ버튼 관련ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	if(voteState != 0){
		$("#voteInsert").css("background-color","rgb(158, 158, 158)");
		$("#voteInsert").css("border","rgb(158, 158, 158)");
		$("#voteInsert").css("color","white");
		$("#voteInsert").attr("disabled",true);

		$("#btn-delete1").css("color","rgb(158, 158, 158)");
		$("#btn-delete1").attr("disabled",true);

		$("#btn-delete2").css("color","rgb(158, 158, 158)");
		$("#btn-delete2").attr("disabled",true);

		$("#voteInputAdd").css("color","rgb(158, 158, 158)");
		$("#voteInputAdd").attr("disabled",true);

	}

	$("#returnBtn").on("click",function(){
		if(voteBodyDiv.style.display === 'block'){
			voteBodyDiv.style.display = 'none';
			cVoteText1 = $("#vote-input1").val();
			cVoteText2 = $("#vote-input2").val();
			cVoteText3 = $("#vote-input3").val();
			cVoteText4 = $("#vote-input4").val();
			}
	});
	//투표 등록 버튼을 눌렀을 때 투표가 화면 보이게 
	$("#comVoteInsert").on("click",function(){
		if(voteBodyDiv.style.display == 'none'){  //만약 화면에 없으면
			voteBodyDiv.style.display = 'block'; //화면에 보이게
			$("#vote-input1").val(divText1);
			$("#vote-input2").val(divText2);
			if(divText3 != ""){//선택지 3이 null이 아니면 보이게 하기
				div3.style.display = 'block'; 
				divButton1.style.display = 'block';
				if(divText4 != ""){//선택지 4가 null이 아니면 보이게 하기
					divButton1.style.display = 'none';
					divButton2.style.display = 'block';
					divButtonAdd.style.display ='none';
					div4.style.display = 'block';
					}
					$("#vote-input1").val(divText1);
					$("#vote-input2").val(divText2);
					$("#vote-input3").val(divText3);
					$("#vote-input4").val(divText4);
				}
			}
	});

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ투표등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	

	$("#voteInsert").on("click", function(){
		 cVoteText1 = $("#vote-input1").val();
		 cVoteText2 = $("#vote-input2").val();
		 cVoteText3 = $("#vote-input3").val();
		 cVoteText4 = $("#vote-input4").val();
		
		
		if(voteBodyDiv.style.display === 'block'){
			if(cVoteText1 == "" && cVoteText2 == "" || div3.style.display != 'none' && cVoteText3 == "" ||div4.style.display != 'none' && cVoteText4 == ""){
				   //만약 text1이랑  text2가 값이 없으면
				   alert("투표 선택지를 입력해주세요!");
				}else{//투표 선택지에 값이 있으면 데이터 보내기
				   voteBodyDiv.style.display = 'none';
		}
	}
		
	});
	
	
	//투표 삭제 버튼을 누르면 안보이게
	//만약 투표 테이블이 있으면 테이블 삭제
	//테이블이 없으면 투표 창만 안보이도록
	$("#voteDelete").on("click",function(){
		if(voteResult == null || voteResult == 0){ //이전 투표가 없었으면 투표를 삭제하는 ajax를 실행시키지않고
			//그냥 비워줌
			if(voteBodyDiv.style.display === 'block'){
			cVoteText1 ="";
			cVoteText2 ="";
			cVoteText3 ="";
			cVoteText4 ="";
			divText1 = "";
			divText2 = "";
			divText3 = "";
			divText4 = "";
			$("#vote-input1").val("");
			$("#vote-input2").val("");
			$("#vote-input3").val("");
			$("#vote-input4").val("");
			voteBodyDiv.style.display = 'none';
			}
		}else{
			var comNo = "${community.comNo}";
			var cSelect = "${cVoteSelect.cSelect}";
			
			$.ajax({
				url: "/community/deleteCommuntyVote.sw",
				type: "GET",
				data: {"comNo": comNo
					,"cSelect":cSelect},
				success : function(data) {
					if(data == "success") {
						alert("투표삭제 성공!");
						cVoteText1 ="";
						cVoteText2 ="";
						cVoteText3 ="";
						cVoteText4 ="";
						divText1 = "";
						divText2 = "";
						divText3 = "";
						divText4 = "";
						$("#vote-input1").val("");
						$("#vote-input2").val("");
						$("#vote-input3").val("");
						$("#vote-input4").val("");
						voteBodyDiv.style.display = 'none';
					}else {
						alert("삭제 실패!");
					}
				},
				error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
			})
		}
			
	
		});
	
	$("#voteInputAdd").on("click",function(){
		
		//div1 이 생성됐을 때는 -버튼이 보여야함
		if(div3.style.display === 'none'){
			div3.style.display = 'block';
			divButton1.style.display = 'block';
			divButtonAdd.style.display = 'block';
		//div2가 생성됐을 때는 div1의 -버튼이 보이면 안됨
		}else if(div3.style.display === 'block'){
			div4.style.display = 'block';
			divButton1.style.display = 'none';
			divButton2.style.display = 'block';
			divButtonAdd.style.display = 'none';
		}
	});
	
	$("#btn-delete1").on("click", function(){

		if(div3.style.display === 'block'){
			div3.style.display = 'none';
			cVoteText3 ="";
			$("#vote-input3").val("");
		}
	});

	$("#btn-delete2").on("click", function(){

		if(div4.style.display === 'block'){
			div4.style.display = 'none';
			divButton1.style.display = 'block';
			cVoteText4 ="";
			$("#vote-input4").val("");
		}
	});
	
	// //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ이미지 미리보기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// const imageInput = $("#comImgName")[0]; //첨부파일 input id
	//   console.log("imageInput: ", imageInput.files) //콘솔출력
	
	//   function loadImg(obj){
	// 	console.log(obj.files);
	// 	if(obj.files.length != 0 && obj.files[0] !=0){//만약 파일 크기가 null이 아니고 파일이 null이 아니면 실행
	// 		var reader = new FileReader();
	// 		reader.readAsDataURL(obj.files[0]);
	// 		reader.onload = function(e){
	// 			$("#img").attr("src", e.target.result);
				
	// 			bookedImgbox.style.display = 'none';
	// 		}
	// 	}
	// }

		
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	const imageInput = $("#comImgName")[0];

	$("#updateBtn").on("click", function(){
		
		if(voteBodyDiv.style.display === 'block'){
			alert("투표 작성을 끝마쳐주요.");
		}else{
				var comTitle = $("#comTitle").val();
				var comContent = $("#comContent").val();
				var comNo = "${community.comNo}";
				var cVoteState = "${communityVote.cVoteState}";
				
				 const formData = new FormData();
				  formData.append("uploadFile", imageInput.files[0]);
				  formData.append("comNo", comNo);
				   formData.append("comTitle", comTitle);
				   formData.append("comContent", comContent);
				   formData.append("cVoteState", cVoteState);
				   
				   if(cVoteText1 != "" || cVoteText2 != "" || cVoteText1 != null || cVoteText2 != null){
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
				             url : "/community/modify.sw"
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
	});

	</script>

</body>
</html>