<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("euc-kr");%>
<% response.setContentType("text/html; charset=euc-kr");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조직도</title>
<link rel="stylesheet" href="../../../resources/css/jquery.treeview.css"/>
<link rel="stylesheet" href="../../../resources/css/screen.css"/>
<style type="text/css">
	.d-orgList{ /* 조직도 영역 */
	display:inline-block;
	width: 200px;
	font-size: 14px;
	}
	.d-table{ /* 오른쪽 테이블 영역 */
	display:inline-block;
	float: right;
	}
	.stats-List{
	width: 500px;
	margin: 20px 0;
	font-size: 14px;
	text-align: center;
	border : 1px;
	}
 	.d-table{margin-bottom:30px}
    .d-table button {cursor:pointer;font-family:Arial,'돋움',Dotum;border:none;padding:0; outline:0}
    .d-table .blind_view{font-size:1.14em;font-weight:bold;margin-top:-3px;text-decoration:underline}
    .d-table { display:none; }
</style>
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>

	<div class="s-container">
		<h2 id="h-title">조직도</h2><br>
		<div class="d-orgList">
			<ul id="orgList"></ul>
		</div>
		<div class="d-table" id="d-table">
		<form action="/member/organizationInfo.sw" method="post" id="memInfo">
			<table class="stats-List" border="1">
				<tr>
					<td>사원번호</td>
					<td id="memberNum"></td>
					<td rowspan="4"><img src="" alt="사원사진"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td id="memberName"></td>
				</tr>
				<tr>
					<td>부서</td>
					<td id="division"></td>
				</tr>
				<tr>
					<td>직급</td>
					<td id="rank"></td>
				</tr>	
				<tr>
					<td>이메일</td>
					<td colspan="2" id="mail"></td>							
				<tr>
					<td>전화번호</td>
					<td colspan="2" id="phone"></td>
				</tr>
			</table>
			<br>
			<input type="button" id="button" value="채팅">
			<input type="button" id="button" value="이메일">
		</form>
		</div>
	</div>	
		
	<!-- 스크립트 -->
	<script>
		/* 닫기이벤트 */
		//close id를 클릭했을떄
		$('#close').click(function(){			
			//객체 접근(document style)
			document.getElementById('tree').style.display = 'none';			
		});
		
		/* 열기이벤트 */
		//open id를 클릭했을떄
		$('#open').click(function(){			
			//객체 접근(document style)
			document.getElementById('tree').style.display = 'block';			
		});
		
		/* 부서명클릭시 이벤트 */
		$('#deptName').click(function(){
			alert("test");
		});
	
			
		$(function() {
			$.ajax({
				type : "GET",
				url : "<c:url value='/member/organizationData.sw'/>",
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					data.forEach(function(e,i) {
						var divCode = e.divCode;
						var divName = e.divName;
						var divLevel = e.divLevel;
						var parentDivCd = e.parentDivCode;
						var $orgUl = $("#orgList");
						var $li = "<li id='"+divCode+"'>"+divName+"</li>";
						if(divLevel == 1) {
							$orgUl.append($li);
						}else{
							if(divLevel==3){
								$li = "<li id='"+divCode+"'><a href='javascript:void(0);' onclick='showEmplInfo(\""+divCode+"\")'>"+divName+"</a></li>";
							}
							$li = "<ul>" + $li + "</ul>";
							$("#"+parentDivCd).append($li);
						}
					});
					$("#orgList").treeview({
						persist : "location",
						collapsed : true,
						unique : true
					});
				},
				error : function() {
					alert("ajax 통신 실패!!");
				}
			});
		});
		
		function showEmplInfo(memNum){
		    var objDiv = document.getElementById('d-table');
		    if(objDiv.style.display!="block"){ objDiv.style.display = "block"; }
		    // ajax 이용하여 memNum으로 검색해온 데이터를 테이블에 출력
		    $.ajax({
		    	url : "/member/organizationInfo.sw",
		    	type : "get",
		    	contentType : "application/json",
				dataType : "json",
		    	data : { "memNum" : memNum },
		    	success : function(data) {
		    		$("#memberNum").text(data.memberNum);
		    		$("#memberName").text(data.memberName);
		    		$("#division").text(data.division);
		    		$("#rank").text(data.rank);
		    		$("#mail").text(data.mail);
		    		$("#phone").text(data.phone);
		    	},
		    	error : function() {
		    		alert("ajax 실행 오류!!");
		    	}
		    });
		}

	</script>
	<script type="text/javascript" src="../../../resources/js/jquery.treeview.js"></script>
	<script type="text/javascript" src="../../../resources/js/jquery.cookie.js"></script>
	
</body>
</html>