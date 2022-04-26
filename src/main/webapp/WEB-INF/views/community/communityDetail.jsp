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

			<!-- 글쓴이, 투표 종료 전 -->
			<c:choose>
				<c:when test="${loginUser.memberNum == community.memberNum && communityVote.cVoteState == 0 && communityVote.comVoteNo !=null}">
					<div id="vote-body-div">
							<div id="vote-textbox-div">
								<div id="vote-textbox1-div">
									${communityVote.cVoteText1}
									${communityVote.cVoteSelect1}표
								</div>
								<div id="vote-textbox2-div">
									${communityVote.cVoteText2}
									${communityVote.cVoteSelect2}표
								</div>
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
								<!-- 투표 종료가 되어있으면 해당 버튼이 생성되지 않도록 -->
								<c:if test="${communityVote.cVoteState == 0}">
									<button type="button" id="andVote"> 투표 종료</button>
								</c:if>
								</div>
						</div>
				</c:when>
				<c:when test="${loginUser.memberNum == community.memberNum && communityVote.cVoteState == 0 && communityVote.comVoteNo !=null}">
					<div id="vote-body-div">
							<div id="vote-textbox-div">
								<div id="vote-textbox1-div">
									${communityVote.cVoteText1}
									${communityVote.cVoteSelect1}표
								</div>
								<div id="vote-textbox2-div">
									${communityVote.cVoteText2}
									${communityVote.cVoteSelect2}표
								</div>
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
								<!-- 투표 종료가 되어있으면 해당 버튼이 생성되지 않도록 -->
								<c:if test="${communityVote.cVoteState == 0}">
									<button type="button" id="andVote"> 투표 종료</button>
								</c:if>
								</div>
						</div>
						</c:when>	
			</c:choose>
	</div>
	
</body>
<script>

	$("#andVote").on("click", function(){
		var comNo = "${community.comNo}";
		$.ajax({
			url: "/community/andVoteCommunity.sw",
			type: "GET",
			data: {"comNo": comNo},
			success : function(data) {
				if(data == "success") {
					alert("투표가 종료 되었습니다.");
				}else {
					alert("삭제 실패!");
				}
			},
			error : function() {
				alert("ajax 통신 오류! 관리자에게 문의해주세요.");
			}
		})
	});

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
	
	

	
</script>
</html>