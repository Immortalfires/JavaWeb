# CSS

## 一、css与html的结合

1. 每个html标签上有属性style，用于结合。（demo1）

   ```html
   <div style="background-color: aqua;color: rebeccapurple"></div>
   ```

2. 用head里的标签实现style。（demo2）

   ```html
      <style type="text/css"><style/>
   ```

3. 在style标签内，@import url（css文件）（demo3）

   ```html
   <style type="text/css">
       @import "css/demo1.css";
   </style>
   ```

4. 使用头标签link，引入外部css文件 （demo4）

   ```html
   <link rel="stylesheet" type="text/css" href="css/demo1.css"/>
   ```

## 二、css的优先级

&emsp;后加载的优先级高

## 三、css的选择器

- 基本选择器

1. 标签选择器 标签名作为选择器名称

   ```html
   div{
       background-color: aquamarine;
       color: bisque;
   }
   ```

2. class选择器

   每个html标签都有个class属性 （demo5）

   ```html
    div.libai{
               background-color: darkcyan;
           }
   
   <div class="libai"></div>
   ```

3. id选择器

   每个html标签都有个id属性 （demo5）

   ```html
   div#no1{
               background-color: yellow;
           }
   
   <div id="no1"></div>
   ```

4. 优先级

   style > id选择器 > class选择器 > 标签选择器
   

- 扩展选择器

1. 关联选择器

   当标签嵌套时，设置嵌套内格式 （demo6）

   ```html
   <style type="text/css">
       div p{
       	background-color: crimson;
   	}
   </style>
   ```

2. 组合选择器

   当想设置不同标签内的内容相同格式（demo7）

   ```html
   <style type="text/css">
       div,p{
           background-color: coral;
       }
   </style>
   ```

3. 伪元素选择器

   css内提供的样式，可以直接使用

   例如对超链接的状态，可以进行不同的设置（demo8）

   ```html
   <style type="text/css">
       a:link{
           background-color: antiquewhite;
           /*原始状态*/
       }
       a:hover{
           background-color: yellow;
           /*悬停状态*/
       }
       a:active{
           background-color: coral;
           /*点击状态*/
       }
       a:visited{
           background-color: crimson;
           /*点击之后*/
       }
   </style>
   ```

## 四、css的盒子模型

在进行布局前需要把数据封装到一块一块的区域（div）

1. 边框

   border（demo9）

   border-top border-bottom border-left border-right

   属性有：width style color

2. 内边距

   padding（demo10）

   padding-top padding-bottom padding-left padding-right

   属性有：length

3. 外边距

   margin（demo11）

   margin-top margin-bottom margin-left margin-right

   属性有：length

## 五、css的布局的漂浮

float（demo12）

> left：文本流向对象的右边     right：文本流向对象的左边

## 六、 css的布局定位

​	postion（demo13）

> absolute ：将对象从文档流中拖出，使用 left ， right ， top ， bottom等属性相对于其最接近的一个最有定位设置的父对象进行绝对定位。
>
> relative： 对象不可层叠，但将依据 left ， right ， top ， bottom 等属性在正常文档流中偏移位置 

