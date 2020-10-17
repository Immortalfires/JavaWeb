# day07

## 一、JSP

1. 作用：可以在原有html基础上添加java脚本，构成jsp页面
2. 与Servlet的分工：
   - Servlet：处理数据
   - JSP：作为请求发起和结束的页面

3. 组成：html+java脚本+jsp标签（指令）

   - 9大内置对象，无需创建。

     > request、response、session、application、out、pagecontext、config、page、exception

   - 3种java脚本

     > <%...%>  java代码片段，不能包含函数和类。 
     >
     > <%=...%>用于输出，表达式或变量的结果
     >
     > <%!...%>声明，用于创建类的变量和方法

4. 案例：
   - 循环演示：add/a.jsp
   - jsp和Servlet分工合作 add/form.jsp result.jsp A_Servlet

5. 服务器解析结果：
   - html数据都在out.write()中出现，以字符串形式输出
   - <%...%>内的语句不变
   - <%=...%>会放入out.print()中，输出变量

6. 注释：<%--...--%>当编译后，已经忽略了注释部分

## 二、cookie

### (一)简介

1. 由HTTP协议制定。服务器创建Cookie键值对（一键一值），保存到客户端上。下次请求服务后交给服务器。服务器保存Cookie的响应头：Set-Cookie，客户端归还Cookie的请求头：Cookie

2. Cookie有限制

   > 1个Cookie最大4KB
   > 1个服务器最多向1个浏览器保存20个Cookie
   > 1个浏览器最多可以保存300个Cookie

3. 使用Cookie：

   - 使用response发送set-Cookie响应头，request获取Cookie请求头

   - response.addCookie()保存Cookie，request.getCookies()获取浏览器归还的Cookie

     （常用）

4. 实例：Cookie的保存(saveAndGet/a.jsp b.jsp)

### (二)详解

1. 属性

   - name（Cookie名）

   - value（Cookie值）

   - maxAge（Cookie的最大生命）

     > maxAge>0  保存Cookie，有效时长由maxAge的值决定
     >
     > maxAge=0 浏览器马上删除Cookie
     >
     > maxAge<0 只在浏览器内存中存在。浏览器一关闭，Cookie立即死亡

   - path（Cookie的路径）

     > 设置当访问该路径时，返回该Cookie

   - domain（Cookie的域名）当多个二级域中共享Cookie时才有用。其setPath必须为`/`

## 三、HttpSession

### (一)概述

1. JavaWeb提供，用于会话跟踪，保存在服务器端。
2. Servlet三大域对象之一（request，application（ServletContext），session（HttpSession））
   - setAttribute（）
   - getAttribute（）
   - removeAttribute（）
3. 底层依赖Cookie，或URL重写

### (二)简介

1. session在首次打开浏览器时创建，关闭浏览器时结束。

2. Servlet中获得session对象

   > HttpSession session=request.getSession()

3. JSP中获得session对象

   > 为9大内置对象之一，不用创建可以直接使用

4. session域相关方法

   -  void setAttribute(String name, Object value);
   - Object getAttribute(String name);
   - void removeAttribute(String name);
   
5. 实例

   - 存储获取session数据(session1/SetSession.jsp GetSession.jsp)
   - 保存用户登录信息！！！(session2 & B_Servlet)

### (三)原理

1. request.getSession()方法，获取Cookie中的JSESSIONID（唯一）
2. 只在第一次获取session时才会创建session

