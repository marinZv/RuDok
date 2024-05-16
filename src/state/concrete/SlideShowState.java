package state.concrete;

import gui.panes.PresentationView;
import state.State;

import java.awt.*;
import java.io.Serializable;

public class SlideShowState implements State, Serializable {

    //JToolBar toolBarSlideShow;

    @Override
    public void changeView(PresentationView presentationView) {


        //presentationView.remove(presentationView.getSlideShowToolBar());
        presentationView.removeAll();

        //JToolBar toolBar = presentationView.getSlideShowToolBar();
        //toolBar.removeAll();


        //toolBar.add(MainFrame.getInstance().getActionManager().getEditShowAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getPreviousSlideAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getNextSlideAction());

        presentationView.add(presentationView.getSlideShowToolBar(), BorderLayout.NORTH);
        presentationView.add(presentationView.getSlideShowPane(), BorderLayout.CENTER);

        presentationView.revalidate();

    }
}
