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
<h3>買い物リスト</h3>
<div class="conteiner" id="container">
<table class="table" border="1">
<thead>
<tr>
  <th>食材</th>
  <th>分量</th>
  <th>単位</th>
</tr>
</thead>
<c:forEach var="mtlist" items="${mtlist}">
<tbody>
<tr>
  <td>${mtlist.name}</td>
  <td>${mtlist.quantity}</td>
  <td>${mtlist.data}</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="ListDelete.action">献立表・買い物リストを削除する</a>
<%@include file="footer.html" %>