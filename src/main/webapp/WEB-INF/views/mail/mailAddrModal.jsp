<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">	
	#m-appSel2 {
		max-width: 400px;
	}
	#m-list2 {
		height: 35%;
		width: 100%;
		
	}
	#m-list-table2 {
		margin: 10px;
		font-size: 14px;
		border-collapse: collapse;
		cursor:pointer;
		width: 280px;
	}
</style>
</head>
<body>
	<div class="m-appSel-wrap" id="appSelModal2">
		<div class="m-appSel" id="m-appSel2">
			<div class="m-header">
				<span class="m-header-title" id="header2"></span>
			</div>
			<div class="m-body" style="width:300px;">
				<div class="m-search">
					<select class="s-select" id="s-condition" name="searchCondition">
						<option value="all">전체</option>
						<option value="division">부서</option>
						<option value="memberName">이름</option>
					</select>
					<div class="s-input">
						<input type="text" id="s-value2" name="searchValue" class="s-text">
						<input type="button" id="btn-search" class="i-search" value="&#xf002;">
					</div>
				</div>
				<div class="m-list" id="m-list2">
					<table id="m-list-table2">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text2"></strong><br>
					<p id="s-list2">
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm2">확인</span>
				<span class="m-btn cancel" id="cancel2">취소</span>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
var Arr2 = new Array(); // 선택한 참여자 담을 배열 선언
var arrText2 = new Array(); // 화면에 보여줄 텍스트 배열 선언
// 참여자 선택 모달
function participant2() {
	$("#header2").html("주소록");
	$("#s-text2").html("주소");
	$("#appSelModal2").css('display', 'flex').hide().fadeIn();
	$.ajax({
		url : "/modal/member/list.sw",
		type : "get",
		success : function(mList) {
			$("#s-value2").val(""); // 검색 입력창 지우기
			appList2(mList);
		},
		error : function() {
			alert("사원 목록 조회 실패");
		}
	})
}
$("#confirm2").click(function(){
	appSelView2();
	 modalClose2();
});
$("#cancel2").click(function(){
    modalClose2();
});
function modalClose2(){
    $("#appSelModal2").fadeOut();
}
//참여자 선택 사원 검색
$("#btn-search2").click(function() {
	var searchCondition = $("#s-condition").val();
	var searchValue = $("#s-value").val(); 
	$.ajax({
		url : "/modal/member/search.sw",
		type : "get",
		data : { "searchCondition" : searchCondition,  "searchValue" : searchValue },
		success : function(mList) {
			appList2(mList);
		},
		error : function() {
			alert("사원 목록 검색 실패");
		}
	})
});
//사원 목록 불러오기
function appList2(mList) {
	$("#m-list-table2").html(""); // 테이블 값 지우기
	var tr2;
	$.each(mList, function(i) {
		tr2 += '<tr class="tr2"><td style="display:none;">' + mList[i].memberNum
		+ '</td><td>' + mList[i].division
		+ '</td><td>' + mList[i].memberName
		+ '</td><td>' + mList[i].rank 
		+ '</td><td>' + mList[i].mail + '</td></tr>';
	});
	$("#m-list-table2").append(tr2);
	appSelect2(); // 참여자 선택
	
	
}


// 선택한 참여자 문서 작성 페이지에 표시
function appSelView2() {
	/* $("#m-bmk").html({mailBmk.bmkSubject}); */
	/* $("#mailRec").val('arrText.join("<br>")'); */
	$("input[name='mailReceiver']").val(arrText2.join(" "))
}
function appSelect2() {
	
	$("#m-list-table2 tr").click(function(){
		var trArr2 = new Object(); // 한 행의 배열을 담을 객체 선언
		var tdArr2 = new Array(); // 배열 선언(사원번호, 부서, 이름, 직급)
		
		// 현재 클릭된 Row(<tr>)
		var tr2 = $(this);
		var td2 = tr2.children();
					
		// 반복문을 이용해서 배열에 값을 담아 사용 가능
		td2.each(function(i){
			tdArr2.push(td2.eq(i).text());
		});
		
		// td.eq(index)를 통해 값 가져와서 trArr 객체에 넣기
		trArr2.memberNum = td2.eq(0).text();
		trArr2.division = td2.eq(1).text();
		trArr2.memberName = td2.eq(2).text();
		trArr2.rank = td2.eq(3).text();
		trArr2.mail = td2.eq(4).text();
		
		// 객체에 데이터가 있는지 여부 판단
		var checkedArrIdx = _.findIndex(Arr2, { memberNum : trArr2.memberNum }); // 동일한 값 인덱스 찾기
		arrText2 = []; // 배열 비우기
		if(checkedArrIdx > -1) {
			_.remove(Arr2, { memberNum : trArr2.memberNum }); // 동일한 값 지우기
		}else {
			Arr2.push(trArr2);
		}
		Arr2.forEach(function(el, index) {
			arrText2.push(el.mail);
			
		});
		$("#s-list2").html(arrText2.join("<br>")); // 개행해서 s-list 영역에 출력
		
	});
}

</script>
</html>