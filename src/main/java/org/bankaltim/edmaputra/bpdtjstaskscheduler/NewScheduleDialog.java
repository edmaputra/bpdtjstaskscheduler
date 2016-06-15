package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class NewScheduleDialog extends JDialog {

	private static final long serialVersionUID = -4012739574279410359L;
	private NewMainFrame parent;

	public NewScheduleDialog(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}
	
	private void ok(){
		if (!txtNamaSchedule.getText().trim().isEmpty()){
			String newSchedule = txtNamaSchedule.getText();
			MainPanel newPanel = new MainPanel(newSchedule);
			parent.add(newPanel);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Harap Isi Nama Schedule");
		}		
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtNamaSchedule = new javax.swing.JTextField();
		btnOK = new javax.swing.JButton();
		btnBatal = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel1.setText("Scheduler Baru");

		jLabel2.setText("Nama");

		btnOK.setText("OK");
		btnOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ok();
			}
		});

		btnBatal.setText("Batal");
		btnBatal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
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
				.createSequentialGroup().addContainerGap().addComponent(jLabel1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(txtNamaSchedule, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnBatal)
						.addComponent(btnOK))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	public NewMainFrame getParent() {
		return parent;
	}
	

	public void setParent(NewMainFrame parent) {
		this.parent = parent;
	}
	

	private javax.swing.JButton btnBatal;
	private javax.swing.JButton btnOK;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField txtNamaSchedule;

}
