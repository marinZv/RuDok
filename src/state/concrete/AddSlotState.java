package state.concrete;

import gui.panes.SlideView;
import gui.panes.SlotView;
import model.workspace.Slide;
import model.workspace.Slot;
import model.workspace.SlotType;
import state.StateSlot;

import java.awt.*;
import java.io.Serializable;

public class AddSlotState implements StateSlot, Serializable {


    @Override
    public void onMousePressed(Point point, Dimension dimension, Color colorStroke, Stroke stroke, SlideView slideView, SlotType slotType) {

        Slide slide = slideView.getSlide();

        Slot slot = new Slot(point, dimension, colorStroke, stroke, slotType);
        SlotView slotView = new SlotView(slot);

        //slide.getSlots().add(slot);
        slide.addSlot(slot);

        slideView.getSlotViews().add(slotView);
        //slideView.addSlotView(slotView);


        System.out.println(slide.getSlots().size());
        System.out.println(slideView.getSlotViews().size());

        System.out.println(slot.getColor());

    }

    @Override
    public void onMouseDragged(Point currentPoint, Point nextPoint, SlideView slideView) {

    }

    @Override
    public void onMouseReleased() {

    }
}
