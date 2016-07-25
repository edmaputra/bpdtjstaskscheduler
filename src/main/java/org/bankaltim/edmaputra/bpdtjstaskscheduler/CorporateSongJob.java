package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CorporateSongJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Song song = new Song();
		song.startPlayBack(DefaultValue.corporateSongDir);
		System.out.println("Corporate Song Played");
	}

}
