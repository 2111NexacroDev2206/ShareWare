<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/community/communityDetail-style.css">
</head>
<body>
<jsp:include page="communityMenu.jsp"></jsp:include>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
				<form action="/community/modifyView.sw" method="GET" enctype="multipart/form-data" id="upDateForm">
							<div class="WriteDiv">작성자 : ${community.member.memberName }</div>
							<c:if test="${loginUser.memberNum == community.memberNum}">
								<div class="optionBtnDiv">
								<c:url var="update" value="/community/modifyView.sw">
									<c:param name="comNo" value="${community.comNo }"></c:param>
								</c:url>
								<button type="button" id="upload" onclick="location.href='${update}'">수정</button> <!-- 변수 update value comNo을 가지고  /community/modifyView.sw실행-->
								<button type="button" id="delete" onclick="deleteCommunity(replyCount)">삭제</button>
								</div>
							</c:if>
							<div class="optionBtnDiv">
								<button type="button" id="return" onclick="location.href='/fileBoard/list.sw'">목록</button>
							</div>
							<div class="dateDiv">작성일 : ${community.comDate}</div>
							
							<div id="community-TileDiv">${community.comTitle}</div>
							<div id="community-ContentDiv">${community.comContent}
							
							<c:if test="${community.comImgName != null}">
								<div class="imgDiv">
									<img src = "../../../resources/loadFile/${community.comImgRename}" alt="${community.comImgName}">
								</div>
							</c:if>
									
										<div id="vote-body-div">
										</div>
						</div>
						</form>
						<div id="replyDiv">
						<!-- 댓글 작성-->
						</div>
						<div id="replyListDiv">
							<table width="500" id="listTable" class="type04">
							<!-- 출력 -->
								<tbody>
									<tr>
									</tr>
									<tr>
									</tr>
								</tbody>
							</table>
				</div>
			</div>
		</div>
	</div>
<script>
	var replyCount =0;
	getCommunityReply();
	viewCommunityVote();
	
	function select1(comVoteNo){
		var select = 1;
		voteSelect(select, comVoteNo)
	}
	
	function select2(comVoteNo){
		var select = 2;
		voteSelect(select, comVoteNo)
	}
	
	function select3(comVoteNo){
		var select = 3;
		voteSelect(select, comVoteNo)
	}
	
	function select4(comVoteNo){
		var select = 4;
		voteSelect(select, comVoteNo)
	}

	
	//투표
	function voteSelect(select, comVoteNo){
		
			var cSelect = select;
			var comNo ="${community.comNo}";
			var comVoteNo = comVoteNo;
			var memberNum = "${loginUser.memberNum}";
			
			$.ajax({
				url: "/community/insertCommunityVote.sw",
				type: "GET",
				data: {"comNo": comNo
					,"comVoteNo": comVoteNo
					,"cSelect" : cSelect
					,"memberNum":memberNum}
				,success : function(data) {
					if(data == "success") {
						alert("투표완료");
						viewCommunityVote();
					}else {
						alert("투표 실패!");
					}
				},
				error : function() {
					alert("ajax 통신 오류! 관리자에게 문의해주세요.");
				}
		})
		
	};
	

	function viewCommunityVote(){
		var comNo = "${community.comNo}";
		
			$.ajax({
			url: "/community/viewCommunityVote.sw"
			,type: "get"
			,data: { "comNo" : comNo }
			,dataType : "json"
			,success : function(data) {
					var comVoteNo = data.communityVote.comVoteNo; 
					var loginUser ="${loginUser.memberNum}";
					var writer = "${community.memberNum}";
					var vote3 = data.communityVote.cVoteText3;
					var vote4 = data.communityVote.cVoteText4;
					var cSelectTrue = data.cVoteSelect.cSelectTrue; 
					var cVoteState = data.communityVote.cVoteState; 
					var cVoteSelect = data.cVoteSelect.cSelect;
					
					console.log(cVoteSelect);
					
					if(cSelectTrue == 1 || cVoteState ==2 || writer == loginUser ){ 
						var $voteBodyDiv = $("#vote-body-div");
						$voteBodyDiv.html("");
						var $voteBox1 = $("<div id=\"voteBox1-div\" class=\"voteBox\">");
						var $voteText1 = $("<div id=\"voteTextBox1-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText1);
						var $voteSelect1 = $("<div id=\"voteSelect1-div\"class=\"voteSelect\">").text(data.communityVote.cVoteSelect1+"표");
						var $voteBox2 = $("<div id=\"voteBox2-div\" class=\"voteBox\">");
						var $voteText2 = $("<div id=\"voteTextBox2-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText2);
						var $voteSelect2 = $("<div id=\"voteSelect2-div\"class=\"voteSelect\">").text(data.communityVote.cVoteSelect2+"표");
						if(vote3 != null){
							var $voteBox3 = $("<div id=\"voteBox3-div\" class=\"voteBox\">");
							var $voteText3 = $("<div id=\"voteTextBox3-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText3);
							var $voteSelect3 = $("<div id=\"voteSelect3-div\"class=\"voteSelect\">").text(data.communityVote.cVoteSelect3+"표");
						}
						if(vote4 != null){
							var $voteBox4 = $("<div id=\"voteBox4-div\" class=\"voteBox\">");
							var $voteText4 = $("<div id=\"voteTextBox4-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText4);
							var $voteSelect4 = $("<div id=\"voteSelect4-div\" class=\"voteSelect\">").text(data.communityVote.cVoteSelect4+"표");
						}
						if(writer == loginUser && cVoteState != 2){
							var $voteEndDiv = $("<div id=\"voteEndDiv\">");
							var $voteEndButton = $("<button type=\"button\" id=\"andVoteButton\"  onclick='andVote()'>투표종료</button>");
						}
							
							$voteBox1.append($voteText1);
							$voteBox1.append($voteSelect1);
							$voteBodyDiv.append($voteBox1);
							$voteBox2.append($voteText2);
							$voteBox2.append($voteSelect2);
							$voteBodyDiv.append($voteBox2);
							if(vote3 != null){
								$voteBox3.append($voteText3);
								$voteBox3.append($voteSelect3);
								$voteBodyDiv.append($voteBox3);
							};
							if(vote4 != null){
								$voteBox4.append($voteText4);
								$voteBox4.append($voteSelect4);
								$voteBodyDiv.append($voteBox4);
								
							}
							if(writer == loginUser && cVoteState != 2){
								$voteEndDiv.append($voteEndButton);
								$voteBodyDiv.append($voteEndDiv);
							}
							if(writer == loginUser){
								$("#voteSelect1-div").css("background","white");
								$("#voteSelect1-div").css("color","black");
								$("#voteSelect2-div").css("background","white");
								$("#voteSelect2-div").css("color","black");
								$("#voteSelect3-div").css("background","white");
								$("#voteSelect3-div").css("color","black");
								$("#voteSelect4-div").css("background","white");
								$("#voteSelect4-div").css("color","black");
							}else if(cVoteSelect == 1 ){
								$("#voteSelect1-div").css("background","RGB(147, 169, 209)");
								$("#voteSelect1-div").css("color","white");
							}else if(cVoteSelect == 2 ){
								$("#voteSelect2-div").css("background","RGB(147, 169, 209)");
								$("#voteSelect2-div").css("color","white");
							}else if(cVoteSelect == 3 ){
								$("#voteSelect3-div").css("background","RGB(147, 169, 209)");
								$("#voteSelect3-div").css("color","white");
							}else if(cVoteSelect == 4 ){
								$("#voteSelect4-div").css("background","RGB(147, 169, 209)");
								$("#voteSelect4-div").css("color","white");
							}
						
						}else if(cSelectTrue != 1 || cVoteState !=2 || writer != loginUser ){
							var $voteBodyDiv = $("#vote-body-div");
							$voteBodyDiv.html("");
							var $voteBox1 = $("<div id=\"voteBox1-div\" class=\"voteBox\">");
							var $voteText1 = $("<div id=\"voteTextBox1-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText1);
							var $voteSelect1 = $("<button type=\"button\" id=\"selectBtn1\" class=\"voteSelectBtn\"onclick='select1("+comVoteNo+")'>투표</button>");
							var $voteBox2 = $("<div id=\"voteBox2-div\" class=\"voteBox\" >");
							var $voteText2 = $("<div id=\"voteTextBox2-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText2);
							var $voteSelect2 = $("<button type=\"button\" id=\"selectBtn2\" class=\"voteSelectBtn\" onclick='select2("+comVoteNo+")'>투표</button>");
							if(vote3 != null){
								var $voteBox3 = $("<div id=\"voteBox3-div\" class=\"voteBox\">");
								var $voteText3 = $("<div id=\"voteTextBox3-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText3);
								var $voteSelect3 = $("<button type=\"button\" id=\"selectBtn3\" class=\"voteSelectBtn\" onclick='select3("+comVoteNo+")'>투표</button>");
							}
							if(vote4 != null){
								var $voteBox4 = $("<div id=\"voteBox4-div\" class=\"voteBox\">");
								var $voteText4 = $("<div id=\"voteTextBox4-div\" class=\"voteTextBox\">").text(data.communityVote.cVoteText4);
								var $voteSelect4 = $("<button type=\"button\" id=\"selectBtn4\" class=\"voteSelectBtn\" onclick='select4("+comVoteNo+")'>투표</button>");
							}
								
								$voteBox1.append($voteText1);
								$voteBox1.append($voteSelect1);
								$voteBodyDiv.append($voteBox1);
								$voteBox2.append($voteText2);
								$voteBox2.append($voteSelect2);
								$voteBodyDiv.append($voteBox2);
								if(vote3 != null){
									$voteBox3.append($voteText3);
									$voteBox3.append($voteSelect3);
									$voteBodyDiv.append($voteBox3);
								};
								if(vote4 != null){
									$voteBox4.append($voteText4);
									$voteBox4.append($voteSelect4);
									$voteBodyDiv.append($voteBox4);
								}
								
						}
			},
			error : function() {
				var $voteBodyDiv = $("#vote-body-div");
				$voteBodyDiv.html("");
				$("#vote-body-div").css("display","none");
			}
		})
		
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
	
	//투표종료
	function andVote(){
		var comNo = "${community.comNo}";
		$.ajax({
			url: "/community/endVoteCommunity.sw",
			type: "GET",
			data: {"comNo": comNo},
			success : function(data) {
				if(data == "success") {
					alert("투표가 종료 되었습니다.");
					var $voteEndDiv = $("#voteEndDiv");
					$voteEndDiv.html("");
					
				}else {
					alert("투표 종료 실패!");
				}
			},
			error : function() {
				alert("ajax 통신 오류! 관리자에게 문의해주세요.");
			}
		})
	}


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
				var count = data.length; 
				var $replyDiv = $("#replyDiv");
				$replyDiv.html("");
				var $divCountReply = $("<div>");
				var $divCountReplySpan = $("<span>").html("<b>댓글("+count+")</b>");
				$divCountReply.append($divCountReplySpan);
				$replyDiv.append($divCountReply);
				
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글 입력창 추가ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var $insertDiv = $("<div id=\"insertDiv\">"); 
				var $inputTextDiv = $("<div id=\"inputTextDiv\">");
				var $insertBtnDiv = $("<div id=\"insertBtnDiv\">");
				var $inputText = $("<input type=\"text\" id=\"replyContent\">");
				var $btnInsert = $("<button type=\"button\" id=\"replyInsert\" onclick='insertReply()'>작성</button>");
				$inputTextDiv.append($inputText);
				$insertBtnDiv.append($btnInsert);
				$insertDiv.append($inputTextDiv);
				$insertDiv.append($insertBtnDiv);
				$replyDiv.append($insertDiv);
				
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글 출력ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				
				var $listTable = $("#listTable tbody");
				$listTable.html("");
				for(var i = 0; i < data.length; i++){
					var loginUser = "${loginUser.memberNum}";
					var User = data[i].memberNum;
					
					var $tr = $("<tr>");
					var $rContent = $("<td class=\"contentTd\">").text(data[i].replyContent);
					var $rWriter  = $("<td width='100' class=\"defualtTd\">").text(data[i].member.memberName);
					var $rReplyDate  = $("<td width='100' class=\"defualtTd\">").text(data[i].replyDate);
					if(loginUser==User){
						var $btnArea 	 = $("<td width='120' class=\"defualtTd\">")
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
			error   : function() {
				replyCount = 0;
				var $replyDiv = $("#replyDiv");
				$replyDiv.html("");
				var $divCountReply = $("<div>");
				var $divCountReplySpan = $("<span>").html("<b>댓글(0)</b>");
				$divCountReply.append($divCountReplySpan);
				$replyDiv.append($divCountReply);
				//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글작성 란ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
				var $insertDiv = $("<div id=\"insertDiv\">"); 
				var $inputTextDiv = $("<div id=\"inputTextDiv\">");
				var $insertBtnDiv = $("<div id=\"insertBtnDiv\">");
				var $inputText = $("<input type=\"text\" id=\"replyContent\">");
				var $btnInsert = $("<button type=\"button\" id=\"replyInsert\" onclick='insertReply()'>작성</button>");
				$inputTextDiv.append($inputText);
				$insertBtnDiv.append($btnInsert);
				$insertDiv.append($inputTextDiv);
				$insertDiv.append($insertBtnDiv);
				$replyDiv.append($insertDiv);
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
		
		$.ajax({
			url  : "/community/replyAdd.sw",
			type : "post",
			data : { "comNo" : comNo,
					"replyContent" : replyContent }, 
			success  : function(data) { 
				getCommunityReply();
				$("#replyContent").val("");
			},
			error 	 : function() { 
				alert("ajax 실패!") 
			},
			complete : function() {}
		});
	}
	
	//댓글 수정 보기
	function modReplyView(obj, comNo, replyNo, replyContent) {
		var $tr = $(obj).parent().parent();
		$tr.html("");
		var $tdModify = $("<td colspan='3'>");
		var $tdModifyBtn = $("<td width='120'>").append("<a href='javascript:void(0)'onclick='modifyReply("+comNo+","+replyNo+");'>수정 </a>")
												.append("<a href='javascript:void(0)' onclick='getCommunityReply();'>취소</a>");
		
		$tdModify.append("<input type='text' size='50' value='"+replyContent+"' id='modifyData'>"); 
		$tr.append($tdModify);
		$tr.append($tdModifyBtn);
		$(obj).parent().parent().after($tr)
		
	}
	
	//댓글 수정
	function modifyReply(comNo, replyNo){
			var replyContent = $("#modifyData").val(); 
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
		function removeReply(comNo, replyNo) {
			$.ajax({
				url  : "/community/deleteReply.sw",
				type : "get",
				data : { "comNo" : comNo, "replyNo" : replyNo },
				success : function(data) {
					if(data == "success") {
						getCommunityReply();
					}else{
						alert("댓글 삭제 실패!");
					}
				},
				error 	: function() {
					alert("Ajax 통신 실패!!");
				}
			});
		}
	

</script>
</body>
</html>