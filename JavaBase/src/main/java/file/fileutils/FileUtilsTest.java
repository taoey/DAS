package file.fileutils;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileUtilsTest {
    @Test
    public void test01(){
        String userDirectoryPath = FileUtils.getUserDirectoryPath();
        System.out.println(userDirectoryPath); //C:\Users\Administrator

    }

    @Test
    public void test02(){
        String tempDirectoryPath = FileUtils.getTempDirectoryPath();
        System.out.println(tempDirectoryPath);//  C:\Users\ADMINI~1\AppData\Local\Temp\
    }

    @Test
    public void test03(){
        File file = FileUtils.getFile("");
        System.out.println(file.getAbsolutePath()); //E:\projects\back-end\DAS\JavaBase
    }

    @Test
    public void test04() throws Exception{
        String path = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree\\myfile\\d1\\F1";
        String s = FileUtils.readFileToString(new File(path), "utf8");
        System.out.println(s);
    }

    /**
     * 创建文件夹
     */
    @Test
    public void test05(){
        String path = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree\\myfile\\d1\\d1_1";
        try {
            FileUtils.forceMkdir(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //文件列表
    @Test
    public void test06(){
        String path = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree\\pics";
        Collection<File> files = FileUtils.listFiles(new File(path), new MyFileFilter(), new MyFileFilter());
        System.out.println(files);
    }

    @Test
    public void test07(){
        String path = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree";
        Collection<File> files = FileUtils.listFilesAndDirs(new File(path), new MyFileFilter(), new MyFileFilter());
        System.out.println(files);
    }

    @Test
    public void test08(){
        String path = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree";
        Collection<File> files = FileUtils.listFiles(new File(path),null,true);
        System.out.println(files);
    }
}
