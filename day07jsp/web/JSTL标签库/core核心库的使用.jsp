<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/10/27
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>core核心库</title>
</head>
<body>
<h1>c:set</h1>
    保存前：session域里的abc值：${sessionScope.abc}<br/>
    <c:set scope="session" var="abc" value="123" property=""/>
    保存后：session域里的abc值：${sessionScope.abc}<br/>
<h1>c:if</h1>
    <c:if test="${12==12}">
        <div>12 等于 12</div>
    </c:if>
    <c:if test="${12!=12}">
        <div>12 不等于 12</div>
    </c:if>
<h1>c:choose c:when c:otherwise</h1>
    <%
        request.setAttribute("height",130);
    %>
    <c:choose>
        <c:when test="${requestScope.height>190}">
            <div>小巨人</div>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <div>很高</div>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <div>还可以</div>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${requestScope.height > 160}">
                    <h3>大于 160</h3>
                </c:when>
                <c:when test="${requestScope.height > 150}">
                    <h3>大于 150</h3>
                </c:when>
                <c:when test="${requestScope.height > 140}">
                    <h3>大于 140</h3>
                </c:when>
                <c:otherwise>
                    其他小于 140
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
<h1>c:foreach</h1>
    <div>遍历数</div>
        <table border="1">
            <c:forEach begin="1" end="10" var="i">
                <tr>
                    <td>第${i}行</td>
                </tr>
            </c:forEach>
        </table>

    <div>遍历数组</div>
        <%
            request.setAttribute("arr",new String[]{"111","222","333"});
        %>
        <c:forEach items="${requestScope.arr}" var="item">
            ${item}<br/>
        </c:forEach>

    <div>遍历map集合</div>
        <%
            Map<String,Object> map = new HashMap<>();
            map.put("key1","val1");
            map.put("key2","val2");
            map.put("key3","val3");
            request.setAttribute("map",map);
        %>
        <c:forEach items="${requestScope.map}" var="entry">
            <div>${entry.key}:${entry.value}</div>
        </c:forEach>
    <div>遍历list对象集合</div>
        <%
            List<Student> students = new ArrayList<>();
            for(int i=0;i<=10;i++){
                students.add(new Student(i,"user"+i,"pass"+i,18+i,"phone"+i));
            }
            request.setAttribute("students",students);
        %>
        <table>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>年龄</th>
                <th>电话</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.students}" begin="2" end="7" step="2" varStatus="status" var="stu">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.username}</td>
                    <td>${stu.password}</td>
                    <td>${stu.age}</td>
                    <td>${stu.phone}</td>
                    <td>${status.step}</td>
                </tr>
           </c:forEach>
        </table>
</body>
</html>
