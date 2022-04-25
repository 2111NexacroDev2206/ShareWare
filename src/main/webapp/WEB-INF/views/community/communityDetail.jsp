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
	<c:if test="${loginUser.memberNum == community.memberNum}">
		<button>수정</button>
		<button type="button" id="delete">삭제</button>
	</c:if>

	<span>글쓴이 : ${community.memberNum }</span>
	<span>작성일 : ${community.comDate}</span>
	<div dorder="1">${community.comTitle}</div>
	<div dorder="1">${community.comContent}
	
			<c:if test="${loginUser.memberNum == community.memberNum}">
				<div id="vote-body-div">
					<div id="vote-textbox-div">
						<div id="vote-textbox1-div">
							${communityVote.cVoteText1}
							투표 받은 갯수 : ${communityVote.cVoteSelect1}
						</div>
						<div id="vote-textbox2-div">
							${communityVote.cVoteText2}
							투표 받은 갯수 : ${communityVote.cVoteSelect2}
						</div>
						<div id="vote-textbox3-div">
							${communityVote.cVoteText3}
							투표 받은 갯수 : ${communityVote.cVoteSelect3}
						</div>
						<div id="vote-textbox4-div">
							${communityVote.cVoteText4}
							투표 받은 갯수 : ${communityVote.cVoteSelect4}
						</div>
						<button type="button" id="andVote">종료</button>
					</div>
				</div>
		</c:if>
				
	</div>
	
</body>
<script>

	var voteNo = ${communityVote.comVoteNo}
	var voteText3 = ${communityVote.cVoteText3}
	var voteText4 = ${communityVote.cVoteText4}
	
	getCommunityVote();
	
	
	function getCommunityVote(){

		if(voteNo == ""){//화면이 출력 될 때... 투표가 없으면 투표가 보이지 않아야 함
			document.getElementById("vote-body-div").style.display = "none";
		}else if(voteText3 == null){ //값이 없으면 div 출력 x
			document.getElementById("vote-textbox3-div").style.display = "none";
		}else if(voteText4 == null){//값이 없으면 div 출력 x
			document.getElementById("vote-textbox4-div").style.display = "none";
		}
	}

	$("#delete").on("click", function(){
		var comNo = "${community.comNo}";
		var comVoteNo = "${CommunityVote.comVoteNo}";
		$.ajax({
			url: "/community/deleteCommunity.sw",
			type: "GET",
			data: {"comNo": comNo
				,"comVoteNo":comVoteNo},
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
	});
	
	$("#andVote").on("click", function(){
		var comNo = "${community.comNo}";
		var comVoteNo = "${CommunityVote.comVoteNo}";
		$.ajax({
			url: "/community/deleteCommuntyVote.sw",
			type: "GET",
			data: {"comNo": comNo
				,"comVoteNo":comVoteNo},
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
	});
	
	
	
	
	
	
</script>
</html>