package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -6492599990104395582L;
	
	private String title;
	
	private Scheduler scheduler;
	private JobDetail job;
	private Trigger trigger;
	
	private String path;
	private String jobName;
	private String jobGroup;
	private String triggerName;
	private String triggerGroup;

	public MainPanel() {
		initComponents();
	}
	
	public MainPanel(String title){
		this.jobName = title.replaceAll(" ", "").trim()+"Job";
		this.jobGroup = title.replaceAll(" ", "").trim()+"JobGroup";
		this.triggerName = title.replaceAll(" ", "").trim()+"trigger";
		this.triggerGroup = title.replaceAll(" ", "").trim()+"triggerGroup";
		this.title = title;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
	}
	
	public void setTitle(String title){
		
	}

//	private void start() {
//		if (validateWaktu(txtJam, txtMenit)) {
//			startButtonClicked(txtJam, txtMenit, btnStart, btnStop);
//			try {
////				taskScheduler.setPath(txtBrowseFile.getText());
//				path = txtBrowseFile.getText();
//				runScheduler(txtJam.getText(), txtMenit.getText());				
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "Harap Masukkan Waktu dan Lokasi File dengan Benar", "Kesalahan",
//					JOptionPane.WARNING_MESSAGE);
//		}
//	}

//	private void stop() {
//		if (validateWaktu(txtJam, txtMenit)) {
//			stopButtonClicked(txtJam, txtMenit, btnStart, btnStop);
//			try {
//				stopScheduler();
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "Harap Masukkan Waktu dan Lokasi File dengan Benar", "Kesalahan",
//					JOptionPane.WARNING_MESSAGE);
//		}
//	}
	
	public void runScheduler(String hour, String minute) throws SchedulerException {

		job = newJob(TaskJob.class).withIdentity(jobName, jobGroup).build();	

		trigger = setTrigger(job, hour, minute, triggerName, triggerGroup);
		
		scheduler.getContext().put("path", path);
		scheduler.scheduleJob(job, trigger);
		scheduler.start();

//		scheduler = new StdSchedulerFactory().getScheduler();
//		startEachScheduler(scheduler, job, trigger, path);
//		addScheduleJobToScheduler(scheduler, job, trigger, path);
	}
	
	private Trigger setTrigger(JobDetail job, String hour, String minute, String triggerName, String groupName) {
		Trigger trigger = newTrigger()
				.withIdentity(triggerName, groupName)
				.withSchedule(cronSchedule(setCronExpression(hour, minute)))
				.forJob(job).build();
		return trigger;
	}

	private String setCronExpression(String hour, String minute) {
		return "0 " + minute + " " + hour + " ? * MON-FRI *";
		// return "0 " + minute + " " + hour + " 1/1 * ? *";
	}
	
	public void stopScheduler() throws SchedulerException {
		scheduler.shutdown();
	}

//	private void browse() {
//		browseButtonSetter(txtBrowseFile);
//	}

	private void browseButtonSetter(JTextField jTextField) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			jTextField.setText(f.getAbsolutePath());
		}
	}	

//	private Boolean validateWaktu(JTextField jam, JTextField menit) {
//		Boolean validated = true;
//		if (txtBrowseFile.getText().trim().isEmpty()) {
//			validated = false;
//		}
//
//		if (jam.getText().trim().isEmpty()) {
//			jam.setText("00");
//		}
//
//		if (menit.getText().trim().isEmpty()) {
//			menit.setText("00");
//		}
//
//		Integer jamInt = Integer.parseInt(jam.getText());
//		Integer menitInt = Integer.parseInt(menit.getText());
//
//		if (jamInt < 0 || jamInt > 24) {
//			validated = false;
//		}
//
//		if (menitInt < 0 || menitInt > 59) {
//			validated = false;
//		}
//
//		return validated;
//	}	

	private void startButtonClicked(JTextField txtJam, JTextField txtMenit, JButton btnStart, JButton btnStop) {
		txtJam.setEditable(false);
		txtMenit.setEditable(false);
		btnStart.setEnabled(false);
		btnStop.setEnabled(true);
	}

	private void stopButtonClicked(JTextField txtJam, JTextField txtMenit, JButton btnStart, JButton btnStop) {
		txtJam.setEditable(true);
		txtMenit.setEditable(true);
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
	}

	private void initComponents() {

//		lblBrowse = new javax.swing.JLabel();
//		txtBrowseFile = new javax.swing.JTextField();
		lblWaktu = new javax.swing.JLabel();
		txtJam = new IntegerField();
		txtMenit = new IntegerField();
		chkAktif = new javax.swing.JCheckBox();

		java.awt.GridBagConstraints gridBagConstraints;

//        lblWaktu = new javax.swing.JLabel();
        txtJam = new IntegerField();
        txtMenit = new IntegerField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        lblWaktu.setText("Waktu ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(lblWaktu, gridBagConstraints);

        txtJam.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setPreferredSize(new java.awt.Dimension(70, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(txtJam, gridBagConstraints);

        txtMenit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtMenit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMenit.setPreferredSize(new java.awt.Dimension(70, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(txtMenit, gridBagConstraints);
        
        chkAktif.setText("Aktif");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(chkAktif, gridBagConstraints);
	}

//	private javax.swing.JButton btnBrowseFile;
//	private javax.swing.JButton btnStart;
//	private javax.swing.JButton btnStop;
//	private javax.swing.JLabel lblBrowse;
	private javax.swing.JLabel lblWaktu;
//	private javax.swing.JTextField txtBrowseFile;
	private IntegerField txtJam;
	private IntegerField txtMenit;
	private javax.swing.JCheckBox chkAktif;

	public IntegerField getTxtJam() {
		return txtJam;
	}
	

	public void setTxtJam(IntegerField txtJam) {
		this.txtJam = txtJam;
	}
	

	public IntegerField getTxtMenit() {
		return txtMenit;
	}
	

	public void setTxtMenit(IntegerField txtMenit) {
		this.txtMenit = txtMenit;
	}
	

	public Trigger getTrigger() {
		return trigger;
	}
	

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	

	public String getJobName() {
		return jobName;
	}
	

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	

	public String getJobGroup() {
		return jobGroup;
	}
	

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	

	public String getTriggerGroup() {
		return triggerGroup;
	}
	

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	
	public String getPath() {
		return path;
	}
	

	public void setPath(String path) {
		this.path = path;
	}

	public String getTriggerName() {
		return triggerName;
	}
	

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public javax.swing.JCheckBox getChkAktif() {
		return chkAktif;
	}
	

	public void setChkAktif(javax.swing.JCheckBox chkAktif) {
		this.chkAktif = chkAktif;
	}
		

}
