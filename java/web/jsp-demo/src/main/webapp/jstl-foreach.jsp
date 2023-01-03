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
        <td>${key.index}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <td>${brand.status==1?"启用":"禁用"}</td>
        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>
    </c:forEach>
    <table>
        <hr>


            <c:forEach begin="1" end="10" step="1" var="i">
            <a href="#">${i}<a>
            </c:forEach>

</body>
</html>
