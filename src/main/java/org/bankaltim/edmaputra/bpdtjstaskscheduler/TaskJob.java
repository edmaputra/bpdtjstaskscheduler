package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;

public class TaskJob implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {		
		try {
			Song song = new Song();
			SchedulerContext schedulerContext = context.getScheduler().getContext();
			String path = (String) schedulerContext.get("path");			
			song.startPlayBack(path);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
