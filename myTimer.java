import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class myTimer extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        JDialog dialog1 = new ourdialog();
        dialog1.setVisible(true);
    }

}
