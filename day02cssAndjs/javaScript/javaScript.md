# JavaScript

所有实例均在内

## 一、简介

1. 基于对象和事件驱动的语言，应用于客户端。
2. 特点：
   1. 交互性（信息动态交互）
   2. 安全性（不能访问本地磁盘）
   3. 跨平台性（无关平台，只要有支持js的浏览器）
3. 三部分组成
   1. ECMAScript     js的基本语句语法由ECMA制定
   2. BOM    browser object model 浏览器对象模型 
   3. DOM    document object model  文档对象模型

## 二、js与html的结合方式

1. 使用标签 （demo 1）

   <script type="text/javascript"> 
       js 代码
   </script>

2. 使用标签，引入外部js文件（demo 2）

## 三、js的基本语法

### （一）输出显示

- `window.alert()`  写入警告框
- `document.write()`  写入html输出

> 在html文件完全加载后，使用`document.write()`将删除所有已有的html元素。

- `innerHTML`写入html元素

> 如需访问 HTML 元素，
>
> JavaScript 可使用 document.getElementById(id) 方法。
>
> id 属性定义 HTML 元素。
>
> innerHTML 属性定义 HTML 内容：

- `console.log()` 写入浏览器控制台

### （二）原始类型和声明变量

​			定义变量 使用关键字var（demo 3）

1. 原始类型：string、number、boolean、null、undefined

   > string： 字符串类型
   >
   > number： 数字类型
   >
   > boolean： true false
   >
   > null：获取对象的引用，null表示对象引用为空，所有对象的引用都为object。
   >
   > undefined：定义一个未赋值的变量

2. typeof() 查看所有变量的类型

### （三）语句

​			见demo 4

1. if判断语句

```javascript
var a = 7;
if(a == 5){
    alert("a = 5");
}else{
    alert("a != 5");
}
```

2. switch语句

```javascript
var b = 26;
switch (b) {
    case 1:
        alert("1");
        break;
    case 6:
        alert("6");
        break;
    default:
        alert("other");
}
```

3. 循环语句 while for do-while

```javascript
// while循环
var c = 2;
while(c > 0){
    alert(c);
    c--;
}
```

```javascript
// for循环
for(var i = 1;i < 3;i++){
    alert(i);
}
```

```javascript
// do-while循环
var d = 4;
do{
    alert(d);
    d--;
}while(d > 0);
```

### （四）运算符

大致与java内的运算符类似，下面是不同之处。

1. js内不区分小数与整数

```javascript
var e = 123;
alert(e/1000*1000);
// e = 123
```

2. 对于字符串的操作

```javascript
var str = "1223";
alert(str+1);  // 12231
alert(str-1);  // 1222

var str1 = "adf";
alert(str1+1);  // adf1
alert(str1-1);   // NaN
```

3. boolean也可以进行操作

```javascript
var flag1 = true;
alert(flag1+1);   // 2
var flag1 = false;
alert(flag1+1);   // 1

//true相当于1  flase相当于0
```

4. == 和 ===，!= 和  ! ==

   | ==   | 等于           |
   | ---- | -------------- |
   | ===  | 等值等型       |
   | !=   | 不相等         |
   | !==  | 不等值或不等型 |

### （五）数组

1. js数组内可以存放不同数据类型的数组

2. 定义方式：（demo 5）

   1. ```javascript
      var arr[1,"3",true];
      ```

   2. 使用内置对象Array

      ```javascript
      var arr = new Array(5);   //数组长度
      arr[0] = 1;
      ```

   3. 使用内置对象Array

      ```javascript
      var arr = new Array(1,"3",true);
      ```

3. 属性：length 获取到的数组长度

### （六）函数

定义方式（demo 6）

1. 函数

   ```javascript
   // 参数列表内 直接写参数名
   function 方法名 (参数列表){
       方法体
       返回值(可有可无)
   }
   
   e.g:
   function test() {
   	alert("hahaha");
   }
   test();   //函数调用
   
   function add1(a,b){
       var num = a+b;
       document.write(num);
   }
   add1(4,5);   //函数调用
   
   function add2(a,b,c) {
       var num = a + b + c;
       return num;
   }
   document.write(add2(32,4,3));
   //函数调用
   ```

2. 匿名函数

   ```javascript
   var name = function(参数列表){
       方法体和返回值;
   }
   
   e.g:
   var func = function (a,b) {
       document.write(a + b );
   };
   func(5,2);
   ```

3. 动态函数，使用内置对象Function（只要了解就可以）

   ```javascript
   var name = new Function("参数列表","方法体和返回值");
   
   e.g:
   var add3 = new Function("a,b","document.write(a + b;")
   add3(2,3);   //函数调用
   
   
    var canshu = "a,b";
           var bodyFunc= "document.write(a + b + '<br/>');";
           var add3 = new Function(canshu,bodyFunc);
   add3(2,3);   //函数调用
   ```

### （七）全局变量、局部变量

> 全局变量：在script标签内定义一个变量，在页面js部分均可使用。
>
> 局部变量：在方法内部定义一个变量，只能在方法内部使用。

##  四、js的对象

### （一）String对象

1. 创建String对象 `var str = "dhfjkahf"`（demo 7）

2. 方法和属性

   1. 属性：length，字符串的长度

   2. 方法：[js的String对象的方法](https://www.w3school.com.cn/jsref/jsref_obj_string.asp)

      

### （二）Array对象

1. 创建Array对象(demo 8)

   1. ```javascript
      var arr[1,"3",true];
      ```

   2. 使用内置对象Array

      ```javascript
      var arr = new Array(5);   //数组长度
      arr[0] = 1;
      ```

   3. 使用内置对象Array

      ```javascript
      var arr = new Array(1,"3",true);
      ```

2. 属性：length 获取到的数组长度
3. 方法：[js的Array对象的方法](https://www.w3school.com.cn/jsref/jsref_obj_array.asp)

### （三）Date对象

1. 创建Date对象 (demo 9)

   ```javascript
   var date = new Date();
   ```

2. [js的Date对象的方法](https://www.w3school.com.cn/jsref/jsref_obj_date.asp)

### （四）Math对象

1. 无需创建，把Math作为对象使用调用其属性和方法。

   (demo 10)

2. [js的Math对象的方法和属性](https://www.w3school.com.cn/jsref/jsref_obj_math.asp)

## 五、全局函数

不属于任何一个对象，可以直接写名称使用(demo 11)

## 六、函数的重载

方法名相同，参数不同(demo 12)

js内不存在函数重载，但可以通过其他方式模拟重载。

它会调用最后一个方法，并把传递的参数保存在arguments数组内。

## 七、BOM对象

browser object model：浏览器对象模型(demo 13)

1. Navigator：包含有关浏览器的信息。

   ​					 [Navigator对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_navigator.asp)

2. Screen：包含有关客户端显示屏幕的信息。

    					[Screen对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_screen.asp)

3. Location：包含有关当前 URL 的信息，是 Window 对象的一个部分，可通过 window.location 属性来访问。

   ​					 [Location对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_location.asp)

4. History：包含用户访问过的 URL，是 window 对象的一部分，可通过 window.history 属性对其进行访问。

   ​					 [History对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_history.asp)

5. Window：表示浏览器中打开的窗口。

   ​					[Window对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_window.asp)

## 八、DOM对象

document object model：文档对象模型(demo 14)

1. DHTML是很多技术的简称：

   1. html
   2. css
   3. dom
   4. javascript

2. Document对象：(demo 14)

   > 每个载入浏览器的html文档都可以视为document对象

   ​		示范案例(example 2 ,example 3)

   ​		[Document对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_all.asp)

3. Element对象：(demo 15)

   > Element 对象表示 HTML 元素。可以拥有类型为元素节点、文本节点、注释节点的子节点。NodeList 对象表示节点列表，比如 HTML 元素的子节点集合。

   ​		示范案例(example 4)

   ​		[Element对象属性及方法](https://www.w3school.com.cn/jsref/dom_obj_all.asp)

4. Node对象：(demo 16)

   属性有：
   
   -  nodeName
   
   > 如果节点是元素节点，nodeName返回这个元素的名称
   >
   > （使用**getElementById**方法获取元素节点）
   >
   > 如果是属性节点，nodeName返回这个属性的名称
   >
   > （使用**getAttributeNode**方法获取属性节点）
   >
   > 如果是文本节点，nodeName返回一个内容为#text的字符串 
   >
   > （使用firstChild或者lastChild属性获得）
   
   - nodeType
   
   > Node.ELEMENT_NODE  ---1  -- 元素节点Node.ATTRIBUTE_NODE ---2  -- 属性节点Node.TEXT_NODE    ---3  -- 文本节点
   
   - nodeValue
   
   > 如果给定节点是一个属性节点，返回值是这个属性的值
   >
   > 
   >
   > 如果给定节点是一个文本节点，返回值是这个文本节点内容
   >
   > 
   >
   > 如果给定节点是一个元素节点，返回值是 null

![image-20200212161603278](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20200212161603278.png)

- 父节点

  ul是li的父节点

  - parent Node

- 子节点

  li是ul的子节点

  - child Nodes(所有子节点，兼容性很差)
  - first Child(获得第一个子节点)
  - last Child(获得最后一个子节点)

- 同辈节点

  几个li互为同辈节点

  - nextSibing (返回给定节点的下一个兄弟节点)
  - previousSibing(返回给定节点的上一个兄弟节点)

```javascript
<ul>
    <li>hahaha</li>
    <li>lilili</li>
    <li>hehehe</li>
</ul>
```

- 操作dom树( demo 17)
  - appendChild() 添加子节点到末尾，类似剪切黏贴
  - insertBefore(newNode,oldNode) 插入节点
  - removeChild() 删除节点，通过父节点
  - replaceChild(newNode,oldNode) 替换节点，通过父节点
  - cloneNode(boolean) 复制节点，参数：是否复制子节点

## 九、innerHTML属性

1. 不是dom组成部分，但大部分浏览器都支持。
2. 作用：(demo 18)
   - 可以获取文本内容
   - 向标签内设置内容

## 十、案例

1. 九九乘法表（example 1）
2. Window弹窗实例（example 2、3）
3. 末尾添加节点（example 4）
4. 动态显示时间（example 5）
5. 全选 全不选 多项选择框练习（example 6）
6. 下拉列表左右选择（example 7）
7. 选项联动（example 8）
8. 动态生成表格（example 9）