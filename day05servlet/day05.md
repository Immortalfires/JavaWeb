# Web应用&Servlet

## 一、创建Web应用

### (一)创建静态应用

1. 在tomcat文件夹webapps下创建新文件夹hello**（命名不得包含中文）*
2. 在hello下创建index.html
3. 启动tomcat，访问localhost:8080/hello，显示成功即可。

### (二)创建动态应用

1.  在webapps下创建hello1目录
2.  在webapps\hello1\下创建WEB-INF目录
3.  在webapps\hello1\WEB-INF\下创建web.xml
4.  在webapps\hello1\下创建index.html
5.  打开浏览器访问http://localhost:8080/hello1/index.html
6. 在webapps\hello1\下创建index.jsp
7.  打开浏览器访问http://localhost:8080/hello1/index.jsp

### (三)完整项目在webapps里的结构

webapps

-  hello（项目名）
  - index.html（应用资源）
  - WEB-INF
    - web.xml（部署描述文件）
    - classes（存放class文件的目录）
    - lib（存放jar包的目录）

### (四)配置外部应用

当项目存放于tomcat目录之外时，我们要对文件进行配置。

1. 对conf/server.xml进行修改：在`<Host></Host>`元素中添加`<Context> path="指定应用的名称" docBase="指定应用的存放位置"</Context>`。完成后，浏览器可根据http://localhost:8080/应用的名称 访问
2. 对conf/catalana/localhost进行修改：在该目录下创建xml文件，文件名为指定应用的名称，内容为`<Context docBase="指定应用的存放位置"/>`。完成后，浏览器可根据http://localhost:8080/应用的名称 访问

### (五)理解server.xml

```xml
<Server>  <!--根元素,表示整个服务器的配置信息-->
    <Service> <!--只能有一个，表示服务-->
        <Connector></Connector> <!--可能有N个，表示连接-->
         <Engine> <!--只能有一个，表示引擎，是组件核心-->
             <Host> <!--可以有N个，表示虚拟主机-->
                 <Context>
                  <!--可以有N个，表示应用。
					如果应用在<Host>的appBase指定的目录下，那么可					以不配置<Context>元素，如果是外部应用或者要为应					用指定资源，那么就必须配置<Context>。-->
                 </Context>
             </Host>
        </Engine>
    </Service>
</Server>
```

### (六)映射虚拟主机

1. 在conf/server.xml中，修改端口号为80

```xml
<Connector port="80" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443"/>
```

2. 在C:\WINDOWS\system32\drivers\etc\hosts文件内，添加网址与127.0.0.1的绑定关系

> 127.0.0.1      你想要访问的网址

3. 在server.xml文件中添加一个`<Host>`

```xml
<Host name="你想要访问的网址" appBase="项目位置"
      unpackWARs="true" autoDeploy="true"></Host>
```

## 二、Servlet

### (一)servlet是什么？

servlet 是一项用于开发动态web资源的技术。在使用中，我们必须编写一个Java类并实现servlet接口，将开发好的Java类部署到web服务器上。

### (二)servlet的运行过程

servlet程序由web服务器调用，在服务器接收到servlet访问请求时

1. 先检查是否装载并创建了该Servlet的实例对象，若没有则2，若有则4
2. 装载并创建该Servlet的实例对象
3. 调用Servlet的init()方法
4. 创建一个用于封装HTTP请求消息的HttpServletRequest对象和代表HTTP响应消息的HttpServletResponse对象，然后调用servlet的service()方法，并将请求和响应对象作为参数传递
5. 在web应用被停止或重新启动之前，调用servlet的destory()方法，servlet引擎卸载servlet

### (三)servlet接口实现类

1. 实现javax.servlet.Servlet接口；
2. 继承javax.servlet.GenericServlet类；
3. 继承javax.servlet.http.HttpServlet类；(通常选用这个)

创建servlet：idea先创建一个Java工程，选择右边的Web Application，创建完成后，在web/WEB-INF中创建classes文件夹用于存放class文件，创建lib文件用于存放jar包，在project sructure中的Modules的path中，修改class文件和test文件输出路径为web/WEB-INF/classes，在dependencies中添加web/WEB-INF/lib为jar Directory，Artifacts中修改output directory为tomcat webapps的与工程同名的文件夹。然后在src里选择创建servlet，在web.xml里添加servlet-mapping。然后就可以写servlet了。

### (四)servlet注意点

1. URL映射配置（在web.xml中使用`<servlet>`和`<servlet-mapping>`完成）

   + `<servlet>`用于注册servlet，包含两个主要子元素`<servlet-name>`和`<servlet-class>`设置servlet注册名称和完整类名
   + `<servlet-mapping>`用于映射一个已经注册过的servlet的对外访问路径，包含`<servlet-name>`和`<url-pattern>`用于指定servlet的注册名称和servlet的对外访问路径

   ```xml
   <servlet>
       <servlet-name>Servlet1</servlet-name>
       <servlet-class>test2.B_Servlet</servlet-class>
   </servlet>
   
   <servlet-mapping>
       <servlet-name>Servlet1</servlet-name>
       <url-pattern>/X</url-pattern>
   </servlet-mapping>
   ```

   + 同一个servlet可以被映射到**多个url**上，即可以这样。当访问以下网址，均可访问该servlet

   > http://localhost:8080/servletDemo/X
   >
   > http://localhost:8080/servletDemo/Y
   >
   > http://localhost:8080/servletDemo/Z

   ```xml
   <servlet>
           <servlet-name>Servlet1</servlet-name>
           <servlet-class>test2.B_Servlet</servlet-class>
   </servlet>
   
   <servlet-mapping>
       <servlet-name>Servlet1</servlet-name>
       <url-pattern>/X</url-pattern>
   </servlet-mapping>
   <servlet-mapping>
       <servlet-name>Servlet1</servlet-name>
       <url-pattern>/Y</url-pattern>
   </servlet-mapping>
   <servlet-mapping>
       <servlet-name>Servlet1</servlet-name>
       <url-pattern>/Z</url-pattern>
   </servlet-mapping>
   ```

2. URL可以使用*通配符映射，可以使用任意URL访问该servlet

```xml
<servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>test2.B_Servlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>Servlet1</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

3. 缺省Servlet，当映射路径为"/"时，凡是web.xml里找不到匹配`<servlet-mapping>`的URL，统一交给缺省Servlet

### (五)servlet接口

1. 与servlet生命周期相关的方法(前三个)（test1/A_servlet)
   - void init(ServletConfig config)   创建servlet时调用，只调用一次
   - void service(ServletRequest,ServletResponse)  会被调用多次，每次处理请求时都调用
   - void destroy()  在servlet被销毁前调用，只调用一次
   - ServletConfig getServletConfig() 获取servlet配置信息
   - String getServletInfo()   获取servlet信息  

2. servletConfig是什么？（test2/B_servlet）

> 通过servletConfig获取servlet的初始化参数。web容器在创建servlet实例对象是，会自动将这些初始化参数封装到servletConfig对象中，在调用init方法时，会将servletConfig对象传递给servlet，从而通过servletConfig对象得到初始化参数。

- 通过`<init-parm>`配置servlet初始化参数

```xml
<servlet>
    <servlet-name>Servlet1</servlet-name>
    <servlet-class>test2.B_Servlet</servlet-class>
    <!--为servlet配置初始参数-->
    <init-param>
        <param-name>name</param-name>
        <param-value>noName</param-value>
    </init-param>
    <init-param>
        <param-name>pwd</param-name>
        <param-value>789456</param-value>
    </init-param>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</servlet>
```

- API

> String fetServletName()  : 获取的是标签内容
>
> ServletContext getServletContext() : 获取servlet上下文
>
> String getInitParameter(String name)：获取相应名字的初始化参数值
>
> Enumeration getInitParameterNames()：获取所有初始化参数，返回一个迭代器

### (六)GenericServlet

- 模拟实现GenericServlet（test3/C_servlet D_servlet）
- 直接继承GenericServlet（test3/E_servlet）

它是Servlet接口的实现类，我们可以通过继承GenericServlet来编写自己的Servlet。

> 关于init()方法的覆写
>
> 我们应当去覆盖无参的init()方法，因为在GenericServlet中，定义了一个ServletConfig的对象，在类中的许多方法会使用到该对象，在有参的init方法中，对config进行了初始化操作，所以一旦覆盖有参方法，后续可能会出现空指针异常。

```java
void init(ServletConfig config){
    this.config = config;
}
```

它也实现了servletConfig接口，可以调用getInitParameter()、getServletContext()等ServletConfig的方法。

### (七)HttpServlet

（test4/F_Servlet、login.html） 

> HttpServlet extends GenderServlet{}
>
> ​	void service(ServletRequest,ServletResponse)-->一个生命周期方法
>
> >  它会强制转换两个参数为http协议相关的类型
> >
> > 然后调用本类的service(HttpServletRequest,HttpServletResponse)
> >
> > > 它会根据request得到当前请求的请求方式,例如:GET或POST
> > >
> > >  根据请求方式调用doGet()或者doPost()
> > >
> > > 所以我们要根据需求重写doGet/doPost

### (八)Servlet注意的点

1. 关于线程安全

   由于一个类型的servlet只有一个实例化对象，造成线程不安全，所以我们

   - 不要在Servlet中创建成员！创建局部变量即可
   - 可以创建无状态成员(无成员变量的类)
   - 可以创建有状态的成员，但状态必须为只读的(成员变量仅有get方法)

2. 可以在服务器启动时创建Servlet

   在web.xml里配置`<load-on-startup>非负数</load-on-startup>`，启动时由数字小到大依次创建。

3.  <url-pattern>

   它是`<servlet-mapping>`的子元素，用于指定Servlet访问路径，即URL，必须以/开头

   - 可以在一个`<servlet-mapping>`绑定多个 `<url-pattern>`
   - 可以给出通配符 * 

4. web.xml文件的继承

   所有工程里的web.xml文件都“继承”于tomcat下的conf/web.xml

### (九)ServletContext

（test5/G_Servlet、H_Servlet） 

1. 服务器为每个应用创建一个**唯一**的ServletContext对象，可以在web动态资源之间共享数据。在服务器启动时创建，在关闭时销毁。冥迷

2. 获取ServletContext

   - 在servlet中获取：ServletConfig类中的getServletContext()方法
   - 在GenericServlet或HttpServlet中获取：GenericServlet中有该方法，所有可直接使用this.getServletContext()方法
   - HttpSession中获取：getServletContext()方法
   - servletContextEvent中获取：getServletContext()方法

3. ServletContext是四大域对象之一。

   - setAttribute(String name,Object value)用于存储一个对象/域属性。如若多次调用该方法，且使用相同name，则会覆盖上一次的值。
   - getAttribute(String name) 用于获取ServletContext里的值，获取之前必须要去存储。
   - removeAttribute(String name)用于移除域属性。
   - Enumeration getAttribute() 获取所有域属性的名称

4. 可以获取应用初始化参数

   （web.xml & test5/I_Servlet）

   getInitParameter(String) 方法

   > Servlet也可以获取初始化参数，但两者有所不同，Servlet获取到的是局部参数，只能获取自己的。
   >
   > ServletContext可获取公共初始化参数，供所有servlet使用

   ```xml
   <context-param>
       <param-name>context-param</param-name>
       <param-value>context-value</param-value>
   </context-param>
   ```


5. 获取资源（test5/J_Servlet)

   1. 获取真实路径

   > ServletContext.getRealPath() 获得一个带盘符的路径

   2. 获取资源流

   > ServletContext.getResourceAsStream() 

   3. 获取指定目录下所有资源路径

   > ServletContext.getResourcePaths() 

## 三、小练习，访问量的统计

（example）

## 四、获取类路径下的资源

其实就是/WEB-INF/classes和/WEB-INF/lib下的每个jar包

（test5/K_Servlet)

1. Class
2. ClassLoader