package action;

import model.workspace.SlotType;

import java.awt.event.ActionEvent;

public class SlotMultimedia extends AbstractRudokAction {

    private SlotType slotType;
    private boolean pressed;

    public SlotMultimedia(){

        putValue(NAME, "Slot multimedia");
        putValue(SHORT_DESCRIPTION, "Slot multimedia");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        slotType = SlotType.slot_multimedia;
        pressed = true;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}
