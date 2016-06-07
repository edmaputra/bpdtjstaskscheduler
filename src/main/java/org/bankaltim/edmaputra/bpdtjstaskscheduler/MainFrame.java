package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -5461558103154462195L;
	
	public MainFrame() {
		initComponents();
	}
	
	private void initComponents(){
		java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        panelDoaPagi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFileDoaPagi = new javax.swing.JTextField();
        btnBrowseDoaPagi = new javax.swing.JButton();
        btnStartDoaPagi = new javax.swing.JButton();
        btnStopDoaPagi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtJamDoaPagi = new javax.swing.JTextField();
        txtMenitDoaPagi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        panelCorporateSong = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFileCorporateSong = new javax.swing.JTextField();
        btnBrowseCorporateSong = new javax.swing.JButton();
        btnStartCorporateSong = new javax.swing.JButton();
        btnStopCorporateSong = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtJamCorporateSong = new javax.swing.JTextField();
        txtMenitCorporateSong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        panelMars = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFileMarsBankaltim = new javax.swing.JTextField();
        btnBrowseMarsBankaltim = new javax.swing.JButton();
        btnStartMarsBankaltim = new javax.swing.JButton();
        btnStopMarsBankaltim = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtJamMarsBankaltim = new javax.swing.JTextField();
        txtMenitMarsBankaltim = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        panelCustom = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFileCustom = new javax.swing.JTextField();
        btnBrowseCustom = new javax.swing.JButton();
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

        panelDoaPagi.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "DOA PAGI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelDoaPagi.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("File :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelDoaPagi.add(jLabel2, gridBagConstraints);

        txtFileDoaPagi.setPreferredSize(new java.awt.Dimension(170, 30));
        txtFileDoaPagi.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelDoaPagi.add(txtFileDoaPagi, gridBagConstraints);

        btnBrowseDoaPagi.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDoaPagi.add(btnBrowseDoaPagi, gridBagConstraints);

        btnStartDoaPagi.setText("Start");
        btnStartDoaPagi.setPreferredSize(new java.awt.Dimension(57, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelDoaPagi.add(btnStartDoaPagi, gridBagConstraints);

        btnStopDoaPagi.setText("Stop");
        btnStopDoaPagi.setEnabled(false);
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

        panelCorporateSong.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "CORPORATE SONG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelCorporateSong.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("File :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelCorporateSong.add(jLabel4, gridBagConstraints);

        txtFileCorporateSong.setPreferredSize(new java.awt.Dimension(170, 30));
        txtFileCorporateSong.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelCorporateSong.add(txtFileCorporateSong, gridBagConstraints);

        btnBrowseCorporateSong.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCorporateSong.add(btnBrowseCorporateSong, gridBagConstraints);

        btnStartCorporateSong.setText("Start");
        btnStartCorporateSong.setPreferredSize(new java.awt.Dimension(57, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelCorporateSong.add(btnStartCorporateSong, gridBagConstraints);

        btnStopCorporateSong.setText("Stop");
        btnStopCorporateSong.setEnabled(false);
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

        panelMars.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "MARS BANKALTIM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelMars.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("File :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelMars.add(jLabel6, gridBagConstraints);

        txtFileMarsBankaltim.setPreferredSize(new java.awt.Dimension(170, 30));
        txtFileMarsBankaltim.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelMars.add(txtFileMarsBankaltim, gridBagConstraints);

        btnBrowseMarsBankaltim.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelMars.add(btnBrowseMarsBankaltim, gridBagConstraints);

        btnStartMarsBankaltim.setText("Start");
        btnStartMarsBankaltim.setPreferredSize(new java.awt.Dimension(57, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelMars.add(btnStartMarsBankaltim, gridBagConstraints);

        btnStopMarsBankaltim.setText("Stop");
        btnStopMarsBankaltim.setEnabled(false);
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

        panelCustom.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Custom", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelCustom.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("File :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelCustom.add(jLabel8, gridBagConstraints);

        txtFileCustom.setPreferredSize(new java.awt.Dimension(170, 30));
        txtFileCustom.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelCustom.add(txtFileCustom, gridBagConstraints);

        btnBrowseCustom.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelCustom.add(btnBrowseCustom, gridBagConstraints);

        btnStartCustom.setText("Start");
        btnStartCustom.setPreferredSize(new java.awt.Dimension(57, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelCustom.add(btnStartCustom, gridBagConstraints);

        btnStopCustom.setText("Stop");
        btnStopCustom.setEnabled(false);
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

	private javax.swing.JButton btnBrowseCorporateSong;
    private javax.swing.JButton btnBrowseCustom;
    private javax.swing.JButton btnBrowseDoaPagi;
    private javax.swing.JButton btnBrowseMarsBankaltim;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelCorporateSong;
    private javax.swing.JPanel panelCustom;
    private javax.swing.JPanel panelDoaPagi;
    private javax.swing.JPanel panelMars;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField txtFileCorporateSong;
    private javax.swing.JTextField txtFileCustom;
    private javax.swing.JTextField txtFileDoaPagi;
    private javax.swing.JTextField txtFileMarsBankaltim;
    private javax.swing.JTextField txtJamCorporateSong;
    private javax.swing.JTextField txtJamCustom;
    private javax.swing.JTextField txtJamDoaPagi;
    private javax.swing.JTextField txtJamMarsBankaltim;
    private javax.swing.JTextField txtMenitCorporateSong;
    private javax.swing.JTextField txtMenitCustom;
    private javax.swing.JTextField txtMenitDoaPagi;
    private javax.swing.JTextField txtMenitMarsBankaltim;

}
