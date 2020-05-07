<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

</style>
<script type="text/javascript"></script>
</head>
<body>
<%
String dbId = "bjhye", dbPwd="1234";

String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String userName = request.getParameter("userName");


if(dbId.equals(userId) && dbPwd.equals(userPwd)){
	// 인증된 사용자의 정보를 session에 저장한다.
	session.setAttribute("sessionName", userName);
	session.setAttribute("sessionTime", new Date().toLocaleString());
	
	// 이동하기 (여기에서 바로 session.invalidate();를 사용하면 오류 발생)
	response.sendRedirect("LoginOK.jsp");
	
} else{
	// 자바 중심
	out.println("<script>");
	out.println("alert('"+userName+"님 정보를 확인해주세요.')");
	out.println("history.back()");
	out.println("</script>");
	%>
	<%
	}
	%>
</body>
</html>