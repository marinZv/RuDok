package state.concrete;

import gui.panes.SlideView;
import model.workspace.Slide;
import model.workspace.SlotType;
import state.StateSlot;

import java.awt.*;
import java.io.Serializable;

public class RemoveSlotState implements StateSlot, Serializable {


    @Override
    public void onMousePressed(Point point, Dimension dimension, Color color, Stroke stroke, SlideView slideView, SlotType slotType) {

        Slide slide = slideView.getSlide();

        //Slot slot = new Slot(point, dimension, color, stroke);

        slide.removeSlot(point);
        //slide.getSlots().remove(slot);
        System.out.println("slide slots size: " + slide.getSlots().size());
        System.out.println("slide view slots size: " + slideView.getSlotViews().size());
    }

    @Override
    public void onMouseDragged(Point currentPoint, Point nextPoint, SlideView slideView) {

    }

    @Override
    public void onMouseReleased() {

    }

}
