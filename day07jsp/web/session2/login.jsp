<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/4/18
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--登录表单 && 错误信息--%>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<%
    String str = "";
    String msg = (String) request.getAttribute("msg");
    if(msg!=null){
        str = msg;
    }
%>
<font color="red"><b><%=str%></b></font>
    <form action="/day07/B" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>

    </form>

</body>
</html>
