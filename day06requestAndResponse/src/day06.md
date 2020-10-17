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

   案例：发送404状态码

2. df

3. fd