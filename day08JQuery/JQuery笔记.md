# JQuery学习

## (一)介绍

1. JQuery就是辅助JavaScript开发的js类库。（顾名思义为JavaScript以及Query）
2. 核心思想：Write Less，Do More。实现了很多浏览器的兼容问题。

## (二) 使用

1. 判断JQuery是否引入：alert($)

   > 引入有两种方式：引入CDN站点的js文件；引入本地JQuery js文件

2. 原生JS以及JQuery绑定按钮事件。（Demo1）

   1. 使用JQuery查询到按钮对象
   2. 通过click绑定事件

3. JQuery中的$其实是一个函数，也是JQuery这个函数的别称。

![image-20201015205348977](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201015205348977.png)

## (三) JQuery核心函数

1. ***$*** 就是JQuery的核心函数，$()即为调用这个函数。根据传入参数不同而执行不同的方法。

   不同的参数：

   1. 【函数】 表示页面加载完成后，相当于window.onload=function(){}

   2. 【HTML字符串】 创建HTML标签对象

   3. 【选择器字符串】 根据其中的查询标签对象

      ```js
      $("#id属性值"); //根据id查询
      $("标签名");     //标签选择器 根据指定标签名查询标签对象
      $(".class属性值")  //类型选择器 根据指定class属性查询标签对象
      ```

   4. 【DOM对象】会把DOM对象转化为JQuery对象

      ```html
      <button id='btn'>按钮1</button>
      ```

      ```js
      var btnobj = document.getElementById("btn");  //DOM对象
      $(btnobj) //则此时 btnobj为JQuery对象
      
      ```

2. JQuery对象的本质：DOM对象的数组+JQuery提供的一系列功能函数。

   ```html
   <button class="btn">btn1</button>
       <button class="btn">btn2</button>
       <button class="btn">btn3</button>
       <button class="btn">btn4</button>
   ```

   ```js
   var $btns = $(".btn");
   for (var i=0; i< $btns.length;i++){
   	alert($btns[i])
   }
   ```

   ![image-20201015212459260](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201015212459260.png)

3. JQuery对象与DOM对象使用的区别。

   > 两者无法互相使用对方的属性与方法。

4. JQuery对象与DOM对象互转
   1. DOM  ---->  JQuery
      1. 有DOM对象
      2. $(DOM对象)
   2. JQuery ---->  DOM
      1. 先有JQuery对象
      2. JQuery对象[下标]取出相应的DOM对象



## (四)选择器（Demo02）

### (1)基本选择器

1. id选择器    `$("#id")`
2. 元素选择器   `$("div")`
3. 类型选择器   `$(".class")`
4. 选择所有元素   `$("*")`
5. 多个选择器匹配元素合并   `$("div,span,p.myClass")`

### (2)层级选择器

1. 后代选择器  `$("ancestor descendant") `

   > 给定ancestor元素下匹配的所有descendant元素

2. 子元素选择器   `$("parent > child")`

   > 给定的parent元素下匹配所有的child元素

3. 相邻元素选择器 `$("prev + next")`

   > 匹配所有紧接在 prev 元素后的 next 元素

4. 之后的兄弟元素选择器  `$("prev ~ siblings")`

   >匹配 prev 元素之后的所有 siblings 元素

### (3)基本过滤选择器

1. 获取第一个元素   `$('para:first')`

2. 获取最后元素  `$('para:last')`

3. 去除与给定选择器匹配的元素 `$('para:not(selector)')`

   > 索引均从0开始

4. 匹配所有索引值为偶数的元素 `$('para:even')`

5. 匹配所有索引值为奇数的元素  `$('para:odd')`

6. 匹配一个给定索引值的元素  `$('para:eq(index)')`

7. 匹配所有大于给定索引值的元素   `$('para:gt(index)')`

8. 匹配所有小于给定索引值的元素   `$('para:lt(index)')`

9. 匹配所有标题元素   `$(':header')`

10. 匹配所有正在执行动画效果的元素    `$(:animated)`

### (4)内容过滤选择器

1. 匹配包含给定文本的元素  `$(:contains('text'))`
2. 匹配所有不包含子元素或者文本的空元素  `$(:empty)`
3. 匹配含有子元素或者文本的元素  `$(:parent)`
4. 匹配含有选择器所匹配的元素的元素  `$(:has(selector))`

### (5)可见性过滤器

1. 匹配所有不可见元素，或者type为hidden的元素 `$(:hidden)`
2. 匹配所有可见元素  `$(:visible)`

### (6)属性过滤器

1. 匹配包含给定属性的元素   `$("para[attr]")`
2. 匹配给定的属性是某个特定值的元素  `$("para[attr='value']")`
3. 匹配所有不含有指定的属性，或者属性不等于特定值的元素。`$("para[attr!='value']")`
4. 匹配给定的属性是以某些值开始的元素  `$("para[attr^='value']")`
5. 匹配给定的属性是以某些值结尾的元素  `$("para[attr$='value']")`
6. 匹配给定的属性是以包含某些值的元素  `$("para[attr*='value']")`
7. 复合属性选择器，需要同时满足多个条件时使用。  $("para\[selector1][selector2]")

### (7)表单对象、属性过滤选择器

1. 表单对象：
   1. 匹配所有 input, textarea, select 和 button 元素  `$(":input")`
   2. 匹配所有的单行文本框  `$(":text")`
   3. 匹配所有密码框  `$(":password")`
   4. 匹配所有单选按钮  `$(":radio")`
   5. 匹配所有复选框   `$(":checkbox")`
   6. 匹配所有提交按钮  `$(":submit")`
   7. 匹配所有图像域 `$(":image")`
   8. 匹配所有重置按钮  `$(":reset")`
   9. 匹配所有按钮  `$(":button")`
   10. 匹配所有文件域  `$(":file")`
   11. 匹配所有不可见元素，或者type为hidden的元素  ``$(":hidden")`
2. 表单属性：
   1. 匹配所有可用元素  `$("para:enabled")`
   2. 匹配所有不可用元素  `$("para:disabled")`
   3. 匹配所有选中的被选中元素(复选框、单选框等，不包括select中的option)  `$("para:checked")`
   4. 匹配所有选中的option元素  `$("para:selected")`

### (8)JQuery元素筛选

1. 获取第N个元素  `$("para").eq(index)`

2. 获取第一个元素   `$("para").first()`

3. 获取最后一个元素  `$("para").last()`

4. 检查当前的元素是否含有某个特定的类，如果有，则返回true `$("para").hasClass("class")`

5. 筛选出与指定表达式匹配的元素集合。  `$(para).filter("参数")`

   > 这个方法用于缩小匹配的范围。用逗号分隔多个表达式

   

   ![image-20201016223947012](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201016223947012.png)

6. 根据选择器、DOM元素或 jQuery 对象来检测匹配元素集合。

   `$("").is("参数")`

   > 如果其中至少有一个元素符合这个给定的表达式就返回true。如果没有元素符合，或者表达式无效，都返回'false'。

   ![image-20201017191026209](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191026209.png)

7. 将一组元素转换成其他数组（不论是否是元素数组）  `$("").map(callback)`

   > 你可以用这个函数来建立一个列表，不论是值、属性还是CSS样式，或者其他特别形式。

   ![image-20201017191245365](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191245365.png)

8. 保留包含特定后代的元素，去掉那些不含有指定后代的元素。`$("").has(expr|element)`

   ![image-20201017191356150](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191356150.png)

9. 删除与指定表达式匹配的元素  `$("").not(expr|ele|fn)`

   ![image-20201017191504880](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191504880.png)

10. 选取一个匹配的子集  `$("").slice(start,[end])`

    ![image-20201017191648118](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191648118.png)

11. 取得一个包含匹配的元素集合中每一个元素的所有子元素的元素集合`$("").children([expr])`

    ![image-20201017191746330](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191746330.png)

12. 从**元素本身**开始，逐级向上级元素匹配，并返回最先匹配的元素 `$("").cloest(expr,[con]|obj|ele)`

    ![image-20201017191930302](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017191930302.png)

13. 搜索所有与指定表达式匹配的元素  `$("").find(expr|obj|ele)`

    > 这个函数是找出正在处理的元素的后代元素的好方法。

    ![image-20201017192046047](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017192046047.png)

14. 查找一个指定元素后面紧邻的同辈元素的集合   `$("").next([expr])`

15. 查找当前元素之后所有的同辈元素    `$("").nextAll([expr])`

16. 查找当前元素之后的所有同辈元素，直至遇到匹配元素  `$("").nextUntil([exp|ele][,fil])`

    ![image-20201017193127571](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017193127571.png)

17. 查找一个包含所匹配元素的唯一父元素的元素集合  `$("").parent([expr])`

18. 取得一个包含着所有匹配元素的祖先元素的元素集合（不包含根元素） `$("").parents([expr])`

19. 查找当前元素的所有的父辈元素，直到遇到匹配的那个元素为止  `$("").parentsUntil([exp|ele],[,fil])`

    ![image-20201017193127571](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017193127571.png)

20. 找到指定元素紧邻的前一个同辈元素  `$("").prev([expr])`

21. 找到当前元素之前所有的同辈元素  `$("").prevAll([expr])`

22. 查找当前元素之前所有的同辈元素，直到遇到匹配的那个元素为止  `$("").prevUntil([exp|ele][,fil])`

23. 取得一个包含匹配的元素集合中每一个元素的所有唯一同辈元素的元素集合   `$("").sibings([expr])`

24. 把与表达式匹配的元素添加到jQuery对象中   `$("").add`

    > 这个函数可以用于连接分别与两个表达式匹配的元素结果集

    ![image-20201017194711279](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201017194711279.png)

25. 加入先前所选的加入当前元素中   `$("").andSelf()`
26. 查找匹配元素内部所有的子节点（包括文本节点）   `$("").contents()`
27. 将匹配的元素列表变为前一次的状态   `$("").end()`

## (五)JQuery属性操作(Demo03)

### (1)HTML代码/文本/值

1. `html()` 设置和获取起始标签和结束标签里的内容
2. `text() ` 设置和获取起始标签和结束标签里的文本
3. `val()`  设置和获取<font color=red>表单</font>项中的value属性值

### (2)属性

1. `attr()`  可以设置和获取属性的值，包括自定义属性。

   > 不推荐操作  checked、readOnly、selected、disabled

2. `prop()` 可以设置和获取属性的值。

   > 只推荐操作  checked、readOnly、selected、disabled

   ![image-20201019210017333](C:\Users\Au revoir\AppData\Roaming\Typora\typora-user-images\image-20201019210017333.png)

### (3)文档处理

1. `appendTo()`    a.appendTo(b)    把a插到b子元素末尾，成为最后一个子元素。
2. `prependTo()`  a.prependTo(b)    把a插到b所有子元素之前，成为第一个子元素。
3. `insertAfter()`   a.insertAfter(b)    得到ba
4. `insertBefore()`   a.insertBefore(b)   得到ab
5. `replaceWith()`   a.replaceWith(b)   用b替换掉a
6. `replaceAll()`   a.replaceAll(b)   用a替换掉所有b
7. `remove()`   a.remove()    删除a标签
8. `empty()`     a.empty()    清空a标签里的内容

## (六)css样式操作(Demo04)

1. `addClass()`    添加样式
2. `removeClass()`    删除样式
3. `toggleClass()`    有就删除、没有就添加
4. `offset()`   获取和设置元素坐标

## (七)JQuery动画(Demo05)

1. `show()`    将隐藏的元素显示

2. `hide()`   将可见的元素隐藏

3. `toggle()`   可见就隐藏，隐藏就显示

   > 都可以添加参数
   >
   > 1. 动画执行时长   ms为单位
   > 2. 动画的回调参数

4. `fadeIn()`   淡入

5. `fadeOut()`    淡出

6. `fadeTo()`    在指定时长内慢慢将透明度修改到指定值，0透明，1完成可见，0.5半透明

7. `fadeToggle()`   淡入淡出切换

## (八)JQuery事件操作

1. `$(function{})`与`window.onload=function(){}`
   1. JQuery在页面加载完成前执行，原生js在页面加载完成后执行
   2. JQuery的页面加载完成之后是浏览器的内核解析完页面的标签创建好DOM对象之后就会马上执行。原生js的页面加载完后曾之后，除了要等浏览器内核解析完标签创建好DOM对象，还要等标签显示是需要的内容加载完成。
   3. JQuery会把注册的function函数，按顺序依次执行。原生js的页面加载完成后，只会执行最后一次赋值行为。

2. 其他事件的处理方法

   1. `click()`    可以绑定单击事件，以及触发单击事件
   2. `mouseover()`    鼠标移入事件
   3. `mouseout()`   鼠标移出事件
   4. `bind()`    给元素一次性绑定一个或多个事件
   5. `one()`    与bind一样，但只会响应一次
   6. `unbind()`    与bind方法相反的操作，解除事件的绑定
   7. `live()`    也是用来绑定事件。用来绑定选择器匹配的所有元素的事件

3. 事件的冒泡

   - 什么是事件的冒泡？

     > 它指父子元素同时监听同一个事件。当触发子元素的事件时，同一事件也被传递到父元素的事件里去响应。

   - 如何阻止？

     > 在子函数事件函数体内，return false；

4. 事件对象(Demo06)

   > 封装有触发的事件信息的一个js对象

   1. 如何获取：

      在给元素绑定事件时，在事件的function(event)参数列表中添加一个参数，习惯取名为event。即为事件对象

      1. 原生js获取
   
         ```js
         window.onload = function(){
             document.getElementById("areaDiv").onclick = function (event) {
                 console.log(event);
             }
         };
         ```
   
      2. JQuery获取
   
         ```js
         $(function(){
         		$("#areaDiv").click(function (event) {
         			console.log(event);
         		})
         	});
         ```
   
         