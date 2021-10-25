package view;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(){
        super();

        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");

        menuFile.add(MainFrame.getInstance().getActionManager().getNewAction());
        menuHelp.add(MainFrame.getInstance().getActionManager().getInfoAction());

        add(menuFile);
        add(menuHelp);
    }

}
