package action;

import application.MainFrame;
import gui.panes.ProjectTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SlideShowAction extends AbstractRudokAction{

    public SlideShowAction(){

        putValue(NAME, "SlideShow");
        putValue(SMALL_ICON, loadIcon("slideShow.png"));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SHORT_DESCRIPTION, "Slide show");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().startSlideShow();
        ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView().changeView();

    }
}
