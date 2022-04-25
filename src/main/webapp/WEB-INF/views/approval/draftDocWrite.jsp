<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
</head>
<body>
	<jsp:include page="docForm.jsp"></jsp:include> <!-- 문서 양식 -->
</body>
<script>
	$("#h-title").text("기안서");
	$("#form").attr("action", "/approval/draftDocWrite.sw");
</script>
</html>