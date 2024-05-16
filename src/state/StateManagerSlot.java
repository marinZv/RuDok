package state;

import state.concrete.AddSlotState;
import state.concrete.MoveSlotState;
import state.concrete.RemoveSlotState;
import state.concrete.SelectSlotState;

import java.io.Serializable;

public class StateManagerSlot implements Serializable {

    private AddSlotState addSlotState;
    private RemoveSlotState removeSlotState;
    private MoveSlotState moveSlotState;
    private SelectSlotState selectSlotState;
    private StateSlot currentSlotState;

    public StateManagerSlot(){
        this.addSlotState = new AddSlotState();
        this.removeSlotState = new RemoveSlotState();
        this.moveSlotState = new MoveSlotState();
        this.selectSlotState = new SelectSlotState();
        currentSlotState = addSlotState;
    }

    public void setAddSlotState() {
        this.currentSlotState = addSlotState;
    }

    public void setMoveSlotState() {
        this.currentSlotState = moveSlotState;
    }

    public void setRemoveSlotState() {
        this.currentSlotState = removeSlotState;
    }

    public void setSelectSlotState() {
        this.currentSlotState = selectSlotState;
    }

    public StateSlot getCurrentSlotState() {
        return currentSlotState;
    }
}
