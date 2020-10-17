package day03xml.xml.student;

import day03xml.xml.dom4j.dom4jUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

/**
 * @author:Aurevoir
 * @date: 2020/2/18  15:07
 */
public class StudentService {
    public static final String path = "src/day03xml/xml/student/student.xml";
    /**增加
     * @param student 增加对象
     * 1. 创建解析器
     * 2. 得到document
     * 3. 获得根节点
     * 4. 创建stu
     * 5. 在stu上依次添加 id name age
     * 6. 添加值
     * 7. 回写
     */
    public static void addStudent(Student student){
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        Element stu = root.addElement("stu");
        Element id = stu.addElement("id");
        id.setText(student.getId());
        Element name = stu.addElement("name");
        name.setText(student.getName());
        Element age = stu.addElement("age");
        age.setText(student.getAge());
        dom4jUtils.writeToXML(document,path);
    }

    /**删除
     * @param id 判断删除对象
     * 1. 创建解析器
     * 2. 得到document
     * 3. 获得根节点
     * 4. 找到所有id标签
     * 5. 找到符合id的stu，并删除
     * 6. 回写xml
     */
    public static void removeStu(String id){
        Document document = dom4jUtils.parse(path);
        Element root = document.getRootElement();
        List<Node> nodeList = document.selectNodes("//id");
        for(Node node:nodeList){
            if(id.equals(node.getText())){
                Element stu = node.getParent();
                root.remove(stu);
                break;
            }
        }
        dom4jUtils.writeToXML(document,path);
    }

    /**查询
     * @param id
     * 1. 创建解析器
     * 2. 得到document
     * 3. 找到所有id标签
     * 4. 找到符合id的stu，并返回出相关信息
     */
    public static Student searchStu(String id){
        Student student = new Student();
        Document document = dom4jUtils.parse(path);
        List<Node> nodeList = document.selectNodes("//id");
        for(Node node:nodeList){
            if(id.equals(node.getText())){
                Element stu = node.getParent();
                student.setId(id);
                student.setName(stu.element("name").getText());
                student.setAge(stu.element("age").getText());
            }
        }
        return student;
    }
}
