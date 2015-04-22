<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hogan.util.PropertyUtil" %>
<%@ page import="com.hogan.Constants" %>
<%@ page import="com.hogan.util.PathUtil" %>
    
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<!-- Bootstrap -->
    <link href="<%=PropertyUtil.getStaticUrl()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=PropertyUtil.getStaticUrl()%>/style/login.css" rel="stylesheet" type="text/css">
</head>
<style>
.errorMessage {
     color: red;
}
</style>
<script>
  
 function login() {
      
      var loginFormObj = document.getElementById("loginForm");
      
      var isSubmitForm = true;
      
      var userNameObj = document.getElementById("userId");
      var userNameValue = userNameObj.value;
      
      var errorMsg = ""
      var errorMsgObj = document.getElementById("errorMsg");
      
      var userNameIsNull = false;
      var passwordIsNull = false;
      
      if (!userNameValue.trim()) {
          userNameIsNull = true;
          errorMsg = "请输入用户名";
          isSubmitForm = false;
          userNameObj.style.border="1px dashed #EB340A";
      } else {
    	  userNameObj.style.cssText = "border: 1px solid #858585;";
      }
      
      var passwordObj = document.getElementById("password");
      var passwordValue = passwordObj.value;
      if (!passwordValue.trim()) {
          passwordIsNull = true;
          errorMsg = "请输入密码";
          passwordObj.style.border="1px dashed #EB340A"
          isSubmitForm = false;
      } else {
    	  passwordObj.style.cssText = "border: 1px solid #858585;";
    	 
      }
      
      if (userNameIsNull && passwordIsNull) {
          errorMsg = "请输入用户名和密码";
      }
      
      if (!isSubmitForm) {
          errorMsgObj.innerHTML = errorMsg;
          errorMsgObj.style.visibility="visible";
      }
      
      
      if (isSubmitForm) {
         loginFormObj.submit();
      }
  }
</script>
<body>
<%String tipMessage = (String)request.getAttribute(Constants.TIP_MESSAGE);
  String visibility = "hidden";
  if (tipMessage != null && !tipMessage.equals("")) {
      visibility = "visible";
  }
  
%>

	<div class="login_title">奇文共欣赏 疑义相与析</div>
    
    <div class="login_form">
        <div class="logo"></div>
        <div class="title">个人借阅信息平台</div>
        
	    <form action="<%=PathUtil.getFullPath("user/login")%>" method="POST" id="loginForm">
	       <div class="line">
	          <label>用户名</label>
	           <input type="text" name="userId" id="userId"/>
	           <input type="hidden" name="go" value="<%=request.getAttribute("go") %>"/>
	           <input type="hidden" name="queryString" id="queryString"/>
	      </div>
	      
	      <div class="line" style="margin-top: 20px;">
              <label>密码</label>
              <input type="password" name="password" id="password"/>
          </div>
	      
	      <div id="errorMsg" class="line" style="margin-top: 10px; visibility: <%=visibility %>;color: red;font-size: 14px;">
            <%=tipMessage %>
          </div>
	     
	       <div class="button" onclick="login()">登陆</div>
	    </form>
    </div>
    <div class="login_footer">Copyright &copy 2015 Hogan Hu. All Rights Reserved</div>

	<script src="<%=PropertyUtil.getStaticUrl()%>/js/jquery-2.1.3.min.js"></script>
	<script src="<%=PropertyUtil.getStaticUrl()%>/js/bootstrap.min.js"></script>
</body>
</html>