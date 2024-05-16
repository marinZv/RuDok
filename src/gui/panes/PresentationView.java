package gui.panes;

import application.MainFrame;
import model.workspace.Presentation;
import model.workspace.Slide;
import model.workspace.SlotType;
import model.workspace.nodes.RuNode;
import observer.Subscriber;
import state.StateManager;
import state.StateManagerSlot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements Subscriber{

    private Presentation presentation;
    private JPanel panel;
    private JPanel navigatorPane;

    private StateManager stateManager;

    private List<SlideView> slideViewsPanel;
    private List<SlideView> slideViewsNavigatorPane;

    private JScrollPane spNavigator;

    private PresentationToolBar presentationToolBar;

    private List<SlideView> slideViewsSlideShow;

    private JPanel slideShowPane;

    private JToolBar slideShowToolBar;

    private StateManagerSlot stateManagerSlot;

    private boolean parameter = false;


    public PresentationView(Presentation presentation){

        this.presentation = presentation;
        this.stateManager = new StateManager();
        this.presentationToolBar = new PresentationToolBar();
        this.slideShowToolBar = new JToolBar();
        this.slideShowToolBar.setFloatable(false);

        this.setLayout(new BorderLayout());
        //
        presentation.addSubscriber(this);
        //

        this.add(presentationToolBar, BorderLayout.NORTH);

        this.slideShowToolBar.add(MainFrame.getInstance().getActionManager().getEditShowAction());
        this.slideShowToolBar.add(MainFrame.getInstance().getActionManager().getPreviousSlideAction());
        this.slideShowToolBar.add(MainFrame.getInstance().getActionManager().getNextSlideAction());

        panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        navigatorPane = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(navigatorPane, BoxLayout.Y_AXIS);
        navigatorPane.setLayout(boxLayout1);

        this.slideViewsPanel = new ArrayList<>();
        this.slideViewsNavigatorPane = new ArrayList<>();
        this.slideViewsSlideShow = new ArrayList<>();
        //this.spNavigator = new JScrollPane();

        slideShowPane = new JPanel();
        slideShowPane.setLayout(new CardLayout());

        this.stateManagerSlot = new StateManagerSlot();

        for(RuNode ch : presentation.getChildren()){

            Slide slide = (Slide)ch;
            SlideView slideView = new SlideView(slide);
            //SlideView slideViewLeft = new SlideView(slide);
            slideView.setPreferredSize(new Dimension(500,250));
            slideView.setMaximumSize(new Dimension(500, 250));

            slideViewsPanel.add(slideView);

        }

        for(RuNode ch: presentation.getChildren()){

            Slide slide = (Slide)ch;
            SlideView slideViewLeft = new SlideView(slide);
            slideViewLeft.setPreferredSize(new Dimension(150,75));
            slideViewLeft.setMaximumSize(new Dimension(150, 75));

            slideViewsNavigatorPane.add(slideViewLeft);

        }

        fillPresentationView();

        //
        fillSlideShow();
        //
    }

    public void fillSlideShow(){

        for(RuNode ch : this.presentation.getChildren()){

            Slide slide = (Slide) ch;

            SlideView slideViewSlideShow = new SlideView(slide);
            slideViewSlideShow.setPreferredSize(new Dimension(800, 400));
            slideViewSlideShow.setMaximumSize(new Dimension(800, 400));


            slideViewsSlideShow.add(slideViewSlideShow);

        }

        for(SlideView sws : slideViewsSlideShow){

            slideShowPane.add(sws);

        }

    }

    @Override
    public void update(Object notification) {

        this.slideViewsPanel.clear();
        this.slideViewsNavigatorPane.clear();


        this.panel.removeAll();
        this.navigatorPane.removeAll();

        fillSlideViews();
        fillPresentationView();

        System.out.println(this.slideViewsPanel.size());
    }

    public void fillSlideViews(){

        for(RuNode ch : presentation.getChildren()){

            Slide slide = (Slide)ch;
            SlideView slideView = new SlideView(slide);
            //SlideView slideViewLeft = new SlideView(slide);
            slideView.setPreferredSize(new Dimension(500,250));
            slideView.setMaximumSize(new Dimension(500, 250));

            slideViewsPanel.add(slideView);

        }

        for(RuNode ch: presentation.getChildren()){

            Slide slide = (Slide)ch;
            SlideView slideViewLeft = new SlideView(slide);
            slideViewLeft.setPreferredSize(new Dimension(150,75));
            slideViewLeft.setMaximumSize(new Dimension(150, 75));

            slideViewsNavigatorPane.add(slideViewLeft);

        }

    }

    public void fillPresentationView(){

        for(SlideView sw : slideViewsPanel){
            panel.add(sw);
            panel.add(Box.createVerticalStrut(15));
        }

        for(SlideView sw : slideViewsNavigatorPane){
            navigatorPane.add(sw);
            navigatorPane.add(Box.createVerticalStrut(3));
        }

        this.add(navigatorPane, BorderLayout.WEST);
        this.add(panel, BorderLayout.CENTER);
        navigatorPane.revalidate();
        panel.revalidate();
    }

    public void startAddSlotState(){
        this.stateManagerSlot.setAddSlotState();
    }

    public void startRemoveSlotState(){
        this.stateManagerSlot.setRemoveSlotState();
    }

    public void startMoveSlotState(){
        this.stateManagerSlot.setMoveSlotState();
    }

    public void startSelectSlotState(){
        this.stateManagerSlot.setSelectSlotState();
    }

    public void onMousePressed(Point point, Dimension dimension, Color color, Stroke stroke, SlideView slideView, SlotType slotType){
        this.stateManagerSlot.getCurrentSlotState().onMousePressed(point, dimension, color, stroke, slideView, slotType);
    }

    public void onMouseDragged(Point currentPoint, Point nextPoint, SlideView slideView){
        this.stateManagerSlot.getCurrentSlotState().onMouseDragged(currentPoint, nextPoint, slideView);
    }


    public void startEditShow(){
        this.stateManager.setEditShowState();
        parameter = false;
    }

    public void startSlideShow(){
        this.stateManager.setSlideShowState();
        parameter = true;
    }

    public void changeView(){
        this.stateManager.getCurrentState().changeView(this);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getSlideShowPane() {
        return slideShowPane;
    }

    public JToolBar getSlideShowToolBar() {
        return slideShowToolBar;
    }

    public PresentationToolBar getPresentationToolBar() {
        return presentationToolBar;
    }

    public JPanel getNavigatorPane() {
        return navigatorPane;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public List<SlideView> getSlideViewsPanel() {
        return slideViewsPanel;
    }

    public boolean isParameter() {
        return parameter;
    }
}
