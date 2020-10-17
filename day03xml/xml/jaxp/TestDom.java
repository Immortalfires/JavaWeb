package day03xml.xml.jaxp;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author:Aurevoir
 * @date: 2020/2/17  14:30
 */
public class TestDom {
    public static void main(String[] args) throws Exception {
//        //查询所有name元素的值
//        selectAll();
//        //查询第一个name元素的值
//        selectFirst();
//        //向第一个人物添加一个sex标签
//        addSex();
//        //修改第一个人物的年龄
//        modifyAge();
//        //删除第二个节点的sex标签
//        removeSex();
        //遍历xml，打印所有节点
        roundElement();
    }

    /*
    查询所有name元素的值:
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 解析xml返回document
    4. 得到所有name标签
    5. 返回集合，遍历该集合，得到name元素
     */
    private static void selectAll() throws Exception {
        System.out.println("查询所有name元素的值：");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        NodeList list = document.getElementsByTagName("name");
        for(int i=0;i<list.getLength();i++){
            Node name = list.item(i);
             String str = name.getTextContent();
             System.out.println(str);
        }
    }

    /*
    查询xml内第一个name元素的值
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 解析xml返回document
    4. 获得第一个name对象
        * NodeList list = document.getElementsByTagName("name");
          list[0]即可取到
    5. 取得具体的值
     */
    private static void selectFirst() throws Exception{
        System.out.println("取得第一个name元素的值：");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        NodeList list = document.getElementsByTagName("name");
        String str = list.item(0).getTextContent();
        System.out.println(str);
    }

    /*
    添加一个sex标签
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 解析xml返回document
    4. 得到第一个p1
    5. 创建新标签<sex>
    6. 创建新文本
    7. 将新文本添加至新标签下
    8. 将新标签添加至xml树形结构内
            *此时仅仅只是添加进内存，没有显示出来
    9. 写入xml
    */
    private static void addSex() throws Exception{
        System.out.println("向<p1>下添加sex标签：");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        NodeList list = document.getElementsByTagName("p1");
        Node p1 = list.item(0);
        Element sex = document.createElement("sex");
        Text text1 = document.createTextNode("female");
        sex.appendChild(text1);
        p1.appendChild(sex);
        // 写入xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/day03xml/xml/demo03.xml"));
    }

    /*
    修改第一个人物的年龄
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 解析xml返回document
    4. 得到age
    5. 修改age里的setTextContent方法
    6. 回写操作
     */
    private static void modifyAge() throws Exception{
        System.out.println("修改<p1>标签下的<age>标签文本：");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        NodeList list = document.getElementsByTagName("age");
        Node age = list.item(0);
        age.setTextContent("36");
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/day03xml/xml/demo03.xml"));
    }

    /*
   删除第二个节点的sex标签
   1. 创建解析器工厂
   2. 根据解析器工厂创建解析器
   3. 解析xml返回document
   4. 获取sex元素
   5. 获取sex的父节点
   6. 使用父节点删除
   7. 回写xml
    */
    private static void removeSex() throws Exception{
        System.out.println("删除第二个节点的sex标签");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        NodeList list = document.getElementsByTagName("sex");
        Node sex = list.item(1);
        Node parent = sex.getParentNode();
        parent.removeChild(sex);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/day03xml/xml/demo03.xml"));
    }

    /*
    遍历xml，打印所有节点
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 解析xml返回document
    4. 得到根节点
    5. 得到根节点的子节点
    ...
    采取递归
     */
    private static void roundElement() throws Exception{
        DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("src/day03xml/xml/demo03.xml");
        lists(document);
    }
    //Document 的 父接口是 Node
    private static void lists(Node node) {
        //判断解析内容为元素时打印
        if(node.getNodeType() == Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }
        /*
        因为jaxp解析会将换行空格一同解析，所以换种方式
        System.out.println(node.getNodeName());
        */

        //得到一层子节点
        NodeList list = node.getChildNodes();
        for(int i=0;i<list.getLength();i++){
            //得到每一个节点
            Node node1 = list.item(i);
            //继续得到node1的子节点
            lists(node1);
        }
    }
}
