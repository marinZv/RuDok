package gui.panes;

import application.MainFrame;
import errors.ErrorFactory;
import gui.tree.model.MyTreeNode;
import model.workspace.Project;
import model.workspace.SlotType;
import model.workspace.Workspace;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {

    private Color colorStroke;
    private Color colorSpace;
    private Stroke stroke;

    private Point currentPoint;

    private SlotType slotType;

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        PresentationView presentationView = ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView();

        Dimension dimension = new Dimension(100, 50);
        colorStroke = MainFrame.getInstance().getActionManager().getColorStrokeAction().getColor();
        colorSpace = MainFrame.getInstance().getActionManager().getColorSpaceAction().getColor();

        Point point = e.getPoint();
        currentPoint = point;
        Object obj = e.getSource();

        int lineWidht;

        if(presentationView.getPresentationToolBar().getTextField().getText().isEmpty()){
            ErrorFactory.getInstance().generateError("Morate uneti debljinu okvira slota!");
            return;
           // lineWidht = 3;
        }else{
            lineWidht = Integer.parseInt(presentationView.getPresentationToolBar().getTextField().getText());
        }

        if(presentationView.getPresentationToolBar().getTypeOfStroke().equals("Dashed stroke")){
            stroke = new BasicStroke(lineWidht, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        }else{
            stroke = new BasicStroke(lineWidht);
        }

        if(MainFrame.getInstance().getActionManager().getSlotTekst().isPressed()){
            slotType = SlotType.slot_tekst;
            MainFrame.getInstance().getActionManager().getSlotTekst().setPressed(false);
        }else{
            slotType = SlotType.slot_multimedia;
            MainFrame.getInstance().getActionManager().getSlotMultimedia().setPressed(false);
        }

        if(obj instanceof SlideView){
            SlideView slideView = (SlideView) obj;
            presentationView.onMousePressed(point, dimension, colorStroke, stroke, slideView, slotType);
        }


        System.out.println(presentationView.getPresentationToolBar().getTextField().getText());
        System.out.println(lineWidht);

        ((Project)presentationView.getPresentation().getParent()).setChanged(true);
        Workspace workspace = ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode());
        workspace.setChanged(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        PresentationView presentationView = ((ProjectTab)MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView();

        Object obj = e.getSource();

        SlideView slideView = (SlideView) obj;
        //SlideView slideView = null;
        /*
        if((obj != null) && (obj instanceof SlideView)){
            slideView = (SlideView) obj;
            presentationView.onMouseDragged(e.getPoint(), slideView);
        }

         */

        Point nextPoint = e.getPoint();

        System.out.println(currentPoint);
        System.out.println(nextPoint);

        presentationView.onMouseDragged(currentPoint,nextPoint, slideView);


        System.out.println("Usao sam u mouse dragged u kontoleru");

        ((Project)presentationView.getPresentation().getParent()).setChanged(true);
        Workspace workspace = ((Workspace) ((MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot()).getRuNode());
        workspace.setChanged(true);
        presentationView.getPresentation().setChanged(true);


    }

    public void setColor(Color color) {
        this.colorStroke = color;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
}
