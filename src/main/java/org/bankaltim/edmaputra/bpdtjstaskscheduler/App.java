package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App implements Runnable {
	
	private MainFrame form;
//	private Song song;

    public App() {
        form = new MainFrame();
//    	song = new Song();
//    	song.playMp3File(DefaultValue.corporateSongDir);
    }

    public void start() {
        SwingUtilities.invokeLater(this);
    }

//    @Override
    public void run() {
        form.setVisible(true);
//        LoginView view = new LoginView(form);
//        view.display(form, null);
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
