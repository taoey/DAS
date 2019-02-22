package process;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     *使用 Process执行python脚本，并在控制台输出
     */
    @Test
    public void executePython() {
        try {
            String[] args=new String[]{"python","C:\\Users\\Administrator\\Desktop\\test.py"};
            Process pr=Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
