package file;


import java.io.*;


public class MergeFiles {
    public static void main(String[] args) throws Exception {
        String targetName = "result.md";
        File file = new File("");
        String absolutePath = file.getAbsolutePath();

        File dic = new File(absolutePath);
        File[] files = dic.listFiles();
        String targetFilePath = dic.getAbsolutePath()+File.separator+targetName;
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath));
        OutputStreamWriter outw = new OutputStreamWriter(new FileOutputStream(targetFilePath),"UTF-8");
        for(File f : files){
            if(f.getName().indexOf(".md")!=-1  && f.getName().indexOf(targetName)==-1){
                //FileReader reader = new FileReader(f.getAbsolutePath());
                InputStreamReader in = new InputStreamReader(new FileInputStream(f),"UTF-8");
                BufferedReader br = new BufferedReader(in);
                String str = null;
                while((str=br.readLine())!=null){
                    //bw.write(str);
                    //bw.newLine();
                    System.out.println(str);
                    outw.write(str);
                    outw.write("\n");
                }

                outw.flush(); // Just like  `commit` in Mysql
                br.close();
                in.close();

            }
        }
        bw.close();
        outw.close();
        System.out.println("Done!!!");
    }
}
