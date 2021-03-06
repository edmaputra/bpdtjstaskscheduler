package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.quartz.SchedulerException;

public class CobaFrame extends JFrame {

	private static final long serialVersionUID = -867303560708939702L;
	
	private TaskScheduler cobaScheduler;

	public CobaFrame() {
		cobaScheduler = new TaskScheduler();
		initComponents();
//		start();
	}
	
	private void initComponents(){
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		getContentPane().add(btnStart, BorderLayout.CENTER);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop();				
			}
		});
		getContentPane().add(btnStop, BorderLayout.EAST);
	}

	private void stop() {
		try {
			cobaScheduler.stopScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() {
//		try {
//			cobaScheduler.setPath(DefaultValue.doaPagiDir);
//			cobaScheduler.runScheduler("10","10");
//		} catch (SchedulerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
