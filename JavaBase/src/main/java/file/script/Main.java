package file.script;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        String path = "E:\\docs\\找工作\\201907找工作\\coding-interviews\\src";

        File sumFile = new File(path+File.separator+"剑指offer（Java版）.md");
        Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"java"}, false);

        int count = 2;
        try {
            for(File f:files){
                if(count>=16){
                    String fileString = FileUtils.readFileToString(f, "gbk");
                    System.out.println(fileString);
                    FileUtils.write(sumFile,"### "+count+"、\n",true);
                    FileUtils.write(sumFile,"```java\n",true);
                    FileUtils.writeStringToFile(sumFile,fileString,true);
                    FileUtils.write(sumFile,"\n```\n",true);
                }

                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
