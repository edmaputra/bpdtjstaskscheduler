package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerExample {
	
	private final String JOB_NAME_DOA_PAGI = "doaPagiJob";
	private final String JOB_NAME_CORPORATE_SONG = "corporateSongJob";
	private final String JOB_NAME_MARS_BANKALTIM = "marsBankaltimJob";
	private final String JOB_NAME_DZUHUR = "dzuhurJob";
	private final String JOB_NAME_ASAR = "asarJob";
	private final String JOB_NAME_CUSTOM = "customJob";

	private JobDetail jobDoaPagi;
	private JobDetail jobCorporateSong;
	private JobDetail jobMarsBankaltim;
	private JobDetail jobDzuhur;
	private JobDetail jobAsar;
	private JobDetail jobCustom;
	
	private InterruptableJob intJobDoaPagi;

	private Scheduler schedulerDoaPagi;
	private Scheduler schedulerCorporateSong;
	private Scheduler schedulerMarsBankaltim;
	private Scheduler schedulerDzuhur;
	private Scheduler schedulerAsar;
	private Scheduler schedulerCustom;

	public SimpleTriggerExample() {
		
		try {
			schedulerDoaPagi = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void triggerDoaPagiInterruptable(){
//		intJobDoaPagi = newJob(DoaJob.class).wi
	}
	
	public void cobaTriggerDoaPagi(String hour, String minute){
		jobDoaPagi = newJob(DoaJob.class).withIdentity(JOB_NAME_DOA_PAGI, "group1").build();
		
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.withSchedule(cronSchedule(setCronExpression(hour, minute))).forJob(jobDoaPagi).build();

		try {
			schedulerDoaPagi = new StdSchedulerFactory().getScheduler();
			schedulerDoaPagi.start();
			schedulerDoaPagi.scheduleJob(jobDoaPagi, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void triggerDoaPagi(String hour, String minute) {
		jobDoaPagi = newJob(DoaJob.class).withIdentity(JOB_NAME_DOA_PAGI, "group1").build();
		Trigger trigger = setTrigger(jobDoaPagi, hour, minute, "doaPagiTrigger", "group1");
		startEachScheduler(jobDoaPagi, trigger);
	}

	public void triggerCorporateSong(String hour, String minute) {
		jobCorporateSong = newJob(CorporateSongJob.class).withIdentity(JOB_NAME_CORPORATE_SONG, "group1").build();
		
		startScheduler(jobCorporateSong, hour, minute, "corporateSongTrigger", "group1");
	}

	public void triggerMarsBankaltim(String hour, String minute) {
		jobMarsBankaltim = newJob(MarsBankaltimJob.class).withIdentity(JOB_NAME_MARS_BANKALTIM, "group1").build();
		startScheduler(jobMarsBankaltim, hour, minute, "marsBankaltimTrigger", "group1");
	}

	public void triggerCustom(String hour, String minute) {
		jobCustom = newJob(CustomJob.class).withIdentity("job1", "group1").build();
		startScheduler(jobCustom, hour, minute, "customTrigger", "group1");
	}

	public void triggerCobaCustom(String hour, String minute) {
		JobDetail jobDetail = newJob(CustomJob.class).withIdentity(JOB_NAME_CUSTOM, "group1").build();
		startCobaScheduler(jobDetail, hour, minute, "customTrigger", "group1");
	}
	
	public void stopDoaPagi(){
			try {
				stopScheduler(schedulerDoaPagi, jobDoaPagi);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
//	public void stopCorporateSong(){
//		stopSche
//	}

	private void startScheduler(JobDetail jobDetail, String hour, String minute, String triggerName, String group) {
		Trigger trigger = setTrigger(jobDetail, hour, minute, triggerName, group);
		try {
//			setScheduler(jobDetail, trigger);
			setSchedulerEach(schedulerDoaPagi, jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	private void startEachScheduler(JobDetail job, Trigger trigger){
		try {			
			setSchedulerEach(schedulerDoaPagi, job, trigger);
			System.out.println("Start Scheduler Doa Pagi");
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopScheduler(Scheduler scheduler, JobDetail job) throws SchedulerException {
//		scheduler.interrupt(JobKey.jobKey(JOB_NAME_DOA_PAGI, "group1"));
		scheduler.shutdown(true);
	}

	private void startCobaScheduler(JobDetail jobDetail, String hour, String minute, String triggerName, String group) {
		Trigger trigger = cobaTrigger(jobDetail, hour, minute, triggerName, group);
		try {
			setScheduler(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	private Trigger setTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute))).forJob(job).build();
		return trigger;
	}

	private void setScheduler(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
		// scheduler.in
	}

	private void setSchedulerEach(Scheduler scheduler, JobDetail jobDetail, Trigger trigger) throws SchedulerException {		
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		System.out.println("scheduler start");
	}

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
	}

	private Trigger cobaTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName).startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).forJob(job).build();

		return trigger;
	}

	// private void startSchedulerWithInterruptable(InterruptableJob jobDetail,
	// String hour, String minute, String triggerName, String group) {
	// Trigger trigger = setTrigger(jobDetail, hour, minute, triggerName,
	// group);
	// try {
	// setScheduler(jobDetail, trigger);
	// } catch (SchedulerException e) {
	// e.printStackTrace();
	// }
	// }

	// private void setSchedulerWithInterruptableJob(InterruptableJob job,
	// Trigger trigger) throws SchedulerException {
	// Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	// scheduler.start();
	// scheduler.scheduleJob(jobDetail, trigger);
	// }

	// private Trigger setTriggerWithInterruptableJob(InterruptableJob job,
	// String hour, String minute, String triggerName,
	// String groupName) {
	// Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
	// .withSchedule(cronSchedule(setCronExpression(hour, minute))).build();
	// return trigger;
	// }

}
