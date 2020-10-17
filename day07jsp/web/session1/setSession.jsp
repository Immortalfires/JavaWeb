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
    <title>SetSession</title>
</head>
<body>

<h1>Save in Session</h1>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("name","Amy");
%>

</body>
</html>
