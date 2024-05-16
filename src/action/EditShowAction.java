package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import java.awt.event.ActionEvent;

public class EditShowAction extends AbstractRudokAction{

    public EditShowAction(){

        putValue(NAME, "Edit Show");
        putValue(SHORT_DESCRIPTION, "Edit show");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startEditShow();
        ((ProjectTab) MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().changeView();


    }
}
