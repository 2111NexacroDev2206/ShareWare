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
							
						<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-circle-minus" style="color: grey;" onclick="deleteBmk();"></i>&nbsp;&nbsp;${mail.bmkSubject }</div>
					</c:forEach>
					</div>
			</div>
			<div class="mailTemList">
				<div class="m-list-item"><a href="/mail/mailTemListView.sw"><i class="fa-solid fa-folder-open"></i>&nbsp;임시 저장함</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong style="color: green;">${totalCount}</strong></div>
			</div>
			</div>	
			<jsp:include page="mailBmkModal.jsp"></jsp:include>
	</div>
	
</body>
<script type="text/javascript">
		

</script>
</html>