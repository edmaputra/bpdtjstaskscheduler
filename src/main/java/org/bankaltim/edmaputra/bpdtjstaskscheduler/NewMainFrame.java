package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class NewMainFrame extends JFrame {

	private static final long serialVersionUID = 2534689276808583670L;

	private Scheduler scheduler;

	public NewMainFrame() {
		this.setTitle("BPD Kaltim Tanjung Selor Task Scheduler");
		initComponents();
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnStopAll.setEnabled(false);
	}

	private void initComponents() {
		mainPanel = new javax.swing.JPanel();
		mainPanel1 = new MainPanel("Doa Pagi");
		mainPanel2 = new MainPanel("Corporate Song 1");
		mainPanel3 = new MainPanel("Corporate Song 2");
		mainPanel4 = new MainPanel("Mars Bankaltim");
		mainPanel5 = new MainPanel("Dzuhur");
		mainPanel6 = new MainPanel("Asar");
		btnStartAll = new JButton("Start All");
		btnStopAll = new JButton("Stop All");
		// titlePanel = new javax.swing.JPanel();
		// lblTitle = new javax.swing.JLabel();
		// jMenuBar1 = new javax.swing.JMenuBar();
		// mnuSchdule = new javax.swing.JMenu();
		// mnuItemScheduleBaru = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		mainPanel.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

		mainPanel.add(mainPanel1);
		mainPanel.add(mainPanel2);
		mainPanel.add(mainPanel3);
		mainPanel.add(mainPanel4);
		mainPanel.add(mainPanel5);
		mainPanel.add(mainPanel6);
		mainPanel.add(btnStartAll);
		mainPanel.add(btnStopAll);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		btnStartAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startScheduler();
				startButtonClicked();
			}
		});

		btnStopAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
//					scheduler.shutdown();					
					stopButtonClicked();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void startScheduler() {
		try {
			if (!mainPanel1.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel1.getTxtJam(), mainPanel1.getTxtMenit())) {
					JobDetail job1 = setDoaPagiJob(mainPanel1.getJobName(), mainPanel1.getJobGroup());
					Trigger trigger1 = setTrigger(job1, mainPanel1.getTxtJam().getText(),
							mainPanel1.getTxtMenit().getText(), mainPanel1.getTriggerName(),
							mainPanel1.getTriggerGroup());
					// scheduler.getContext().put("path",
					// mainPanel1.getTxtBrowseFile().getText());
					scheduler.scheduleJob(job1, trigger1);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}

			}

			if (!mainPanel2.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel2.getTxtJam(), mainPanel2.getTxtMenit())) {
					JobDetail job2 = setCorporateSongJob(mainPanel2.getJobName(), mainPanel2.getJobGroup());
					Trigger trigger2 = setTrigger(job2, mainPanel2.getTxtJam().getText(),
							mainPanel2.getTxtMenit().getText(), mainPanel2.getTriggerName(),
							mainPanel2.getTriggerGroup());
					// scheduler.getContext().put("path",
					// mainPanel2.getTxtBrowseFile().getText());
					scheduler.scheduleJob(job2, trigger2);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			if (!mainPanel3.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel3.getTxtJam(), mainPanel3.getTxtMenit())) {
					JobDetail job3 = setCorporateSongJob(mainPanel3.getJobName(), mainPanel3.getJobGroup());
					Trigger trigger3 = setTrigger(job3, mainPanel3.getTxtJam().getText(),
							mainPanel3.getTxtMenit().getText(), mainPanel3.getTriggerName(),
							mainPanel3.getTriggerGroup());
					scheduler.scheduleJob(job3, trigger3);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			if (!mainPanel4.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel4.getTxtJam(), mainPanel4.getTxtMenit())) {
					JobDetail job4 = setMarsBankaltimJob(mainPanel4.getJobName(), mainPanel4.getJobGroup());
					Trigger trigger4 = setTrigger(job4, mainPanel4.getTxtJam().getText(),
							mainPanel4.getTxtMenit().getText(), mainPanel4.getTriggerName(),
							mainPanel4.getTriggerGroup());
					scheduler.scheduleJob(job4, trigger4);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			if (!mainPanel5.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel5.getTxtJam(), mainPanel5.getTxtMenit())) {
					JobDetail job5 = setAdzanJob(mainPanel5.getJobName(), mainPanel5.getJobGroup());
					Trigger trigger5 = setTrigger(job5, mainPanel5.getTxtJam().getText(),
							mainPanel5.getTxtMenit().getText(), mainPanel5.getTriggerName(),
							mainPanel5.getTriggerGroup());
					scheduler.scheduleJob(job5, trigger5);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			if (!mainPanel6.getTxtJam().getText().isEmpty()) {
				if (validateWaktu(mainPanel5.getTxtJam(), mainPanel5.getTxtMenit())) {
					JobDetail job6 = setAdzanJob(mainPanel6.getJobName(), mainPanel6.getJobGroup());
					Trigger trigger6 = setTrigger(job6, mainPanel6.getTxtJam().getText(),
							mainPanel6.getTxtMenit().getText(), mainPanel6.getTriggerName(),
							mainPanel6.getTriggerGroup());
					scheduler.scheduleJob(job6, trigger6);
				} else {
					JOptionPane.showMessageDialog(null, "Harap Isi Waktu dengan Benar", "Waktu Salah",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startButtonClicked() {
		btnStopAll.setEnabled(true);
		btnStartAll.setEnabled(false);
		mainPanel1.getTxtJam().setEditable(false);
		mainPanel1.getTxtMenit().setEditable(false);
		mainPanel2.getTxtJam().setEditable(false);
		mainPanel2.getTxtMenit().setEditable(false);
		mainPanel3.getTxtJam().setEditable(false);
		mainPanel3.getTxtMenit().setEditable(false);
		mainPanel4.getTxtJam().setEditable(false);
		mainPanel4.getTxtMenit().setEditable(false);
		mainPanel5.getTxtJam().setEditable(false);
		mainPanel5.getTxtMenit().setEditable(false);
		mainPanel6.getTxtJam().setEditable(false);
		mainPanel6.getTxtMenit().setEditable(false);
	}

	private void stopButtonClicked() {
		btnStartAll.setEnabled(true);
		btnStopAll.setEnabled(false);
		mainPanel1.getTxtJam().setEditable(true);
		mainPanel1.getTxtMenit().setEditable(true);
		mainPanel2.getTxtJam().setEditable(true);
		mainPanel2.getTxtMenit().setEditable(true);
		mainPanel3.getTxtJam().setEditable(true);
		mainPanel3.getTxtMenit().setEditable(true);
		mainPanel4.getTxtJam().setEditable(true);
		mainPanel4.getTxtMenit().setEditable(true);
		mainPanel5.getTxtJam().setEditable(true);
		mainPanel5.getTxtMenit().setEditable(true);
		mainPanel6.getTxtJam().setEditable(true);
		mainPanel6.getTxtMenit().setEditable(true);
	}

	private JobDetail setDoaPagiJob(String jobName, String jobGroup) {
		JobDetail job = newJob(DoaJob.class).withIdentity(jobName, jobGroup).build();
		return job;
	}

	private JobDetail setMarsBankaltimJob(String jobName, String jobGroup) {
		JobDetail job = newJob(MarsBankaltimJob.class).withIdentity(jobName, jobGroup).build();
		return job;
	}

	private JobDetail setCorporateSongJob(String jobName, String jobGroup) {
		JobDetail job = newJob(CorporateSongJob.class).withIdentity(jobName, jobGroup).build();
		return job;
	}

	private JobDetail setAdzanJob(String jobName, String jobGroup) {
		JobDetail job = newJob(AdzanJob.class).withIdentity(jobName, jobGroup).build();
		return job;
	}

	public void stopScheduler() throws SchedulerException {
		scheduler.shutdown();
	}

	private Trigger setTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute))).forJob(job).build();
		return trigger;
	}

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
		// return "0 " + minute + " " + hour + " 1/1 * ? *";
	}

	private Boolean validateWaktu(JTextField jam, JTextField menit) {
		Boolean validated = true;

		if (jam.getText().trim().isEmpty()) {
			jam.setText("00");
		}

		if (menit.getText().trim().isEmpty()) {
			menit.setText("00");
		}

		Integer jamInt = Integer.parseInt(jam.getText());
		Integer menitInt = Integer.parseInt(menit.getText());

		if (jamInt < 0 || jamInt > 24) {
			validated = false;
		}

		if (menitInt < 0 || menitInt > 59) {
			validated = false;
		}

		return validated;
	}
	
	

	private MainPanel mainPanel1;
	private MainPanel mainPanel2;
	private MainPanel mainPanel3;
	private MainPanel mainPanel4;
	private MainPanel mainPanel5;
	private MainPanel mainPanel6;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JButton btnStartAll;
	private javax.swing.JButton btnStopAll;
}
