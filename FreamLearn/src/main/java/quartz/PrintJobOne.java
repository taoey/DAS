package quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

public class PrintJobOne implements InterruptableJob {

    private boolean pause = false;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(!pause){
            System.out.println("正在执行：PrintJobOne");
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        pause = true;
    }
}
