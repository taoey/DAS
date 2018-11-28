package fastjson;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

public class FastJsonDemos {


    /**
     * 操作list格式的Json对象
     */
    @Test
    public void operateJsonList() throws Exception{
        File file = new File("src/main/java/fastjson/JsonData.json");
        String data = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(data);
    }

    @Test
    public void test01(){

    }
}
