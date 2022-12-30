<%@ page import="java.util.List" %>
<%@ page import="com.xxq.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: amw
  Date: 2022/12/30
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Brand> brands = new ArrayList<Brand>();
    Brand brand = new Brand();
    brands.add(new Brand(1, "三只松鼠", "三只松鼠食品", 100, "好吃的很", 1));
    brands.add(new Brand(2, "小米", "小米科技", 100, "为发烧", 2));
    brands.add(new Brand(3, "华为", "华为科技", 1000, "科技巨头", 1));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello</h1>
<%
    System.out.println("hello word");
    int i = 3;
%>

<%="hello"%>
<%=i%>
<%!
    void show() {

    }

    ;
    String name = "zhangsan";

%>
<br/>
<div style="margin-top: 30px">
    <table border="1" cellspacing="0" width="800" >
    <tr align="center">
        <th>id</th>
        <th>品牌名称</th>
        <th>公司名称</th>
        <th>排序</th>
        <th>描述</th>
        <th>状态</th>
        <th>操作</th>
    </tr>


<%
    for (int j = 0; j < brands.size(); j++) {
        Brand brandInfo = brands.get(j);
%>
<tr align="center">
    <td><%= brandInfo.getId()%></td>
    <td><%= brandInfo.getBrandName()%></td>
    <td><%= brandInfo.getCompanyName()%></td>
    <td><%= brandInfo.getOrdered()%></td>
    <td><%= brandInfo.getDescription()%></td>
    <td><%= brandInfo.getStatus()%></td>
    <td><a href="#">修改</a> <a href="#">删除</a></td>
</tr>
<%
    }
    ;
%>
        <table>
</div>

</body>
</html>
