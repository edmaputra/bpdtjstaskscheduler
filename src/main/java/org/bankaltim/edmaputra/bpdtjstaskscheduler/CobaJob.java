package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CobaJob implements Job {

//	private static Logger LOG = LoggerFactory.getLogger(CobaJob.class);
//
//	private volatile boolean isJobInterrupted = false;
//
//	private JobKey jobKey = null;
//
//	private volatile Thread thisThread;


	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
//		thisThread = Thread.currentThread();
//		LOG.info("Thread name of the current job: " + thisThread.getName());
//
//		jobKey = context.getJobDetail().getKey();
//		LOG.info("Job " + jobKey + " executing at " + new Date());
//
//		try {
//			System.out.println("OK");
//		} catch (Exception e) {
//			LOG.info("Caught IOException... exiting job.", e);
//		} finally {
//			if (isJobInterrupted) {
//				LOG.info("Job " + jobKey + " did not complete");
//			} else {
//				LOG.info("Job " + jobKey + " completed at " + new Date());
//			}
//		}
		System.out.println("CobaJob.run");
		Song song = new Song();
		song.playMp3File(DefaultValue.doaPagiDir);	
	}

//	@Override
//	public void interrupt() throws UnableToInterruptJobException {
//		// TODO Auto-generated method stub
////		LOG.info("Job " + jobKey + "  -- INTERRUPTING --");
////	    isJobInterrupted = true;
////	    if (thisThread != null) {
////	      // this call causes the ClosedByInterruptException to happen
////	      thisThread.interrupt(); 
////	    }
//		System.out.println("CobaJob.stop");
//	}

}
