package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewMainFrame extends JFrame {

	private static final long serialVersionUID = 2534689276808583670L;
	
	public NewMainFrame(){
		initComponents();
		this.setTitle("BPD Kaltim Tanjung Selor Task Scheduler");
	}
	
	private void openNewScheduleDialog(){
//		NewScheduleDialog newScheduleDialog = new NewScheduleDialog(this, true);
//		newScheduleDialog.setParent(this);
//		newScheduleDialog.setVisible(true);
		
		
		dialog = new JDialog(this, true);
		initDialogComponents();		
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	
	}
	
	private void tambahTask(){
		MainPanel mpnl = new MainPanel(txtNamaSchedule.getText());
		mainPanel.add(mpnl);
		System.out.println("Add Panel");
		dialog.dispose();
	}
	
	private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainPanel1 = new MainPanel("Doa Pagi");
        mainPanel2 = new MainPanel("Corporate Song 1");
        mainPanel3 = new MainPanel("Mars Bankaltim");
        mainPanel4 = new MainPanel("Corporate Song 2");
        mainPanel5 = new MainPanel("Dzuhur");
        mainPanel6 = new MainPanel("Asar");
        mainPanel7 = new MainPanel("Custom 1");
        mainPanel8 = new MainPanel("Custom 2");
        mainPanel9 = new MainPanel("Custom 3");
//        titlePanel = new javax.swing.JPanel();
//        lblTitle = new javax.swing.JLabel();
//        jMenuBar1 = new javax.swing.JMenuBar();
//        mnuSchdule = new javax.swing.JMenu();
//        mnuItemScheduleBaru = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.GridLayout(3, 3, 1, 1));
        
        mainPanel.add(mainPanel1);
        mainPanel.add(mainPanel2);
        mainPanel.add(mainPanel4);
        mainPanel.add(mainPanel3);
        mainPanel.add(mainPanel5);
        mainPanel.add(mainPanel6);
        mainPanel.add(mainPanel7);
        mainPanel.add(mainPanel8);
        mainPanel.add(mainPanel9);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

//        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

//        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
//        lblTitle.setText("Task Scheduler");
//        titlePanel.add(lblTitle);

//        getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

//        mnuSchdule.setText("Schedule");
//
//        mnuItemScheduleBaru.setText("Baru");
//        mnuItemScheduleBaru.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                openNewScheduleDialog();
//            }
//        });
//        mnuSchdule.add(mnuItemScheduleBaru);
//
//        jMenuBar1.add(mnuSchdule);
//
//        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	private void initDialogComponents() {
//		dialogPanel = new JPanel();
		lblTitle = new javax.swing.JLabel();
		lblNama = new javax.swing.JLabel();
		txtNamaSchedule = new javax.swing.JTextField();
		btnOK = new javax.swing.JButton();
		btnBatal = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		lblTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblTitle.setText("Scheduler Baru");

		lblNama.setText("Nama");

		btnOK.setText("OK");
		btnOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				ok();
				tambahTask();
			}
		});

		btnBatal.setText("Batal");
		btnBatal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dialog.dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(dialog.getContentPane());
		dialog.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(lblTitle).addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(lblNama)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtNamaSchedule))
						.addGroup(layout.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101,
										Short.MAX_VALUE)
								.addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnBatal)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap().addComponent(lblTitle)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblNama)
						.addComponent(txtNamaSchedule, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnBatal)
						.addComponent(btnOK))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
		dialog.setSize(350, 140);
		dialog.setTitle("BPD Kaltim Tanjung Selor Task Scheduler");
	}
	
	private MainPanel mainPanel1;
	private MainPanel mainPanel2;
	private MainPanel mainPanel3;
	private MainPanel mainPanel4;
	private MainPanel mainPanel5;
	private MainPanel mainPanel6;
	private MainPanel mainPanel7;
	private MainPanel mainPanel8;
	private MainPanel mainPanel9;
//    private javax.swing.JMenuBar jMenuBar1;
//    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel mainPanel;
//    private javax.swing.JMenuItem mnuItemScheduleBaru;
//    private javax.swing.JMenu mnuSchdule;
//    private javax.swing.JPanel titlePanel;
    
    private javax.swing.JButton btnBatal;
	private javax.swing.JButton btnOK;
	private javax.swing.JLabel lblTitle;
	private javax.swing.JLabel lblNama;
	private javax.swing.JTextField txtNamaSchedule;
//	private JPanel dialogPanel;
	private JDialog dialog;
}
