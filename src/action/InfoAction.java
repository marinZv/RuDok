package action;

import dialogs.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRudokAction {

    public InfoAction(){
        putValue(NAME, "Info");
        putValue(SMALL_ICON,loadIcon("infoIcon.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setVisible(true);
    }
}
