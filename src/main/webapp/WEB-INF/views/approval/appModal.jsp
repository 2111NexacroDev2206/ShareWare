<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재자 선택</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
</head>
<body>
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title">결재자 선택</span>
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
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm">확인</span>
				<span class="m-btn cancel" id="cancel">취소</span>
			</div>
		</div>
	</div>
</body>
<script>
	// 결재자 선택 모달
	function appBtn() {
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
		$.ajax({
			url : "/modal/member/list.sw",
			type : "get",
			success : function(mList) {
				var tr;
				$.each(mList, function(i) {
					tr += '<tr><td style="display:none;">' + mList[i].memberNum
					+ '</td><td>' + mList[i].division + ' ' + mList[i].memberName + ' '+ mList[i].rank + '</td></tr>';
				});
				$("#m-list-table").append(tr);
				appSelect(); // 결재자 선택
			},
			error : function() {
				alert("사원 목록 조회 실패");
			}
		})
	}
	$("#cancel").click(function(){
	    modalClose();
    });
	$("#confirm").click(function(){
	    modalClose();
	});
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
	
	// 결재자 선택 사원 검색
	$("#btn-search").click(function() {
		var searchCondition = $("#s-condition").val();
		var searchValue = $("#s-value").val(); 
		$.ajax({
			url : "/modal/member/search.sw",
			type : "get",
			data : { "searchCondition" : searchCondition,  "searchValue" : searchValue },
			success : function(mList) {
				$("#m-list-table").html(""); // 테이블 값 지우기
				var tr;
				$.each(mList, function(i) {
					tr += '<tr><td style="display:none;">' + mList[i].memberNum
					+ '</td><td id="">' + mList[i].division + ' ' + mList[i].memberName + ' '+ mList[i].rank + '</td></tr>';
				});
				$("#m-list-table").append(tr);
			},
			error : function() {
				alert("사원 목록 검색 실패");
			}
		})
	});
	
	// 결재자 선택
	function appSelect() {
		$("#m-list-table tr").click(function(){
			var str = "";
			var tdArr = new Array(); // 배열 선언
			
			// 현재 클릭된 Row(<tr>)
		});
	}
</script>
</html>