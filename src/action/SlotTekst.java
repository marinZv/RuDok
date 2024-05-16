package action;

import model.workspace.SlotType;

import java.awt.event.ActionEvent;

public class SlotTekst extends AbstractRudokAction{

    private SlotType slotType;
    private boolean pressed;

    public SlotTekst(){

        putValue(NAME, "Slot type");
        putValue(SHORT_DESCRIPTION, "Slot type");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        slotType = SlotType.slot_tekst;
        pressed = true;

    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
}
