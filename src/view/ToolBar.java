package view;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar(){

        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());

    }

}
