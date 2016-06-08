package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5461558103154462195L;

	public MainFrame() {
		initComponents();
	}

//	private void browseDoaPagi() {
//		browseButtonSetter(txtFileDoaPagi);
//	}
//
//	private void browseCorporateSong() {
//		browseButtonSetter(txtFileCorporateSong);
//	}
//
//	private void browseMarsBankaltim() {
//		browseButtonSetter(txtFileMarsBankaltim);
//	}
//
//	private void browseCustom() {
//		browseButtonSetter(txtFileCustom);
//	}
//
//	private void browseButtonSetter(JTextField jTextField) {
//		JFileChooser chooser = new JFileChooser();
//		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//		int result = chooser.showOpenDialog(this);
//		if (result == JFileChooser.APPROVE_OPTION) {
//			File f = chooser.getSelectedFile();
//			jTextField.setText(f.getAbsolutePath());
//		}
//	}

	private void startCustomScheduler() {
		if (validateWaktu(txtJamCustom, txtMenitCustom)) {
			startButtonClicked(txtJamCustom, txtMenitCustom, btnStartCustom, btnStopCustom);
			SimpleTriggerExample trigger = new SimpleTriggerExample();
			trigger.triggerCobaCustom(txtJamCustom.getText(), txtMenitCustom.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}
	}

	private void startDoaPagiScheduler() {
		startButtonClicked(txtJamDoaPagi, txtMenitDoaPagi, btnStartDoaPagi, btnStopDoaPagi);
		SimpleTriggerExample trigger = new SimpleTriggerExample();
		trigger.triggerDoaPagi(txtJamDoaPagi.getText(), txtMenitDoaPagi.getText());
	}

	private void startCorporateSongScheduler() {
		// if (validateWaktu(txtJamCustom, txtMenitCustom)){
		startButtonClicked(txtJamCorporateSong, txtMenitCorporateSong, btnStartCorporateSong, btnStopCorporateSong);
		SimpleTriggerExample trigger = new SimpleTriggerExample();
		trigger.triggerCorporateSong(txtJamCorporateSong.getText(), txtMenitCorporateSong.getText());
		// } else {
		// JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		// }

	}

	private void startMarsBankaltimScheduler() {
		startButtonClicked(txtJamMarsBankaltim, txtMenitMarsBankaltim, btnStartMarsBankaltim, btnStopMarsBankaltim);
		SimpleTriggerExample trigger = new SimpleTriggerExample();
		trigger.triggerMarsBankaltim(txtJamMarsBankaltim.getText(), txtMenitMarsBankaltim.getText());
	}

	private Boolean validateWaktu(JTextField jam, JTextField menit) {
		Boolean validated = false;
		if (!jam.getText().isEmpty()) {
			if (!menit.getText().isEmpty()) {
				validated = true;
			}
		}
		return validated;
	}

	private void stopCustomScheduler() {
		stopButtonClicked(txtJamCustom, txtMenitCustom, btnStartCustom, btnStopCustom);
	}

	private void stopDoaPagiScheduler() {
		stopButtonClicked(txtJamDoaPagi, txtMenitDoaPagi, btnStartDoaPagi, btnStopDoaPagi);
	}

	private void stopCorporateSongScheduler() {
		stopButtonClicked(txtJamCorporateSong, txtMenitCorporateSong, btnStartCorporateSong, btnStopCorporateSong);
	}

	private void stopMarsBankaltimScheduler() {
		stopButtonClicked(txtJamMarsBankaltim, txtMenitMarsBankaltim, btnStartMarsBankaltim, btnStopMarsBankaltim);
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
		java.awt.GridBagConstraints gridBagConstraints;

		mainPanel = new javax.swing.JPanel();
		panelDoaPagi = new javax.swing.JPanel();
		btnStartDoaPagi = new javax.swing.JButton();
		btnStopDoaPagi = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		txtJamDoaPagi = new javax.swing.JTextField();
		txtMenitDoaPagi = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		panelCorporateSong = new javax.swing.JPanel();
		btnStartCorporateSong = new javax.swing.JButton();
		btnStopCorporateSong = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		txtJamCorporateSong = new javax.swing.JTextField();
		txtMenitCorporateSong = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		panelMars = new javax.swing.JPanel();
		btnStartMarsBankaltim = new javax.swing.JButton();
		btnStopMarsBankaltim = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		txtJamMarsBankaltim = new javax.swing.JTextField();
		txtMenitMarsBankaltim = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		panelCustom = new javax.swing.JPanel();
		btnStartCustom = new javax.swing.JButton();
		btnStopCustom = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		txtJamCustom = new javax.swing.JTextField();
		txtMenitCustom = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		titlePanel = new javax.swing.JPanel();
		lblTitle = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		mainPanel.setLayout(new java.awt.GridBagLayout());

		panelDoaPagi.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DOA PAGI",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelDoaPagi.setLayout(new java.awt.GridBagLayout());

		btnStartDoaPagi.setText("Start");
		btnStartDoaPagi.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartDoaPagi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startDoaPagiScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelDoaPagi.add(btnStartDoaPagi, gridBagConstraints);

		btnStopDoaPagi.setText("Stop");
		btnStopDoaPagi.setEnabled(false);
		btnStopDoaPagi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopDoaPagiScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelDoaPagi.add(btnStopDoaPagi, gridBagConstraints);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel3.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDoaPagi.add(jLabel3, gridBagConstraints);

		txtJamDoaPagi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamDoaPagi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamDoaPagi.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDoaPagi.add(txtJamDoaPagi, gridBagConstraints);

		txtMenitDoaPagi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitDoaPagi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitDoaPagi.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDoaPagi.add(txtMenitDoaPagi, gridBagConstraints);

		jLabel10.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelDoaPagi.add(jLabel10, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		mainPanel.add(panelDoaPagi, gridBagConstraints);

		panelCorporateSong.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "CORPORATE SONG",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelCorporateSong.setLayout(new java.awt.GridBagLayout());

		btnStartCorporateSong.setText("Start");
		btnStartCorporateSong.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartCorporateSong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startCorporateSongScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelCorporateSong.add(btnStartCorporateSong, gridBagConstraints);

		btnStopCorporateSong.setText("Stop");
		btnStopCorporateSong.setEnabled(false);
		btnStopCorporateSong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopCorporateSongScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelCorporateSong.add(btnStopCorporateSong, gridBagConstraints);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel5.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCorporateSong.add(jLabel5, gridBagConstraints);

		txtJamCorporateSong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamCorporateSong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamCorporateSong.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCorporateSong.add(txtJamCorporateSong, gridBagConstraints);

		txtMenitCorporateSong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitCorporateSong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitCorporateSong.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCorporateSong.add(txtMenitCorporateSong, gridBagConstraints);

		jLabel12.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelCorporateSong.add(jLabel12, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		mainPanel.add(panelCorporateSong, gridBagConstraints);

		panelMars.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "MARS BANKALTIM",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelMars.setLayout(new java.awt.GridBagLayout());

		btnStartMarsBankaltim.setText("Start");
		btnStartMarsBankaltim.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartMarsBankaltim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startMarsBankaltimScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelMars.add(btnStartMarsBankaltim, gridBagConstraints);

		btnStopMarsBankaltim.setText("Stop");
		btnStopMarsBankaltim.setEnabled(false);
		btnStopMarsBankaltim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopMarsBankaltimScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelMars.add(btnStopMarsBankaltim, gridBagConstraints);

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel7.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelMars.add(jLabel7, gridBagConstraints);

		txtJamMarsBankaltim.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamMarsBankaltim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamMarsBankaltim.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelMars.add(txtJamMarsBankaltim, gridBagConstraints);

		txtMenitMarsBankaltim.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitMarsBankaltim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitMarsBankaltim.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelMars.add(txtMenitMarsBankaltim, gridBagConstraints);

		jLabel11.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelMars.add(jLabel11, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		mainPanel.add(panelMars, gridBagConstraints);

		panelCustom.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Custom",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelCustom.setLayout(new java.awt.GridBagLayout());

		btnStartCustom.setText("Start");
		btnStartCustom.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartCustom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startCustomScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelCustom.add(btnStartCustom, gridBagConstraints);

		btnStopCustom.setText("Stop");
		btnStopCustom.setEnabled(false);
		btnStopCustom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopCustomScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelCustom.add(btnStopCustom, gridBagConstraints);

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel9.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCustom.add(jLabel9, gridBagConstraints);

		txtJamCustom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamCustom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamCustom.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCustom.add(txtJamCustom, gridBagConstraints);

		txtMenitCustom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitCustom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitCustom.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCustom.add(txtMenitCustom, gridBagConstraints);

		jLabel13.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelCustom.add(jLabel13, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		mainPanel.add(panelCustom, gridBagConstraints);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

		lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblTitle.setText("jLabel1");
		titlePanel.add(lblTitle);

		getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

		pack();
		setLocationRelativeTo(null);
	}

	private javax.swing.JButton btnStartCorporateSong;
	private javax.swing.JButton btnStartCustom;
	private javax.swing.JButton btnStartDoaPagi;
	private javax.swing.JButton btnStartMarsBankaltim;
	private javax.swing.JButton btnStopCorporateSong;
	private javax.swing.JButton btnStopCustom;
	private javax.swing.JButton btnStopDoaPagi;
	private javax.swing.JButton btnStopMarsBankaltim;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel lblTitle;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel panelCorporateSong;
	private javax.swing.JPanel panelCustom;
	private javax.swing.JPanel panelDoaPagi;
	private javax.swing.JPanel panelMars;
	private javax.swing.JPanel titlePanel;
	private javax.swing.JTextField txtJamCorporateSong;
	private javax.swing.JTextField txtJamCustom;
	private javax.swing.JTextField txtJamDoaPagi;
	private javax.swing.JTextField txtJamMarsBankaltim;
	private javax.swing.JTextField txtMenitCorporateSong;
	private javax.swing.JTextField txtMenitCustom;
	private javax.swing.JTextField txtMenitDoaPagi;
	private javax.swing.JTextField txtMenitMarsBankaltim;

}
