package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.UnableToInterruptJobException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobaScheduler {

	SchedulerFactory sf;
	Scheduler sched;
	JobDetail job;
	Trigger trigger;

	public CobaScheduler() {
	}

	public void runScheduler() throws SchedulerException {

		// final Logger log = LoggerFactory.getLogger(CobaScheduler.class);

		// log.info("------- Initializing ----------------------");

		// First we must get a reference to a scheduler

		// log.info("------- Initialization Complete -----------");

		// log.info("------- Scheduling Jobs -------------------");

		// get a "nice round" time a few seconds in the future...

		job = newJob(CobaJob.class).withIdentity("coba", "cobagroup").build();
		trigger = newTrigger()
				.withIdentity("trigger1", "triggerGroup1")
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(2000)
								.repeatForever()).build();

		sf = new StdSchedulerFactory();
		sched = sf.getScheduler();

		sched.start();
		sched.scheduleJob(job, trigger);
		System.out.println("Started");
		// log.info("Scheduler thread's name: " +
		// Thread.currentThread().getName());
		// log.info("------- Started Scheduler -----------------");
	}

	public void interruptScheduler() throws SchedulerException {		
//		sched.interrupt(job.getKey());
		System.out.println("Interrupted");
		sched.shutdown();
	}

	// public static void main(String[] args){
	// CobaScheduler coba = new CobaScheduler();
	// try {
	// coba.runScheduler();
	// } catch (SchedulerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
