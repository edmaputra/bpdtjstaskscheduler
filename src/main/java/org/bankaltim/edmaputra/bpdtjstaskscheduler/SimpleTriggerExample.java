package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerExample {
	
	public SimpleTriggerExample(){
		
		JobDetail job = newJob(DoaJob.class)
				.withIdentity("job1", "group1")
				.build();
		
		Trigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(6).repeatForever())
				.build();		
	
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public SimpleTriggerExample(){
//		JobDetail job = new JobDetail();
//		job.setName("dummyJobName");
//		job.setJobClass(CorporateSongJob.class);
//		
//		JobDetail doaJob = new JobDetail();
//		doaJob.setName("doaJob");
//		doaJob.setJobClass(DoaJob.class);
//		
//		//configure the scheduler time
//    	SimpleTrigger trigger = new SimpleTrigger();
//    	trigger.setName("triggerOne");
//    	trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
//    	trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//    	trigger.setRepeatInterval(5 * 1000);
//    	
//    	//schedule it
//    	Scheduler scheduler;
//		try {
//			scheduler = new StdSchedulerFactory().getScheduler();
//	    	scheduler.start();
//	    	scheduler.scheduleJob(job, trigger);
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		SimpleTrigger triggerTwo = new SimpleTrigger();
//    	triggerTwo.setName("triggerTwo");
//    	triggerTwo.setStartTime(new Date(System.currentTimeMillis() + 3000));
//    	triggerTwo.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//    	triggerTwo.setRepeatInterval(10 * 1000);
//    	
//    	//schedule it
//    	Scheduler schedulerTwo;
//		try {
//			schedulerTwo = new StdSchedulerFactory().getScheduler();
//	    	schedulerTwo.start();
//	    	schedulerTwo.scheduleJob(doaJob, triggerTwo);
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
// 	0 45 7 ? * MON-FRI *

}
