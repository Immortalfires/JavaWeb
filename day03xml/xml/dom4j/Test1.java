package day03xml.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

/**
 * @author:Aurevoir
 * @date: 2020/2/17  19:35
 */
public class Test1 {
    private static final String path = "src\\day03xml\\xml\\demo06.xml";
    public static void main(String[] args) throws Exception {
         //查询xml内所有name元素的值
        selectName();
        //查询第一个name元素的值
        selectFirstName();
        //查询第二个name元素的值
        selectSecondName();
        System.out.println("--------------------------");
        /*添加操作
        向第一个p1标签末尾添加一个<sex>标签
         */
        addSex();
        //特定位置添加元素。在第一个p1的age之前添加<school></school>
        addSchool();
        System.out.println("--------------------------");
        /*修改操作
         修改第二个p1下的age
        */
        modifyAge();
        System.out.println("--------------------------");
        /*删除操作
          删除第一个标签下的age标签
         */
        removeAge();
        System.out.println("--------------------------");
        /*获取属性值
        获取第一个p1内的id
         */
        getAttriId();
    }

    /**查询xml内所有name元素的值
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     *
     * 4. 得到p1
     * 5. 得到p1下的name
     * 6. 得到name的值
     */
    private static void selectName() throws Exception {
        System.out.println("查询xml内所有name元素的值：");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        List<Element> list = root.elements("p1");
        for(Element element:list){
            Element name = element.element("name");
            String str = name.getText();
            System.out.println(str);
        }
    }

    /**查询第一个name元素的值
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 得到第一个p1
     * 5. 得到p1下的name
     * 6. 获得name的值
     */
    private static void selectFirstName() throws Exception {
        System.out.println("查询第一个name元素的值： ");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        Element name = p1.element("name");
        String str = name.getText();
        System.out.println(str);
    }

    /**查询第二个name元素的值
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 得到所有p1
     * 5. 遍历得到第二个p1
     * 5. 得到p1下的name
     * 6. 获得name的值
     */
    private static void selectSecondName() throws Exception {
        System.out.println("查询第二个name元素的值：");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        List<Element> list = root.elements("p1");
        Element p1 = list.get(1);
        Element name = p1.element("name");
        System.out.println(name.getText());
    }


    /**向第一个p1标签末尾添加一个<sex>标签
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 获取第一个p1
     * 5. p1添加元素
     * 6. 添加文本
     * 7. 回写xml
     */
    private static void addSex() throws Exception {
        System.out.println("向第一个p1标签末尾添加一个<sex>标签：");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        Element sex = p1.addElement("sex");
        sex.addText("female");
        //回写xml
        dom4jUtils.writeToXML(document,path);
        System.out.println("添加完成~");
    }

    /**在第一个p1的age之前添加<school></school>
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 得到第一个p1
     * 5. 获取p1下的所有元素，返回list
     * 6. 创建元素
     * 7. list.add(int index,Element e)添加元素
     * 8. 回写xml
     */
    private static void addSchool() throws Exception{
        System.out.println("在第一个p1的age之前添加<school></school>：");
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        List<Element> list = p1.elements();
        Element school = DocumentHelper.createElement("school");
        school.addText("Senior");
        list.add(1,school);
        XMLWriter writer = new XMLWriter(new FileOutputStream(path),OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
        System.out.println("添加完成~");
    }

    /**修改第二个p1下的age
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 获取到第二个p1
     * 5. 获取age
     * 6. 修改age
     * 7. 回写xml
     */
    private static void modifyAge() throws Exception{
        System.out.println("修改第二个p1下的age：");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        List<Element> list = root.elements("p1");
        Element p1 = list.get(1);
        Element age = p1.element("age");
        age.setText("45");
        dom4jUtils.writeToXML(document,path);
        System.out.println("修改成功~");
    }

    /**删除第一个标签下的age标签
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 得到第一个p1标签
     * 5. 获得p1下的age元素
     * 6. 使用p1删除age
     */
    private static void removeAge() {
        System.out.println("删除第一个标签下的age标签");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        Element age = p1.element("age");
        p1.remove(age);
        dom4jUtils.writeToXML(document,path);
        System.out.println("删除成功~");
    }

    /**获取第一个p1内的id
     * 1. 创建解析器
     * 2. 得到document
     * 3. 得到根节点
     * 4. 得到p1及属性值
     */
    private static void getAttriId() {
        System.out.println("获取第一个p1内的id");
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        System.out.println(p1.attributeValue("id"));
    }
}