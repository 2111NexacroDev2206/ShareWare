<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재자 선택</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
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
</body>
<script>
	var varType; // 결재자/참조자 구분 넣을 변수 선언
	// 결재자/참조자 선택 모달
	function appBtn(type) {
		varType = type; // 변수에 type 넣어주기
		if(type == "app") {
			$("#header").html("결재자 선택");
			$("#s-text").html("결재자");
		}else if(type == "ref"){
			$("#header").html("참조자 선택");
			$("#s-text").html("참조자");
		}
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
		$.ajax({
			url : "/modal/member/list.sw",
			type : "get",
			success : function(mList) {
				$("#s-value").val(""); // 검색 입력창 지우기
				appList(mList, type);
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
	    $("#s-list").html(""); // 결재자/참조자 선택 텍스트 초기화
	}
	
	// 결재자/참조자 선택 사원 검색
	$("#btn-search").click(function(type) {
		var searchCondition = $("#s-condition").val();
		var searchValue = $("#s-value").val(); 
		$.ajax({
			url : "/modal/member/search.sw",
			type : "get",
			data : { "searchCondition" : searchCondition,  "searchValue" : searchValue },
			success : function(mList) {
				appList(mList, type);
			},
			error : function() {
				alert("사원 목록 검색 실패");
			}
		})
	});
	
	// 사원 목록 불러오기
	function appList(mList, type) {
		$("#m-list-table").html(""); // 테이블 값 지우기
		var tr;
		$.each(mList, function(i) {
			tr += '<tr class="tr"><td style="display:none;">' + mList[i].memberNum
			+ '</td><td>' + mList[i].division
			+ '</td><td>' + mList[i].memberName
			+ '</td><td>' + mList[i].rank + '</td></tr>';
		});
		$("#m-list-table").append(tr);
		appSelect(type); // 결재자/참조자 선택
	}
	
	// 결재자/참조자 선택
	var Arr = new Array(); // 선택한 결재자/참조자를 담을 배열 선언
	var arrText = new Array(); // 화면에 보여줄 텍스트 배열 선언
	function appSelect(type) {
		Arr = []; // 배열 비우기
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
				if(type == "app") {
					if(Arr.length < 3) { // 선택한 결재자 수가 3보다 작으면
						Arr.push(trArr); // 객체를 배열에 담기
					}else {
						alert("결재자는 3명까지만 선택할 수 있습니다.");
					}
				}else if(type == "ref"){
					Arr.push(trArr);
				}
			}
			Arr.forEach(function(el, index) {
				arrText.push(el.division +" "+ el.memberName +" "+ el.rank);
			});
			$("#s-list").html(arrText.join("<br>")); // 개행해서 s-list 영역에 출력
		});
	}
	// 선택한 결재자/참조자 문서 작성 페이지에 표시
	function appSelView() {
		if(varType == "app") {
			for(var i = 0; i < 3; i++) { // 전에 입력한 값이 있을 경우 대비 초기화
				$("#d-app" + i).text("");
				$("#name-app" + i).text("");
				$("#num-app" + i).val("");
			}
			var app = []; // 결재자 담을 배열 선언
			Arr.forEach(function(el, i){
				$("#d-app" + i).text(el.division);
				$("#name-app" + i).text(el.memberName);
				app[i] = el.memberNum;
			});
			$("#num-app").val(app);
		}else if(varType == "ref"){
			$("#ref-list").text(arrText.join(", "));
			var ref = []; // 참조자 담을 배열 선언
			Arr.forEach(function(el, i){
				ref[i] = el.memberNum;
			})
			$("#num-ref").val(ref);
		}
	}
</script>
</html>