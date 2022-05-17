<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.m-appSel3 {
		    margin-right:5%;
		    padding-bottom: 2%;
		     padding-right: 3%;
	}
	.m-body3 {
			height: 60%;
		    width: 80%;
	}
	
	.m-list3{
		height: 35%;
		 width: 100%;
		 
	}
	#m-list-table3 {
		margin: 10px;
		font-size: 14px;
		border-collapse: collapse;
		cursor:pointer;
	}
	#header3 {
		margin-left: 10%;
		
	}
</style>
</head>
<body>
		<div class="m-appSel-wrap" id="appSelModal3">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header3"></span>
			</div>
			<div class="m-body">
				<div class="m-search">
					<select class="s-select" id="s-condition" name="searchCondition">
						<option value="all">전체</option>
						<option value="division">부서</option>
						<option value="memberName">이름</option>
					</select>
					<div class="s-input">
						<input type="text" id="s-value3" name="searchValue" class="s-text">
						<input type="button" id="btn-search" class="i-search" value="&#xf002;">
					</div>
				</div>
				<div class="m-list3">
					<table id="m-list-table3">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text3"></strong><br>
					<p id="s-list3">
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm3">확인</span>
				<span class="m-btn cancel" id="cancel3">취소</span>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function participant3() {
	
	$("#header3").html("주소록");
	$("#s-text3").html("주소");
	$("#appSelModal3").css('display', 'flex').hide().fadeIn();
	$.ajax({
		url : "/modal/member/list.sw",
		type : "get",
		success : function(mList) {
			$("#s-value3").val(""); // 검색 입력창 지우기
			appList3(mList);
			
		},
		error : function() {
			alert("사원 목록 조회 실패");
		}
	})
}
$("#confirm3").click(function(){
	$("arrText2").val("");
	appSelView3();
	 modalClose3();
});
$("#cancel3").click(function(){
	$("arrText2").val("");
    modalClose3();
});
function modalClose3(){
    $("#appSelModal3").fadeOut();
}
//참여자 선택 사원 검색
$("#btn-search").click(function() {
	var searchCondition = $("#s-condition").val();
	var searchValue = $("#s-value").val(); 
	$.ajax({
		url : "/modal/member/search.sw",
		type : "get",
		data : { "searchCondition" : searchCondition,  "searchValue" : searchValue },
		success : function(mList) {
			appList3(mList);
		},
		error : function() {
			alert("사원 목록 검색 실패");
		}
	})
});
//사원 목록 불러오기
function appList3(mList) {
	$("#m-list-table3").html(""); // 테이블 값 지우기
	var tr;
	$.each(mList, function(i) {
		tr += '<tr class="tr"><td style="display:none;">' + mList[i].memberNum
		+ '</td><td>' + mList[i].division
		+ '</td><td>' + mList[i].memberName
		+ '</td><td>' + mList[i].rank 
		+ '</td><td>' + mList[i].mail + '</td></tr>';
	});
	$("#m-list-table3").append(tr);
	appSelect3(); // 참여자 선택
}


// 선택한 참여자 문서 작성 페이지에 표시
function appSelView3() {
	/* $("#m-bmk").html({mailBmk.bmkSubject}); */
	/* $("#mailRec").val('arrText.join("<br>")'); */
	
	$("input[name='mailReferee']").eq(0).val(arrText3.join(" "))
}
function appSelect3() {
	$("#m-list-table3 tr").click(function(){
		arrText3 = [];
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
		trArr.mail = td.eq(4).text();
		
		// 객체에 데이터가 있는지 여부 판단
		var checkedArrIdx = _.findIndex(Arr, { memberNum : trArr.memberNum }); // 동일한 값 인덱스 찾기
		arrText3 = []; // 배열 비우기
		if(checkedArrIdx > -1) {
			_.remove(Arr, { memberNum : trArr.memberNum }); // 동일한 값 지우기
		}else {
			Arr.push(trArr);
		}
		Arr.forEach(function(el, index) {
			
			arrText3.push(el.mail);
			
		});
		$("#s-list3").html(arrText3.join("<br>")); // 개행해서 s-list 영역에 출력
	});
}
</script>
</html>