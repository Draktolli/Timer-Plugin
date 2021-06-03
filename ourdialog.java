import com.intellij.openapi.ui.Messages;
import org.jdesktop.swingx.JXTextField;


import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class ourdialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JXTextField textField1;
    private JXTextField textField2;
    private JXTextField textField3;

    public ourdialog() {
        setContentPane(contentPane);
        setSize(400, 200);
        setLocation(800, 400);
        textField1.setPrompt("Hours");
        textField2.setPrompt("Minutes");
        textField3.setPrompt("Type your message here");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String hour = textField1.getText();
        String minute = textField2.getText();
        int minutes = 1000*60;
        int hour1 = Integer.parseInt(hour);
        if (textField1.getText().equals("")){
            hour1 = 0;
        }
        int hourMinutes = hour1*60;
        int minute1 = Integer.parseInt(minute);
        int delay = (hourMinutes + minute1) * minutes;
        TimerTask ourTask = new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, textField3.getText());
            }
        };
        Timer timer = new Timer();
        timer.schedule(ourTask, delay);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ourdialog dialog = new ourdialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
