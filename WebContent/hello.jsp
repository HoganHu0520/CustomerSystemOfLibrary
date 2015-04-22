<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
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
      
      var userNameObj = document.getElementById("userName");
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
<body>hello hogan.</body>
</html>