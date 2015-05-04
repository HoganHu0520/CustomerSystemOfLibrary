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
	<link href="<%=PropertyUtil.getStaticUrl()%>/style/borrowRecordList.css" rel="stylesheet">
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
					<li role="presentation"><a href="<%=mybookUrl%>/borrowRecord">借阅信息</a></li>
					<li role="presentation" class="active"><a href="#">借阅历史</a></li>
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
						<th>归还日期</th>
					</tr>
					<%
						Pagination<BorrowRecord> pagination = (Pagination<BorrowRecord>)request.getAttribute("pagination");
						List<BorrowRecord> borrowRecordList = pagination.getResults();
						
						int i = (pagination.getPageIndex() - 1) * pagination.getPageSize();
						for(BorrowRecord borrowRecord : borrowRecordList) {
							i++;
					%>
					<tr>
						<td><%=i %></td>
						<td>
							<a class="table-link" href="<%=mybookUrl %>/bookInfo?id=<%=borrowRecord.getBook().getId() %>">
								<%=borrowRecord.getBook().getTitle() %>
							</a>
						</td>
						<td><%=DateUtil.formatOnlyDate(borrowRecord.getBorrowDate()) %></td>
						<% int dayDiff = DateUtil.getDayDiff(borrowRecord.getBorrowDate(), borrowRecord.getGivebackDate()); %>
						<td><%=dayDiff %></td>
						<td><%=dayDiff * 0.5 %></td>
						<td><%=DateUtil.formatOnlyDate(borrowRecord.getGivebackDate()) %></td>
					</tr>
					<%
						}
					%>
				</table>
				<div class="pagination">
					<div class="pagination-info">
						<span>当前页/总页数: </span>
						<span style="margin-left: 10px; margin-right: 20px;"> <%=pagination.getPageIndex() %>/<%=pagination.getPageCount() %></span>
						<span>总条数： <%=pagination.getTotalCount() %></span>
					</div>
					
					<%
					if(pagination.getPageCount() > 1) {
					%>
					<div class="btn-toolbar pagination-list" role="toolbar" aria-label="...">
						<div class="btn-group" role="group" aria-label="...">
						<%
							if (pagination.getPageIndex() == 1) {
						%>
							<a href="#" class="btn btn-default disabled">首页</a>
						<%
							} else {
						%>
							<a href="<%=mybookUrl %>/borrowRecord?page=1" class="btn btn-primary">首页</a>
						<% 	} %>
						</div>
						<div class="btn-group" role="group" aria-label="...">
						<%
							for(int index = 1; index <= pagination.getPageCount(); index++) {
								if (index != pagination.getPageIndex()) {
						%>
									<a href="<%=mybookUrl %>/borrowRecord?page=<%=index %>" class="btn btn-primary"><%=index %></a>
						<%
								} else {
						%>
									<a href="#" class="btn btn-default disabled"><%=index %></a>
						<%
								}
							}
						%>
						</div>
						<div class="btn-group" role="group" aria-label="...">
						<%
							if (pagination.getPageIndex() == pagination.getPageCount()) {
						%>
							<a href="#" class="btn btn-default disabled">尾页</a>
						<%
							} else {
						%>
							<a href="<%=mybookUrl %>/borrowRecord?page=<%=pagination.getPageCount() %>" class="btn btn-primary">尾页</a>
						<% 	} %>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	<div class="footer"></div>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/jquery-2.1.3.min.js"></script>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/bootstrap.min.js"></script>
</body>
</html>