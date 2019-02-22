package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class MyScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("PrintWordsJob", "group1")
                .build();

        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger for PrintWordsJob", "triggerGroup1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1s执行一次
                        .repeatForever())//一直执行
                .build();

        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");

        ///////////////////////////
        //使用Cron方式执行Job1
        ///////////////////////////
        JobDetail jobOne = JobBuilder.newJob(PrintJobOne.class)
                .withIdentity("job1","group1")
                .build();

        //每秒执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ?");
        Trigger triggerOne = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobOne,triggerOne);

        TimeUnit.SECONDS.sleep(10);

        //暂停任务（设置crontab为无限大，重新激活任务）

        System.out.println("停止jobOne:"+jobOne.getKey());
        //scheduler.pauseJob(jobOne.getKey()); //不能通过这种方式暂停，因为错过的执行会在resumeJob时重新执行

        CronScheduleBuilder reScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 1 1 * ? 2099");
        Trigger reTriggerOne = TriggerBuilder.newTrigger().withSchedule(reScheduleBuilder).build();
        scheduler.rescheduleJob(triggerOne.getKey(),reTriggerOne);



        //睡眠3秒
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println("重启jobOne:"+jobOne.getKey());
//        scheduler.resumeJob(jobOne.getKey());
        //scheduler.interrupt(jobDetail.getKey());
        //scheduler.shutdown();
        //System.out.println("--------scheduler shutdown ! ------------");
    }
}