<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/10/26
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>empty</title>
</head>
<body>
    <%
        request.setAttribute("emptyNull",null);
        request.setAttribute("emptyStr","");
        request.setAttribute("emptyArr",new Object[]{});
        List<String> list = new ArrayList<>();
        request.setAttribute("emptyList",list);
        Map<String,Object> map = new HashMap<String,Object>();
        request.setAttribute("emptyMap",map);

        Map<String,Object> map1 = new HashMap<>();
        map1.put("a.a.a", "aaaValue");
        map1.put("b+b+b", "bbbValue");
        map1.put("c-c-c", "cccValue");
        request.setAttribute("map1",map1);
    %>
    ${emptyNull}<br>
    ${emptyStr}<br>
    ${emptyArr}<br>
    ${emptyList}<br>
    ${emptyMap}<br>

    三元运算：${12==12?"真的":"假的"}<br>

    中括号运算：
    ${ map1['a.a.a'] } <br>
    ${ map1["b+b+b"] } <br>
    ${ map1['c-c-c'] } <br>
</body>
</html>
