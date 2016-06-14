package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5461558103154462195L;

	SimpleTriggerExample triggerDoaPagi;
	SimpleTriggerExample triggerCorporateSong;
	SimpleTriggerExample triggerMarsBankaltim;
	SimpleTriggerExample triggerDzuhur;
	SimpleTriggerExample triggerAsar;
	SimpleTriggerExample triggerCustom;

	public MainFrame() {
		initComponents();
	}

	// private void browseDoaPagi() {
	// browseButtonSetter(txtFileDoaPagi);
	// }
	//
	// private void browseCorporateSong() {
	// browseButtonSetter(txtFileCorporateSong);
	// }
	//
	// private void browseMarsBankaltim() {
	// browseButtonSetter(txtFileMarsBankaltim);
	// }
	//
	// private void browseCustom() {
	// browseButtonSetter(txtFileCustom);
	// }
	//
	// private void browseButtonSetter(JTextField jTextField) {
	// JFileChooser chooser = new JFileChooser();
	// chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	// int result = chooser.showOpenDialog(this);
	// if (result == JFileChooser.APPROVE_OPTION) {
	// File f = chooser.getSelectedFile();
	// jTextField.setText(f.getAbsolutePath());
	// }
	// }

	private void startCustomScheduler() {
		if (validateWaktu(txtJamCustom, txtMenitCustom)) {
			startButtonClicked(txtJamCustom, txtMenitCustom, btnStartCustom,
					btnStopCustom);
			SimpleTriggerExample trigger = new SimpleTriggerExample();
			// trigger.triggerCobaCustom(txtJamCustom.getText(),
			// txtMenitCustom.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}
	}

	private void startDoaPagiScheduler() {
		if (validateWaktu(txtJamDoaPagi, txtMenitDoaPagi)) {
			startButtonClicked(txtJamDoaPagi, txtMenitDoaPagi, btnStartDoaPagi,
					btnStopDoaPagi);
			triggerDoaPagi = new SimpleTriggerExample();
			triggerDoaPagi.startDoaPagi(txtJamDoaPagi.getText(),
					txtMenitDoaPagi.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}
	}

	private void startCorporateSongScheduler() {
		if (validateWaktu(txtJamCorporateSong, txtMenitCorporateSong)) {
			startButtonClicked(txtJamCorporateSong, txtMenitCorporateSong,
					btnStartCorporateSong, btnStopCorporateSong);
			triggerCorporateSong = new SimpleTriggerExample();
			triggerCorporateSong.startCorporateSong(txtJamCorporateSong.getText(),
					txtMenitCorporateSong.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}

	}

	private void startMarsBankaltimScheduler() {
		if (validateWaktu(txtJamMarsBankaltim, txtMenitMarsBankaltim)) {
			startButtonClicked(txtJamMarsBankaltim, txtMenitMarsBankaltim,
					btnStartMarsBankaltim, btnStopMarsBankaltim);
			triggerMarsBankaltim = new SimpleTriggerExample();
			triggerMarsBankaltim.startMarsBankaltimScheduler(txtJamMarsBankaltim.getText(),
					txtMenitMarsBankaltim.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}
	}
	
	private void startDzuhurScheduler(){
		if (validateWaktu(txtJamDzuhur, txtMenitDzuhur)) {
			startButtonClicked(txtJamDzuhur, txtMenitDzuhur, btnStartDzuhur, btnStopDzuhur);
			triggerDzuhur = new SimpleTriggerExample();
//			triggerDzuhur.(txtJamDzuhur.getText(), txtMenitDzuhur.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Harap Isi Waktu dengan Benar");
		}
	}
	
	private void stopDzuhurScheduler(){
		
	}
	
	private void startAsarScheduler(){
		
	}
	
	private void stopAsarScheduler(){
		
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

	private void stopCustomScheduler() {
		stopButtonClicked(txtJamCustom, txtMenitCustom, btnStartCustom, btnStopCustom);
		triggerCustom.stopCustom();
	}

	private void stopDoaPagiScheduler() {
		stopButtonClicked(txtJamDoaPagi, txtMenitDoaPagi, btnStartDoaPagi, btnStopDoaPagi);
		triggerDoaPagi.stopDoaPagi();
	}

	private void stopCorporateSongScheduler() {
		stopButtonClicked(txtJamCorporateSong, txtMenitCorporateSong, btnStartCorporateSong, btnStopCorporateSong);
		triggerCorporateSong.stopCorporateSong();
	}

	private void stopMarsBankaltimScheduler() {
		stopButtonClicked(txtJamMarsBankaltim, txtMenitMarsBankaltim, btnStartMarsBankaltim, btnStopMarsBankaltim);
		triggerMarsBankaltim.stopMarsBankaltim();
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
		txtJamDoaPagi = new IntegerField();
		txtMenitDoaPagi = new IntegerField();
		jLabel10 = new javax.swing.JLabel();
		panelCorporateSong = new javax.swing.JPanel();
		btnStartCorporateSong = new javax.swing.JButton();
		btnStopCorporateSong = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		txtJamCorporateSong = new IntegerField();
		txtMenitCorporateSong = new IntegerField();
		jLabel12 = new javax.swing.JLabel();
		panelMars = new javax.swing.JPanel();
		btnStartMarsBankaltim = new javax.swing.JButton();
		btnStopMarsBankaltim = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		txtJamMarsBankaltim = new IntegerField();
		txtMenitMarsBankaltim = new IntegerField();
		jLabel11 = new javax.swing.JLabel();
		panelCustom = new javax.swing.JPanel();
		btnStartCustom = new javax.swing.JButton();
		btnStopCustom = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		txtJamCustom = new IntegerField();
		txtMenitCustom = new IntegerField(2);
		jLabel13 = new javax.swing.JLabel();
		titlePanel = new javax.swing.JPanel();
		lblTitle = new javax.swing.JLabel();
		lblJamAsar = new JLabel();
		lblJamDzuhur = new JLabel();
		lblDzuhur = new JLabel();
		lblAsar = new JLabel();
		txtJamAsar = new IntegerField();
		txtJamDzuhur = new IntegerField();
		txtMenitAsar = new IntegerField();
		txtMenitDzuhur = new IntegerField();
		btnStartAsar = new JButton();
		btnStartDzuhur = new JButton();
		btnStopAsar = new JButton();
		btnStopDzuhur = new JButton();
		panelDzuhur = new JPanel();
		panelAsar = new JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		mainPanel.setLayout(new java.awt.GridBagLayout());

		panelDoaPagi.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED), "DOA PAGI",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
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

		panelCorporateSong.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED),
						"CORPORATE SONG",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelCorporateSong.setLayout(new java.awt.GridBagLayout());

		btnStartCorporateSong.setText("Start");
		btnStartCorporateSong.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartCorporateSong
				.addActionListener(new java.awt.event.ActionListener() {
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
		btnStopCorporateSong
				.addActionListener(new java.awt.event.ActionListener() {
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
		txtJamCorporateSong
				.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamCorporateSong.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelCorporateSong.add(txtJamCorporateSong, gridBagConstraints);

		txtMenitCorporateSong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitCorporateSong
				.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
				new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED),
				"MARS BANKALTIM",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelMars.setLayout(new java.awt.GridBagLayout());

		btnStartMarsBankaltim.setText("Start");
		btnStartMarsBankaltim.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartMarsBankaltim
				.addActionListener(new java.awt.event.ActionListener() {
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
		btnStopMarsBankaltim
				.addActionListener(new java.awt.event.ActionListener() {
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
		txtJamMarsBankaltim
				.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamMarsBankaltim.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelMars.add(txtJamMarsBankaltim, gridBagConstraints);

		txtMenitMarsBankaltim.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitMarsBankaltim
				.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
				new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED), "Custom",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
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

		panelDzuhur.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED), "Dzuhur",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelDzuhur.setLayout(new java.awt.GridBagLayout());

		btnStartDzuhur.setText("Start");
		btnStartDzuhur.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartDzuhur.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startDzuhurScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelDzuhur.add(btnStartDzuhur, gridBagConstraints);

		btnStopDzuhur.setText("Stop");
		btnStopDzuhur.setEnabled(false);
		btnStopDzuhur.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopDzuhurScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelDzuhur.add(btnStopDzuhur, gridBagConstraints);

		lblDzuhur.setFont(new java.awt.Font("Tahoma", 1, 24));
		lblDzuhur.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDzuhur.add(lblDzuhur, gridBagConstraints);

		txtJamDzuhur.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamDzuhur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamDzuhur.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDzuhur.add(txtJamDzuhur, gridBagConstraints);

		txtMenitDzuhur.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitDzuhur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitDzuhur.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelDzuhur.add(txtMenitDzuhur, gridBagConstraints);

		lblJamDzuhur.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelDzuhur.add(lblJamDzuhur, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		mainPanel.add(panelDzuhur, gridBagConstraints);
		
		panelAsar.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(
						javax.swing.border.BevelBorder.RAISED), "Asar",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14))); // NOI18N
		panelAsar.setLayout(new java.awt.GridBagLayout());

		btnStartAsar.setText("Start");
		btnStartAsar.setPreferredSize(new java.awt.Dimension(57, 35));
		btnStartAsar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startAsarScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelAsar.add(btnStartAsar, gridBagConstraints);

		btnStopAsar.setText("Stop");
		btnStopAsar.setEnabled(false);
		btnStopAsar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopAsarScheduler();
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		panelAsar.add(btnStopAsar, gridBagConstraints);

		lblAsar.setFont(new java.awt.Font("Tahoma", 1, 24));
		lblAsar.setText(":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelAsar.add(lblAsar, gridBagConstraints);

		txtJamAsar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtJamAsar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtJamAsar.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelAsar.add(txtJamAsar, gridBagConstraints);

		txtMenitAsar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		txtMenitAsar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtMenitAsar.setPreferredSize(new java.awt.Dimension(50, 45));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		panelAsar.add(txtMenitAsar, gridBagConstraints);

		lblJamAsar.setText("Jam :");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		panelAsar.add(lblJamAsar, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		mainPanel.add(panelAsar, gridBagConstraints);

		getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

		titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,
				10, 5));

		lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		lblTitle.setText("Task Scheduler");
		titlePanel.add(lblTitle);

		getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

		pack();
		setLocationRelativeTo(null);
	}

	private javax.swing.JButton btnStartCorporateSong;
	private javax.swing.JButton btnStartCustom;
	private javax.swing.JButton btnStartDoaPagi;
	private javax.swing.JButton btnStartMarsBankaltim;
	private javax.swing.JButton btnStartDzuhur;
	private javax.swing.JButton btnStartAsar;
	private javax.swing.JButton btnStopCorporateSong;
	private javax.swing.JButton btnStopCustom;
	private javax.swing.JButton btnStopDoaPagi;
	private javax.swing.JButton btnStopMarsBankaltim;
	private javax.swing.JButton btnStopDzuhur;
	private javax.swing.JButton btnStopAsar;
	private javax.swing.JLabel lblJamAsar;
	private javax.swing.JLabel lblJamDzuhur;
	private JLabel lblDzuhur;
	private JLabel lblAsar;
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
	private javax.swing.JPanel panelDzuhur;
	private javax.swing.JPanel panelAsar;
	private javax.swing.JPanel panelDoaPagi;
	private javax.swing.JPanel panelMars;
	private javax.swing.JPanel titlePanel;
	private IntegerField txtJamCorporateSong;
	private IntegerField txtJamCustom;
	private IntegerField txtJamDoaPagi;
	private IntegerField txtJamMarsBankaltim;
	private IntegerField txtMenitCorporateSong;
	private IntegerField txtMenitCustom;
	private IntegerField txtMenitDoaPagi;
	private IntegerField txtMenitMarsBankaltim;
	private IntegerField txtJamDzuhur;
	private IntegerField txtMenitDzuhur;
	private IntegerField txtJamAsar;
	private IntegerField txtMenitAsar;
}
