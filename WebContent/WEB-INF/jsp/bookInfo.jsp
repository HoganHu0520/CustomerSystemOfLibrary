<%@page import="com.hogan.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hogan.util.PropertyUtil"%>
<%@ page import="com.hogan.Constants"%>
<%@ page import="com.hogan.util.PathUtil"%>
<%@ page import="com.hogan.model.User"%>
<%@ page import="com.hogan.util.StringUtil"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<!-- Bootstrap -->
<link href="<%=PropertyUtil.getStaticUrl()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=PropertyUtil.getStaticUrl()%>/style/myBook.css"
	rel="stylesheet">
<link href="<%=PropertyUtil.getStaticUrl()%>/style/bookInfo.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h2>图书馆个人借阅信息系统</h2>
	</div>
	<div class="content">
		<div class="content-left">
			<%
				User user = (User) session.getAttribute(Constants.USER);
			%>
			<div class="photo-image">
				<img
					src="<%=PropertyUtil.getStaticUrl()%>/images/MyBooks_IMG_DefaultAvatar_80x80.png" />
				<span><%=StringUtil.htmlEncode(user.getName())%></span>
				<form id="logoutForm" action="<%=PathUtil.getFullPath("user/logout")%>" method="POST">
					<button type="button" class="btn btn-danger" onclick="logout()">退出</button>
				</form>
			</div>
			<div class="nav-block">
				<%
					String mybookUrl = PathUtil.getFullPath("book");
				%>
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"><a href="<%=mybookUrl%>/mybook">首页</a></li>
					<li role="presentation"><a href="<%=mybookUrl%>/borrowRecord">借阅信息</a></li>
					<li role="presentation"><a href="<%=mybookUrl%>/borrowRecordHistory">借阅历史</a></li>
				</ul>
			</div>
		</div>
		<div class="content-right">
			<% Book book = (Book)request.getAttribute("book"); %>
			<div class="book-info">
				<div class="book-info-top">
					<div class="book-img"><img src="<%=PropertyUtil.getStaticUrl()%>/images/<%=book.getImageUrl()%>"></div>
					<div class="book-profile">
						<div><h3><%=book.getTitle() %></h3></div>
						<div><h4 class="book-lable">作者：</h4><h4 class="book-lable-info"><%=book.getAuthor() %></h4></div>
						<div><h4 class="book-lable">售价：</h4><h4 class="book-lable-info"><%=book.getAmount() %></h4></div>
						<div><h4 class="book-lable">数量：</h4><h4 class="book-lable-info"><%=book.getCount() %></h4></div>
					</div>
				</div>
				<div class="book-info-buttom">
					<%=book.getDiscription() %>
				</div>
			</div>
		</div>
	</div>
	<div class="footer"></div>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/jquery-2.1.3.min.js"></script>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/bootstrap.min.js"></script>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/book.js"></script>
</body>
</html>