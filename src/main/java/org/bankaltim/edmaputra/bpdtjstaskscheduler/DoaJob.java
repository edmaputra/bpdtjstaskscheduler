package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

public class DoaJob implements InterruptableJob{

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		Song song = new Song();
		song.playMp3File(DefaultValue.doaPagiDir);		
	}

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		// TODO Auto-generated method stub
		System.out.println("Stop Job");		
	}

}
