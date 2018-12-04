package YoutubeDownloader;

import java.io.File;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        File file = new File("src/main/java/YoutubeDownloader/execute.bat");
        String path = file.getAbsoluteFile().toString();
        Runtime run = Runtime.getRuntime();
        Process exec = run.exec("cmd.exe /k start dir");
        Process exec1 = run.exec("cmd.exe /k c");
    }
}
