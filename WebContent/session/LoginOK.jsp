<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
response.setHeader("Cache-Control","no-store");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style ></style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script>
	$(function(){
		// 로그아웃 버튼 클릭
		$("input[type=button]").click(function(){
			if(confirm("정말 로그아웃 하시겠습니까?")){
				location.href="Logout.jsp";
			}
		});
	})
</script>
</head>
<body>
<%

	Object sessionName = session.getAttribute("sessionName");
	
	long time = session.getCreationTime();
	
	if(sessionName == null){
		%>
		<script type="text/javascript">
			alert("로그인하고 이용해주세요");
			location.href="LoginForm.html";
		</script>
		<%
		} else{
			%>
			<h3>
			[접속자 수: <%=application.getAttribute("count") %> 명]<p>
			[접속시간: <%=session.getAttribute("sessionTime") %>]<p>
			<%=sessionName %>님 로그인 되었습니다.<p>
			<img src="images/common.jpg"/>
			<input type="button" value="로그아웃"/>
			</h3>
			<%
		}
		%>

</body>
</html>