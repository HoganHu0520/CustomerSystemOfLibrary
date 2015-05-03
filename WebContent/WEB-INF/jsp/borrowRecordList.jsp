<%@page import="java.util.Date"%>
<%@page import="java.util.List" %>
<%@page import="com.hogan.model.common.Pagination"%>
<%@page import="com.hogan.model.BorrowRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hogan.util.PropertyUtil" %>
<%@ page import="com.hogan.Constants" %>
<%@ page import="com.hogan.util.PathUtil" %>
<%@ page import="com.hogan.model.User" %>
<%@ page import="com.hogan.util.StringUtil" %>
<%@ page import="com.hogan.util.DateUtil" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<!-- Bootstrap -->
	<link href="<%=PropertyUtil.getStaticUrl()%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=PropertyUtil.getStaticUrl()%>/style/myBook.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h2>图书馆个人借阅信息系统</h2>
	</div>
	<div class="content">
		<div class="content-left">
		<%User user = (User)session.getAttribute(Constants.USER);%>
			<div class="photo-image">
				<img src="<%=PropertyUtil.getStaticUrl()%>/images/MyBooks_IMG_DefaultAvatar_80x80.png"/>
				<span><%=StringUtil.htmlEncode(user.getName())%></span>
				<button type="button" class="btn btn-danger">退出</button>
			</div>
			<div class="nav-block">
				<%
					String mybookUrl = PathUtil.getFullPath("book");
				%>
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"><a href="<%=mybookUrl%>/mybook">首页</a></li>
					<li role="presentation" class="active"><a href="<%=mybookUrl%>/borrowRecord">借阅信息</a></li>
					<li role="presentation"><a href="<%=mybookUrl%>/borrowRecordHistory">借阅历史</a></li>
				</ul>
			</div>
		</div>
		<div class="content-right container">
			<div class="content-info">
				<table class="table table-striped table-hover">
					<tr>
						<th>编号</th>
						<th>书籍标题</th>
						<th>借阅时间</th>
						<th>借阅天数</th>
						<th>缴纳金额</th>
						<th>是否过期</th>
						<th>操作</th>
					</tr>
					<%
						int i = 0;
						Pagination<BorrowRecord> pagination = (Pagination<BorrowRecord>)request.getAttribute("pagination");
						List<BorrowRecord> borrowRecordList = pagination.getResults();
						for(BorrowRecord borrowRecord : borrowRecordList) {
							i++;
					%>
					<tr>
						<td><%=i %></td>
						<td><%=borrowRecord.getBook().getTitle() %></td>
						<td><%=DateUtil.formatOnlyDate(borrowRecord.getBorrowDate()) %></td>
						<% int dayDiff = DateUtil.getDayDiff(borrowRecord.getBorrowDate(), new Date()); %>
						<td><%=dayDiff %></td>
						<td><%=dayDiff * 0.5 %></td>
						
						<%
						if (dayDiff > 30) {
						%>
						<td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
						<%
						} else {
						%>
						<td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
						<%
						}
						%>
						
						<td>续借</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<div class="footer"></div>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/jquery-2.1.3.min.js"></script>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/bootstrap.min.js"></script>
</body>
</html>