<%--
  Created by IntelliJ IDEA.
  User: Yangshuangpeng
  Date: 2017/6/17
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="create">创建索引</a>

<form action="/index"  method="post">
    <input name="keywords" maxLength ="50">
    <input type="submit" value="提交">
</form>
</body>
</html>
