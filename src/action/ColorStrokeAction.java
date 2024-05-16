package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorStrokeAction extends AbstractRudokAction{

    private Color color;

    public ColorStrokeAction(){
        putValue(NAME, "Color stroke");
        putValue(SHORT_DESCRIPTION, "Color stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //JColorChooser jColorChooser = new JColorChooser();

        color = JColorChooser.showDialog(null, "Pick a color", Color.black);

    }

    public Color getColor() {
        return color;
    }
}
