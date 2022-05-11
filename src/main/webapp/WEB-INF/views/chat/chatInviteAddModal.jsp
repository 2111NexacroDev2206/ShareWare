<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 초대</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
<script src="https://kit.fontawesome.com/c7853f4d26.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header"></span>
			</div>
			<div class="m-body">
				<div class="m-search">
					<select class="s-select" id="s-condition" name="searchCondition">
						<option value="all">전체</option>
						<option value="division">부서</option>
						<option value="memberName">이름</option>
					</select>
					<div class="s-input">
						<input type="text" id="s-value" name="searchValue" class="s-text">
						<input type="button" id="btn-search" class="i-search" value="&#xf002;">
					</div>
				</div>
				<div class="m-list">
					<table id="m-list-table">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text"></strong><br>
					<p id="s-list">
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm">확인</span>
				<span class="m-btn cancel" id="cancel">취소</span>
			</div>
		</div>
	</div>
<script>
	var Arr = new Array(); // 선택한 사용자 담을 배열 선언
	var arrText = new Array(); // 화면에 보여줄 텍스트 배열 선언
	// 사용자 선택 모달
	function invite(chatRoomNo, memNum) {
		$("#header").html("사용자 초대");
		$("#s-text").html("사용자");
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
		$.ajax({
			url : "/modal/chat/inviteMember/list.sw",
			type : "get",
			data : { "chatRoomNo" : chatRoomNo },
			success : function(mList) {
				$("#s-value").val(""); // 검색 입력창 지우기
				appList(mList);
			},
			error : function() {
				alert("사원 목록 조회 실패");
			}
		})
	}
	$("#confirm").click(function(){
	    modalClose();
	    appSelView();
	});
	$("#cancel").click(function(){
	    modalClose();
    });
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
	
	// 검색 내용 입력 후 엔터 눌러도 검색되도록 처리
	$("#s-value").keyup(function (e) {
		e.preventDefault();
		var code = e.keyCode ? e.keyCode : e.which;
		if(code == 13) { // 엔터키면
			$("#btn-search").click();
		}
	})
	
	// 사원 검색
	var chatRoomNo = "${chatRoomNo}";
	$("#btn-search").click(function() {
		var searchCondition = $("#s-condition").val();
		var searchValue = $("#s-value").val();
		$.ajax({
			url : "/modal/chat/inviteMember/search.sw",
			type : "get",
			data : { "searchCondition" : searchCondition,  "searchValue" : searchValue, "chatRoomNo" : chatRoomNo },
			success : function(mList) {
				appList(mList);
			},
			error : function() {
				alert("사원 목록 검색 실패");
			}
		})
	});
	
	// 사원 목록 불러오기
	function appList(mList) {
		$("#m-list-table").html(""); // 테이블 값 지우기
		var tr;
		$.each(mList, function(i) {
			tr += '<tr class="tr"><td style="display:none;">' + mList[i].memberNum
			+ '</td><td>' + mList[i].division
			+ '</td><td>' + mList[i].memberName
			+ '</td><td>' + mList[i].rank + '</td></tr>';
		});
		$("#m-list-table").append(tr);
		appSelect(); // 사용자 선택
	}
	
	// 사용자 선택
	function appSelect() {
		$("#m-list-table tr").click(function(){
			var trArr = new Object(); // 한 행의 배열을 담을 객체 선언
			var tdArr = new Array(); // 배열 선언(사원번호, 부서, 이름, 직급)
			
			// 현재 클릭된 Row(<tr>)
			var tr = $(this);
			var td = tr.children();
						
			// 반복문을 이용해서 배열에 값을 담아 사용 가능
			td.each(function(i){
				tdArr.push(td.eq(i).text());
			});
			
			// td.eq(index)를 통해 값 가져와서 trArr 객체에 넣기
			trArr.memberNum = td.eq(0).text();
			trArr.division = td.eq(1).text();
			trArr.memberName = td.eq(2).text();
			trArr.rank = td.eq(3).text();
			
			// 객체에 데이터가 있는지 여부 판단
			var checkedArrIdx = _.findIndex(Arr, { memberNum : trArr.memberNum }); // 동일한 값 인덱스 찾기
			arrText = []; // 배열 비우기
			if(checkedArrIdx > -1) {
				_.remove(Arr, { memberNum : trArr.memberNum }); // 동일한 값 지우기
			}else {
				Arr.push(trArr);
			}
			Arr.forEach(function(el, index) {
				arrText.push(el.division +" "+ el.memberName +" "+ el.rank);
			});
			$("#s-list").html(arrText.join("<br>")); // 개행해서 s-list 영역에 출력
		});
	}
	
	// 사용자 등록
	function appSelView() {
		var ref = []; // 사용자 담을 배열 선언
		Arr.forEach(function(el, i){
			ref[i] = el.memberNum;
		});
		$.ajax({
			url : "/chat/registerChatMember.sw",
			type : "get",
			traditional: true,
			data : { "chatMember" : ref, "chatRoomNo" : chatRoomNo },
			success : function(result) {
				opener.parent.location.reload();
				window.location.reload();
			},
			error : function() {
				alert("사용자 초대 실패");
			}
		});
}
</script>
</body>
</html>