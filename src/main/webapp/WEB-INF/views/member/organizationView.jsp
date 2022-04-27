<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조직도</title>
<style>
	.tree{
  margin-top: 5px;
}
.tree, .tree ul{
  list-style: none; /* 기본 리스트 스타일 제거 */
  padding-left:10px;
}
.tree *:before{
  width:15px;
  height:15px;
  display:inline-block;
}
.tree label{
  cursor: pointer;
  font-family: NotoSansKrMedium, sans-serif !important;
  font-size: 14px;
}
.tree label:hover{
  color: #00AACC;
}
.tree label:before{
  content: '+'
}
.tree label.lastTree:before{
  content:'o';
}
.tree label:hover:before{
  content: '+'
}
.tree label.lastTree:hover:before{
  content:'o';
}
.tree input[type="checkbox"] {
  display: none;
}
.tree input[type="checkbox"]:checked~ul {
  display: none;
}
.tree input[type="checkbox"]:checked+label:before{
  content: '-'
}
.tree input[type="checkbox"]:checked+label:hover:before{
  content: '-'
}

.tree input[type="checkbox"]:checked+label.lastTree:before{
  content: 'o';
}
.tree input[type="checkbox"]:checked+label.lastTree:hover:before{
  content: 'o';
}
</style>
</head>
<body>
<form action="/member/organizationView.sw" method="post" >
	<ul class="tree" align="center">
	  <li>
	    <ul>
	      <li>
	        <input type="checkbox" id="node1">
	        <label for="node1">임원</label>
	        <ul>
	          <li>
	            <input type="checkbox" id="node11">
	            <label for="node11" class="lastTree">정은진</label>
	          </li>
	          <li>
	            <input type="checkbox" id="node12">
	            <label for="node12" class="lastTree">김민지</label>
	          </li>
	        </ul>
		</ul>
	  </li>
	</ul>

</form>
</body>
</html>