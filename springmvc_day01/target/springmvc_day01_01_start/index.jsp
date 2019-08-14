
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>入门程序</h3>
<%--
    <a href="hello">入门程序</a>
--%>

<a href="/hello">RequestMapping注解</a>
<script src="js/jquery-3.4.1.min.js"></script>
<script >
  $(function () {
      $("#btn").click(function () {
          alert("hello")

      });

  });
</script>
<form enctype="multipart/form-data" method="post">
    <input type="file" name="upload"/>
    <input type="submit" value="提交">
</form>
<input id="btn" type="button" name="button" value="button">
</body>
</html>
<%--
//请求转发
request。getRequestDispatcher("").foward(request,response)
//重定向
response.sendRedirect(requset.getContextPath（）+"");
//直接进行响应
response.getWrite().print("")
--%>