package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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
	
	private final String TRIGGER_NAME_DOA_PAGI = "doaPagiTrigger";
	private final String TRIGGER_NAME_CORPORATE_SONG = "corporateSongTrigger";
	private final String TRIGGER_NAME_MARS_BANKALTIM = "marsBankaltimTrigger";
	private final String TRIGGER_NAME_DZUHUR = "dzuhurTrigger";
	private final String TRIGGER_NAME_ASAR = "asarTrigger";
	private final String TRIGGER_NAME_CUSTOM = "customTrigger";

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
			schedulerAsar = new StdSchedulerFactory().getScheduler();
			schedulerCorporateSong = new StdSchedulerFactory().getScheduler();
			schedulerCustom = new StdSchedulerFactory().getScheduler();
			schedulerDzuhur = new StdSchedulerFactory().getScheduler();
			schedulerMarsBankaltim = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void triggerDoaPagi(String hour, String minute) {	
		jobDoaPagi = newJob(DoaJob.class).withIdentity(JOB_NAME_DOA_PAGI,"group1").build();
		Trigger trigger = setTrigger(jobDoaPagi, hour, minute, TRIGGER_NAME_DOA_PAGI, "group1");
		startEachScheduler(schedulerDoaPagi, jobDoaPagi, trigger);
	}

	public void triggerCorporateSong(String hour, String minute) {
		jobCorporateSong = newJob(CorporateSongJob.class).withIdentity(JOB_NAME_CORPORATE_SONG, "group1").build();
		Trigger trigger = setTrigger(jobCorporateSong, hour, minute, TRIGGER_NAME_CORPORATE_SONG, "group1");
		startEachScheduler(schedulerCorporateSong, jobCorporateSong, trigger);
	}

	public void triggerMarsBankaltim(String hour, String minute) {
		jobMarsBankaltim = newJob(MarsBankaltimJob.class).withIdentity(JOB_NAME_MARS_BANKALTIM, "group1").build();
		Trigger trigger = setTrigger(jobMarsBankaltim, hour, minute, TRIGGER_NAME_MARS_BANKALTIM, "group1");
		startEachScheduler(schedulerMarsBankaltim, jobMarsBankaltim, trigger);
	}

	public void triggerCustom(String hour, String minute) {
		jobCustom = newJob(CustomJob.class).withIdentity(JOB_NAME_CUSTOM, "group1").build();
		Trigger trigger = setTrigger(jobCustom, hour, minute, TRIGGER_NAME_CUSTOM, "group1");
		startEachScheduler(schedulerCustom, jobCustom, trigger);
	}	

	public void stopDoaPagi() {
		try {
			stopScheduler(schedulerDoaPagi);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopCorporateSong() {
		try {
			stopScheduler(schedulerCorporateSong);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopMarsBankaltim() {
		try {
			stopScheduler(schedulerMarsBankaltim);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopCustom() {
		try {
			stopScheduler(schedulerCustom);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopDzuhur() {
		try {
			stopScheduler(schedulerDzuhur);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopAshar() {
		try {
			stopScheduler(schedulerAsar);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startEachScheduler(Scheduler scheduler, JobDetail job, Trigger trigger) {
		try {
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopScheduler(Scheduler scheduler)
			throws SchedulerException {
		scheduler.shutdown(true);
	}

	private Trigger setTrigger(JobDetail job, String hour, String minute,
			String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute)))
				.forJob(job).build();
		return trigger;
	}

	private String setCronExpression(String hour, String minute) {
		// return "0 " + minute + " " + hour + " ? * MON-FRI *";
		return "0 " + minute + " " + hour + " 1/1 * ? *";
	}
	
//	public void triggerCobaCustom(String hour, String minute) {
//		JobDetail jobDetail = newJob(CustomJob.class).withIdentity(
//				JOB_NAME_CUSTOM, "group1").build();
//		// startCobaScheduler(jobDetail, hour, minute, "customTrigger",
//		// "group1");
//	}

	// private void startCobaScheduler(JobDetail jobDetail, String hour, String
	// minute, String triggerName, String group) {
	// Trigger trigger = cobaTrigger(jobDetail, hour, minute, triggerName,
	// group);
	// try {
	// setScheduler(jobDetail, trigger);
	// } catch (SchedulerException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// private Trigger cobaTrigger(JobDetail job, String hour, String minute,
	// String triggerName, String groupName) {
	// Trigger trigger = newTrigger().withIdentity(triggerName,
	// groupName).startNow()
	// .withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).forJob(job).build();
	//
	// return trigger;
	// }
	//
	// public void cobaTriggerDoaPagi(String hour, String minute){
	// jobDoaPagi = newJob(DoaJob.class).withIdentity(JOB_NAME_DOA_PAGI,
	// "group1").build();
	//
	// Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
	// .withSchedule(cronSchedule(setCronExpression(hour,
	// minute))).forJob(jobDoaPagi).build();
	//
	// try {
	// schedulerDoaPagi = new StdSchedulerFactory().getScheduler();
	// schedulerDoaPagi.start();
	// schedulerDoaPagi.scheduleJob(jobDoaPagi, trigger);
	// } catch (SchedulerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

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
