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

</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
<script type="text/javascript" src="../../../resources/js/jquery.treeview.js"></script>
<script type="text/javascript" src="../../../resources/js/jquery.cookie.js"></script>

	<div class="s-container">
		<h2 id="h-title">조직도</h2><br>
			<ul id="orgList">
			
			</ul>
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
						var $li = "<li id='"+divCode+"'><a href='#'>"+divName+"</a></li>";
						if(divLevel == 1) {
							$orgUl.append($li);
						}else{
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
	</script>
</body>
</html>