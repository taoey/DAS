package comonio;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

public class CommonIoTest {

    /**
     * 一次性读取本地文件的全部内容并转化为String对象
     */
    @Test
    public void readLocalFile2StringByAll() throws Exception{
        File file =new File("src/main/java/comonio/TestData.txt");
        String s = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(s);
    }
}
