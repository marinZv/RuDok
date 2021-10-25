package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRudokAction {


    public NewAction(){
        putValue(NAME, "New");
        putValue(SMALL_ICON, loadIcon("newIcon.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
