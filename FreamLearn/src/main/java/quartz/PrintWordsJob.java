package quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PrintWordsJob implements InterruptableJob {

    private boolean interrupted = false; //是否中断
    private JobKey jobKey = null; // job name
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobKey = jobExecutionContext.getJobDetail().getKey();
        if(!interrupted){
            String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
            System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("中断了："+jobKey);
        interrupted = true;
    }
}