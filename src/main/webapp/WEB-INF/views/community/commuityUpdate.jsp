<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>수정 페이지</h1>
	<c:if test="${loginUser.memberNum == community.memberNum}">
		<button>작성</button>
		<button type="button" id="delete">삭제</button>
	</c:if>
	
	<span>작성일 : ${community.comDate}</span>
	<div dorder="1">${community.comTitle}</div>
	<div dorder="1">${community.comContent}

			
			<c:choose>
				<c:when test="${communityVote.comVoteNo !=null}">
					<div id="vote-body-div">
							<div id="vote-textbox-div">
								<div id="vote-textbox1-div">
									${communityVote.cVoteText1}
								</div>
								<div id="vote-textbox2-div">
									${communityVote.cVoteText2}
								</div>
								<c:if test="${communityVote.cVoteText3 != null}">
									<div id="vote-textbox3-div">
										${communityVote.cVoteText3}
									</div>
								</c:if>
								<c:if test="${communityVote.cVoteText4 != null}">
									<div id="vote-textbox4-div">
										${communityVote.cVoteText4}
									</div>
								</c:if>
								
								<c:if test="${communityVote.cVoteState == 0}">
									<button type="button" id="andVote">삭제 </button>
									<button type="button" id="andVote">수정 </button>
								</c:if>
								</div>
						</div>
				</c:when>
			</c:choose>
	</div>

</body>
</html>