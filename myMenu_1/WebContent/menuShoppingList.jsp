<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>
<%@include file="navBar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>献立表</h3>
<div id="container">
<table border="1">
<tr>
  <th>番号</th>
  <th>メニュー</th>
  <th>レシピ</th>
</tr>
<c:forEach var="menus" items="${menus}">
<tr>
  <td>${menus.id}</td>
  <td>${menus.name}</td>
  <td><a href="${menus.url}">${menus.url}</a></td>
</tr>
</c:forEach>
</table>
<a href="ListCreate.action">買い物リスト作成</a>
<%@include file="footer.html" %>