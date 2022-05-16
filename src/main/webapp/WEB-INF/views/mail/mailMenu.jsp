<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 소메</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#mailBmkModal {
		display:none;
	}

</style>
</head>
<body>
	<div class="s-menu">
			<div class="s-menu-title">
				<p>메일
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
			</div>
			<div>
			 	&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" onclick="location.href= '/mail/WriteView.sw'" style="width:90px; height: 35px;">메일쓰기</button>
				&nbsp;&nbsp;<button type="submit" onclick= "location.href= '/mail/WriteMyView.sw'" style="width: 90px; height: 35px;">내게쓰기</button>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="read"><a href="#"><small>안읽음</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="bmk"><a href="#"><small>중요</small></a></div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}" id="file"><a href="/mail/FmailListView.sw"><small>첨부</small></a></div>
			</div>
			<div>
				<div class="s-list-item ${listCondition eq 'draft' ? 'active' : ''}"><a href="/mail/SmailListView.sw">받은 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'approval' ? 'active' : ''}"><a href="/mail/RmailListView.sw">보낸 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}"><a href="/mail/MmailListView.sw">내게 쓴 메일함</a></div>
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}" ><a href="">보낸 승인 메일함</a></div>
				
				<div class="s-list-item ${listCondition eq 'reference' ? 'active' : ''}" id="btn-Bmk" onclick="'bmkRegisterForm();'"><a href="">즐겨찾는 그룹</a>
			</div>
				<div class="s-list-item ${listCondition eq 'temporary' ? 'active' : ''}"><a href="/mail/mailTemListView.sw">임시 저장함</a></div>
			</div>
	</div>

	<div  class="modal" id="mailBmkModal"  aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
	                    <h5 class="modal-title" id="exampleModalLabel">그룹명을 입력하세요.</h5>
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
					<div class="modal-body">
					<form>
	                    <div class="form-group">
	                        <label for="taskId" class="col-form-label">그룹명</label>
	                        <input type="text" class="form-control" id="bmkSubject" name="bmkSubject">
	                   </div> 
	                    <div class="form-group">
	                        <label for="taskId" class="col-form-label">그룹원</label>
	                        <div>
	                        <input type="text" class="form-control" id="bmkName" name="bmkName">
	                        </div>
	                   </div> 	
		               <div class="form-group">     
	                        <label for="taskId" class="col-form-label">주소</label>
	                       <div>
	                        <input type="email" class="form-control" id="bmkAddr" name="bmkAddr">
	                       </div>
	                   </div>   
	                  </form>
	           		 </div> <!-- body 끝-->
	               <div class="modal-footer">
	                    <button type="submit" class="btn-register" data-bs-dismiss="modal" id="addBmk">저장</button>
	                    <button type="reset" class="btn-cancel" data-dismiss="modal">취소</button>
	               </div>
	             </div>  
	          </div>     
           	 </div>
</body>
<script type="text/javascript">

		function bmkRegisterForm() {
		$("#mailBmkModal").modal("show");
		
		}
		var bmkNo = $("#bmkNo").val();
		var bmkSubject = $("#bmkSubject").val();
		var bmkName = $("#bmkName").val();
		var bmkAddr = $("#bmkAddr").val();
		
		$.ajax({
			url : "/mail/registerMailBmk.sw",
			type : "post",
			data : { "bmkNo" : bmkNo,  "bmkSubject" : bmkSubject,
				"bmkName" : bmkName, "bmkAddr" : bmkAddr},
		});
		  var obj = {
              	"bmkNo" : bmkNo,
                  "bmkSubject" : bmkSubject,
                  "bmkName" : bmkName,
                  "bmkAddr" : bmkAddr
              }//전송할 객체 생성

</script>
</html>