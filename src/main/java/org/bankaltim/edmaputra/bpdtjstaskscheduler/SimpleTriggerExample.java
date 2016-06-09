package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.InterruptableJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class SimpleTriggerExample {

	public SimpleTriggerExample() {
	}

	public void triggerDoaPagi(String hour, String minute) {
		JobDetail jobDetail = newJob(DoaJob.class).withIdentity("doaJob", "group1").build();
		startScheduler(jobDetail, hour, minute, "doaPagiTrigger", "group1");
	}

	public void triggerCorporateSong(String hour, String minute) {
		JobDetail jobDetail = newJob(CorporateSongJob.class).withIdentity("corporateJob", "group1").build();
		startScheduler(jobDetail, hour, minute, "corporateSongTrigger", "group1");
	}

	public void triggerMarsBankaltim(String hour, String minute) {
		JobDetail jobDetail = newJob(MarsBankaltimJob.class).withIdentity("marsBankaltimJob", "group1").build();
		startScheduler(jobDetail, hour, minute, "marsBankaltimTrigger", "group1");
	}

	public void triggerCustom(String hour, String minute) {
		JobDetail jobDetail = newJob(CustomJob.class).withIdentity("job1", "group1").build();
		startScheduler(jobDetail, hour, minute, "customTrigger", "group1");
	}

	public void triggerCobaCustom(String hour, String minute) {
		JobDetail jobDetail = newJob(CustomJob.class).withIdentity("job1", "group1").build();
		startCobaScheduler(jobDetail, hour, minute, "customTrigger", "group1");
	}

	private void startScheduler(JobDetail jobDetail, String hour, String minute, String triggerName, String group) {
		Trigger trigger = setTrigger(jobDetail, hour, minute, triggerName, group);
		try {
			setScheduler(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
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

	private Trigger setTriggerWithInterruptableJob(InterruptableJob job, String hour, String minute, String triggerName,
			String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute))).build();
		return trigger;
	}

	private void setScheduler(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
		// scheduler.in
	}

	// private void setSchedulerWithInterruptableJob(InterruptableJob job,
	// Trigger trigger) throws SchedulerException {
	// Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	// scheduler.start();
	// scheduler.scheduleJob(jobDetail, trigger);
	// }

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
	}

	private Trigger cobaTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName).startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).forJob(job).build();

		return trigger;
	}

}
