package picdegree;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/**
 * 机型图片处理脚本
 */
public class MiPicFilter {

    /**
     * 获取图片设备信息
     * @param picFile
     */
    public static String getPicModle(File picFile) {
        if(picFile.isDirectory()){
            return null;
        }
        Metadata metadata = null;
        try {
            metadata = ImageMetadataReader.readMetadata(picFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Directory directory : metadata.getDirectories()){
            for (Tag tag : directory.getTags()){
                if(tag.getTagName().trim().equals("Model")){
                    return tag.getDescription().replaceAll(" ","");
                }
            }
            if (directory.hasErrors()){
                for (String error : directory.getErrors()){
                    System.err.println("ERROR: " + error);
                    System.out.println(picFile.getAbsoluteFile());
                    return null;
                }
            }
        }
        return "无设备信息";
    }

    /**
     * 判断图形像素信息是否大于 3000*4000
     * @param file
     * @return
     */
    public static boolean picPixels(File file){
        if(file.isDirectory()){
            return false;
        }
        Metadata metadata = null;
        try {
            metadata = ImageMetadataReader.readMetadata(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String,String> map = new HashMap<>();
        for (Directory directory : metadata.getDirectories()){
            for (Tag tag : directory.getTags()){
                if(tag.getTagName().trim().equals("Image Height")){
                    map.put("height",tag.getDescription());
                }
                if(tag.getTagName().trim().equals("Image Width")){
                    map.put("width",tag.getDescription());
                }
            }
        }
        // 像素信息判断
        Integer height = Integer.valueOf(map.get("height").split(" ")[0]);
        Integer width = Integer.valueOf(map.get("width").split(" ")[0]);

        if(height>=4000){
            if(width>=3000){
                return true;
            }else {
                return false;
            }
        }else if (width>=4000){
            if(height>=3000){
                return true;
            }else {
                return false;
            }
        }
        System.out.println(height+"*"+width);
        return false;
    }
    /**
     * 处理单个文件夹下的图片
     * @param path 图片的绝对路径
     */
    public static void solve(String path){
        //判断父路径是否是一个文件夹
        File parentDir = new File(path);
        if(!parentDir.isDirectory()){
            return;
        }

        //获取该目录下的所有文件列表
        Collection<File> files = FileUtils.listFiles(parentDir, new String[]{"jpg"}, true);
        for(File file:files){
            try{
                System.out.println(file.getAbsoluteFile());

                String picModle = getPicModle(file);
                if(picModle!=null){
                    String s = picModle.toUpperCase();
                }
                //建立设备文件夹
                if(picModle!=null && picModle.toUpperCase().indexOf("MI")>=0){
                    File dicPassDir = new File(path+"\\"+picModle+"\\");
                    if(!dicPassDir.exists()){
                        dicPassDir.mkdirs();
                    }
                    //文件移动
                    boolean pixPass = picPixels(file);
                    try {
                        if(pixPass){
                            FileUtils.moveFile(file,new File(dicPassDir.getAbsoluteFile()+"\\"+file.getName()));
                        }else{
                            System.out.println("像素不合格");
                            FileUtils.forceDelete(file);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{ //设备信息不对，直接删除
                    try {
                        FileUtils.forceDelete(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }

    }

    public static void main(String[] args) {
        String testpic = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree\\mi_pics";



        String [] picPath = new String[]{testpic};

        for(int j=0;j<picPath.length;j++){

            File file = new File(picPath[j]);
            String[] list = file.list();

            for(int i=0;i<list.length;i++){

                String curDir = list[i];
                if(curDir.indexOf("夕阳照片")>=0 || curDir.indexOf("含人像照片")>=0){
                    System.out.println(String.format("%s不做处理",list[i]));
                }else{
                    solve(file.getAbsolutePath()+"\\"+list[i]);
                }

            }
        }
    }

    @Test
    public void test(){
        String path = "E:\\BaiduNetdiskDownload\\0701小米采集---1887\\0626小米采集---1887\\小米场景-1196\\含人像照片-192";
        solve(path);
    }
}
