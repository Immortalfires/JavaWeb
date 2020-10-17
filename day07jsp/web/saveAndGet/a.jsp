<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/14
  Time: 19:57
  To change this template use File | Settings | File Templates.

  保存Cookie
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
    <h1>Save Cookie</h1>

    <%
        response.addCookie(new Cookie("align","right"));
        response.addCookie(new Cookie("crown","center"));
    %>

</body>
</html>
