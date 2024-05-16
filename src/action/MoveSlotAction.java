package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import java.awt.event.ActionEvent;

public class MoveSlotAction extends AbstractRudokAction{

    public MoveSlotAction(){
        putValue(NAME, "Move slot");
        putValue(SHORT_DESCRIPTION, "Move slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startMoveSlotState();
    }
}
