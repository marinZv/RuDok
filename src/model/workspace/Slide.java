package model.workspace;

import model.workspace.nodes.RuNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode {

    private int count;
    private List<Slot> slots;

    public Slide(){
        slots = new ArrayList<>();
    }

    public Slide(String name, RuNode parent) {
        super(name, parent);
        slots = new ArrayList<>();
    }

    public void addSlot(Slot slot){
        this.slots.add(slot);
        notifySubscribers(this);
    }

    public void removeSlot(Point point){

        Slot sl = null;

        for(Slot s : this.slots){
            if(s.getPoint().x <= point.x && (s.getPoint().x + s.getDimension().getWidth() >= point.x)
            && (s.getPoint().y <= point.y && (s.getPoint().y + s.getDimension().getHeight()) >= point.y)){

                sl = s;
                break;
            }
        }

        if(sl != null){
            this.slots.remove(sl);
        }


        //System.out.println(slots.size());
        notifySubscribers(this);
    }


    public Slot getSlot(Point point){
        Slot sl = null;
        for(Slot s : this.slots){
            if(s.getPoint().x <= point.x && (s.getPoint().x + s.getDimension().getWidth() >= point.x)
                    && (s.getPoint().y <= point.y && (s.getPoint().y + s.getDimension().getHeight()) >= point.y)){

                sl = s;
                break;
            }
        }
        return sl;
    }

    public void setSelectedSlot(Point point){

        for(Slot s : this.slots){
            if(s.isSelected() == true){
                s.setSelected(false);
            }
        }

        for(Slot s : this.slots){
            if(s.getPoint().x <= point.x && (s.getPoint().x + s.getDimension().getWidth() >= point.x)
                    && (s.getPoint().y <= point.y && (s.getPoint().y + s.getDimension().getHeight()) >= point.y)){

                s.setSelected(true);
                break;
            }
        }

    }

    public Slot getSelectedSlot(){

        for(Slot s : this.slots){
            if(s.isSelected()){
                return s;
            }
        }

        return null;
    }

    public void changeSlotPosition(Slot slot, Point point){
        slot.setPoint(point);
        notifySubscribers(this);
    }

    @Override
    public String toString(){
        return "Slide";
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
