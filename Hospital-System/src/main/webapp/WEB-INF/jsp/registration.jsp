<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
     $(function (){
    	 $.post(
    	   "findDept",
    	   function (obj){
    		   for(var i in obj){
    			   $(".dept").append("<option value='"+obj[i].did+"'>"+obj[i].dept+"</option>");
    		   }
    	   },
    	   "json"
    	 );
    	  
    	  $(".dept").change(function (){
    		  $("span").empty();
    		 $(".doctor").empty();
    		 $(".doctor").append("<option>--选择医生--</option>");
       	   var did =  $(this).val();
       	      $.post(
       	    	"findDoctor",
       	    	{did:did},
       	    	function (obj){    	    	  
       	    		for(var i in obj){
       	    		  $(".doctor").append("<option value='"+obj[i].doc_id+"'>"+obj[i].dname+"</option>");
       	    		 
       	    		}
       	    	},
       	    	"json"
       	      );
          })
          
          $(".doctor").change(function (){
        	  $("span").empty();
        	  var dcid = $(this).val();
                $.post(
                 "getPrice",
                 {dcid:dcid},
                 function (obj){
                	  $("p").append("<span>"+obj+"元</span>"); 
                 },
                 "json"
                );
        	  
          })
    	
     })
     
     function gh(){
    	 $.post(
    	 "doRegistration",
    	 $("form").serialize(),
    	 function (obj){
    		if(obj){
    			alert("挂号成功");
    			location="todayList";
    		}
    	},
    	"json"
    	 );
     }
     
</script>
</head>
<body>
<form>
     病人姓名:<input name="inq_name"><br>
     病人性别: <input type="radio" value="男" name="sex">男<input type="radio" value="女" name="sex">女<br>
     联系电话:<input name="phone"><br>
     挂号科室: <select name="did" class="dept">
      <option value="0">--选择科室--</option>
    </select><br>
     问诊医生:<select name="doc_id" class="doctor">  
    </select><br>
    <p>  挂号费用:</p> 
    <button class="btn btn-success" type="button" onclick="gh()">挂号</button>
    </form>
</body>
</html>