<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/14
  Time: 19:57
  To change this template use File | Settings | File Templates.

  获取Cookie
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get</title>
</head>
<body>
    <h1>Get Cookie</h1>

    <%
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies) {
                response.getWriter().write(cookie.getName()+"="+cookie.getValue()+"<br/>");
            }
        }
    %>
</body>
</html>