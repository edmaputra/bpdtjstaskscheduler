package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

public class CobaJob implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {		
		try {
			Song song = new Song();
			SchedulerContext schedulerContext = context.getScheduler().getContext();
			String path = (String) schedulerContext.get("path");
			song.playMp3File(path);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
