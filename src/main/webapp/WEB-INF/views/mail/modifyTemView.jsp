<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	#bmk {
		float: left;
		width: 40%;
	}
	#read{
		
		width: 50%;
	}
	#file{
		float: left;
		width: 40%;
	}
	.mailHeader {
		
		
		padding-bottom: 170px;
		border-bottom: 2px solid rgb(200, 200, 200);
	}
	.mailWriteMenu {
		float: left;
		margin-top: 100px;
		margin-left:500px;
		
	}
	.btn-mail {
	display: inline-block;
	width: 100px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
	vertical-align: middle;
}
	#mailRegister {
	
		float: left;
		margin-top: 25px;
		margin-left: 470px;
	}
	#mFile{
    width: 0.1px;
	height: 0.1px;
	
	
	
	}
	
	#mFile + label {
	    border: 1px solid #d9e1e8;
	    background-color: #fff;
	    color: #2b90d9;
	    border-radius: 2rem;
	    padding: 8px 17px 8px 17px;
	    font-weight: 500;
	    font-size: 15px;
	    box-shadow: 1px 2px 3px 0px #f2f2f2;
	    outline: none;
	}
	
	#mFile:focus + label,
	#mFile + label:hover {
	    cursor: pointer;
	}
.fa-paper-plane { 
	color: orange;
}
.fa-user-check {
	color: green;
}
#write {
	color: grey;
}
</style>


</head>

<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<form action="/mail/mailRegister.sw" method="post" enctype="multipart/form-data">
		
		
		
   	 	<div class="mailHeader">
	   	 	<div class= "mailWriteMenu">
					<div>
					<button type="submit"class="btn-mail"  style=" width:110px;" onclick= "javascript: form.action='mailRegister.sw'"><i class="fa-solid fa-paper-plane"></i>&nbsp;<strong>보내기</strong></button>&nbsp;&nbsp;
						<button type="submit" class="btn-mail" onclick= "javascript: form.action='mailTemRegister.sw'"><i class="fa-solid fa-download"></i>&nbsp;<strong>임시 저장</strong></button>
						<button type="submit" class="btn-mail" onclick= "javascript: form.action='mailAppRegister.sw'"><i class="fa-solid fa-user-check"></i>&nbsp;<strong>승인 메일</strong></button>
						<a href="/mail/WriteMyView.sw"><i class="fa-solid fa-rotate"></i>내게 쓰기</a>&nbsp;&nbsp;
					</div>
				</div>
	    	</div>
		
		<div id="mailRegister">
		<input type="hidden" name="mailSender" value="${loginUser.mail }">
			<div>
				<div><strong id="write">받는사람</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<c:forEach items="${mailRec }" var="mailRec">
				<input type="text" size="130" style= "height: 30px" id="mailRec"  name="mailReceiver" value="${mailRec.mailReceiver}">
				</c:forEach> 
				&nbsp;<button type="button" class="btn-mail" style="width:80px" onclick="participant2();"><i class="fa-regular fa-address-book"></i>&nbsp;주소록</button>&nbsp;<button type="button" class="btn-mail" style="width: 130px;" onclick="bmk();"><i class="fa-solid fa-at"></i>&nbsp;즐겨찾는 그룹</button></div>
				<!-- <p id="mailReceiver"> -->
			</div>
			<br>
			<div>
				<div><strong id="write">참조인</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				
				<input type="text" size="130" style= "height: 30px"id="mailReferee" name="mailReferee" value="<c:forEach items="${mailRef }" var="mailRef">${mailRef.mailReferee} </c:forEach>" >
				
				&nbsp;&nbsp;<button type="button" class="btn-mail" style="width:80px" onclick="participant3();"><i class="fa-regular fa-address-book"></i>&nbsp;주소록</button>&nbsp;<button type="button" class="btn-mail" style="width: 130px;" onclick="bmk();"><i class="fa-solid fa-at"></i>&nbsp;즐겨찾는 그룹</button></div>
			</div>
			<br>
			<div>
				<div><strong id="write">제목 </strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;<input type="text" size="130" style= "height: 30px" name="mailSubject" value="${mail.mailSubject}"></div>
			</div>
			<br>
			<br>
			<div>
				<div class="filebox"><strong id="write">파일첨부 </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="file" id="mFile" name="uploadFiles" multiple/>
					<label for="mFile"><i class="far fa-file-image"/></i>&nbsp;내 PC</label></div>
			</div> 
			<br>
			<br>
			<div>
				<div><textarea rows="25" cols="160" name="mailContent">${mail.mailContent }</textarea></div>
			</div>	
		</div>
		</form>
		<jsp:include page="../mail/mailAddrModal.jsp"></jsp:include>
		<jsp:include page="../mail/mailRecModal.jsp"></jsp:include>
		<jsp:include page="../mail/mailBmkModal.jsp"></jsp:include>
		<jsp:include page="../mail/bmkListModal.jsp"></jsp:include>
		</body>
		<script type="text/javascript">
		function bmk() {
			$("#header4").html("즐겨찾는 그룹 찾기");
			$("#s-text4").html("그룹");
			$("#bmkSelModal").css('display', 'flex').hide().fadeIn();
			$.ajax({
				url : "/modal/mailBmklist.sw",
				type : "get",
				dataType : "json",
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
			
			
			$("#b-list-table").html(""); // 테이블 값 지우기
			var tr = "";
			for(var i = 0; i<bList.length; i++) {
				tr += '<tr class="tr"><td><i class="fa-solid fa-user-group"></i></td><td id="td-bmk">' +bList[i].bmkSubject + '</td></tr>';
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
				var td = tr.children("#td-bmk");
							
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