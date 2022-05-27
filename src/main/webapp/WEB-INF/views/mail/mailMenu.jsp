<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 소메뉴</title>
<link href="/resources/css/approval/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>


<style type="text/css">
.mailClass {
padding-bottom: 20px;
padding-top: 20px;
    width: 95%;
     margin: 10px auto;
    display: flex;
}
#mailWriteBtn {
padding-bottom: 20px;
padding-top: 20px;
width: 95%;
margin: 10px auto;
display: flex;
    
}

#read {
border: 1px solid lightgrey;
    flex:1;
    width:30%;
    height:80px;
    box-sizing: border-box;
    text-align: center;
    padding-top: 10px;
    display: inline-block;
	background-color: white;
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
	color: grey;
}
#bmk {
border: 1px solid lightgrey;
    flex:1;
    margin: 0px 5%;
    width:30%;
    box-sizing: border-box;
    text-align: center;
     padding-top: 10px;
      display: inline-block;
	background-color: white;
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
	color: grey;
}
#file {
  border: 1px solid lightgrey;
    flex:1;
    width:30%;
    box-sizing: border-box;
    text-align: center;
     padding-top: 10px;
      display: inline-block;
	background-color: white;
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
	color: grey;
}
.mailList {
padding-top: 15px;
border-bottom: 1px solid lightgrey;
border-top: 1px solid lightgrey;
padding-bottom: 15px;
}
.mailBmkList {
border-bottom: 1px solid lightgrey;
padding-bottom: 20px;
padding-top: 15px;
}
.m-list-item a {
	text-decoration: none;
	color: rgb(51, 51, 51);
	margin-left:25px;
	margin-top : 5px;
}
.mailTemList {
border-bottom: 1px solid lightgrey;
padding-bottom: 30px;
padding-top: 15px;
}

#subject {
	overflow:auto;
	height: 80px;
	
}

</style>
</head>
<body>
	<div class="s-menu">
			<div class="s-menu-title">
				<p>메일
				<i class="fa-solid fa-square-envelope" ></i>
			</div>
			<br>
			<br>
			<div id="mailWriteBtn">
			 	<button type="submit" class="btn-mail" id="btn-write" onclick="location.href= '/mail/WriteView.sw'" style="width:105px; height: 40px;  color: green; "><strong>메일쓰기</strong></button>
				&nbsp;&nbsp;<button type="submit" class="btn-mail" id="btn-write" onclick= "location.href= '/mail/WriteMyView.sw'" style="width: 105px; height: 40px; float:left;  color: green;"><strong>내게쓰기</strong></button>
			</div>
			
			
			<div class="mailClass">
				<div id="read"><h1  style="color: green; margin-top: 3px;">${readTypeNCount}+</h1><small>안읽음</small></div>
				<div id="bmk" onclick="location.href= '/mail/mailIListView.sw'"><i class="fa-solid fa-star fa-2x"></i><br><small>중요</small><br><strong style="color: green;">${totalICount}</strong></div>
				<div id="file" onclick="location.href= '/mail/FmailListView.sw'"><i class="fa-regular fa-file fa-2x"></i><br><small>첨부</small><br><strong style="color: green;">${totalmFileCount}</strong></div>
			</div>
			
			
			<div>
			<div class="mailList">
				<div class="m-list-item ${listCondition eq 'S' || listCondition eq 'rej' ? 'active' : ''}"><a href="/mail/SmailListView.sw"><i class="fa-solid fa-inbox"></i>&nbsp;받은 메일함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalmRecCount}</strong></div><br>
				<div class="m-list-item"><a href="/mail/RmailListView.sw"><i class="fa-solid fa-paper-plane"></i>&nbsp;보낸 메일함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalmCount}</strong></div><br>
				<div class="m-list-item "><a href="/mail/MmailListView.sw"><i class="fa-solid fa-file-lines"></i>&nbsp;내게 쓴 메일함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalmMyCount}</strong></div><br>
				<div class="m-list-item" ><a href="/mail/mailAppListView.sw"><i class="fa-solid fa-circle-check"></i>&nbsp;보낸 승인 메일함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalAppCount}</strong></div>
			</div>	
			<div class="mailBmkList">
			
						
				<div class="m-list-item" id=""><a href="javascript:participant();"><i class="fa-solid fa-user-group"></i>&nbsp;즐겨찾는 그룹</a></div>
					<br>
					<div id="subject">
					<c:forEach items="${bList}" var="mail">
							
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-circle-minus" style="color: grey;" onclick="deleteBmkOne('${mail.bmkSubject}');"></i>&nbsp;&nbsp;${mail.bmkSubject }</div>
					</c:forEach>
					</div>
			</div>
			<div class="mailTemList">
				<div class="m-list-item"><a href="/mail/mailTemListView.sw"><i class="fa-solid fa-folder-open"></i>&nbsp;임시 저장함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalTemCount}</strong></div>
			</div>
			</div>	
			<jsp:include page="mailBmkModal.jsp"></jsp:include>
	</div>
	
</body>
<script type="text/javascript">
	var Arr = new Array(); // 선택한 참여자 담을 배열 선언
	var arrText = new Array(); // 화면에 보여줄 텍스트 배열 선언
	var Arr4 = new Array();
	var arrText4 = new Array();
	var bList = ${"bList"};
	
	function refreshList(){ //실행시 재로드
		location.reload();
	}
	function deleteBmkOne(bmkSubject) {
		$.ajax({
			url : "/mail/deleteMailBmk.sw",
			type : "get",
			data : {
				"bmkSubject" : bmkSubject
			},
			success : function(result) {
				 refreshList(); 
				
			},
			error : function() {
				alert("Ajax 통신 실패!");
			}
		});
	}
	
	// 참여자 선택 모달
	function participant() {
		$("#header").html("즐겨찾는 그룹 등록");
		$("#g-text").html("그룹");
		$("#s-text").html("사원");
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
		$.ajax({
			url : "/modal/member/list.sw",
			type : "get",
			success : function(mList) {
				$("#s-value").val(""); // 검색 입력창 지우기
				appList(mList);
			},
			error : function() {
				alert("사원 목록 조회 실패");
			}
		})
	}
	$("#register-bmk").click(function(){
		var bmkSubject = $("#bmkSubject").val();
	     $.ajax({
			url :"/mail/registerBmk.sw",
			type : "post",
			traditional : true,
			data: { "arrText" : arrText,
				"bmkSubject" : bmkSubject },
			success : function(data) {
				if(data == "success") {
					 modalClose();
					 refreshList();
				}else{
					alert("즐겨찾는 그룹 등록 실패");
				}
			},
			error : function() {
				alert("ajax 통신 실패!!");
			}
		})  
	    
	});
	$("#cancel").click(function(){
	    modalClose();
	});
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
	
	// 참여자 선택 사원 검색
	$("#btn-search").click(function() {
		var searchCondition = $("#s-condition").val();
		var searchValue = $("#s-value").val(); 
		$.ajax({
			url : "/modal/member/search.sw",
			type : "get",
			data : { "searchCondition" : searchCondition,  "searchValue" : searchValue },
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
			+ '</td><td>' + mList[i].rank 
			+ '</td><td>' + mList[i].mail + '</td></tr>';
		}); 
		$("#m-list-table").append(tr);
		appSelect(); // 참여자 선택
	}
	
	// 참여자 선택
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
			trArr.mail = td.eq(4).text();
			
			// 객체에 데이터가 있는지 여부 판단
			var checkedArrIdx = _.findIndex(Arr, { memberNum : trArr.memberNum }); // 동일한 값 인덱스 찾기
			arrText = []; // 배열 비우기
			if(checkedArrIdx > -1) {
				_.remove(Arr, { memberNum : trArr.memberNum }); // 동일한 값 지우기
			}else {
				Arr.push(trArr);
			}
			Arr.forEach(function(el, index) {
				arrText.push(el.division +" "+ el.memberNum +" "+ el.memberName +" "+ el.rank+" "+el.mail);
			});
			$("#s-list").html(arrText.join("<br>")); // 개행해서 s-list 영역에 출력
		});
	}
	// 선택한 참여자 문서 작성 페이지에 표시
	function appSelView() {
		/* $("#m-bmk").html({mailBmk.bmkSubject}); */
		$("#par-list").html(arrText.join("<br>"));
		var ref = []; // 참여자 담을 배열 선언
		Arr.forEach(function(el, i){
			ref[i] = el.memberNum;
		});
		$("#num-par").val(ref);
		
	}
	
	
	
	
	
	
	
</script>
</html>