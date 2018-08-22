<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  function testName(){
	var name =   $("[name=name]").val();
	  $.post(
		"testName",
		{name:name},
		function (obj){
			if(obj){
				alert("用户名不存在");
			}
		},
		"json"
	  );
	  
  }

</script>
</head>
<body>
          <h1>医院门诊系统</h1><br>
         <font color="red"> ${mes }</font>
        <form method="post">
     账号: <input name="name" onblur="testName()"><br><br>
    密码:  <input name="pwd"><br>
      <input type="checkbox" name="x" value="1"> 保持我的登录状态<br>
      <input type="submit" value="登录">
      </form>
</body>
</html>