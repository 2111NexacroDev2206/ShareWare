<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<h1>수정 페이지</h1>

	
		
	
	<span>작성일 : ${community.comDate}</span>
	<form action="/community/update.sw" method="POST" enctype="multipart/form-data" id="updateForm">  
		<button type="button" id="cancel" onClick="location.href='/community/list.sw'">취소</button>
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="comTitle" value="${community.comTitle}"></td>
			
		</tr>
		<tr>
			<td>본문</td>
			<td>
 				<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
				<input type="text" id="comContent" value="${community.comContent}">
				<input type="text" value="${communityVote.cVoteState}">
					<div>
						<c:if test="${community.comImgName != null}">
							<img src = "../../../resources/loadFile/${community.comImgRename}" alt="${community.comImgName}" id="viewImg">
						</c:if>
							<img id ="img" />
					</div>
			
				<div id="vote-body-div">
					<div id="vote-textbox-div">
						<div id="vote-textbox1-div">
							<input id="vote-input1" type="text" value="${communityVote.cVoteText1}" class="intext">
						</div>
						<div id="vote-textbox2-div">
							<input id="vote-input2" type="text" value="${communityVote.cVoteText2}" class="intext">	
						</div>
						<div id="vote-textbox3-div">
							<input id="vote-input3" type="text" value= "${communityVote.cVoteText3}" class="intext">
							<button type="button" id="btn-delete1" >-</button>
						</div>
						<div id="vote-textbox4-div">
							<input id="vote-input4" type="text" value= "${communityVote.cVoteText4}" class="intext">
							<button type="button" id="btn-delete2">-</button>
						</div>
					</div>
						<div id="button-box">
							<button type="button" id="voteDelete">삭제</button>
							<button type="button" id="voteInputAdd">+</button>
						</div>
					</div>
		
				<!--</div>  -->
				
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" accept=".jpg,.pdf,.bmp,.png,.jpeg" id="comImgName" onchange="loadImg(this);" ></td>
			<!--onchange="loadImg(this)주기->function loadImg(obj)받기-->
		</tr>
		<tr>
			<td>
				<button type="button" id="upDate">수정</button>
				<button>취소</button>
				<button type="button" id="comVoteInsert">투표등록</button>
			</td>
		</tr>
	</table>
	</form>
	
	<script>

	const voteBodyDiv =document.getElementById('vote-body-div');
	const div1 =document.getElementById('vote-textbox3-div');
	const div2 =document.getElementById('vote-textbox4-div');
	const divAddButton = document.getElementById('voteInputAdd');
	const divButton1 =document.getElementById('btn-delete1');
	const divButton2 =document.getElementById('btn-delete2');
	const bookedImg = "${community.comImgName}";
	const bookedImgbox = document.getElementById('viewImg');
	var divText3 ="${communityVote.cVoteText3}";
	var divText4 ="${communityVote.cVoteText4}";
	var voteState = "${communityVote.cVoteState}"
	var voteResult = "${communityVote.comVoteNo}";
	
	//투표가 있을 때는 투표가 보이고 투표가 없을 때 화면을 부르면 투표가 안보이게
	
		if(voteResult != ""){ //투표 번호가 null이 아니면 투표 보이게 하기
			if(divText3 != ""){//선택지 3이 null이 아니면 보이게 하기
				div1.style.display = 'block';
				 
				if(divText4 != ""){//선택지 4가 null이 아니면 보이게 하기
					divButton1.style.display = 'none';
					divButton2.style.display = 'block';
					div2.style.display = 'block';
					}
			}
			if(voteState > 0){//투표한 사람이 있거나 투표 종료가 되어있으면 수정 불가
				$(".intext").attr("readonly",true);
				divButton1.style.display = 'none';
				divButton2.style.display = 'none';
				divAddButton.style.display = 'none';
			}
			
		}else{ // 아니면 안보이게
			voteBodyDiv.style.display = 'none';
			div1.style.display = 'none';
			div2.style.display = 'none';
			divButton1.style.display = 'none';
			divButton2.style.display = 'none';
		}

	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ버튼 관련ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	//투표 등록 버튼을 눌렀을 때 투표가 화면에 없으면 보이게 
	$("#comVoteInsert").on("click",function(){
 	
		if(voteBodyDiv.style.display == 'none'){  //만약 화면에 없으면
			voteBodyDiv.style.display = 'block'; //화면에 보이게
		}
		
	});
	
	//투표 삭제 버튼을 누르면 안보이게
	//만약 투표 테이블이 있으면 테이블 삭제
	//테이블이 없으면 투표 창만 안보이도록
	$("#voteDelete").on("click",function(){
		if(voteResult == null || voteState == 0){
			if(voteBodyDiv.style.display === 'block'){
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
						voteBodyDiv.style.display = 'none';
						div1.style.display = 'none';
						div2.style.display = 'none';
						divButton1.style.display = 'none';
						divButton2.style.display = 'none';
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

		if(div1.style.display === 'block'){
			div1.style.display = 'none';	
		}
	});

	$("#btn-delete2").on("click", function(){

		if(div2.style.display === 'block'){
			div2.style.display = 'none';
			divButton1.style.display = 'block';
		}
	});


	
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ이미지 미리보기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	const imageInput = $("#comImgName")[0]; //첨부파일 input id
	  console.log("imageInput: ", imageInput.files) //콘솔출력
	
	  function loadImg(obj){
		console.log(obj.files);
		if(obj.files.length != 0 && obj.files[0] !=0){//만약 파일 크기가 null이 아니고 파일이 null이 아니면 실행
			var reader = new FileReader();
			reader.readAsDataURL(obj.files[0]);
			reader.onload = function(e){
				$("#img").attr("src", e.target.result);
				
				bookedImgbox.style.display = 'none';
			}
		}
	}	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	$("#update").on("click", function(){
		    
			var comTitle = $("#comTitle").val();
			var comContent = $("#comContent").val();
	
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