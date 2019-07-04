package picdegree;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;

public class PicDegree {

    private static  String getPicInfo(String imagePath) {
        File picFile= new File(imagePath);
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(picFile);

            for (Directory directory : metadata.getDirectories()){
                for (Tag tag : directory.getTags()){
                    System.out.print(tag.getTagName() + " --> ");
                    System.out.println(tag.getDescription());
                }

                if (directory.hasErrors()){
                    for (String error : directory.getErrors()){
                        System.err.println("ERROR: " + error);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String picpath = "E:\\projects\\back-end\\DAS\\JavaBase\\src\\main\\java\\picdegree\\IMG_20190704_150836.jpg";
        String picInfo = getPicInfo(picpath);
        System.out.println(picInfo);
    }

}
