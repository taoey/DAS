package file;

import org.junit.Test;

import java.io.File;

/**
 * Created by tao on 2018/9/29.
 */
public class UpdateFilesName {

    @Test
    public void test00(){
        File path = new File("D:\\视频\\学习视频\\Java相关\\深入理解Java虚拟机（jvm性能调优+内存模型+虚拟机原理\\");
        File[] files = path.listFiles();
        for(File f:files){
            String fileName = f.getName();
            if(fileName.indexOf("更多视频关注微信公众号【八戒程序猿】")!=-1){
                String newFileName = fileName.substring(18);
                f.renameTo(new File(path+newFileName));
//                System.out.println(fileName);
//                System.out.println(newFileName);
            }
        }


    }
    @Test
    public void test01(){
        System.out.println("更多视频关注微信公众号【八戒程序猿】".length());
    }


}
