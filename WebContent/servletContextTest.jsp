<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import ="java.util.*"%>
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
<h2>ServletContextListener TEST</h2>

<fieldset>
	<legend>나라선택</legend>
	<%
		// 나라정보를 가져오기
		Map<String, String> map = (Map<String, String>)application.getAttribute("map");
		for(String key : map.keySet()){
			String value = map.get(key);
			%>
			<input type="radio" name="nation" value="<%=key%>"><%=value %>
			<%
		}
		
	%>
</fieldset>
<hr>
application.getContextPath(): <%=application.getContextPath() %><br>
application.getAttribute("path"): <%=application.getAttribute("path") %><br>
</body>
</html>