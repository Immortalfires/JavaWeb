<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/18
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Succ1</title>
</head>
<body>

    <%
        HttpSession session1 = request.getSession();
        String name = (String) session1.getAttribute("username");
    %>
    <h1>欢迎访问！用户<font color="darkorange"><%=name%></font> </h1>

</body>
</html>
