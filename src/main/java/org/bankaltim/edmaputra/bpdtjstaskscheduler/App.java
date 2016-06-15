package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App implements Runnable {
	
//	private MainFrame form;
//	private CobaScheduler coba;
//	private CobaFrame cobaFrame;
	private NewMainFrame frame;

    public App() {
//        form = new MainFrame();
        frame = new NewMainFrame();
//    	coba = new CobaScheduler();
//    	cobaFrame = new CobaFrame();
    }

    public void start() {
        SwingUtilities.invokeLater(this);
    }

//    @Override
    public void run() {
//        form.setVisible(true);
        frame.setVisible(true);
//    	cobaFrame.setSize(new Dimension(500,300));
//    	cobaFrame.setVisible(true);
    	
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            // run app
            App app = new App();
            app.start();
        }
    }

}
