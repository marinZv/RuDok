package action;

import gui.panes.MouseController;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DashedStrokeAction extends AbstractRudokAction{

    private Stroke stroke;
    private MouseController mouseController;

    public DashedStrokeAction(){
        putValue(NAME, "Dashed stroke");
        putValue(SHORT_DESCRIPTION, "Dashed stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        //mouseController = new MouseController();
        //mouseController.setStroke(stroke);

    }

    public Stroke getStroke() {
        return stroke;
    }
}
