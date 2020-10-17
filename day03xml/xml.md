# XML学习(day03)

## 一、表单提交方式

(formAction/demo 1)

1. 一般使用submit进行表单提交

   ```html
   <form>
       ......
       <input type="submit"/>
   </form>
   ```

2. 也可使用button按钮提交

   ```javascript
   function form1(){
       //获取form表单
       var form1 = document.getElementById("form1");
       //设置action 提交页面
       form1.action="hello.html";
       //执行提交
       form1.submit();
   }
   ```

3. 超链接提交

   ```html
   <a href="hello.html?username=ahhaha">提交</a>
   ```

- onclick   鼠标点击事件
- onchange   改变内容，与select一起用
- onfocus   得到焦点
- onblur    失去焦点

## 二、XML的简介

### （一）什么是XML

> 可扩展标记语言，类似html，它是用来传输数据的。
>
> 标签可扩展性，无预定义标签，需要自行定义。

### （二）XML的应用

1. 不同系统间传输数据

2. 表示生活中有关系的数据

   > lXML中的数据必须通过软件程序来解析执行或显示，如IE；这样的解析程序称之为Parser(解析器)。

3. 配置文件

   > Struts、Spring、Hibernate都基于XML作为配置文件。

## 三、XML语法

### （一）文档声明

1. 创建文件，后缀名.xml

2. 必须有**文档声明**，表示写xml文件的内容

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   ```

3. **必须写在第一行第一列**
4. 属性
   1. version：1.0 / 1.1 一般使用1.0
   2. encoding：gbk utf-8 iso8859-1（不含中文）
   3. standalone：是否需要依赖其他文件 （很少用）

### （二）定义元素（标签）

1. 标签必须有始有终。
   1. <a></a>
   2. <a/>
2. 一个标签可以嵌套其他子标签。
3. 一个XML文档**<font color=red>有且仅有一个根标签</font>**。
4. 空格和换行均会被当做内容进行解析。
5. **命名规则**
   1. 区分大小写
   2. 不能以数字或__开头
   3. 不能以xml、XML、Xml开头
   4. 不能包含空格、冒号

### （三）定义属性

```xml
<person id1="haha"></person>
<!--id1是个属性，属性值为haha-->
```

1. 属性定义的要求
   1. 一个标签可以有多个属性
   2. 属性名称不能相同
   3. 命名规范同定义元素的要求相同。

### （四）注释

```xml
<!--其中为注释-->
```

> 注意：注释不能嵌套！！！

### （五）特殊字符

| 特殊字符 | 替代符号 |
| -------- | -------- |
| &        | `&amp;`  |
| <        | `&lt;`   |
| >        | `&gt;`   |
| "        | `&quot;` |
| '        | `&apos;` |

### *（六）CDATA区*

> 了解一下即可
>
> CDATA是Character Data的缩写。

作用：把特殊字符当做普通文本内容；

语法：`<![CDATA[内容]]>`

### *（七）PI指令（处理指令）*

（xml/demo01）

> 了解一下即可
>
> 在xml里设置样式
>
> <font color=red>对中文标签无作用</font>

```xml
<?xml-stylesheet type="text/css" href="css文件路径"?>
<!--PI指令，将css文件导入-->
```

## 四、XML的约束

> 为什么需要约束？
>
> 因为xml的标签为自定义，所以无法体现该标签是否合理，所以必须规定xml中能出现的元素，所以需要约束。

约束技术：dtd约束、schema约束

idea生成该文件方法：菜单栏

> tools->XML Actions->Generate DTD/Schema from files

### （一）dtd约束

一个xml文件只能有一个dtd文件

#### （Ⅰ）dtd的引入方式

1. 外部文件约束

   1. 新建dtd文件，后缀名.dtd。

   2. xml文件内有多少个元素，就写几个`<!ELEMENT>`。

   3. 判断是简单元素还是复杂元素。

      1. 简单元素：无子元素  

         `<!ELEMENT 元素名称 (#PCDATA)>`

      2. 复杂元素：有子元素

         `<!ELEMENT 元素名称 (子元素)>`

   4. 在xml内引入dtd文件

   ```dtd
   <!DOCTYPE 根元素名称 SYSTEM "dtd文件路径">
   ```

2. 内部dtd约束（idea编辑器可自动生成dtd文件）

   1. idea生成此类文件：

      tools->XML Actions->Generate DTD from XMLfiles

```xml-dtd
<!DOCTYPE person [
        <!ELEMENT person (name|age)*>
        <!ELEMENT name (#PCDATA)>
        <!ELEMENT age (#PCDATA)>
        ]>
<person>
    <name>Alex Piper</name>
    <age>34</age>
</person>
```

3. 使用外部dtd文件

```xml-dtd
<!DOCTYPE 根元素 PUBLIC "DTD名称" "DTD文档的URL">
```

#### （Ⅱ）dtd定义元素

```xml-dtd
<!ELEMENT 元素名 约束>
```

1. 简单元素： `<!ELEMENT 元素名称 (#PCDATA)>`

   约束条件：	

   - (#PCDATA)：约束元素名称是字符串类型
   - EMPTY：约束元素为空，没有内容
   - ANY：任意

2. 复杂元素：`<!ELEMENT 元素名称 (子元素)>`

   约束条件：

   - 表示元素出现的次数

     + ：出现一次或多次

     ?：出现零次或一次

     *：出现零次或多次

   - 子元素分隔符

     , ：必须按照声明顺序去编写XML文档

     | ：说明任选其一。

#### （Ⅲ）dtd定义属性

（xml/demo02）

1. 语法：`<!ATTLIST 元素名称 属性名称 属性类型 属性约束>`

2. 属性类型：

   - CDATA：普通文本字符

   ```xml-dtd
   <!ATTLIST birth ID1 CDATA #REQUIRED>
   ```

   - ENUMERATED：枚举，只能从枚举列表选一

   > 由于没有该关键字，用(枚举值|枚举值|枚举值)
   >
   > 代替

   ```xml-dtd
   <!ATTLIST age ID2 (AA|BB|CC|DD) #REQUIRED>
   ```

   - ID：表示属性取值不能重复(只能由数字或下划线开头)

   ```xml-dtd
   <!ATTLIST name ID3 ID #REQUIRED>
   ```

3. 属性约束：

   1. #REQUIRED：该属性不许出现
   2. #IMPLIED：该属性可有可无
   3. #FIXED：属性取值固定 `#FIXED "固定值"`
   4. 直接值：该属性取值为默认值，可被覆盖

#### （Ⅳ）dtd定义实体

（xml/demo02）

```xml-dtd
<!--实体定义 需要写入内部dtd-->
<!ENTITY TEST "Copyright to xxx">

<!--实体引用-->
&TEST;
```

#### （Ⅴ）实例

（xml/example1 example2）根据dtd文件建立xml文件

### （二）Schema约束

1. 它符合xml语法
2. 一个xml可以有多个schema，使用名称空间进行区分
3. schema支持更多数据类型

#### （Ⅰ）schema快速入门

1. 创建schema文件(xml/1.xsd)，根节点为<schema></schema>

   约束的xml文件为demo04.xml

> 根节点schema有以下属性：
>
> xmlns="http://www.w3.org/2001/XMLSchema" 表示当前xml文件是一个约束文件
>
> targetNamespace="http://www.Aurevoir/20200217"  使用schema约束文件，通过这个地址引入约束条件
>
> elementFormDefault="qualified" 

1. 看xml文件内有多少个元素写几个`<element>`

2. 判断是简单元素还是复杂元素

   - 复杂元素

   ```xml
   <element name="person">
           <complexType>
               <sequence>
                   子元素
               </sequence>
           </complexType>
       </element>
   ```

   - 简单元素，写在sequence内

   ```xml
   <element name="name" type="string"></element>
   <element name="age" type="int"></element>
   ```

3. 被约束文件引入schema文件

```xml
<person xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  表示该xml文件是一个被约束文件
    xmlns="schema文件的targetNamespace"
    xsi:schemaLocation="schema文件的targetNamespace schema文件名">xsi为别名
```

4. 复杂的schema约束，当一个xml文件引入多个schema文件时，标签名一样，使用 命名别名:标签名 来区分不同的命名空间中的同名标签。

#### （Ⅱ）复杂元素指示器

1. all：所包的标签只能出现一次
2. choice：所包的标签只能出现其中的一个
3. sequence：元素按照顺序出现
4. maxOccurs="unbounded" 表示出现次数没限制

```xml
<element name="name" type="string" maxOccurs="unbounded"/>
```

1. 定义属性（必须是复杂元素）：写在complexType下

```xml
<attribute name="p1" type="string" use="required"></attribute>
```

6. `<any></any>`表示任意元素

## 五、XML解析简介

### （一）解析方式：dom和sax

![xml的dom和sax的解析过程](D:\.AA重要文件\学习文件\xml的dom和sax的解析过程.png)

![sax的解析的过程.png](D:\.AA重要文件\学习文件\sax的解析的过程.png)

1. 解析器：通过api方式提供
   1. sun公司  jaxp针对dom和sax
   2. dom4j   dom4j针对dom和sax
   3. jdom    jdom针对dom和sax

### （二）解析器使用

#### （Ⅰ）jaxp

1. jaxp是javaSE的一部分，位于javax.xml.parsers包中。

   有四个类，分别是针对dom 和 sax解析使用的类

   dom：

   - DocumentBuilder：解析器类

     抽象类，可通过DocumentBuilderFactory.newDocumentBuilder()方法获

     parse("xml路径")  可以解析xml，返回Document文档。返回的Document是一个接口，继承Node。

   > documenrt方法：
   >
   > 1. getElementsByTagName(String  tagName) 得到标签 返回集合
   > 2. createELement(String tagName)   创建标签
   > 3. createTextNode(String data)  创建文本
   > 4. appendChild(Node newChild)   添加子节点
   > 5. removeChild(Node oldChild)   删除子节点
   > 6. getParentNode()   获取父节点
   > 7. NodeList list getLength()  获取列表长度
   > 8. NodeList list item(int index)  下标取得具体值
   > 9. getTextContent 得到标签内的内容

   - DocumentBuilderFactory：解析器工厂

     抽象类，可通过DocumentBuilderFactory.newInstance()方法获取实例

   sax：

   - SAXParser：解析器类

     实例从SAXParserFactory.newSAXParser()方法获得

     parse(File f,DefaultHandler dh)

     - 第一个参数 xml的路径
     - 事件处理器

   - SAXParserFactory：解析器工厂类

2. 使用jaxp的dom操作节点   

   （xml/demo 03 和 jaxp文件夹）

   - 查询
   - 添加
   - 修改
   - 删除
   - 遍历节点

   <font color=red>**在进行添加、修改、删除操作时，应当在最后一步进行回写xml操作，不然无法成功显示修改内容！！！**</font>

   回写xml操作

   ```java
   TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           transformer.transform(new DOMSource(document),new StreamResult("xml文件路径"));
   ```

3. 使用jaxp的sax方式解析xml。sax不能实现增删改操作，只能查询。

   （xml/demo 05 和 jaxp文件夹）

#### （Ⅱ）dom4j

[dom4j QuickStart](https://dom4j.github.io/)

1. 导入jar包
2. 得到document对象

```java
public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
}
```

- document父接口为Node，其中的方法

> 1. getRootElement()    获取根节点，返回ELement

- Element父接口也为Node，其中的方法

> 1. getParent()    获得父节点
> 2. addElement() 添加标签
> 3. element(qname)表示获取标签下的第一个子标签 ，qname为标签名
> 4.   elements(qname)获取标签下所有子标签，qname为标签名
> 5. elements() 获取标签下的所有子标签，不规定标签名

3. dom4j执行操作：（xml/demo 06 和 dom4j文件夹）

   - 查询xml

   - 添加操作、特定位置添加

   - 创建dom4j工具类   dom4j/dom4jUtils

   - 修改

   - 删除

   - 获取属性值

   - **支持xpath的操作，可以直接获取到某个元素**

     （默认不支持xpath，需要导入jar包 jaxen-1.1-beta-6.jar）

     dom4j提供两个方法支持用于支持xpath

     - selectNodes("xpath表达式")
     - selectSingleNode("xpath表达式")

   <font color=red>**在进行添加、修改、删除操作时，应当在最后一步进行回写xml操作，不然无法成功显示修改内容！！！**</font>

```java
XMLWriter writer = new XMLWriter(new FileOutputStream(), 					OutputFormat.createPrettyPrint());
//OutputFormat.createPrettyPrint()为格式化操作
writer.write(document);
writer.close();
```

xpath的实例：

> 1. /AAA/BBB/DDD   表示一层一层的，AAA下的BBB下的DDD
>
> 2. //BBB   表示只要名称是BBB，就都能得到
>
> 3. /*   表示选择*之前路径的所有元素
>
> 4. /AAA/BBB[1]   表示AAA下的第一个BBB元素
>
>    /AAA/BBB[last()]  表示AAA下的最后一个BBB元素
>
> 5. //@[属性名]   表示选择含有属性名的所有标签
>
> 6. //@[属性名='值']  表示选择含有属性名且属性值为指定值
>
>    的所有标签

## 六、简单示例

学生管理系统 student，使用xml存储信息。

