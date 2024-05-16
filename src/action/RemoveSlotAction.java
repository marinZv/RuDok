package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import java.awt.event.ActionEvent;

public class RemoveSlotAction extends  AbstractRudokAction{


    public RemoveSlotAction(){
        putValue(NAME, "Remove slot");
        putValue(SHORT_DESCRIPTION, "Remove slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startRemoveSlotState();
    }
}
