package yaml;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class YamlTest {
    @Test
    public void test01() throws FileNotFoundException {

        // 获取 resource 文件夹下的文件地址
        String path =this.getClass().getClassLoader().getResource("yamltest.yaml").getPath();
        InputStream in = new FileInputStream(new File(path));

        // 加载配置文件
        Yaml yaml = new Yaml();
        HashMap hashMap = yaml.loadAs(in, HashMap.class);
        System.out.println(hashMap);

        // 获取配置信息
        Object father = hashMap.get("father");
        System.out.println(father);
    }
}
