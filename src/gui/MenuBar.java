package gui;

import application.MainFrame;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(){
        super();

        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        JMenu menuEdit = new JMenu("Edit");

        menuFile.add(MainFrame.getInstance().getActionManager().getNewAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getSaveWorkspaceAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getOpenWorkspaceAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getSavePresentationAction());
        menuFile.add(MainFrame.getInstance().getActionManager().getOpenPresentationAction());
        menuHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());
        menuEdit.add(MainFrame.getInstance().getActionManager().getAuthorAction());
        menuEdit.add(MainFrame.getInstance().getActionManager().getThemeAction());


        add(menuFile);
        add(menuHelp);
        add(menuEdit);
    }

}
