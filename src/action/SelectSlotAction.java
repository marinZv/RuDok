package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import java.awt.event.ActionEvent;

public class SelectSlotAction extends AbstractRudokAction{

    public SelectSlotAction(){

        putValue(NAME, "Select slot");
        putValue(SHORT_DESCRIPTION, "Select slot");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startSelectSlotState();

    }
}
