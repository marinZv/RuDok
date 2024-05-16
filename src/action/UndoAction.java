package action;

import application.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{

    public UndoAction(){
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
        putValue(SMALL_ICON, loadIcon("undo.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
