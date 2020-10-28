<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/10/27
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的11个隐含对象</title>
</head>
<body>
<%
    pageContext.setAttribute("key1","pageContext1");
    pageContext.setAttribute("key2","pageContext2");
    pageContext.setAttribute("req",request);
    request.setAttribute("key2","request");
    session.setAttribute("key2","session");
    application.setAttribute("key2","application");
%>
1. EL获取四个特定域的属性 : ${applicationScope.key2}、${sessionScope.key2}、${requestScope.key2}、${pageScope.key1}<br/>
2. pageContext对象的使用<br/>
    请求的协议：<%=request.getScheme()%>,${req.scheme}<br/>
    请求的服务器ip/域名: <%=request.getServerName()%>,${req.serverName}<br/>
    请求的端口号：<%=request.getServerPort()%>,${req.serverPort}<br/>
    获取当前的工程路径：<%=request.getContextPath()%>,${req.contextPath}<br/>
    获取请求方式：<%=request.getMethod()%>,${req.method}<br/>
    获取客户端的ip地址：<%=request.getRemoteHost()%>,${req.remoteHost}<br/>
    获取会话唯一id：<%=request.getSession()%>,<%=session.getId()%>,${pageContext.session.id}<br/>
3. 其他隐含对象的使用<br/>
    输出请求参数 username 的值：${ param.username } <br>
    输出请求参数 password 的值：${ param.password } <br>
    输出请求参数 username 的值：${ paramValues.username[0] } <br>
    输出请求参数 hobby 的值：${ paramValues.hobby[0] } <br>
    输出请求参数 hobby 的值：${ paramValues.hobby[1] } <br>
    输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
    输出请求头【Connection】的值：${ header.Connection } <br>
    输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br>
    获取 Cookie 的名称：${ cookie.JSESSIONID.name }<br>
    获取 Cookie 的值：${ cookie.JSESSIONID.value } <br>
    输出web.xml中Context-param的username值：${initParam.username}<br>
    输出web.xml中Context-param的url值：${initParam.url}<br>
</body>
</html>
