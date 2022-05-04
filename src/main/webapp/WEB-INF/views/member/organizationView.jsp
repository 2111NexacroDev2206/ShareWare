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
<link rel="stykesheet" href="css/jquery.treeview.css"/>
<link rel="stykesheet" href="css/screen.css"/>
<script type="lib/jquery.js"type="text/javascript"></script>
<script type="lib/jquery.cookie.js"type="text/javascript"></script>
<script type="lib/jquery.treeview.js"type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#tree").treeview({
		collapsed:true,
		animated:"medium",
		control:"#sidetreecontrol",
		persist:"location"
		});
	})
</script>
</head>
<body>

	<div>
		<div class="treeheader">
		</div>
		
		<div id="sidetreecontrol">
			<a href="#">전체닫기</a>|<a href="#">전체열기</a>
		</div>
		<ul id="tree">
		<c:forEach items="${oList }" var="division">
			<c:if test="${division.divLevel eq 1 }">
				<strong>${division.divName }</strong>
			</c:if>
			<c:if test="${division.divLevel eq 2 }">
			<ul>
				<li>
					<a href="#">${division.divName }</a>
				</li>
			</ul>
			</c:if>
			<c:if test="${division.divLevel eq 3}">
			<ul>
				<li style="list-style:none;">
					<ul>
						<li><a href="#">${division.divName }</a></li>
					</ul>
				</li>
			</ul>
			
			</c:if>
		</c:forEach>
		</ul>
	</div>
<!-- <ul id="tree"> -->
<!-- 	<li> -->
<!-- 		<strong>첫번째 메뉴</strong> -->
<!-- 		<ul> -->
<!-- 			<li><a href="#">서브메뉴</a></li> -->
<!-- 		</ul> -->
<!-- 		</li> -->
<!-- 	<li> -->
<!-- 	<strong>두번째 메뉴</strong> -->
<!-- 	<ul> -->
<!-- 		<li><a href="#">첫번째 서브메뉴</a></li> -->
<!-- 	</ul> -->
<!-- 	<ul> -->
<!-- 		<li> -->
<!-- 			<a href="#">두번째 서브메뉴</a> -->
<!-- 			<ul> -->
<!-- 				<li><a href="#">서브메뉴 속 첫번째 서브메뉴</a></li> -->
<!-- 			</ul> -->
<!-- 		</li> -->
<!-- 	</ul> -->
<!-- 	</li> -->
<!-- </ul> -->

	<%-- <form action="/member/organizationView.sw" method="get">
		<c:forEach items="${oList }" var="division">
			<c:if test="${sessionScope.memNum eq member.memNum }">
				<tr>
					<td>${division.divName }</td>
				</tr>
			</c:if>
		</c:forEach>
	</form> --%>
</body>
</html>