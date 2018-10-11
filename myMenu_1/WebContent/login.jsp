<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.html" %>
<div class="container">
 <div class="mx-auto" style="width: 200px;">
    <form class="form-inline" action="Login.action" method="post">
      <div class="col text-center">
       <h5>ログイン</h5>
      </div>
      <p>ログインID<input type="text" id="id" name="id" class="form-control" placeholder="login ID" required autofocus></p>
      <p>パスワード<input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" required></p>
      <div class="col text-center">
       <button class="btn btn-outline-success my-2 my-sm-0 btn-sm btn-block" type="submit">ログイン</button>
      </div>
    </form>
 </div>
</div>

<%@include file="footer.html" %>
