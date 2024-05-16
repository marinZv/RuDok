package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorSpaceAction extends AbstractRudokAction{

    private Color color;

    public ColorSpaceAction(){
        putValue(NAME, "Color Space");
        putValue(SHORT_DESCRIPTION, "Color Space");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        color = JColorChooser.showDialog(null, "Pick a color for space", Color.black);

    }

    public Color getColor() {
        return color;
    }
}
