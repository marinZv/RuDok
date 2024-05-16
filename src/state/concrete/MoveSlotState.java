package state.concrete;

import gui.panes.SlideView;
import model.workspace.Slide;
import model.workspace.Slot;
import model.workspace.SlotType;
import state.StateSlot;

import java.awt.*;
import java.io.Serializable;

public class MoveSlotState implements StateSlot, Serializable {


    @Override
    public void onMousePressed(Point point, Dimension dimension, Color color, Stroke stroke, SlideView slideView, SlotType slotType) {

    }

    @Override
    public void onMouseDragged(Point currentPoint,Point nextPoint ,SlideView slideView) {

        //SlotView slotView = slideView.returnSlotView(currentPoint);

        //Slide slide = slideView.getSlide();
        //Slot slot = slide.getSlot(currentPoint);


        Slide slide = slideView.getSlide();
        Slot slot = slide.getSelectedSlot();
        slide.changeSlotPosition(slot, nextPoint);

        //slide.changeSlotPosition(slot, currentPoint);
        //slotView.setLocation(nextPoint);
        //slotView.setLocation(nextPoint.x, nextPoint.y);
       // slotView.setTransferHandler(new TransferHandler());

        //slotView.getSlot().setPoint(nextPoint);
        //slideView.getSlide().changeSlotPosition(slotView.getSlot(), nextPoint);
        //System.out.println(currentPoint);
        //System.out.println(nextPoint);
    }

    @Override
    public void onMouseReleased() {

    }
}
