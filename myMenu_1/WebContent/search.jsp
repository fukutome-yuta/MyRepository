<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>

<p>検索キーワードを入力してください</p>
<form action="Search.action" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="p" items="${list}">
	${p.id}:${p.name}:${p.price}<br>
</c:forEach>
<%@include file="footer.html" %>
