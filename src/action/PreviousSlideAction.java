package action;

import application.MainFrame;
import gui.panes.PresentationView;
import gui.panes.ProjectTab;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PreviousSlideAction extends AbstractRudokAction{

    public PreviousSlideAction(){

        putValue(NAME, "<<-");
        putValue(SHORT_DESCRIPTION, "Previous slide");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        PresentationView presentationView = ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView();

        CardLayout cardLayout = (CardLayout) presentationView.getSlideShowPane().getLayout();
        cardLayout.previous(presentationView.getSlideShowPane());

    }
}
