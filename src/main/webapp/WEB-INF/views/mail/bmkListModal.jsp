<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
<style type="text/css">
	.m-appSel {
		    margin-right:5%;
		    padding-bottom: 2%;
		     padding-right: 3%;
	}
	.m-body {
			height: 60%;
		    width: 80%;
	}

	/* .m-search {
		height: 60%;
		    width: 100%;
	} */
	.s-input {
		width: 89%;
		float: left;
		margin-right: 5%;
	}
	.s-text {
		width: 100%;
	}
	.m-list {
		height: 35%;
		 width: 100%;
		 
	}
	.button{
		margin-bottom: 5%;
		height:35px;
		width: 10%;
	}
	.m-footer {
	margin-left: 10%;
	}
	#header {
		margin-left: 10%;
		
	}
	.g-text {
		isplay: flex;
		height: 30px;
		width: 198px;
		border-radius: 4px;
		border: solid 1px rgb(190, 190, 190);
	}
	
</style>
</head>
<body>

	<div class="m-appSel-wrap" id="bmkSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header4"></span>
			</div>
			<div class="m-body">
				<div class="m-list">
					<table id="b-list-table">
					</table>
				</div>
				<div class="m-select">
					<strong id="s-text4"></strong><br>
					<p id="bmk-list">
					
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm4">확인</span>
				<span class="m-btn cancel" id="cancel4">취소</span>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
var Arr4 = new Array();
var arrText4 = new Array();
var bList = ${"bList"};
// 참여자 선택 모달

function bmk() {
	$("#header4").html("즐겨찾는 그룹 찾기");
	$("#s-text4").html("그룹");
	$("#bmkSelModal").css('display', 'flex').hide().fadeIn();
	$.ajax({
		url : "/modal/mailBmklist.sw",
		type : "get",
		success : function(data) {
			 bmkList(data);
			 console.log(data);
		},
		error : function() {
			alert("즐겨찾는 그룹 목록 검색 실패");
		}
});
}
function bmkList(bList) {
	debugger;
	
	$("#b-list-table").html(""); // 테이블 값 지우기
	var tr = "";
	for(var i = 0; i<bList.length; i++) {
		tr += '<tr class="tr"><td>&emsp;<i class="fa-solid fa-user-group"></i>&ensp;' +bList[i].bmkSubject + '</td></tr>';
	}

	$("#b-list-table").append(tr);
	bmkSelect(); // 참여자 선택
}
function bmkSelect() {
	$("#b-list-table tr").click(function(){
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
		trArr.bmkSubject = td.eq(0).text();
		trArr.memNum = td.eq(1).text();
		trArr.division = td.eq(2).text();
		trArr.bmkName = td.eq(3).text();
		trArr.rank = td.eq(4).text();
		trArr.bmkAddr = td.eq(5).text();
		
		// 객체에 데이터가 있는지 여부 판단
		var checkedArrIdx = _.findIndex(Arr, { memNum : trArr.memNum }); // 동일한 값 인덱스 찾기
		arrText4 = []; // 배열 비우기
		if(checkedArrIdx > -1) {
			_.remove(Arr, { memNum : trArr.memNum }); // 동일한 값 지우기
		}else {
			Arr.push(trArr);
		}
		Arr.forEach(function(el, index) {
			arrText4 = [];
			arrText4.push(el.bmkSubject);
		});
		$("#bmk-list").html(arrText4.join("<br>")); // 개행해서 s-list 영역에 출력
	});
}
$("#confirm4").click(function(){
	 bmkSelView();
	 modalClose4();
    
});
$("#cancel4").click(function(){
    modalClose4();
});
function modalClose4(){
    $("#bmkSelModal").fadeOut();
}

//선택한 참여자 문서 작성 페이지에 표시
function bmkSelView() {
	/* $("#m-bmk").html({mailBmk.bmkSubject}); */
	$("input[name='mailReceiver']").val(arrText4.join(" "))
	
}

</script>

</html>