package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DoaJob implements Job{

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Song song = new Song();
		song.startPlayBack(DefaultValue.doaPagiDir);
		System.out.println("Doa Pagi Played");
	}

}
