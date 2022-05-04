<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
	
		padding-bottom: 210px;
		border-bottom: 1px lightgray solid;
	}
	.mailWriteMenu {
		float: right;
		margin-top: 12%;
		margin-right:37%;
		
	}
	button {
		width: 80px;
		height: 30px;
		border : 1px lightgray solid;
		background: #ffffff;
			
	}
	#mailRegister {
	
		float: right;
		margin-top: 3%;
		margin-right: 8%;
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

</style>


</head>
<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<form action="/mail/mailRegister.sw" method="post" enctype="multipart/form-data">
		<div class="s-menu">
			<div class="s-menu-title">
				<p>메일
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
			</div>
			<div>
			 	&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" onclick= "javascript: form.action='/mail/WriteView.sw'" style="width:90px; height: 35px;">메일쓰기</button>
				&nbsp;&nbsp;<button type="submit" onclick= "javascript: form.action='/mail/WriteMyView.sw'" style="width: 90px; height: 35px;">내게쓰기</button>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="read"><a href="#"><small>안읽음</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="bmk"><a href="#"><small>중요</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="file"><a href="/mail/FmailListView.sw"><small>첨부</small></a></div>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}"><a href="/mail/RmailListView.sw">받은 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="/mail/SmailListView.sw">보낸 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="/mail/MmailListView.sw">내게 쓴 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">보낸 승인 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="">즐겨찾는 그룹</a></div>
				<div class="s-list-item ${listCondition eq 'temporary' ? 'active' : ''}"><a href="/mail/mailTemListView.sw">임시 저장함</a></div>

			</div>
		</div>
		
		
   	 	<div class="mailHeader">
	   	 	<div class= "mailWriteMenu">
					<div>
					<button type="submit" onclick="javascript: form.action='mailRegister.sw'">메일보내기</button>&nbsp;&nbsp;
						<a href="/mail/WriteMyView.sw"><i class="fa-solid fa-rotate"></i>내게 쓰기</a>&nbsp;&nbsp;
						<button type="submit" onclick= "javascript: form.action='mailTemRegister.sw'">임시 저장</button>
						<button type="button">승인 메일</button>
						<button type="button">발송 예약</button>
					</div>
				</div>
	    	</div>
		
		<div id="mailRegister">
			<div>
				<div><small>받는사람</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="90" style= "height: 20px" name="mailReceiver">&nbsp;<button type="button"style="width:60px">주소록</button>&nbsp;<button type="submit" style="width: 90px;">즐겨찾는 그룹</button></div>
			</div>
			<br>
			<div>
				<div><small>참조인</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="90" style= "height: 20px" name="mailReferee">&nbsp;<button type="button"style="width:60px">주소록</button>&nbsp;<button type="submit" style="width: 90px;">즐겨찾는 그룹</button></div>
			</div>
			<br>
			<div>
				<div><small>제목 </small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" size="112" style= "height: 20px" name="mailSubject"></div>
			</div>
			<br>
			<div>
				<div class="filebox"><small>파일첨부 </small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='file'  id='mFile' name="uploadFile"/>
					<label for='mFile'><i class="far fa-file-image"/></i>&nbsp;파일 선택</label></div>
			</div>
			<br>
			<div>
				<div><input type="text" size="125" style= "height: 200px; " name="mailContent"></div>
			</div>	
		</div>
		</form>
</body>
</html>