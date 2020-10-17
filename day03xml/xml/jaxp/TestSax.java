package day03xml.xml.jaxp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author:Aurevoir
 * @date: 2020/2/17  18:59
 */

//将xml文档整个打印
class MyHandler extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch,start,length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</" + qName + ">");
    }
}

//获取所有name元素的值
class MyHandler2 extends DefaultHandler{
    private boolean flag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("name".equals(qName)){
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(flag){
            System.out.println(new String(ch,start,length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("name".equals(qName)){
            flag = false;
        }
    }
}

public class TestSax {
    public static void main(String[] args) throws Exception{
    /*
    1. 创建解析器工厂
    2. 根据解析器工厂创建解析器
    3. 执行parse方法
    4. 自己创建一个类，继承DefaultHandler
    5. 重写类里的三个方法 startElement、endElement、characters
    */
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    System.out.println("打印出整个文档：");
    saxParser.parse("src/day03xml/xml/demo05.xml",new MyHandler());
    System.out.println("\n"+"打印出所有name元素的值：");
    saxParser.parse("src/day03xml/xml/demo05.xml",new MyHandler2());
    //获取选定的name，可以设置index值表示第几个name
    }
}
