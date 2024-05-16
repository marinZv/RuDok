package state.concrete;

import gui.panes.SlideView;
import model.workspace.Slide;
import model.workspace.SlotType;
import state.StateSlot;

import java.awt.*;
import java.io.Serializable;

public class SelectSlotState implements StateSlot, Serializable {


    @Override
    public void onMousePressed(Point point, Dimension dimension, Color color, Stroke stroke, SlideView slideView, SlotType slotType) {

        Slide slide = slideView.getSlide();

        slide.setSelectedSlot(point);

    }

    @Override
    public void onMouseDragged(Point currentPoint, Point nextPoint, SlideView slideView) {

    }

    @Override
    public void onMouseReleased() {

    }
}
