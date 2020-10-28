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

## 四、EL表达式

> day07jsp/web/EL表达式

### (一)简介

1. expression language，表达式语言
2. 作用：替代jsp页面中的表达式脚本，进行数据输出，为了简洁。

### (二)四个域中的顺序问题

> pageContext、session、application、request四个域

1. pageContext
2. request
3. session
4. application

### (三)JavaBean中的属性（person.jsp）

### (四)运算

1. 关系运算

   | 关系运算符 | 说明     | 范例     | 结果  |
   | ---------- | -------- | -------- | ----- |
   | ==或eq     | 等于     | ${5==5}  | true  |
   | !=或ne     | 不等于   | ${5!=5}  | false |
   | <或lt      | 小于     | ${3<5}   | true  |
   | \>或gt     | 大于     | ${2>10}  | false |
   | <=或le     | 小于等于 | ${5<=12} | true  |
   | \>=或ge    | 大于等于 | ${3>=5}  | false |

2. 逻辑运算

   | 逻辑运算符 | 说明     | 范例               | 结果  |
   | ---------- | -------- | ------------------ | ----- |
   | &&或and    | 与运算   | ${12==12&&12<11}   | false |
   | \|\| 或 or | 或运算   | ${12==12\|\|12<11} | true  |
   | ! 或 not   | 取反运算 | ${!true}           | false |
   
3. 算术运算

   | 算术运算符 | 说明 | 范例      | 结果 |
   | ---------- | ---- | --------- | ---- |
   | +          | 加法 | ${12+18}  | 30   |
   | -          | 减法 | ${18-8}   | 10   |
   | *          | 乘法 | ${12*12}  | 144  |
   | /或div     | 除法 | ${144/12} | 12   |
   | %或mod     | 取模 | ${144%10} | 14.4 |

4. empty运算

   用于判断一个数据是否为空，若为空，输出true，不为空输出false

   >1. 值为null，为空
   >2. 值为空串，为空
   >3. 值是Object类型数组，长度为0
   >4. list集合，长度为0
   >5. map集合，长度为0

5. 三元运算

   表达式1？表达式2：表达式 3

   > 如果 表达式1为真，返回2；如果为假，返回3

6. 点运算以及中括号运算

   "."运算，可以输出bean对象中某个属性的值

   "[]"运算，可与输出有序集合中某个元素的值，还可以输出map集合中key含有特殊字符的key的值

### (五)11个隐含对象

> web/EL表达式 /duixiang.jsp

| 变量             | 类型                 | 作用                                               |
| ---------------- | -------------------- | -------------------------------------------------- |
| pageContext      | PageContextImpl      | 它可以获取 jsp 中的九大内置对象                    |
| pageScope        | Map<String,Object>   | 它可以获取 pageContext 域中的数据                  |
| requestScope     | Map<String,Object>   | 它可以获取 Request 域中的数据                      |
| sessionScope     | Map<String,Object>   | 它可以获取 Session 域中的数据                      |
| applicationScope | Map<String,Object>   | 它可以获取 ServletContext 域中的数据               |
| param            | Map<String,String>   | 它可以获取请求参数的值                             |
| paramValues      | Map<String,String[]> | 它可以获取请求参数的值，获取多个值                 |
| header           | Map<String,String>   | 它可以获取请求头的信息                             |
| headerValues     | Map<String,String[]> | 它可以获取请求头的信息，获取多个值                 |
| cookie           | Map<String,Cookie>   | 它可以获取当前请求的 Cookie 信息                   |
| initParam        | Map<String,String>   | 它可以获取web.xml中配置的<context-param>上下文参数 |

## 五、JSTL标签库

### (一)简介

1. JSP standrad Tag Library,Jsp标准标签库，是一个不断完善的开源jsp标签库。

2. 主要是为了替换代码脚本，由五个不同功能的标签库组成

   >核心标签库 ----- http://java.sun.com/jsp/jstl/core     ----c
   >
   >格式化		------ http://java.sun.com/jsp/jstl/fmt   - -----fmt
   >
   >函数             ----- http://java.sun.com/jsp/jstl/functions   ----fn
   >
   >数据库		------ http://java.sun.com/jsp/jstl/sql	-----sql
   >
   >xml				----- http://java.sun.com/jsp/jstl/xml	-----x

3. 先导入jar包，再用taglib指令引入标签库

   > taglibs-standard-impl-1.2.1.jar
   >
   > taglibs-standard-spec-1.2.1.jar
   >
   > <%@ taglib prefix="前缀"  uri="uri"%>

### (二)core核心库的使用

1. \<c:set/>往域中保存数据

   1. scope 属性设置保存到哪个域
          page表示PageContext域（默认值）
          request表示Request域
          session表示Session域
          application表示ServletContext域
   2. var属性设置key
   3. value属性设置值

2. \<c:if/>  if判断，test属性表示判断条件，使用EL表达式输出

3. \<c:choose>\<c:when>\<c:otherwise> 多路判断，类似于switch case

4. \<c:foreach>  用于遍历输出

   > begin属性设置开始的索引 end 属性设置结束的索引 var 属性表示循环的变量(也是当前正在遍历到的数据)
   >
   > for (Object item: arr) items 表示遍历的数据源（遍历的集合） var 表示当前遍历到的数据