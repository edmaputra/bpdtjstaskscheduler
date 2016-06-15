package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.quartz.SchedulerException;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -6492599990104395582L;
	private CobaScheduler scheduler;
	private String title;

	public MainPanel() {
		initComponents();
		scheduler = new CobaScheduler();
	}

	public MainPanel(String newSchedule) {
		title = newSchedule;
		initComponents();
		scheduler = new CobaScheduler(newJobName(newSchedule), newJobGroup(newSchedule), newTriggerName(newSchedule), newTriggerGroup(newSchedule));
	}

	private void start() {
		if (validateWaktu(txtJam, txtMenit)) {
			startButtonClicked(txtJam, txtMenit, btnStart, btnStop);
			try {
				scheduler.setPath(txtBrowseFile.getText());
				scheduler.runScheduler(txtJam.getText(), txtMenit.getText());
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Harap Masukkan Waktu dan Lokasi File dengan Benar", "Kesalahan",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void stop() {
		if (validateWaktu(txtJam, txtMenit)) {
			stopButtonClicked(txtJam, txtMenit, btnStart, btnStop);
			try {
				scheduler.stopScheduler();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Harap Masukkan Waktu dan Lokasi File dengan Benar", "Kesalahan",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void browse() {
		browseButtonSetter(txtBrowseFile);
	}

	private void browseButtonSetter(JTextField jTextField) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			jTextField.setText(f.getAbsolutePath());
		}
	}

	private Boolean validateWaktu(JTextField jam, JTextField menit) {
		Boolean validated = true;
		if (txtBrowseFile.getText().trim().isEmpty()) {
			validated = false;
		}

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
	
	private String newJobName(String newSchedule) {
		String newJob = newSchedule.trim();
		return newJob +"job";
	}
	
	private String newJobGroup(String newSchedule) {
		String newJobGroup = newSchedule.trim();
		return newJobGroup +"jobGroup";
	}
	
	private String newTriggerName(String newSchedule) {
		String newTrigger = newSchedule.trim();
		return newTrigger +"trigger";
	}
	
	private String newTriggerGroup(String newSchedule) {
		String newTriggerGroup = newSchedule.trim();
		return newTriggerGroup +"triggerGroup";
	}

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

		lblBrowse = new javax.swing.JLabel();
		txtBrowseFile = new javax.swing.JTextField();
		btnBrowseFile = new javax.swing.JButton();
		lblWaktu = new javax.swing.JLabel();
		txtJam = new IntegerField();
		txtMenit = new IntegerField();
		btnStart = new javax.swing.JButton();
		btnStop = new javax.swing.JButton();

		setBorder(javax.swing.BorderFactory.createTitledBorder(null, title,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N

		lblBrowse.setText("MP3 File");

		txtBrowseFile.setEditable(false);

		btnBrowseFile.setText("...");
		btnBrowseFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browse();
			}
		});

		lblWaktu.setText("Waktu ");

		txtJam.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		txtMenit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		txtMenit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		btnStart.setText("Start");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				start();
			}
		});

		btnStop.setText("Stop");
		btnStop.setEnabled(false);
		btnStop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stop();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrowse)
                    .addComponent(lblWaktu))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBrowseFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseFile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrowse)
                    .addComponent(txtBrowseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWaktu)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
	}

	private javax.swing.JButton btnBrowseFile;
	private javax.swing.JButton btnStart;
	private javax.swing.JButton btnStop;
	private javax.swing.JLabel lblBrowse;
	private javax.swing.JLabel lblWaktu;
	private javax.swing.JTextField txtBrowseFile;
	private IntegerField txtJam;
	private IntegerField txtMenit;

}
