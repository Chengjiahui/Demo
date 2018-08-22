<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" href="css/index_like.css">
<title>Insert title here</title>
<script type="text/javascript">
     function toTodayList(){
    	 location ="todayList";
     }
</script>
</head>
<body>
<form>
  <input name="mohu" value="${mohu }">
  <button type="submit" class="btn-info">查询</button>
</form>
<button type="button" onclick="toTodayList()" class="btn btn-link">挂号列表</button>
  <table>
  <tr>
    <th>病例编号</th>
    <th>病人姓名</th>
    <th>性别</th>
    <th>科室</th>
    <th>挂号医生</th>
    <th>门诊挂号状态</th>
    <th>挂号日期</th>
    <th>挂号时间</th>
    <th>诊断意见</th>
  </tr>
  <c:forEach items="${list }" var="l">
  <tr>
   <td>${l.inq_id }</td>
   <td>${l.inq_name }</td>
   <td>${l.sex }</td>
   <td>${l.dept.dept }</td>
   <td>${l.doctor.dname }</td>
   <td>${l.status==0?"待就诊":"已就诊" }</td>
   <td>${l.date }</td>
   <td>${l.time }</td>
   <td>${l.result }</td>
 

  </tr>
  </c:forEach>
</table>

</body>
</html>