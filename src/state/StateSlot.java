package state;

import gui.panes.SlideView;
import model.workspace.SlotType;

import java.awt.*;

public interface StateSlot {

    public void onMousePressed(Point point, Dimension dimension, Color color, Stroke stroke, SlideView slideView, SlotType slotType);
    public void onMouseDragged(Point currentPoint,Point nextPoint ,SlideView slideView);
    public void onMouseReleased();

}
