package dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

/**
 * 参考文章：
 * https://www.cnblogs.com/sharpest/p/7877501.html
 */
public class Dom4jTest {

    /**
     * 读取，操作xml
     */
    @Test
    public void test00() throws  Exception{
        File f = new File("src/main/java/dom4j/data.xml");
        Document document = null;
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(f); // 读取XML文件,获得document对象

        //获取根节点
        Element rootElement = document.getRootElement();

        //xpath 获取某个结点
        Node node = document.selectSingleNode("/people/teachers/teacher[@name='tao']");
        System.out.println(node.getText());

        //建立某个结点
        Element student = rootElement.addElement("student");
        student.addAttribute("age","12");

        //重新写回到xml文件中
        XMLWriter writer = new XMLWriter(new FileWriter(f));
        writer.write(document);
        writer.flush();
        writer.close();

    }
}
