<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/18
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetSession</title>
</head>
<body>

<h1>Get Session</h1>
<%
    String str = (String) session.getAttribute("name");
    out.write(str);
%>

</body>
</html>
