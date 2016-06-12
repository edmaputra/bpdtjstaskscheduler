package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DoaJob implements Job{

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		Song song = new Song();
		song.playMp3File(DefaultValue.doaPagiDir);		
		System.out.println("Play Doa Pagi");
	}

}
