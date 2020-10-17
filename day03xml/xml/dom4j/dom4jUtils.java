package day03xml.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author:Aurevoir
 * @date: 2020/2/18  13:55
 */
public class dom4jUtils {
    //创建解析器，得到document
    public static Document parse(String path){
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    //回写xml操作
    public static void writeToXML(Document document,String path){
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
