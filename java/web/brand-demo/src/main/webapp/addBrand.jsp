<%--
  Created by IntelliJ IDEA.
  User: amw
  Date: 2023/1/4
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand-demo/addBrandServlet" method="post">
    <input placeholder="品牌名称" name="brandName"><br>
    <input placeholder="公司名称" name="companyName"><br>
    <input placeholder="排序" type="number" name="ordered"><br>
    <textarea placeholder="介绍" name="description"></textarea><br>
    <input type="radio" name="status" value="1" checked>启用<br>
    <input type="radio" name="status" value="0">禁用<br>
    <button type="submit">提交</button>

</form>
</body>
</html>
