package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JFrame;

public class NewMainFrame extends JFrame {

	private static final long serialVersionUID = 2534689276808583670L;
	
	public NewMainFrame(){
		initComponents();
		this.setTitle("BPD Kaltim Tanjung Selor Task Scheduler");
	}
	
	private void openNewScheduleDialog(){
		NewScheduleDialog newScheduleDialog = new NewScheduleDialog(this, true);
		newScheduleDialog.setParent(this);
		newScheduleDialog.setVisible(true);
	}
	
	private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainPanel1 = new MainPanel("Doa Pagi");
        mainPanel2 = new MainPanel("Corporate Song 1");
        mainPanel3 = new MainPanel("Mars Bankaltim");
        mainPanel4 = new MainPanel("Corporate Song 2");
        mainPanel5 = new MainPanel("Dzuhur");
        mainPanel6 = new MainPanel("Asar");
        mainPanel7 = new MainPanel("Custom");
//        titlePanel = new javax.swing.JPanel();
//        lblTitle = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuSchdule = new javax.swing.JMenu();
        mnuItemScheduleBaru = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.GridLayout(3, 3, 1, 1));
        
        mainPanel.add(mainPanel1);
        mainPanel.add(mainPanel2);
        mainPanel.add(mainPanel4);
        mainPanel.add(mainPanel3);
        mainPanel.add(mainPanel5);
        mainPanel.add(mainPanel6);
        mainPanel.add(mainPanel7);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

//        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

//        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
//        lblTitle.setText("Task Scheduler");
//        titlePanel.add(lblTitle);

//        getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);

        mnuSchdule.setText("Schedule");

        mnuItemScheduleBaru.setText("Baru");
        mnuItemScheduleBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openNewScheduleDialog();
            }
        });
        mnuSchdule.add(mnuItemScheduleBaru);

        jMenuBar1.add(mnuSchdule);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	private MainPanel mainPanel1;
	private MainPanel mainPanel2;
	private MainPanel mainPanel3;
	private MainPanel mainPanel4;
	private MainPanel mainPanel5;
	private MainPanel mainPanel6;
	private MainPanel mainPanel7;
    private javax.swing.JMenuBar jMenuBar1;
//    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem mnuItemScheduleBaru;
    private javax.swing.JMenu mnuSchdule;
//    private javax.swing.JPanel titlePanel;
}
