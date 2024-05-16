package gui.panes;

import application.MainFrame;
import dialogs.ImagePanel;
import model.workspace.Presentation;
import model.workspace.Slide;
import model.workspace.Slot;
import observer.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlideView extends JPanel implements Subscriber {

    private String themePath;
    private Presentation presentation;
    private ImagePanel imgPanel;
    private Slide slide;

    private List<SlotView> slotViews;

    public SlideView(Slide slide){

        themePath = ((Presentation)slide.getParent()).getTheme();

        this.slide = slide;
        this.slide.getParent().addSubscriber(this);
        //
        this.slide.addSubscriber(this);
        //
        slotViews = new ArrayList<>();

        this.addMouseListener(new MouseController());
        this.addMouseMotionListener(new MouseController());

        this.slide = slide;

    }


    @Override
    protected void paintComponent(Graphics g) {

        Image img = new ImageIcon(themePath).getImage();
        /*
        g.drawImage(img, (int)(this.getSize().getWidth() - img.getWidth(null))/2,
                (int)(this.getSize().getHeight() - img.getHeight(null))/2, null);
        */


        super.paintComponent(g);
        Dimension d = getSize();
        g.drawImage(img, 0, 0, d.width, d.height, this);


        PresentationView presentationView = ((ProjectTab) MainFrame.getInstance().getMyTabbedPane().getSelectedComponent()).getPresentationView();

        for(SlotView sv : slotViews){

            sv.paint((Graphics2D)g,  presentationView.isParameter());
            repaint();
            revalidate();

        }


    }

    public void addSlotView(Object notification){
        Slide slide = (Slide) notification;
        for(Slot s : slide.getSlots()){
            SlotView slotView = new SlotView(s);
            slotViews.add(slotView);
        }
    }

    public SlotView returnSlotView(Point point){

        for(SlotView sv : slotViews){
            Slot slot = sv.getSlot();
            if(slot.getPoint().x <= point.x && (slot.getPoint().x + slot.getDimension().width) >= point.x
                && slot.getPoint().y <= point.y && (slot.getPoint().y + slot.getDimension().height) >= point.y) {
                    return sv;
            }
        }

        return null;
    }

    @Override
    public void update(Object notification) {

        if(notification instanceof Presentation){
            setThemePath(((Presentation)notification).getTheme());
        }

        if(notification instanceof Slide){
            this.slotViews.clear();
            addSlotView(notification);
        }

        this.repaint();
        this.revalidate();
    }

    public void setThemePath(String themePath){
        this.themePath = themePath;
       // imgPanel.repaint();
        this.repaint();
    }


    public ImagePanel getImgPanel() {
        return imgPanel;
    }

    public Slide getSlide() {
        return slide;
    }

    public List<SlotView> getSlotViews() {
        return slotViews;
    }
}