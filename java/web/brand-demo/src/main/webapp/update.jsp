<%--
  Created by IntelliJ IDEA.
  User: amw
  Date: 2023/1/4
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brand-demo/updateServlet" method="post">
<%--    隐藏域--%>
    <input type="hidden" name="id" value="${brand.id}">
    <input placeholder="品牌名称" name="brandName" value="${brand.brandName}"><br>
    <input placeholder="公司名称" name="companyName" value="${brand.companyName}"><br>
    <input placeholder="排序" type="number" name="ordered" value="${brand.ordered}"><br>
    <textarea placeholder="介绍" name="description" >${brand.description}</textarea><br>
    <input type="radio" name="status" value="1" ${brand.status==1?'checked':''}>启用<br>
    <input type="radio" name="status" value="0" ${brand.status==0?'checked':''}>禁用<br>
    <button type="submit">提交</button>
</form>
</body>
</html>
