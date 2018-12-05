package dom4j;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

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
        File f = new File("");
        Document document = null;
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(f); // 读取XML文件,获得document对象
    }
}
