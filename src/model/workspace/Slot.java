package model.workspace;

import gui.panes.SerializableStrokeAdapter;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slot implements Serializable {

    private Point point;
    private Dimension dimension;
    private Color color;
    //private Stroke stroke;
    private SerializableStrokeAdapter serializableStrokeAdapter;
    private boolean selected;
    private SlotType slotType;
    private String text;
    private String imagePath;
    private List<String> strings = new ArrayList<>();

    public Slot(Point point, Dimension dimension, Color color, Stroke stroke, SlotType slotType){
         this.point = point;
         this.dimension = dimension;
         this.color = color;
         this.serializableStrokeAdapter = new SerializableStrokeAdapter(stroke);
         //this.serializableStrokeAdapter.setStroke(stroke);
         this.selected = false;
         this.slotType = slotType;
    }


    public Point getPoint() {
        return point;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }

    /*
    public Stroke getStroke() {
        return stroke;
    }
    */
    public void setPoint(Point point) {
        this.point = point;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void addToStrings(String string){
        strings.add(string);
    }

    public List<String> getStrings() {
        return strings;
    }

    public SerializableStrokeAdapter getSerializableStrokeAdapter() {
        return serializableStrokeAdapter;
    }
}
