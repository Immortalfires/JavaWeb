# 服务器处理请求

## 一、流程

1. 服务器接收请求，为请求开辟一个新的线程
2. 将客户端的请求数据封装至request对象
3. 服务器创建response对象，向客户端发送响应

## 二、response

类型为HttpServletResponse（与HTTP协议相关的类）

1. 状态码

   - sendError(int sc) 发送错误状态码
   - sendError（int sc,String msg) 发送错误状态码以及错误信息
   - setStatus(int sc) 发送成功状态码，或者302(重定向)

   案例：发送404状态码（A_Servlet)

2. 响应头：Content-Type、Refresh、Location等等
   *头就是一个键值对！可能会存在一个头（一个名称，一个值），也可能会存在一个头（一个名称，多个值！）*

   - setHeader(String name, String value)：适用于单值的响应头
   - addHeader(String name, String value)：适用于多值的响应头
   - setIntHeader(String name, int value)：适用于单值的int类型的响应头
   - addIntHeader(String name, int value)：适用于多值的int类型的响应头
   - setDateHeader(String name, long value)：适用于单值的毫秒类型的响应头
   - addDateHeader(String name, long value)：适用于多值的毫秒类型的响应头

   案例：发送302，设置Location头，完成重定向（B_Servlet、C_Servlet)

   ​			定时刷新，设置Refresh头（D_Servlet、E_Servlet)

   ​			禁用浏览器缓存 Cache-Control，pragma，expires（F_Servlet)

   ​			<meta>标签可以代替响应头

3. response的两个流：

   **两个流不能同时使用！**（会报错 Illegal State Exception）

   - ServletOutputStream，用来向客户端发 送字节数据。ServletOutputStream out = resopnse.getOutputStream();

   - PrintWriter，用来向客户端发送字符数据！需要设置编码。PrintWriter writer = response.getWriter();

     案例：重定向send Redirect（String location）（G_Servlet）

## 三、request

1. 它封装了客户端所有的请求数据

   请求行
   请求头
   空行
   请求体（GET请求没有请求体）

2. 获取常用信息：
   - 获取客户端IP：request.getRemoteAddr()
   - 获取请求方式：request.getMethod() 
3. 获取HTTP请求头：
   - **String getHeader(String name)，适用于单值头**
   - int getIntHeader(String name)，适用于单值int类型的请求头
   - long getDateHeader(String name)，适用于单值毫秒类型的请求头
   -  Enumeration<String> getHeaders(String name)，适用于多值请求头
4. 案例：
   - 通过User-Agent识别用户浏览器类型（H_Servlet)
   - 获取请求URL（I_Servlet)
     - String getScheme()：获取协议
     - String getServerName()：获取服务器名
     -  String getServerPort()：获取服务器端口
     - String getContextPath()：获取项目名
     - String getServletPath()：获取Servlet路径
     - String getQueryString()：获取参数部分，即问号后面的部分
     - String getRequestURI()：获取请求URI，等于项目名+Servlet路径
     - String getRequestURL()：获取请求URL，等于不包含参数的整个请求路径
   - 防盗链：Referer头。（J_Servlet&&test.html)
5. 获取请求参数：（客户端发给服务器的，可能在请求体中，也可能当成参数直接发送）（超链接和表单数据）（K_Servlet&&a.html)
   - String getParameter(String name)：获取指定名称的请求参数值，适用于单值请求参数
   - String[] getParameterValues(String name)：获取指定名称的请求参数值，适用于多值请求参数
   - Enumeration<String> getParameterNames()：获取所有请求参数名称
   - Map<String,String[]> getParameterMap()：获取所有请求参数，其中key为参数名，value为参数值。

6. 请求转发和请求包含

   请求转发：rd.forward(request,response);(L_Servlet M_Servlet)
   请求包含：rd.include(request,response);(N_Servlet O_Servlet)

   有时一个请求需要多个Servlet协作才能完成，所以需要在一个Servlet跳到另一个Servlet！

   > 一个请求跨多个Servlet，需要使用转发和包含。
   >
   > > 请求转发：由下一个Servlet完成响应体！当前Servlet可以设置响应头！（留头不留体)
   >
   > > 请求包含：由两个Servlet共同未完成响应体！（都留）
   >
   > > 无论是请求转发还是请求包含，都在一个请求范围内！使用同一个request和response

7. request域(L_Servlet M_Servlet)

   Servlet中三大域对象：request、session、application，都有如下三个方法：

   > void setAttribute(String name, Object value)
   >
   > Object getAttribute(String name)
   >
   > void removeAttribute(String name);

   同一请求范围内使用request.setAttribute()、request.getAttribute()来传值！前一个Servlet调用setAttribute()保存值，后一个Servlet调用getAttribute()获取值。

8. 请求转发和重定向的区别

   - 请求转发是一个请求一次响应，而重定向是两次请求两次响应

   - 请求转发地址栏不变化，而重定向会显示后一个请求的地址

   - 请求转发只能转发到本项目其他Servlet，而重定向不只能重定向到本项目的其他Servlet，还能定向到其他项目

   - 请求转发是服务器端行为，只需给出转发的Servlet路径，而重定向需要给出requestURI，即包含项目名！

   - 请求转发和重定向效率是转发高！因为是一个请求

     > 需要地址栏发生变化，那么必须使用重定向！
     >
     > 需要在下一个Servlet中获取request域中的数据，必须要使用转发！

9. 路径