<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>
<%@include file="navBar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>メニュー名で検索</p>
<form action="Search.action" method="post">
<input type="text" name="keyword">
<input type ="submit" value="検索">
</form>
<hr>

<div class="conteiner" id="container">
<table class="table" border="1">
<thead>
<tr>
  <th>番号</th>
  <th>メニュー</th>
  <th>レシピ</th>
  <th>献立表に追加</th>
</tr>
</thead>
<form action="MenuAdd.action" method="post">
<tbody>
<c:forEach var="menu" items="${list}">
<tr>
  <td>${menu.id}</td>
  <td>${menu.name}</td>
  <td><a href="${menu.url}">${menu.url}</a></td>
  <td><input type="checkbox" name="id" value="${menu.id}"></td>
</tr>
</c:forEach>
</tbody>
</table>
<input type="submit" value="追加">
</form>
</div>
<%@include file="footer.html" %>
