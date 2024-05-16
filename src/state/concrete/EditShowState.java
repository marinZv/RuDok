package state.concrete;

import gui.panes.PresentationView;
import state.State;

import java.awt.*;
import java.io.Serializable;

public class EditShowState implements State, Serializable {


    @Override
    public void changeView(PresentationView presentationView) {

        //JToolBar toolBar = presentationView.getPresentationToolBar();
        //toolBar.removeAll();

        //presentationView.remove(presentationView.getPresentationToolBar());
        presentationView.removeAll();

        //toolBar.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getAddSlotAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getRemoveSlotAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        //toolBar.add(MainFrame.getInstance().getActionManager().getColorStrokeAction());


        presentationView.add(presentationView.getPresentationToolBar(), BorderLayout.NORTH);
        presentationView.add(presentationView.getPanel(), BorderLayout.CENTER);
        presentationView.add(presentationView.getNavigatorPane(), BorderLayout.WEST);

        presentationView.revalidate();

    }
}
