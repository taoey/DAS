package daily;

import org.junit.Test;

public class StringTest {

    /**
     * 解析特定文件名
     */
    @Test
    public void solveFileName(){
        // 句集名称-句子作者-上传人
        String fileName = "红楼梦-曹雪芹-tao.csv";

        int dotIndex = fileName.lastIndexOf(".");
        String fileSuffix = fileName.substring(dotIndex+1);
        if(fileSuffix !="csv"){
            System.out.println("文件名错误");
        }
        String[] datas = fileName.substring(0, dotIndex).split("-");
        if(datas.length != 3){
            System.out.println("file name error , please fix and try again ");
        }
        System.out.println();
    }
}
