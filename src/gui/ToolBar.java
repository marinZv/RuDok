package gui;

import application.MainFrame;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(){

        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getRemoveAction());
        add(MainFrame.getInstance().getActionManager().getAuthorAction());
        add(MainFrame.getInstance().getActionManager().getThemeAction());
        //add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getShareAction());
        add(MainFrame.getInstance().getActionManager().getOpenEditorAction());
        add(MainFrame.getInstance().getActionManager().getSlotTekst());
        add(MainFrame.getInstance().getActionManager().getSlotMultimedia());
    }

}
