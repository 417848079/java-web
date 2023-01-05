<%--
  Created by IntelliJ IDEA.
  User: amw
  Date: 2023/1/3
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add" style="margin-bottom: 50px">
<table border="1" cellspacing="0" width="800">
    <tr align="center">
        <th>id</th>
        <th>品牌名称</th>
        <th>公司名称</th>
        <th>排序</th>
        <th>描述</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="key">
    <tr align="center">
            <%--        <td>${brand.id}</td>--%>
            <%--        <td>${key.count}</td>--%>
        <td>${key.count}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <td>${brand.status==1?"启用":"禁用"}</td>
        <td><a href="/brand-demo/oneServlet?id=${brand.id}">修改</a> <a href="/brand-demo/delete?id=${brand.id}">删除</a></td>
    </tr>
    </c:forEach>
    <table>




</body>
<script lang="javascript">
    document.getElementById("add").onclick=function (){
        location.href="/brand-demo/addBrand.jsp"
    }
</script>
</html>
