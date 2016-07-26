package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class NewMainFrame extends JFrame {

	private static final long serialVersionUID = 2534689276808583670L;

	private Scheduler scheduler;

	private JobKey jobKey1;
	private JobKey jobKey2;
	private JobKey jobKey3;
	private JobKey jobKey4;
	private JobKey jobKey5;
	private JobKey jobKey6;

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
				System.out.println("Validasi 1 : " + validasi());
				System.out.println("Validasi 2 : " + validasiPerTask());
				int errorCode = validasi();
				if (errorCode == 0) {
					int errorCode1 = validasiPerTask();
					validateWaktu(mainPanel1.getTxtJam(), mainPanel1.getTxtMenit());
					if (errorCode1 == 0) {
						startScheduler();
						startButtonClicked();
					} else if (errorCode == 2) {
						JOptionPane.showMessageDialog(null,
								"Harap Isi Waktu dengan Benar", "Isi Waktu",
								JOptionPane.WARNING_MESSAGE);
					}
				} else if (errorCode == 1) {
					JOptionPane
							.showMessageDialog(
									null,
									"Harap Isi Salah Satu Task dengan waktu yang ingin ditentukan",
									"Isi Waktu", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnStopAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					scheduler.clear();
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
				jobKey1 = new JobKey(mainPanel1.getJobName());
				JobDetail job1 = setDoaPagiJob(jobKey1);
				Trigger trigger1 = setTrigger(job1, mainPanel1.getTxtJam()
						.getText(), mainPanel1.getTxtMenit().getText(),
						mainPanel1.getTriggerName(),
						mainPanel1.getTriggerGroup());
				scheduler.scheduleJob(job1, trigger1);
			}

			if (!mainPanel2.getTxtJam().getText().isEmpty()) {
				jobKey2 = new JobKey(mainPanel2.getJobName());
				JobDetail job2 = setCorporateSongJob(jobKey2);
				Trigger trigger2 = setTrigger(job2, mainPanel2.getTxtJam()
						.getText(), mainPanel2.getTxtMenit().getText(),
						mainPanel2.getTriggerName(),
						mainPanel2.getTriggerGroup());
				scheduler.scheduleJob(job2, trigger2);
			}

			if (!mainPanel3.getTxtJam().getText().isEmpty()) {
				jobKey3 = new JobKey(mainPanel3.getJobName());
				JobDetail job3 = setCorporateSongJob(jobKey3);
				Trigger trigger3 = setTrigger(job3, mainPanel3.getTxtJam()
						.getText(), mainPanel3.getTxtMenit().getText(),
						mainPanel3.getTriggerName(),
						mainPanel3.getTriggerGroup());
				scheduler.scheduleJob(job3, trigger3);
			}

			if (!mainPanel4.getTxtJam().getText().isEmpty()) {
				jobKey4 = new JobKey(mainPanel4.getJobName());
				JobDetail job4 = setMarsBankaltimJob(jobKey4);
				Trigger trigger4 = setTrigger(job4, mainPanel4.getTxtJam()
						.getText(), mainPanel4.getTxtMenit().getText(),
						mainPanel4.getTriggerName(),
						mainPanel4.getTriggerGroup());
				scheduler.scheduleJob(job4, trigger4);
			}

			if (!mainPanel5.getTxtJam().getText().isEmpty()) {
				jobKey5 = new JobKey(mainPanel5.getJobName());
				JobDetail job5 = setAdzanJob(jobKey5);
				Trigger trigger5 = setTrigger(job5, mainPanel5.getTxtJam()
						.getText(), mainPanel5.getTxtMenit().getText(),
						mainPanel5.getTriggerName(),
						mainPanel5.getTriggerGroup());
				scheduler.scheduleJob(job5, trigger5);
			}

			if (!mainPanel6.getTxtJam().getText().isEmpty()) {
				jobKey6 = new JobKey(mainPanel6.getJobName());
				JobDetail job6 = setAdzanJob(jobKey6);
				Trigger trigger6 = setTrigger(job6, mainPanel6.getTxtJam()
						.getText(), mainPanel6.getTxtMenit().getText(),
						mainPanel6.getTriggerName(),
						mainPanel6.getTriggerGroup());
				scheduler.scheduleJob(job6, trigger6);
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

	private JobDetail setDoaPagiJob(JobKey jobKey) {
		JobDetail job = newJob(DoaJob.class).withIdentity(jobKey).build();
		return job;
	}

	private JobDetail setMarsBankaltimJob(JobKey jobKey) {
		JobDetail job = newJob(MarsBankaltimJob.class).withIdentity(jobKey)
				.build();
		return job;
	}

	private JobDetail setCorporateSongJob(JobKey jobKey) {
		JobDetail job = newJob(CorporateSongJob.class).withIdentity(jobKey)
				.build();
		return job;
	}

	private JobDetail setAdzanJob(JobKey jobKey) {
		JobDetail job = newJob(AdzanJob.class).withIdentity(jobKey).build();
		return job;
	}

	public void stopScheduler() throws SchedulerException {
		// scheduler.shutdown();
		scheduler.clear();
	}

	private Trigger setTrigger(JobDetail job, String hour, String minute,
			String triggerName, String groupName) {
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute)))
				.forJob(job).build();
		return trigger;
	}

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
		// return "0 " + minute + " " + hour + " 1/1 * ? *";
	}

	private int validasi() {
		int errorCode = 0;
		// 1 untuk semua field jam dan menit kosong
		// 2 untuk ada field yang salah mengisi angka jam dan waktu

		String jam1 = mainPanel1.getTxtJam().getText();
		String jam2 = mainPanel2.getTxtJam().getText();
		String jam3 = mainPanel3.getTxtJam().getText();
		String jam4 = mainPanel4.getTxtJam().getText();
		String jam5 = mainPanel5.getTxtJam().getText();
		String jam6 = mainPanel6.getTxtJam().getText();

		String menit1 = mainPanel1.getTxtMenit().getText();
		String menit2 = mainPanel2.getTxtMenit().getText();
		String menit3 = mainPanel3.getTxtMenit().getText();
		String menit4 = mainPanel4.getTxtMenit().getText();
		String menit5 = mainPanel5.getTxtMenit().getText();
		String menit6 = mainPanel6.getTxtMenit().getText();

		if (jam1.isEmpty() && jam2.isEmpty() && jam3.isEmpty()
				&& jam4.isEmpty() && jam5.isEmpty() && jam6.isEmpty()
				&& menit1.isEmpty() && menit2.isEmpty() && menit3.isEmpty()
				&& menit4.isEmpty() && menit5.isEmpty() && menit6.isEmpty()) {
			errorCode = 1;
		}

		return errorCode;
	}

	private int validasiPerTask() {
		int errorCode = 0;

		if (!mainPanel1.getTxtJam().getText().isEmpty()
				&& !mainPanel1.getTxtMenit().getText().isEmpty()) {
			
			if (mainPanel1.getTxtJam().getText().trim().isEmpty()) {
				mainPanel1.getTxtJam().setText("00");
			}

			if (mainPanel1.getTxtMenit().getText().trim().isEmpty()) {
				mainPanel1.getTxtMenit().setText("00");
			}
			// errorCode = validateWaktu(mainPanel1.getTxtJam(),
			// mainPanel1.getTxtMenit());
		}

		// if (!mainPanel1.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel1.getTxtJam(), mainPanel1.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }
		//
		// if (!mainPanel2.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel2.getTxtJam(), mainPanel2.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }
		//
		// if (!mainPanel3.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel3.getTxtJam(), mainPanel3.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }
		//
		// if (!mainPanel4.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel4.getTxtJam(), mainPanel4.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }
		//
		// if (!mainPanel5.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel5.getTxtJam(), mainPanel5.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }
		//
		// if (!mainPanel6.getTxtJam().getText().isEmpty()) {
		// if (validateWaktu(mainPanel6.getTxtJam(), mainPanel6.getTxtMenit())
		// == false) {
		// errorCode = 2;
		// }
		// }

		return errorCode;
	}

	private int validateWaktu(JTextField jam, JTextField menit) {
		if (!jam.getText().isEmpty() && !menit.getText().isEmpty()){
			int errorCode = 0;
			System.out.println("ABC");

			if (jam.getText().trim().isEmpty()) {
				jam.setText("00");
			}

			if (menit.getText().trim().isEmpty()) {
				menit.setText("00");
			}

			Integer jamInt = Integer.parseInt(jam.getText());
			Integer menitInt = Integer.parseInt(menit.getText());

			if (jamInt < 0 || jamInt > 24) {
				errorCode = 2;
			}

			if (menitInt < 0 || menitInt > 59) {
				errorCode = 2;
			}

			return errorCode;
		}else {
			return -1;
		}
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
