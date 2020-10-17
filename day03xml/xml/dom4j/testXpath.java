package day03xml.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

/**
 * @author:Aurevoir
 * @date: 2020/2/18  14:48
 * 用dmo4j使用xpath查询
 */
public class testXpath {
    public static final String path = "src\\day03xml\\xml\\demo06.xml";
    public static void main(String[] args) {
        selectName();
        selectFirstName();
    }

    /**查询xml所有name元素的值
     * 1. 得到document
     * 2. 使用selectNodes("//name")
     */
    private static void selectName() {
        Document document = dom4jUtils.parse(path);
        String Xpath = "//name";
        List<Node> list = document.selectNodes(Xpath);
        for(Node node : list){
            System.out.println(node.getText());
        }
    }

    /**查询xml第一个name元素的值
     * 1. 得到document
     * 2. 使用selectNodes("//name")
     */
    private static void selectFirstName() {
        Document document = dom4jUtils.parse(path);
        String Xpath = "//p1[@id='oitnb']/name";
        Node name = document.selectSingleNode(Xpath);
        System.out.println(name.getText());
    }
    
}
