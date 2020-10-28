<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/10/25
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>

    表达式脚本输出：
    <%=request.getAttribute("key1")==null? "" :request.getAttribute("key1")%>  <br/>
    EL表达式输出：
    ${key1}

    表达式脚本输出：
    <%=request.getAttribute("key")==null? "" :request.getAttribute("key")%>  <br/>
    EL表达式输出：
    ${key}
</body>
</html>
