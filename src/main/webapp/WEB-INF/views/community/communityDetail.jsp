<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>자유게시판 상세보기</h1>
	<form action="/community/modifyView.sw" method="GET" enctype="multipart/form-data" id="upDateForm">
	<c:if test="${loginUser.memberNum == community.memberNum}">
		<c:url var="update" value="/community/modifyView.sw">
			<c:param name="comNo" value="${community.comNo }"></c:param>
		</c:url>
		<input type="button" id="upload" onclick="location.href='${update}'" value="수정"/>
		<button type="button" id="delete" onclick="deleteCommunity(replyCount)">삭제</button>
	</c:if>
	
	<span>글쓴이 : ${community.member.memberName }</span>
	<span>작성일 : ${community.comDate}</span>
	<div dorder="1">${community.comTitle}</div>
	<div dorder="1">${community.comContent}
				
		<c:if test="${community.comImgName != null}">
			<img src = "../../../resources/loadFile/${community.comImgRename}" alt="${community.comImgName}">
		</c:if>
				<c:if test="${loginUser.memberNum eq community.memberNum && communityVote.comVoteNo ne null}">
					<div id="vote-body-div">
							<div id="vote-textbox-div">
							<c:if test="${communityVote.cVoteText1 != null}">
								<div id="vote-textbox1-div">
									${communityVote.cVoteText1}
									${communityVote.cVoteSelect1}표
								</div>
							</c:if>
							<c:if test="${communityVote.cVoteText2 != null}">
								<div id="vote-textbox2-div">
									${communityVote.cVoteText2}
									${communityVote.cVoteSelect2}표
								</div>
							</c:if>
								<c:if test="${communityVote.cVoteText3 != null}">
									<div id="vote-textbox3-div">
										${communityVote.cVoteText3}
										${communityVote.cVoteSelect3}표
									</div>
								</c:if>
								<c:if test="${communityVote.cVoteText4 != null}">
									<div id="vote-textbox4-div">
										${communityVote.cVoteText4}
										${communityVote.cVoteSelect4}표
									</div>
								</c:if>
								<c:if test="${communityVote.cVoteState == 0 && communityVote.comVoteNo ne null }">
									<div>
										<button type="button" id="andVote"> 투표 종료</button>
									</div>
								</c:if>
								</div>
						</div>
				</c:if>
				
				<c:if test="${loginUser.memberNum != community.memberNum && communityVote.comVoteNo !=null}">
					<div id="vote-body-div">
							<div id="vote-textbox-div">
								<div id="vote-textbox1-div">
									${communityVote.cVoteText1}
									<c:if test="${cVoteSelect.cSelectTrue == null && communityVote.cVoteState != 2}" >
											<button type="button" id="select1">투표</button>
									</c:if>
									<c:if test="${cVoteSelect.cSelectTrue ==1 || communityVote.cVoteState == 2}" >
											${communityVote.cVoteSelect1}표
									</c:if>
								</div>
								<div id="vote-textbox2-div">
									${communityVote.cVoteText2}
									<c:if test="${cVoteSelect.cSelectTrue == null && communityVote.cVoteState != 2}" >
									<button type="button" id="select2">투표</button>
									</c:if>
									<c:if test="${cVoteSelect.cSelectTrue ==1 || communityVote.cVoteState == 2}" >
									${communityVote.cVoteSelect2}표
									</c:if>
								</div>
								<c:if test="${communityVote.cVoteText3 != null}">
									<div id="vote-textbox3-div">
										${communityVote.cVoteText3}
									</div>
										<c:if test="${cVoteSelect.cSelectTrue == null && communityVote.cVoteState != 2}" >
											<button type="button" id="select3">투표</button>
										</c:if>
										<c:if test="${cVoteSelect.cSelectTrue ==1 || communityVote.cVoteState == 2}" >
											${communityVote.cVoteSelect3}표
										</c:if>
								</c:if>
								<c:if test="${communityVote.cVoteText4 != null}">
									<div id="vote-textbox4-div">
										${communityVote.cVoteText4}
									</div>
									<c:if test="${cVoteSelect.cSelectTrue == null && communityVote.cVoteState != 2}" >
										<button type="button" id="select4">투표</button>
									</c:if>
									<c:if test="${cVoteSelect.cSelectTrue ==1 || communityVote.cVoteState == 2}" >
										${communityVote.cVoteSelect4}표
									</c:if>
								</c:if>
								</div>
						</div>
				</c:if>
	</div>
	</form>
	<div id="replyDiv">
	<!-- 댓글 작성-->
	</div>
	<div id="replyListDiv">
		<table width="500" id="listTable">
		<!-- 출력 -->
			<tbody>
				<tr>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
<script>
	var replyCount =0;
	getCommunityReply();
	
	
	$("#select1").on("click", function(){
		alert("1번 버튼 실행");
		var select = 1;
		voteSelect(select)
	});
	
	$("#select2").on("click", function(){
		alert("2번 버튼 실행");
		var select = 2;
		voteSelect(select)
	});
	
	$("#select3").on("click", function(){
		alert("3번 버튼 실행");
		var select = 3;
		voteSelect(select)
	});
	
	$("#select4").on("click", function(){
		alert("4번 버튼 실행");
		var select = 4;
		voteSelect(select)
	});
	
	function voteSelect(select){
		var cSelectTrue ="${cVoteSelect.cSelectTrue}"
		if(cSelectTrue == 1){
			alert("이미 투표에 참여했습니다.");
		}else{
			var cSelect = select;
			var comNo ="${community.comNo}";
			var comVoteNo = "${communityVote.comVoteNo}";
			var memberNum = "${loginUser.memberNum}";
			
			//voteMember에 insert
			//vote update 해야됨
			$.ajax({
				url: "/community/insetCommunityVote.sw",
				type: "GET",
				data: {"comNo": comNo
					,"comVoteNo": comVoteNo
					,"cSelect" : cSelect
					,"memberNum":memberNum}
				,success : function(data) {
					if(data == "success") {
						alert("투표완료");
					}else {
						alert("투표 실패!");
					}
				},
				error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
		})}
		
	};
	
	
	//글 삭제
	function deleteCommunity(replyCount){
		var comNo = "${community.comNo}";
		var comVoteNo = "${communityVote.comVoteNo}";
		var cSelect = "${cVoteSelect.cSelect}";
		var replyNo = "${replyNo}";
		
			$.ajax({
			url: "/community/deleteCommunity.sw",
			type: "GET",
			data: {"comNo": comNo
				,"comVoteNo":comVoteNo
				,"cSelect":cSelect
				,"replyCount":replyCount},
			success : function(data) {
				if(data == "success") {
					location.href = '/community/list.sw';
				}else {
					alert("삭제 실패!");
				}
			},
			error : function() {
				alert("ajax 통신 오류! 관리자에게 문의해주세요.");
			}
		})
		
	};
	


	//투표 종료
	$("#andVote").on("click", function(){
		var comNo = "${community.comNo}";
		$.ajax({
			url: "/community/endVoteCommunity.sw",
			type: "GET",
			data: {"comNo": comNo},
			success : function(data) {
				if(data == "success") {
					alert("투표가 종료 되었습니다.");
				}else {
					alert("투표 종료 실패!");
				}
			},
			error : function() {
				alert("ajax 통신 오류! 관리자에게 문의해주세요.");
			}
		})
	});

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ덧글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//덧글 보기(삭제, 수정, 등록시에 바로 동작)
	function getCommunityReply(){
		var comNo = "${community.comNo}";
		$.ajax({
			url  : "/community/replyList.sw",
			type : "get",
			data : { "comNo" : comNo },
			dataType : "json",
			success : function(data) {
				replyCount = 1;
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글 갯수 알려 주기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var count = data.length; //댓글의 갯수를 알 수 있음
				var $replyDiv = $("#replyDiv");//기존 div
				$replyDiv.html("");//기존 div안에 있는 html 태그를 전부 지우기
				var $divCountReply = $("<div>");//div 만들기
				var $divCountReplySpan = $("<span>").html("<b>댓글("+count+")</b>");
				$divCountReply.append($divCountReplySpan);//div 안에 span 태그 넣기
				$replyDiv.append($divCountReply);//div 안에 div 넣기
				
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글 입력창 추가ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var $insertDiv = $("<insertDiv>"); //덧글 작성 div
				var $inputTextDiv = $("<inputTextDiv>");
				var $insertBtnDiv = $("<insertBtnDiv>");
				var $inputText = $("<input type=\"text\" id=\"replyContent\">");
				var $btnInsert = $("<button type=\"button\" id=\"replyInsert\" onclick='insertReply()'>작성</button>");
				$inputTextDiv.append($inputText);//input태그를 div에 넣기
				$insertBtnDiv.append($btnInsert);//버튼을 버튼 div에 넣기
				$insertDiv.append($inputTextDiv);
				$insertDiv.append($insertBtnDiv);//두 idv넣기
				$replyDiv.append($insertDiv);//댓글 div에 댓글 입력 div 넣기
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글 출력ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				
				var $listTable = $("#listTable tbody");
				$listTable.html("");
				for(var i = 0; i < data.length; i++){
					var loginUser = "${loginUser.memberNum}";
					var User = data[i].memberNum;
					
					var $tr = $("<tr>");
					var $rContent = $("<td>").text(data[i].replyContent);
					var $rWriter  = $("<td width='100'>").text(data[i].member.memberName);
					var $rReplyDate  = $("<td width='100'>").text(data[i].replyDate);
					if(loginUser==User){
						var $btnArea 	 = $("<td width='120'>")
						.append("<a href='javascript:void(0)' onclick='modReplyView(this,"+data[i].comNo+","+data[i].replyNo+",\""+data[i].replyContent+"\");'>수정</a> ")//this를 넘겨줌
						.append("<a href='javascript:void(0)' onclick='removeReply("+data[i].comNo+","+data[i].replyNo+");'>삭제</a>");
					}else{
						var $btnArea 	 = $("<td width='120'>")
					}
					

					$tr.append($rContent);
					$tr.append($rWriter);
					$tr.append($rReplyDate);
					$tr.append($btnArea);
					$listTable.append($tr);
					

				}
			}, 
			error   : function() {//기본값을 넣지 않고 동적으로 처리하기
				replyCount = 0;
				var $replyDiv = $("#replyDiv");//기존 div
				$replyDiv.html("");//기존 div안에 있는 html 태그를 전부 지우기
				var $divCountReply = $("<div>");//div 만들기
				var $divCountReplySpan = $("<span>").html("<b>댓글(0)</b>");
				$divCountReply.append($divCountReplySpan);//div 안에 span 태그 넣기
				$replyDiv.append($divCountReply);//div 안에 div 넣기
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글작성 란ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var $insertDiv = $("<insertDiv>"); //덧글 작성 div
				var $inputTextDiv = $("<inputTextDiv>");
				var $insertBtnDiv = $("<insertBtnDiv>");
				var $inputText = $("<input type=\"text\" id=\"replyContent\">");
				var $btnInsert = $("<button type=\"button\" id=\"replyInsert\" onclick='insertReply()'>작성</button>");
				$inputTextDiv.append($inputText);//input태그를 div에 넣기
				$insertBtnDiv.append($btnInsert);//버튼을 버튼 div에 넣기
				$insertDiv.append($inputTextDiv);
				$insertDiv.append($insertBtnDiv);//두 idv넣기
				$replyDiv.append($insertDiv);//댓글 div에 댓글 입력 div 넣기
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var $listTable = $("#listTable tbody");
				$listTable.html("");
				var $trMsg	 = $("<tr>");
				var $tdMsg = $("<td colspan='4'>").text("댓글이 없습니다.");
				$trMsg.append($tdMsg);
				$listTable.append($trMsg);
				
			}
		});	
}
	//댓글 등록
	function insertReply(){	
		var comNo = "${community.comNo}";
		var replyContent   = $("#replyContent").val();
		//console.log(rContents);
		// ajax (jQuery 사용해서 Ajax 동작 시킴)
		$.ajax({
			url  : "/community/replyAdd.sw",
			type : "post",
			data : { "comNo" : comNo,
					"replyContent" : replyContent }, // json 형태
			success  : function(data) { 
				// 성공했을 때 댓글 불러오기
				// 작성된 내용 초기화
				getCommunityReply();
				$("#replyContent").val(""); //댓글 등록과 함께 text박스를 지워주기
			},
			// 실패했을 때 실패메시지 alert
			error 	 : function() { 
				alert("ajax 실패!") 
			},
			complete : function() {}
		});
	}
	
	//댓글 수정 보기
	function modReplyView(obj, comNo, replyNo, replyContent) { // 위에서 function을 소환할 때 받기
		var $tr = $(obj).parent().parent();//버튼의 부모의 부모 선택
		$tr.html("");
		var $tdModify = $("<td colspan='3'>");
		var $tdModifyBtn = $("<td width='120'>").append("<button onclick='modifyReply("+comNo+","+replyNo+");'>수정</button>")//this를 넘겨줌
											.append("<button onclick='getCommunityReply();'>취소</button>");
		
		$tdModify.append("<input type='text' size='50' value='"+replyContent+"' id='modifyData'>"); //td에 input 추가+적혀있던 덧글 넣기
		$tr.append($tdModify);
		$tr.append($tdModifyBtn);
		$(obj).parent().parent().after($tr)
		
	}
	
	//댓글 수정
	function modifyReply(comNo, replyNo){
			var replyContent = $("#modifyData").val(); //id로 가져오는 값
			$.ajax({
				url:"/community/modifyReply.sw",
				type:"post",
				data:{"comNo":comNo
					,"replyNo": replyNo
					,"replyContent" : replyContent}
				,success: function(data){
					if(data == "success"){
						getCommunityReply();
					}else{
						alert("댓글 수정 실패");
					}
					
				},
				error : function(){
					alert("Ajax 통신 실패!!");
				}
			})
		}
	
	
		//댓글 삭제기능
		function removeReply(comNo, replyNo) { // 위에서 function을 소환할 때 받기
			// ajax없이(둘다 사용은 못함 둘중 하나로 사용)
			//location.href = '';
			// ajax로
			$.ajax({
				url  : "/community/deleteReply.sw",
				type : "get",
				data : { "comNo" : comNo, "replyNo" : replyNo },//받은 파라미터 값은 사용하기
				success : function(data) {//컨트롤러에서 데이터를 받아옴
					if(data == "success") {//데이터 값이 success면 성공
						// 삭제가 성공하면 댓글 리스트 불러오기
						getCommunityReply();
					}else{
						// 실패시 실패메시지
						alert("댓글 삭제 실패!");//result값이 0이여서 뜨는 에러->where 조건절에 맞는 데이터가 없다.
					}
				},
				error 	: function() {
					alert("Ajax 통신 실패!!");
					//ajax 자체가 돌아가지 않았다.
				}
			});
		}
	
			
	
				
		
		
		
	

	
</script>
</html>