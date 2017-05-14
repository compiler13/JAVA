package aigame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class TimeForPc extends Thread {
    
    /*

    public void run() {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            Logger.getLogger(TimeForPc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    */
    
    TimeForPc() {

        final JOptionPane msg = new JOptionPane("PC is Thinking");
        final JDialog dlg = msg.createDialog(" ");
        //dlg.setAlwaysOnTop(true);
        //dlg.setSize(new Dimension(200,80));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        dlg.setLocation(450,545);
        
        dlg.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                final Timer t = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dlg.setVisible(false);
                    }
                });
                t.start();
                //t.join();
            }
        });
        dlg.setVisible(true);

    }
}
