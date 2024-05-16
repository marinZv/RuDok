package application;

import action.ActionManager;
import command.CommandManager;
import errors.ErrorFactory;
import errors.MyError;
import gui.MenuBar;
import gui.ToolBar;
import gui.panes.MyTabbedPane;
import gui.panes.ProjectTab;
import gui.tree.model.MyTreeModel;
import gui.tree.model.MyTreeNode;
import gui.tree.view.MyTree;
import model.workspace.Presentation;
import model.workspace.Workspace;
import observer.Subscriber;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Subscriber {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private MyTreeModel treeModel;
    private MyTree myTree;
    private MyTabbedPane myTabbedPane;
    //private ErrorFactory errorFactory;
    private JLabel projectNameLabel;
    //private JPanel editShowPane;
    private JSplitPane sp;
    private CommandManager commandManager;


    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
        //errorFactory = new ErrorFactory();
        commandManager = new CommandManager();
    }

    public void initialiseGui(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth/2, screenHeight/2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("RuDok");

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new BorderLayout());

        treeModel = new MyTreeModel(new MyTreeNode(new Workspace("Workspace",null)));
        myTree = new MyTree(treeModel);
        leftPanel.add(myTree,BorderLayout.CENTER);

        JScrollPane scrollPaneLeft = new JScrollPane(leftPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Dimension dm = new Dimension();
        dm.setSize(50,50);
        scrollPaneLeft.setMinimumSize(dm.getSize());

        projectNameLabel = new JLabel();

        myTabbedPane = new MyTabbedPane();
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(projectNameLabel, BorderLayout.NORTH);
        rightPanel.add(myTabbedPane, BorderLayout.CENTER);

        JScrollPane scrollPaneRight = new JScrollPane(rightPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneLeft, scrollPaneRight);
        sp.setDividerLocation(screenWidth/6);
        sp.setOneTouchExpandable(true);

        //editShowPane = sp;

        add(sp,BorderLayout.CENTER);

    }

    public static MainFrame getInstance() {
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
            instance.initialiseGui();
            ErrorFactory.getInstance().addSubscriber(instance);
        }

        return instance;
    }

    public void addTabToTabbedPane(Presentation presentation){

        ProjectTab projectTab = new ProjectTab(presentation);

        if(myTabbedPane.indexOfTab(presentation.getName()) != -1){
            return;
        }else{
            myTabbedPane.addTab(presentation.getName(), null, projectTab, "ToolTip");
        }
    }

    public void clearTabbedPane(){
        this.myTabbedPane.removeAll();
        getProjectNameLabel().setText("");
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public MyTreeModel getTreeModel() {
        return treeModel;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public MyTabbedPane getMyTabbedPane() {
        return myTabbedPane;
    }

    /*
    public ErrorFactory getErrorFactory() {
        return errorFactory;
    }
    */
    public JLabel getProjectNameLabel() {
        return projectNameLabel;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void update(Object notification) {

        JOptionPane.showMessageDialog(null, ((MyError)notification).getMessage(),"Slide error",JOptionPane.ERROR_MESSAGE);

    }

}
