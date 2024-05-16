package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import java.awt.event.ActionEvent;

public class AddSlotAction extends AbstractRudokAction{

    public AddSlotAction(){
        putValue(NAME, "Add slot");
        putValue(SHORT_DESCRIPTION, "Add slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startAddSlotState();
    }
}
