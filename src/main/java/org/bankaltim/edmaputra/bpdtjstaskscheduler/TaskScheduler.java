package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class TaskScheduler {

	private Scheduler scheduler;
	private JobDetail job;
	private Trigger trigger;

	private String path;
	
	private String jobName;
	private String jobGroup;
	private String triggerName;
	private String triggerGroup;	

	public TaskScheduler() {
	}
	
	public TaskScheduler(String jobName, String jobGroup, String triggerName, String triggerGroup){
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.triggerName = triggerName;
		this.triggerGroup = triggerGroup;
//		try {
//			scheduler = new StdSchedulerFactory().getScheduler();
//			scheduler.start();
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void runScheduler(String hour, String minute, String jobName, String jobGroup, String triggerName, String triggerGroup) throws SchedulerException {

		job = newJob(TaskJob.class).withIdentity(jobName, jobGroup).build();	

		trigger = setTrigger(job, hour, minute, triggerName, triggerGroup);

//		scheduler = new StdSchedulerFactory().getScheduler();
//		startEachScheduler(scheduler, job, trigger, path);
		addScheduleJobToScheduler(scheduler, job, trigger, path);
	}

	public void stopScheduler() throws SchedulerException {
		scheduler.shutdown();
	}

	private Trigger setTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute))).forJob(job).build();
		return trigger;
	}

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
		// return "0 " + minute + " " + hour + " 1/1 * ? *";
	}
	
	private void addScheduleJobToScheduler(Scheduler scheduler, JobDetail job, Trigger trigger, String path){
		try {
//			System.out.println(path);
			scheduler.getContext().put("path", path);
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startEachScheduler(Scheduler scheduler, JobDetail job, Trigger trigger, String path) {
		try {
			scheduler.getContext().put("path", path);
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
			System.out.println(jobName+" Started");
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getJobName() {
		return jobName;
	}
	

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	

	public String getJobGroup() {
		return jobGroup;
	}
	

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	

	public String getTriggerName() {
		return triggerName;
	}
	

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	

	public String getTriggerGroup() {
		return triggerGroup;
	}
	

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	

}
