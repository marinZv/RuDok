package action;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SolidStrokeAction extends AbstractRudokAction{

    Stroke stroke;

    public void SolidStrokeAction(){
        putValue(NAME, "Solid stroke");
        putValue(SHORT_DESCRIPTION, "Solid stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        stroke = new BasicStroke();

    }
}
