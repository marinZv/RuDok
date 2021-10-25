package view;

import controller.ActionManager;
import jdk.nashorn.api.tree.YieldTree;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MenuBar menuBar;
    private ToolBar toolBar;

    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
    }

    public void initialiseGui(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth/2, screenHeight/2);

        setTitle("RuDok");

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        JPanel rightRanel = new JPanel();

        JScrollPane scrollPaneLeft = new JScrollPane(leftPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneLeft, rightRanel);
        sp.setDividerLocation(screenWidth/6);
        sp.setOneTouchExpandable(true);
        Dimension dm = new Dimension();
        dm.setSize(50,50);
        sp.setMinimumSize(dm);

        add(sp);

    }

    public static MainFrame getInstance() {
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
            instance.initialiseGui();
        }

        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

}
