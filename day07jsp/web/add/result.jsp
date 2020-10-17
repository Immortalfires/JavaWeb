<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/14
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>

    <%
        String res = (String)request.getAttribute("result");
    %>
    <%=res
    %>

</body>
</html>
